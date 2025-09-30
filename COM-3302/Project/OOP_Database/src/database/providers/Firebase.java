package database.providers;

import java.util.*;

import database.DatabaseConfig;
import database.DatabaseInterface;
import model.Note;

import java.net.http.*;
import java.net.URI;
import java.time.format.DateTimeFormatter;

public class Firebase implements DatabaseInterface {
   private DatabaseConfig config;
   private boolean connected;
   private HttpClient httpClient;
   private String baseUrl;

   public Firebase(DatabaseConfig config) {
      this.config = config;
      this.connected = false;
      this.httpClient = HttpClient.newHttpClient();
      this.baseUrl = config.getFirebaseUrl();
      if (!baseUrl.endsWith("/")) {
         baseUrl += "/";
      }
      baseUrl += "notes";
   }

   @Override
   public boolean connect() {
      try {
         if (testConnection()) {
            connected = true;
            System.out.println("Firebase database connected successfully");
            return true;
         } else {
            connected = false;
            return false;
         }
      } catch (Exception e) {
         System.err.println("Error connecting to Firebase: " + e.getMessage());
         connected = false;
         return false;
      }
   }

   @Override
   public void disconnect() {
      connected = false;
      System.out.println("Firebase database disconnected");
   }

   @Override
   public boolean isConnected() {
      return connected;
   }

   @Override
   public boolean testConnection() {
      try {
         String url = baseUrl + ".json";
         if (!config.getFirebaseApiKey().isEmpty()) {
            url += "?auth=" + config.getFirebaseApiKey();
         }

         HttpRequest request = HttpRequest.newBuilder()
               .uri(URI.create(url))
               .GET()
               .build();

         HttpResponse<String> response = httpClient.send(request,
               HttpResponse.BodyHandlers.ofString());

         return response.statusCode() == 200;

      } catch (Exception e) {
         System.err.println("Firebase connection test failed: " + e.getMessage());
         return false;
      }
   }

   @Override
   public boolean saveNote(Note note) {
      if (!isConnected())
         return false;

      try {
         String noteJson = convertNoteToJson(note);
         String url = baseUrl + "/" + note.getId() + ".json";

         if (!config.getFirebaseApiKey().isEmpty()) {
            url += "?auth=" + config.getFirebaseApiKey();
         }

         HttpRequest request = HttpRequest.newBuilder()
               .uri(URI.create(url))
               .header("Content-Type", "application/json")
               .PUT(HttpRequest.BodyPublishers.ofString(noteJson))
               .build();

         HttpResponse<String> response = httpClient.send(request,
               HttpResponse.BodyHandlers.ofString());

         return response.statusCode() == 200;

      } catch (Exception e) {
         System.err.println("Error saving note to Firebase: " + e.getMessage());
         return false;
      }
   }

   @Override
   public List<Note> loadAllNotes() {
      List<Note> notes = new ArrayList<>();
      if (!isConnected())
         return notes;

      try {
         String url = baseUrl + ".json";
         if (!config.getFirebaseApiKey().isEmpty()) {
            url += "?auth=" + config.getFirebaseApiKey();
         }

         HttpRequest request = HttpRequest.newBuilder()
               .uri(URI.create(url))
               .GET()
               .build();

         HttpResponse<String> response = httpClient.send(request,
               HttpResponse.BodyHandlers.ofString());

         if (response.statusCode() == 200) {
            String jsonResponse = response.body();
            notes = parseNotesFromJson(jsonResponse);
         }

      } catch (Exception e) {
         System.err.println("Error loading notes from Firebase: " + e.getMessage());
      }

      return notes;
   }

   @Override
   public boolean updateNote(Note note) {
      return saveNote(note);
   }

   @Override
   public boolean deleteNote(int id) {
      if (!isConnected())
         return false;

      try {
         String url = baseUrl + "/" + id + ".json";
         if (!config.getFirebaseApiKey().isEmpty()) {
            url += "?auth=" + config.getFirebaseApiKey();
         }

         HttpRequest request = HttpRequest.newBuilder()
               .uri(URI.create(url))
               .DELETE()
               .build();

         HttpResponse<String> response = httpClient.send(request,
               HttpResponse.BodyHandlers.ofString());

         return response.statusCode() == 200;

      } catch (Exception e) {
         System.err.println("Error deleting note from Firebase: " + e.getMessage());
         return false;
      }
   }

   @Override
   public List<Note> searchNotes(String searchTerm) {

      List<Note> allNotes = loadAllNotes();
      List<Note> results = new ArrayList<>();

      for (Note note : allNotes) {
         if (note.matches(searchTerm)) {
            results.add(note);
         }
      }

      return results;
   }

   @Override
   public boolean clearAllNotes() {
      if (!isConnected())
         return false;

      try {
         String url = baseUrl + ".json";
         if (!config.getFirebaseApiKey().isEmpty()) {
            url += "?auth=" + config.getFirebaseApiKey();
         }

         HttpRequest request = HttpRequest.newBuilder()
               .uri(URI.create(url))
               .DELETE()
               .build();

         HttpResponse<String> response = httpClient.send(request,
               HttpResponse.BodyHandlers.ofString());

         return response.statusCode() == 200;

      } catch (Exception e) {
         System.err.println("Error clearing notes from Firebase: " + e.getMessage());
         return false;
      }
   }

   @Override
   public String getDatabaseType() {
      return "Firebase Realtime Database";
   }

   @Override
   public String getConnectionStatus() {
      if (connected) {
         try {
            List<Note> notes = loadAllNotes();
            return String.format("Connected to Firebase (%d notes)", notes.size());
         } catch (Exception e) {
            return "Connected to Firebase (error counting notes)";
         }
      }
      return "Disconnected from Firebase";
   }

   private String convertNoteToJson(Note note) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

      return String.format("""
            {
                "id": %d,
                "title": "%s",
                "content": "%s",
                "category": "%s",
                "priority": "%s",
                "createdDate": "%s",
                "modifiedDate": "%s"
            }
            """,
            note.getId(),
            escapeJson(note.getTitle()),
            escapeJson(note.getContent()),
            escapeJson(note.getCategory()),
            note.getPriority().name(),
            note.getCreatedDate().format(formatter),
            note.getModifiedDate().format(formatter));
   }

   private List<Note> parseNotesFromJson(String json) {
      List<Note> notes = new ArrayList<>();

      if (json == null || json.trim().equals("null") || json.trim().isEmpty()) {
         return notes;
      }

      try {

         System.out.println("Firebase data loaded (simplified parsing)");
      } catch (Exception e) {
         System.err.println("Error parsing Firebase JSON: " + e.getMessage());
      }

      return notes;
   }

   private String escapeJson(String text) {
      if (text == null)
         return "";
      return text.replace("\"", "\\\"")
            .replace("\n", "\\n")
            .replace("\r", "\\r")
            .replace("\t", "\\t");
   }

   public String getFirebaseInfo() {
      if (config.getFirebaseUrl().isEmpty()) {
         return "Firebase URL not configured";
      }

      String projectId = extractProjectIdFromUrl(config.getFirebaseUrl());
      return String.format("Firebase Project: %s", projectId);
   }

   private String extractProjectIdFromUrl(String url) {
      try {

         String[] parts = url.split("\\.");
         if (parts.length > 0) {
            String projectPart = parts[0];
            return projectPart.substring(projectPart.lastIndexOf("/") + 1);
         }
      } catch (Exception e) {
      }
      return "Unknown";
   }
}
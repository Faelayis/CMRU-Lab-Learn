package database;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import model.Note;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OfflineDatabase implements DatabaseInterface {
   private List<Note> notes;
   private final String DATA_FILE = "notes_data.txt";
   private boolean connected;

   public OfflineDatabase() {
      this.notes = new ArrayList<>();
      this.connected = false;
   }

   @Override
   public boolean connect() {
      try {
         loadNotesFromFile();
         connected = true;
         System.out.println("Offline database connected successfully");
         return true;
      } catch (Exception e) {
         System.err.println("Error connecting to offline database: " + e.getMessage());
         connected = false;
         return false;
      }
   }

   @Override
   public void disconnect() {
      if (connected) {
         saveNotesToFile();
         connected = false;
         System.out.println("Offline database disconnected");
      }
   }

   @Override
   public boolean isConnected() {
      return connected;
   }

   @Override
   public boolean testConnection() {
      try {

         File file = new File(DATA_FILE);
         if (!file.exists()) {
            file.createNewFile();
            file.delete();
         }
         return true;
      } catch (Exception e) {
         return false;
      }
   }

   @Override
   public boolean saveNote(Note note) {
      if (!connected)
         return false;

      try {
         if (note.getId() == 0) {
            note.setId(Note.generateLocalId());
            System.out.println("Generated new ID for offline note: " + note.getId());
         }

         notes.removeIf(n -> n.getId() == note.getId());
         notes.add(note);
         saveNotesToFile();
         return true;
      } catch (Exception e) {
         System.err.println("Error saving note: " + e.getMessage());
         return false;
      }
   }

   @Override
   public List<Note> loadAllNotes() {
      if (!connected)
         return new ArrayList<>();
      return new ArrayList<>(notes);
   }

   @Override
   public boolean updateNote(Note note) {
      return saveNote(note);
   }

   @Override
   public boolean deleteNote(int id) {
      if (!connected)
         return false;

      boolean removed = notes.removeIf(note -> note.getId() == id);
      if (removed) {
         saveNotesToFile();
      }
      return removed;
   }

   @Override
   public List<Note> searchNotes(String searchTerm) {
      if (!connected)
         return new ArrayList<>();

      return notes.stream()
            .filter(note -> note.matches(searchTerm))
            .collect(Collectors.toList());
   }

   @Override
   public boolean clearAllNotes() {
      if (!connected)
         return false;

      notes.clear();
      Note.resetIdCounter();
      saveNotesToFile();
      return true;
   }

   @Override
   public String getDatabaseType() {
      return "Offline File Storage";
   }

   @Override
   public String getConnectionStatus() {
      if (connected) {
         return "Connected to offline storage (" + notes.size() + " notes)";
      }
      return "Disconnected from offline storage";
   }

   private void saveNotesToFile() {
      try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_FILE))) {
         writer.println("# Note Management System - Offline Data");
         writer.println("# Format: ID|Title|Content|Category|Priority|CreatedDate|ModifiedDate");
         writer.println(
               "# Generated: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
         writer.println();

         for (Note note : notes) {
            String line = String.format("%d|%s|%s|%s|%s|%s|%s",
                  note.getId(),
                  escapeDelimiters(note.getTitle()),
                  escapeDelimiters(note.getContent()),
                  escapeDelimiters(note.getCategory()),
                  note.getPriority().name(),
                  note.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                  note.getModifiedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            writer.println(line);
         }

         System.out.println("Notes saved to " + DATA_FILE + " (" + notes.size() + " notes)");
      } catch (IOException e) {
         System.err.println("Error saving notes to file: " + e.getMessage());
      }
   }

   private void loadNotesFromFile() {
      notes.clear();
      Note.resetIdCounter();
      File file = new File(DATA_FILE);

      if (!file.exists()) {
         System.out.println("Data file not found. Starting with empty database.");
         return;
      }

      try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
         String line;
         int loadedCount = 0;

         while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty() || line.startsWith("#")) {
               continue;
            }

            try {
               Note note = parseNoteFromLine(line);
               if (note != null) {
                  notes.add(note);
                  loadedCount++;
               }
            } catch (Exception e) {
               System.err.println("Error parsing line: " + line + " - " + e.getMessage());
            }
         }

         System.out.println("Loaded " + loadedCount + " notes from " + DATA_FILE);
      } catch (IOException e) {
         System.err.println("Error loading notes from file: " + e.getMessage());
      }
   }

   private Note parseNoteFromLine(String line) {
      String[] parts = line.split("\\|");
      if (parts.length != 7) {
         throw new IllegalArgumentException("Invalid line format");
      }

      try {
         int id = Integer.parseInt(parts[0]);
         String title = unescapeDelimiters(parts[1]);
         String content = unescapeDelimiters(parts[2]);
         String category = unescapeDelimiters(parts[3]);
         Note.Priority priority = Note.Priority.valueOf(parts[4]);
         Note note = new Note(title, content, category, priority);
         note.setId(id);
         Note.updateNextIdIfNeeded(id + 1);

         return note;
      } catch (Exception e) {
         throw new IllegalArgumentException("Error parsing note data: " + e.getMessage());
      }
   }

   private String escapeDelimiters(String text) {
      if (text == null)
         return "";
      return text.replace("|", "&#124;").replace("\n", "\\n").replace("\r", "\\r");
   }

   private String unescapeDelimiters(String text) {
      if (text == null)
         return "";
      return text.replace("&#124;", "|").replace("\\n", "\n").replace("\\r", "\r");
   }

   public String getFileInfo() {
      File file = new File(DATA_FILE);
      if (file.exists()) {
         long size = file.length();
         return String.format("File: %s (%.2f KB)", DATA_FILE, size / 1024.0);
      }
      return "File: " + DATA_FILE + " (not found)";
   }
}
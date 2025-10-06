package database;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import core.Note;

import com.fasterxml.jackson.databind.node.ArrayNode;

public class OfflineDatabase implements Database {
   private List<Note> notes;
   private final String DATA_FILE = "notes_data.json";
   private boolean connected;
   private ObjectMapper objectMapper;

   public OfflineDatabase() {
      this.notes = new ArrayList<>();
      this.connected = false;
      this.objectMapper = new ObjectMapper();
   }

   @Override
   public boolean connect() {
      try {
         loadNotesFromFile();
         connected = true;
         return true;
      } catch (Exception e) {
         connected = false;
         return false;
      }
   }

   @Override
   public void disconnect() {
      if (connected) {
         saveNotesToFile();
         connected = false;
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
   public synchronized boolean saveNote(Note note) {
      if (!connected)
         return false;

      if (note.getId() == 0) {
         note.setId(Note.generateLocalId());
      }

      notes.removeIf(n -> n.getId() == note.getId());
      notes.add(note);
      saveNotesToFile();
      return true;
   }

   @Override
   public synchronized List<Note> loadAllNotes() {
      if (!connected)
         return new ArrayList<>();
      return new ArrayList<>(notes);
   }

   @Override
   public boolean updateNote(Note note) {
      return saveNote(note);
   }

   @Override
   public synchronized boolean deleteNote(int id) {
      if (!connected)
         return false;

      boolean removed = notes.removeIf(note -> note.getId() == id);
      if (removed) {
         saveNotesToFile();
      }
      return removed;
   }

   @Override
   public synchronized List<Note> searchNotes(String searchTerm) {
      if (!connected)
         return new ArrayList<>();

      return notes.stream()
            .filter(note -> note.matches(searchTerm))
            .collect(Collectors.toList());
   }

   @Override
   public synchronized boolean clearAllNotes() {
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

   private synchronized void saveNotesToFile() {
      try {
         ObjectNode rootNode = objectMapper.createObjectNode();
         ArrayNode notesArray = objectMapper.createArrayNode();
         List<Note> notesCopy = new ArrayList<>(notes);

         for (Note note : notesCopy) {
            ObjectNode noteNode = objectMapper.createObjectNode();
            noteNode.put("id", note.getId());
            noteNode.put("title", note.getTitle());
            noteNode.put("content", note.getContent());
            noteNode.put("category", note.getCategory());
            noteNode.put("priority", note.getPriority().name());
            noteNode.put("createdDate",
                  note.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            noteNode.put("modifiedDate",
                  note.getModifiedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            notesArray.add(noteNode);
         }
         rootNode.set("notes", notesArray);
         objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(DATA_FILE), rootNode);

      } catch (IOException e) {
      }
   }

   private synchronized void loadNotesFromFile() {
      notes.clear();
      Note.resetIdCounter();
      File file = new File(DATA_FILE);

      if (!file.exists()) {
         return;
      }

      try {
         ObjectNode rootNode = (ObjectNode) objectMapper.readTree(file);

         if (rootNode.has("notes")) {
            ArrayNode notesArray = (ArrayNode) rootNode.get("notes");

            for (int i = 0; i < notesArray.size(); i++) {
               ObjectNode noteNode = (ObjectNode) notesArray.get(i);

               int id = noteNode.get("id").asInt();
               String title = noteNode.get("title").asText();
               String content = noteNode.get("content").asText();
               String category = noteNode.get("category").asText();
               String priorityStr = noteNode.get("priority").asText();

               Note.Priority priority = Note.Priority.valueOf(priorityStr);
               Note note = new Note(title, content, category, priority);
               note.setId(id);
               Note.updateNextIdIfNeeded(id + 1);

               notes.add(note);
            }
         }

      } catch (IOException e) {
      }
   }

}
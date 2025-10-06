
package core;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import database.DatabaseManager;

public class NoteManager {
   private List<Note> notes;
   private Map<String, List<Note>> categoryIndex;
   private DatabaseManager databaseManager;

   public NoteManager() {
      this.notes = new ArrayList<>();
      this.categoryIndex = new HashMap<>();
      this.databaseManager = new DatabaseManager(this);
   }

   public boolean addNote(Note note) {
      return addNote(note, true);
   }

   public boolean addNote(Note note, boolean triggerAutoSync) {
      if (note == null) {
         throw new IllegalArgumentException("Note cannot be null");
      }

      boolean added = notes.add(note);
      if (added) {
         updateCategoryIndex(note);
         if (triggerAutoSync && isAutoSyncEnabled() && databaseManager != null) {
            autoSyncToDatabase(note, "ADD");
         }
      }
      return added;
   }

   public Note addNote(String title, String content, String category, Note.Priority priority) {
      Note note = new Note(title, content, category, priority);

      if (isDatabaseConnected() && isAutoSyncEnabled() && databaseManager != null) {
         if (!databaseManager.saveNoteToDatabase(note)) {
            note.setId(Note.generateLocalId());
         }
         addNote(note, false);
      } else {
         note.setId(Note.generateLocalId());
         addNote(note, true);
      }

      return note;
   }

   public boolean removeNote(int id) {
      Note noteToRemove = findNoteById(id);
      if (noteToRemove != null) {
         notes.remove(noteToRemove);
         removeCategoryIndex(noteToRemove);
         autoSyncToDatabase(noteToRemove, "DELETE");
         return true;
      }
      return false;
   }

   public Note findNoteById(int id) {
      return notes.stream()
            .filter(note -> note.getId() == id)
            .findFirst()
            .orElse(null);
   }

   public boolean updateNote(int id, String title, String content, String category, Note.Priority priority) {
      Note note = findNoteById(id);
      if (note != null) {
         String oldCategory = note.getCategory();

         note.setTitle(title);
         note.setContent(content);
         note.setCategory(category);
         note.setPriority(priority);

         removeCategoryIndexEntry(note, oldCategory);
         updateCategoryIndex(note);
         autoSyncToDatabase(note, "UPDATE");

         return true;
      }
      return false;
   }

   public List<Note> searchNotes(String searchTerm) {
      return notes.stream()
            .filter(note -> note.matches(searchTerm))
            .collect(Collectors.toList());
   }

   public List<Note> getNotesByCategory(String category) {
      return categoryIndex.getOrDefault(category, new ArrayList<>());
   }

   public List<Note> getNotesByPriority(Note.Priority priority) {
      return notes.stream()
            .filter(note -> note.getPriority() == priority)
            .collect(Collectors.toList());
   }

   public List<Note> searchNotes(Predicate<Note> condition) {
      return notes.stream()
            .filter(condition)
            .collect(Collectors.toList());
   }

   public List<Note> getAllNotes() {
      return new ArrayList<>(notes);
   }

   public List<Note> getAllNotesSorted() {
      return notes.stream()
            .sorted()
            .collect(Collectors.toList());
   }

   public Set<String> getAllCategories() {
      return notes.stream()
            .map(Note::getCategory)
            .collect(Collectors.toSet());
   }

   public int getTotalNotes() {
      return notes.size();
   }

   public int getNotesCountByCategory(String category) {
      return categoryIndex.getOrDefault(category, new ArrayList<>()).size();
   }

   public Map<Note.Priority, Long> getPriorityStatistics() {
      return notes.stream()
            .collect(Collectors.groupingBy(Note::getPriority, Collectors.counting()));
   }

   public void clearAllNotes() {
      clearAllNotes(true);
   }

   public void clearAllNotes(boolean triggerAutoSync) {
      notes.clear();
      categoryIndex.clear();

      if (triggerAutoSync && isAutoSyncEnabled() && databaseManager != null && isDatabaseConnected()) {
         Thread syncThread = new Thread(() -> {
            databaseManager.getCurrentDatabase().clearAllNotes();
         });
         syncThread.setDaemon(true);
         syncThread.start();
      }
   }

   public boolean isEmpty() {
      return notes.isEmpty();
   }

   private void updateCategoryIndex(Note note) {
      categoryIndex.computeIfAbsent(note.getCategory(), _ -> new ArrayList<>()).add(note);
   }

   private void removeCategoryIndex(Note note) {
      removeCategoryIndexEntry(note, note.getCategory());
   }

   private void removeCategoryIndexEntry(Note note, String category) {
      List<Note> categoryNotes = categoryIndex.get(category);
      if (categoryNotes != null) {
         categoryNotes.remove(note);
         if (categoryNotes.isEmpty()) {
            categoryIndex.remove(category);
         }
      }
   }

   public DatabaseManager getDatabaseManager() {
      return databaseManager;
   }

   public boolean connectToDatabase() {
      return databaseManager != null && databaseManager.connectToDatabase();
   }

   public void disconnectFromDatabase() {
      if (databaseManager != null) {
         databaseManager.disconnectFromDatabase();
      }
   }

   public boolean isDatabaseConnected() {
      return databaseManager != null && databaseManager.isConnected();
   }

   public String getDatabaseStatus() {
      return databaseManager != null ? databaseManager.getConnectionStatus() : "Database not initialized";
   }

   public boolean isAutoSyncEnabled() {
      return true;
   }

   private void autoSyncToDatabase(Note note, String operation) {
      if (!isAutoSyncEnabled() || databaseManager == null || !isDatabaseConnected()) {
         return;
      }

      Thread syncThread = new Thread(() -> {
         switch (operation) {
            case "ADD":
            case "UPDATE":
               databaseManager.saveNoteToDatabase(note);
               break;
            case "DELETE":
               databaseManager.deleteNoteFromDatabase(note.getId());
               break;
         }
      });

      syncThread.setDaemon(true);
      syncThread.start();
   }

   public void autoSyncAllToDatabase() {
      if (!isAutoSyncEnabled() || databaseManager == null || !isDatabaseConnected()) {
         return;
      }

      Thread syncThread = new Thread(() -> {
         databaseManager.syncNotesToDatabase();
      });

      syncThread.setDaemon(true);
      syncThread.start();
   }
}
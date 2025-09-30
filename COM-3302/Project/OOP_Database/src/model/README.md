`Category.java`<br>
Create: 1 ต.ค. 2568 time 03:49<br>
```java
package model;

import java.util.*;

public class Category {
   private String name;
   private String description;
   private String color;
   private int noteCount;

   private static final List<Category> DEFAULT_CATEGORIES = Arrays.asList(
         new Category("General", "General notes", "#808080"),
         new Category("Work", "Work and job related", "#3498db"),
         new Category("Personal", "Personal matters", "#e74c3c"),
         new Category("Study", "Study and education", "#f39c12"),
         new Category("Health", "Health and self-care", "#2ecc71"),
         new Category("Project", "Various projects", "#9b59b6"),
         new Category("Ideas", "Ideas and thoughts", "#1abc9c"));

   public Category(String name, String description, String color) {
      this.name = name;
      this.description = description;
      this.color = color;
      this.noteCount = 0;
   }

   public Category(Category other) {
      this.name = other.name;
      this.description = other.description;
      this.color = other.color;
      this.noteCount = other.noteCount;
   }

   public String getName() {
      return name;
   }

   public String getDescription() {
      return description;
   }

   public String getColor() {
      return color;
   }

   public int getNoteCount() {
      return noteCount;
   }

   public void setName(String name) {
      if (name != null && !name.trim().isEmpty()) {
         this.name = name.trim();
      } else {
         throw new IllegalArgumentException("Category name cannot be empty");
      }
   }

   public void setDescription(String description) {
      this.description = description != null ? description.trim() : "";
   }

   public void setColor(String color) {
      if (color != null && color.matches("^#[0-9A-Fa-f]{6}$")) {
         this.color = color;
      } else {
         this.color = "#808080";
      }
   }

   public void incrementNoteCount() {
      this.noteCount++;
   }

   public void decrementNoteCount() {
      if (this.noteCount > 0) {
         this.noteCount--;
      }
   }

   public void resetNoteCount() {
      this.noteCount = 0;
   }

   public void setNoteCount(int count) {
      this.noteCount = Math.max(0, count);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null || getClass() != obj.getClass())
         return false;
      Category category = (Category) obj;
      return Objects.equals(name, category.name);
   }

   @Override
   public int hashCode() {
      return Objects.hash(name);
   }

   @Override
   public String toString() {
      return name + " (" + noteCount + ")";
   }

   public String getFullInfo() {
      return String.format("Category: %s\nDescription: %s\nNote Count: %d\nColor: %s",
            name, description, noteCount, color);
   }

   public static List<Category> getDefaultCategories() {
      List<Category> categories = new ArrayList<>();
      for (Category cat : DEFAULT_CATEGORIES) {
         categories.add(new Category(cat));
      }
      return categories;
   }

   public static Category createCategory(String name) {
      return new Category(name, "Category " + name, "#808080");
   }

   public static boolean isValidCategoryName(String name) {
      return name != null && !name.trim().isEmpty() && name.trim().length() <= 50;
   }

   public static boolean isValidColorCode(String color) {
      return color != null && color.matches("^#[0-9A-Fa-f]{6}$");
   }
}
```
`Note.java`<br>
Create: 1 ต.ค. 2568 time 03:49<br>
```java
package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Note implements Comparable<Note> {
   private static int nextId = 1;

   public static int generateLocalId() {
      return nextId++;
   }

   public static void updateNextIdIfNeeded(int minId) {
      if (minId > nextId) {
         nextId = minId;
      }
   }

   public static void resetIdCounter() {
      nextId = 1;
   }

   private int id;
   private String title;
   private String content;
   private LocalDateTime createdDate;
   private LocalDateTime modifiedDate;
   private String category;
   private Priority priority;

   public enum Priority {
      LOW(1, "Low"),
      MEDIUM(2, "Medium"),
      HIGH(3, "High");

      private final int level;
      private final String description;

      Priority(int level, String description) {
         this.level = level;
         this.description = description;
      }

      public int getLevel() {
         return level;
      }

      public String getDescription() {
         return description;
      }

      @Override
      public String toString() {
         return description;
      }
   }

   public Note(String title, String content, String category, Priority priority) {
      this.id = 0;
      this.title = title;
      this.content = content;
      this.category = category;
      this.priority = priority;
      this.createdDate = LocalDateTime.now();
      this.modifiedDate = LocalDateTime.now();
   }

   public Note(int id, String title, String content, String category, Priority priority,
         LocalDateTime createdDate, LocalDateTime modifiedDate) {
      this.id = id;
      this.title = title;
      this.content = content;
      this.category = category;
      this.priority = priority;
      this.createdDate = createdDate;
      this.modifiedDate = modifiedDate;
   }

   public Note(Note other) {
      this.id = other.id;
      this.title = other.title;
      this.content = other.content;
      this.category = other.category;
      this.priority = other.priority;
      this.createdDate = other.createdDate;
      this.modifiedDate = other.modifiedDate;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getTitle() {
      return title;
   }

   public String getContent() {
      return content;
   }

   public LocalDateTime getCreatedDate() {
      return createdDate;
   }

   public LocalDateTime getModifiedDate() {
      return modifiedDate;
   }

   public String getCategory() {
      return category;
   }

   public Priority getPriority() {
      return priority;
   }

   public void setTitle(String title) {
      if (title != null && !title.trim().isEmpty()) {
         this.title = title;
         updateModifiedDate();
      } else {
         throw new IllegalArgumentException("Title cannot be empty");
      }
   }

   public void setContent(String content) {
      this.content = content != null ? content : "";
      updateModifiedDate();
   }

   public void setCategory(String category) {
      this.category = category != null ? category : "General";
      updateModifiedDate();
   }

   public void setPriority(Priority priority) {
      this.priority = priority != null ? priority : Priority.MEDIUM;
      updateModifiedDate();
   }

   private void updateModifiedDate() {
      this.modifiedDate = LocalDateTime.now();
   }

   public boolean matches(String searchTerm) {
      if (searchTerm == null || searchTerm.trim().isEmpty()) {
         return true;
      }

      String search = searchTerm.toLowerCase();
      return title.toLowerCase().contains(search) ||
            content.toLowerCase().contains(search) ||
            category.toLowerCase().contains(search) ||
            priority.toString().toLowerCase().contains(search) ||
            getFormattedCreatedDate().toLowerCase().contains(search) ||
            getFormattedModifiedDate().toLowerCase().contains(search);
   }

   @Override
   public int compareTo(Note other) {
      return other.createdDate.compareTo(this.createdDate);
   }

   public String getFormattedCreatedDate() {
      return createdDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
   }

   public String getFormattedModifiedDate() {
      return modifiedDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
   }

   @Override
   public String toString() {
      return String.format("ID: %d | Title: %s | Category: %s | Priority: %s | Created: %s",
            id, title, category, priority, getFormattedCreatedDate());
   }

   public String getSummary() {
      String contentPreview = content.length() > 50 ? content.substring(0, 50) + "..." : content;
      return String.format("[%s] %s - %s", category, title, contentPreview);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null || getClass() != obj.getClass())
         return false;
      Note note = (Note) obj;
      return id == note.id;
   }

   @Override
   public int hashCode() {
      return Integer.hashCode(id);
   }
}
```
`NoteManager.java`<br>
Create: 1 ต.ค. 2568 time 03:49<br>
```java
package model;

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
         try {
            if (databaseManager.saveNoteToDatabase(note)) {
               System.out.println("Note saved to database with ID: " + note.getId());
               addNote(note, false);
            } else {
               System.err.println("Failed to save note to database");
               note.setId(Note.generateLocalId());
               addNote(note, false);
            }
         } catch (Exception e) {
            System.err.println("Error saving note to database: " + e.getMessage());
            note.setId(Note.generateLocalId());
            addNote(note, false);
         }
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

   public List<Note> getAllNotesSortedByPriority() {
      return notes.stream()
            .sorted((n1, n2) -> Integer.compare(n2.getPriority().getLevel(), n1.getPriority().getLevel()))
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
            try {
               if (databaseManager.getCurrentDatabase().clearAllNotes()) {
                  System.out.println("Auto-cleared all notes from database");
               } else {
                  System.err.println("Failed to auto-clear notes from database");
               }
            } catch (Exception e) {
               System.err.println("Auto-sync clear error: " + e.getMessage());
            }
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
         try {
            switch (operation) {
               case "ADD":
               case "UPDATE":
                  if (databaseManager.saveNoteToDatabase(note)) {
                     System.out.println("Auto-synced note to database: " + note.getTitle());
                  } else {
                     System.err.println("Failed to auto-sync note: " + note.getTitle());
                  }
                  break;
               case "DELETE":
                  if (databaseManager.deleteNoteFromDatabase(note.getId())) {
                     System.out.println("Auto-deleted note from database: " + note.getTitle());
                  } else {
                     System.err.println("Failed to auto-delete note: " + note.getTitle());
                  }
                  break;
            }
         } catch (Exception e) {
            System.err.println("Auto-sync error for note " + note.getTitle() + ": " + e.getMessage());
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
         try {
            if (databaseManager.syncNotesToDatabase()) {
               System.out.println("Auto-synced all notes to database");
            } else {
               System.err.println("Failed to auto-sync all notes to database");
            }
         } catch (Exception e) {
            System.err.println("Auto-sync error: " + e.getMessage());
         }
      });

      syncThread.setDaemon(true);
      syncThread.start();
   }
}
```

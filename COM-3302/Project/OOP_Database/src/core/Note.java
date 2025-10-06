package core;

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
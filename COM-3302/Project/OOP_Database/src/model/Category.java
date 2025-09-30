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
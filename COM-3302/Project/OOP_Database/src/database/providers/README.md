`MySQL.java`<br>
Create: 1 ต.ค. 2568 time 03:49<br>
Last edited: Time 05:33<br>

```java
package database.providers;

import java.sql.*;
import java.util.*;

import database.DatabaseConfig;
import database.DatabaseInterface;
import model.Note;

public class MySQL implements DatabaseInterface {
   private Connection connection;
   private DatabaseConfig config;
   private boolean connected;

   public MySQL(DatabaseConfig config) {
      this.config = config;
      this.connected = false;
   }

   @Override
   public boolean connect() {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");

         String url = config.getMySQLConnectionString();
         connection = DriverManager.getConnection(url, config.getUsername(), config.getPassword());

         createTablesIfNotExists();

         connected = true;
         System.out.println("MySQL database connected successfully");
         return true;

      } catch (ClassNotFoundException e) {
         System.err.println("MySQL JDBC driver not found: " + e.getMessage());
         connected = false;
         return false;
      } catch (SQLException e) {
         System.err.println("Error connecting to MySQL database: " + e.getMessage());
         connected = false;
         return false;
      }
   }

   @Override
   public void disconnect() {
      if (connection != null) {
         try {
            connection.close();
            connected = false;
            System.out.println("MySQL database disconnected");
         } catch (SQLException e) {
            System.err.println("Error disconnecting from MySQL: " + e.getMessage());
         }
      }
   }

   @Override
   public boolean isConnected() {
      try {
         return connected && connection != null && !connection.isClosed();
      } catch (SQLException e) {
         return false;
      }
   }

   @Override
   public boolean testConnection() {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         String url = config.getMySQLConnectionString();

         try (Connection testConn = DriverManager.getConnection(url, config.getUsername(), config.getPassword())) {
            return testConn != null && !testConn.isClosed();
         }
      } catch (Exception e) {
         return false;
      }
   }

   @Override
   public boolean saveNote(Note note) {
      if (!isConnected())
         return false;

      if (note.getId() == 0) {
         String sql = "INSERT INTO notes (title, content, category, priority, created_date, modified_date) " +
               "VALUES (?, ?, ?, ?, ?, ?)";

         try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, note.getTitle());
            stmt.setString(2, note.getContent());
            stmt.setString(3, note.getCategory());
            stmt.setString(4, note.getPriority().name());
            stmt.setTimestamp(5, Timestamp.valueOf(note.getCreatedDate()));
            stmt.setTimestamp(6, Timestamp.valueOf(note.getModifiedDate()));

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
               try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                  if (generatedKeys.next()) {
                     note.setId(generatedKeys.getInt(1));
                     System.out.println("New note saved with database ID: " + note.getId());
                     return true;
                  }
               }
            }

         } catch (SQLException e) {
            System.err.println("Error saving new note to MySQL: " + e.getMessage());
            return false;
         }
      } else {
         String sql = "UPDATE notes SET title=?, content=?, category=?, priority=?, modified_date=? WHERE id=?";

         try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, note.getTitle());
            stmt.setString(2, note.getContent());
            stmt.setString(3, note.getCategory());
            stmt.setString(4, note.getPriority().name());
            stmt.setTimestamp(5, Timestamp.valueOf(note.getModifiedDate()));
            stmt.setInt(6, note.getId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

         } catch (SQLException e) {
            System.err.println("Error updating note in MySQL: " + e.getMessage());
            return false;
         }
      }

      return false;
   }

   @Override
   public List<Note> loadAllNotes() {
      List<Note> notes = new ArrayList<>();
      if (!isConnected())
         return notes;

      String sql = "SELECT * FROM notes ORDER BY created_date DESC";

      try (Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

         while (rs.next()) {
            Note note = createNoteFromResultSet(rs);
            if (note != null) {
               notes.add(note);
            }
         }

      } catch (SQLException e) {
         System.err.println("Error loading notes from MySQL: " + e.getMessage());
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

      String sql = "DELETE FROM notes WHERE id = ?";

      try (PreparedStatement stmt = connection.prepareStatement(sql)) {
         stmt.setInt(1, id);
         int rowsAffected = stmt.executeUpdate();
         return rowsAffected > 0;

      } catch (SQLException e) {
         System.err.println("Error deleting note from MySQL: " + e.getMessage());
         return false;
      }
   }

   @Override
   public List<Note> searchNotes(String searchTerm) {
      List<Note> notes = new ArrayList<>();
      if (!isConnected())
         return notes;

      String sql = "SELECT * FROM notes WHERE " +
            "title LIKE ? OR content LIKE ? OR category LIKE ? OR priority LIKE ? " +
            "ORDER BY created_date DESC";

      try (PreparedStatement stmt = connection.prepareStatement(sql)) {
         String searchPattern = "%" + searchTerm + "%";
         stmt.setString(1, searchPattern);
         stmt.setString(2, searchPattern);
         stmt.setString(3, searchPattern);
         stmt.setString(4, searchPattern);

         try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
               Note note = createNoteFromResultSet(rs);
               if (note != null) {
                  notes.add(note);
               }
            }
         }

      } catch (SQLException e) {
         System.err.println("Error searching notes in MySQL: " + e.getMessage());
      }

      return notes;
   }

   @Override
   public boolean clearAllNotes() {
      if (!isConnected())
         return false;

      try (Statement stmt = connection.createStatement()) {
         String dropSql = "DROP TABLE IF EXISTS notes";
         stmt.executeUpdate(dropSql);
         System.out.println("MySQL notes table dropped");

         createTablesIfNotExists();
         System.out.println("MySQL notes table recreated - ID counter reset to 1");

         /*
          * Alternative Method 2: Delete all records and reset AUTO_INCREMENT
          * String deleteSql = "DELETE FROM notes";
          * stmt.executeUpdate(deleteSql);
          * 
          * String resetSql = "ALTER TABLE notes AUTO_INCREMENT = 1";
          * stmt.executeUpdate(resetSql);
          * System.out.println("All notes deleted and ID counter reset to 1");
          */

         return true;

      } catch (SQLException e) {
         System.err.println("Error clearing notes and resetting ID counter in MySQL: " + e.getMessage());
         return false;
      }
   }

   @Override
   public String getDatabaseType() {
      return "MySQL Database";
   }

   @Override
   public String getConnectionStatus() {
      if (isConnected()) {
         try {
            String sql = "SELECT COUNT(*) FROM notes";
            try (Statement stmt = connection.createStatement();
                  ResultSet rs = stmt.executeQuery(sql)) {
               if (rs.next()) {
                  int count = rs.getInt(1);
                  return String.format("Connected to MySQL (%d notes) - %s", count, config.getHost());
               }
            }
         } catch (SQLException e) {
            return "Connected to MySQL (error counting notes)";
         }
      }
      return "Disconnected from MySQL";
   }

   private void createTablesIfNotExists() throws SQLException {
      String sql = """
            CREATE TABLE IF NOT EXISTS notes (
                id INT AUTO_INCREMENT PRIMARY KEY,
                title VARCHAR(255) NOT NULL,
                content TEXT,
                category VARCHAR(100),
                priority VARCHAR(20),
                created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                INDEX idx_category (category),
                INDEX idx_priority (priority),
                INDEX idx_created_date (created_date)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
            """;

      try (Statement stmt = connection.createStatement()) {
         stmt.executeUpdate(sql);
         System.out.println("MySQL tables created/verified successfully");
      }
   }

   private Note createNoteFromResultSet(ResultSet rs) {
      try {
         int id = rs.getInt("id");
         String title = rs.getString("title");
         String content = rs.getString("content");
         String category = rs.getString("category");
         String priorityStr = rs.getString("priority");
         Timestamp createdTimestamp = rs.getTimestamp("created_date");
         Timestamp modifiedTimestamp = rs.getTimestamp("modified_date");

         Note.Priority priority;
         try {
            priority = Note.Priority.valueOf(priorityStr);
         } catch (IllegalArgumentException e) {
            priority = Note.Priority.MEDIUM;
         }

         Note note = new Note(id, title, content, category, priority,
               createdTimestamp.toLocalDateTime(),
               modifiedTimestamp.toLocalDateTime());

         return note;

      } catch (SQLException e) {
         System.err.println("Error creating note from ResultSet: " + e.getMessage());
         return null;
      }
   }

   public String getDatabaseInfo() {
      if (!isConnected())
         return "Not connected";

      try {
         DatabaseMetaData metaData = connection.getMetaData();
         return String.format("MySQL %s at %s:%s/%s",
               metaData.getDatabaseProductVersion(),
               config.getHost(),
               config.getPort(),
               config.getDatabase());
      } catch (SQLException e) {
         return "Connected (info unavailable)";
      }
   }
}
```

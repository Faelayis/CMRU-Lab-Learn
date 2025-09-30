`DatabaseConfig.java`<br>
Create: 1 ต.ค. 2568 time 03:49<br>
Last edited: Time 05:33<br>

```java
package database;

import java.io.*;
import java.util.Properties;

public class DatabaseConfig {
   public enum DatabaseType {
      OFFLINE("Offline Mode"),
      MYSQL("MySQL Database");

      private final String displayName;

      DatabaseType(String displayName) {
         this.displayName = displayName;
      }

      public String getDisplayName() {
         return displayName;
      }
   }

   private DatabaseType type;
   private String host;
   private String port;
   private String database;
   private String username;
   private String password;
   private boolean autoConnect;
   private static final String CONFIG_FILE = "database.properties";

   public DatabaseConfig() {
      this.type = DatabaseType.OFFLINE;
      this.host = "localhost";
      this.port = "3306";
      this.database = "note";
      this.username = "root";
      this.password = "";
      this.autoConnect = true;
   }

   public DatabaseType getType() {
      return type;
   }

   public String getHost() {
      return host;
   }

   public String getPort() {
      return port;
   }

   public String getDatabase() {
      return database;
   }

   public String getUsername() {
      return username;
   }

   public String getPassword() {
      return password;
   }

   public boolean isAutoConnect() {
      return autoConnect;
   }

   public void setType(DatabaseType type) {
      this.type = type;
   }

   public void setHost(String host) {
      this.host = host != null ? host : "localhost";
   }

   public void setPort(String port) {
      this.port = port != null ? port : "3306";
   }

   public void setDatabase(String database) {
      this.database = database != null ? database : "note";
   }

   public void setUsername(String username) {
      this.username = username != null ? username : "root";
   }

   public void setPassword(String password) {
      this.password = password != null ? password : "";
   }

   public void setAutoConnect(boolean autoConnect) {
      this.autoConnect = autoConnect;
   }

   public String getMySQLConnectionString() {
      return String.format("jdbc:mysql://%s:%s/%s", host, port, database);
   }

   public boolean isValidMySQLConfig() {
      return host != null && !host.trim().isEmpty() &&
            port != null && !port.trim().isEmpty() &&
            database != null && !database.trim().isEmpty() &&
            username != null && !username.trim().isEmpty();
   }

   public void saveToFile() {
      Properties props = new Properties();
      props.setProperty("type", type.name());
      props.setProperty("host", host);
      props.setProperty("port", port);
      props.setProperty("database", database);
      props.setProperty("username", username);
      props.setProperty("password", password);
      props.setProperty("autoConnect", String.valueOf(autoConnect));

      try (FileOutputStream fos = new FileOutputStream(CONFIG_FILE)) {
         props.store(fos, "Database Configuration");
         System.out.println("Configuration saved to " + CONFIG_FILE);
      } catch (IOException e) {
         System.err.println("Error saving configuration: " + e.getMessage());
      }
   }

   public void loadFromFile() {
      Properties props = new Properties();
      try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
         props.load(fis);

         String typeStr = props.getProperty("type", "OFFLINE");
         try {
            this.type = DatabaseType.valueOf(typeStr);
         } catch (IllegalArgumentException e) {
            this.type = DatabaseType.OFFLINE;
         }

         this.host = props.getProperty("host", "localhost");
         this.port = props.getProperty("port", "3306");
         this.database = props.getProperty("database", "note");
         this.username = props.getProperty("username", "root");
         this.password = props.getProperty("password", "");
         this.autoConnect = Boolean.parseBoolean(props.getProperty("autoConnect", "false"));

         System.out.println("Configuration loaded from " + CONFIG_FILE);
         System.out.println("Database Type: " + this.type);
         System.out.println("Auto Connect: " + this.autoConnect);
      } catch (FileNotFoundException e) {
         System.out.println("Configuration file not found. Using default settings.");
      } catch (IOException e) {
         System.err.println("Error loading configuration: " + e.getMessage());
      }
   }

   public static boolean configFileExists() {
      return new File(CONFIG_FILE).exists();
   }

   @Override
   public String toString() {
      return String.format(
            "DatabaseConfig{type=%s, host='%s', port='%s', database='%s', username='%s', autoConnect=%s}",
            type, host, port, database, username, autoConnect);
   }
}
```
`DatabaseInterface.java`<br>
Create: 1 ต.ค. 2568 time 03:49<br>
```java
package database;

import java.util.List;
import model.Note;

public interface DatabaseInterface {
   boolean connect();

   void disconnect();

   boolean isConnected();

   boolean testConnection();

   boolean saveNote(Note note);

   List<Note> loadAllNotes();

   boolean updateNote(Note note);

   boolean deleteNote(int id);

   List<Note> searchNotes(String searchTerm);

   boolean clearAllNotes();

   String getDatabaseType();

   String getConnectionStatus();
}
```
`DatabaseManager.java`<br>
Create: 1 ต.ค. 2568 time 03:49<br>
Last edited: Time 05:33<br>

```java
package database;

import java.util.ArrayList;
import java.util.List;

import database.providers.MySQL;
import model.Note;
import model.NoteManager;

public class DatabaseManager {
   private DatabaseInterface database;
   private DatabaseConfig config;
   private NoteManager noteManager;

   public DatabaseManager(NoteManager noteManager) {
      this.noteManager = noteManager;
      this.config = new DatabaseConfig();

      if (DatabaseConfig.configFileExists()) {
         config.loadFromFile();
      }

      initializeDatabase();
   }

   public void initializeDatabase() {
      if (database != null && database.isConnected()) {
         database.disconnect();
      }

      database = createDatabaseInstance(config.getType());

      if (config.isAutoConnect()) {
         connectToDatabase(noteManager != null);
      }
   }

   private DatabaseInterface createDatabaseInstance(DatabaseConfig.DatabaseType type) {
      switch (type) {
         case MYSQL:
            return new MySQL(config);
         case OFFLINE:
         default:
            return new OfflineDatabase();
      }
   }

   public boolean connectToDatabase() {
      return connectToDatabase(true);
   }

   public boolean connectToDatabase(boolean syncAfterConnection) {
      if (database == null) {
         initializeDatabase();
      }

      boolean connected = database.connect();

      if (connected && syncAfterConnection && noteManager != null) {
         syncNotesFromDatabase();
      }

      return connected;
   }

   public void disconnectFromDatabase() {
      if (database != null && database.isConnected()) {
         database.disconnect();
      }
   }

   public boolean testDatabaseConnection() {
      if (database == null) {
         initializeDatabase();
      }
      return database.testConnection();
   }

   public void syncNotesFromDatabase() {
      if (database == null || !database.isConnected() || noteManager == null) {
         return;
      }

      try {
         List<Note> dbNotes = database.loadAllNotes();

         noteManager.clearAllNotes(false);

         for (Note note : dbNotes) {
            noteManager.addNote(note, false);
         }

         System.out.println("Synced " + dbNotes.size() + " notes from database");

      } catch (Exception e) {
         System.err.println("Error syncing notes from database: " + e.getMessage());
      }
   }

   public boolean syncNotesToDatabase() {
      if (database == null || !database.isConnected() || noteManager == null) {
         return false;
      }

      try {
         List<Note> notes = noteManager.getAllNotes();

         database.clearAllNotes();

         for (Note note : notes) {
            if (!database.saveNote(note)) {
               System.err.println("Failed to save note: " + note.getTitle());
               return false;
            }
         }

         System.out.println("Synced " + notes.size() + " notes to database");
         return true;

      } catch (Exception e) {
         System.err.println("Error syncing notes to database: " + e.getMessage());
         return false;
      }
   }

   public boolean saveNoteToDatabase(Note note) {
      if (database == null || !database.isConnected()) {
         return false;
      }

      return database.saveNote(note);
   }

   public boolean updateNoteInDatabase(Note note) {
      if (database == null || !database.isConnected()) {
         return false;
      }

      return database.updateNote(note);
   }

   public boolean deleteNoteFromDatabase(int noteId) {
      if (database == null || !database.isConnected()) {
         return false;
      }

      return database.deleteNote(noteId);
   }

   public List<Note> searchNotesInDatabase(String searchTerm) {
      if (database == null || !database.isConnected()) {
         return noteManager != null ? noteManager.searchNotes(searchTerm) : new ArrayList<>();
      }

      return database.searchNotes(searchTerm);
   }

   public DatabaseConfig getDatabaseConfig() {
      return config;
   }

   public void updateDatabaseConfig(DatabaseConfig newConfig) {
      this.config = newConfig;
      config.saveToFile();
      initializeDatabase();
   }

   public DatabaseInterface getCurrentDatabase() {
      return database;
   }

   public String getConnectionStatus() {
      if (database == null) {
         return "No database initialized";
      }
      return database.getConnectionStatus();
   }

   public String getDatabaseType() {
      if (database == null) {
         return "Unknown";
      }
      return database.getDatabaseType();
   }

   public boolean isConnected() {
      return database != null && database.isConnected();
   }

   public void enableAutoSave(boolean enable) {
      config.setAutoConnect(enable);
      config.saveToFile();
   }

   public boolean backupNotesToFile() {
      if (noteManager == null) {
         System.err.println("Cannot backup: noteManager is null");
         return false;
      }

      try {
         OfflineDatabase backupDb = new OfflineDatabase();
         if (backupDb.connect()) {
            List<Note> notes = noteManager.getAllNotes();

            backupDb.clearAllNotes();
            for (Note note : notes) {
               backupDb.saveNote(note);
            }

            backupDb.disconnect();
            System.out.println("Notes backed up successfully");
            return true;
         }
      } catch (Exception e) {
         System.err.println("Error backing up notes: " + e.getMessage());
      }
      return false;
   }

   public boolean restoreNotesFromFile() {
      if (noteManager == null) {
         System.err.println("Cannot restore: noteManager is null");
         return false;
      }

      try {
         OfflineDatabase backupDb = new OfflineDatabase();
         if (backupDb.connect()) {
            List<Note> backupNotes = backupDb.loadAllNotes();

            if (!backupNotes.isEmpty()) {
               noteManager.clearAllNotes();
               for (Note note : backupNotes) {
                  noteManager.addNote(note);
               }

               if (isConnected()) {
                  syncNotesToDatabase();
               }

               backupDb.disconnect();
               System.out.println("Notes restored from backup");
               return true;
            }

            backupDb.disconnect();
         }
      } catch (Exception e) {
         System.err.println("Error restoring notes: " + e.getMessage());
      }
      return false;
   }

   public String getDatabaseStatistics() {
      if (database == null) {
         return "No database configured";
      }

      StringBuilder stats = new StringBuilder();
      stats.append("Database Type: ").append(getDatabaseType()).append("\n");
      stats.append("Connection Status: ").append(getConnectionStatus()).append("\n");
      stats.append("Configuration: ").append(config.getType().getDisplayName()).append("\n");

      if (config.getType() == DatabaseConfig.DatabaseType.MYSQL) {
         stats.append("Host: ").append(config.getHost()).append(":").append(config.getPort()).append("\n");
         stats.append("Database: ").append(config.getDatabase()).append("\n");
      }

      return stats.toString();
   }
}
```
`OfflineDatabase.java`<br>
Create: 1 ต.ค. 2568 time 03:49<br>
Last edited: Time 05:33<br>

```java
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
```

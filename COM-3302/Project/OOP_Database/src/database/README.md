`Database.java`<br>
Create: 1 ต.ค. 2568 time 03:49<br>
Update: 6 ต.ค. 2568 time 08:11<br>
```java
package database;

import java.util.List;

import core.Note;

public interface Database {
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
`DatabaseConfig.java`<br>
Create: 1 ต.ค. 2568 time 03:49<br>
Update: 6 ต.ค. 2568 time 08:11<br>
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
      } catch (IOException e) {
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

      } catch (FileNotFoundException e) {
      } catch (IOException e) {
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
`DatabaseManager.java`<br>
Create: 1 ต.ค. 2568 time 03:49<br>
Update: 6 ต.ค. 2568 time 08:11<br>
```java
package database;

import java.util.ArrayList;
import java.util.List;

import core.Note;
import core.NoteManager;
import database.providers.MySQL;

public class DatabaseManager {
   private Database database;
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

   private Database createDatabaseInstance(DatabaseConfig.DatabaseType type) {
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

      List<Note> dbNotes = database.loadAllNotes();

      noteManager.clearAllNotes(false);

      for (Note note : dbNotes) {
         noteManager.addNote(note, false);
      }
   }

   public boolean syncNotesToDatabase() {
      if (database == null || !database.isConnected() || noteManager == null) {
         return false;
      }

      List<Note> notes = noteManager.getAllNotes();

      database.clearAllNotes();

      for (Note note : notes) {
         if (!database.saveNote(note)) {
            return false;
         }
      }

      return true;
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

   public Database getCurrentDatabase() {
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

   public boolean backupNotesToFile() {
      if (noteManager == null) {
         return false;
      }

      OfflineDatabase backupDb = new OfflineDatabase();
      if (backupDb.connect()) {
         List<Note> notes = noteManager.getAllNotes();

         backupDb.clearAllNotes();
         for (Note note : notes) {
            backupDb.saveNote(note);
         }

         backupDb.disconnect();
         return true;
      }
      return false;
   }

   public boolean restoreNotesFromFile() {
      if (noteManager == null) {
         return false;
      }

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
            return true;
         }

         backupDb.disconnect();
      }
      return false;
   }

}
```
`OfflineDatabase.java`<br>
Create: 1 ต.ค. 2568 time 03:49<br>
Update: 6 ต.ค. 2568 time 08:11<br>
```java
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
```

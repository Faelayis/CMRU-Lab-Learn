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
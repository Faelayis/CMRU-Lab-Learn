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

      connectToDatabase(noteManager != null);
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
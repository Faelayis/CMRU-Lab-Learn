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
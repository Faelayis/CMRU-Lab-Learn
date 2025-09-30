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
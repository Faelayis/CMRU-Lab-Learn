package gui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import core.Note;
import core.NoteManager;

import java.awt.*;
import java.util.List;

public class MainGUI extends JFrame {
   private NoteManager noteManager;
   private JTable noteTable;
   private DefaultTableModel tableModel;
   private TableRowSorter<DefaultTableModel> sorter;
   private JTextField searchField;
   private JTextField titleField;
   private JTextArea contentArea;
   private JTextField categoryField;
   private JComboBox<Note.Priority> priorityComboBox;

   private JLabel statusLabel;

   public MainGUI() {
      this.noteManager = new NoteManager();
      initializeGUI();
      setupEventHandlers();

      SwingUtilities.invokeLater(() -> {
         if (noteManager.isDatabaseConnected()) {
            refreshTable();
         }
      });
   }

   private void initializeGUI() {
      setTitle("Note Management System");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new BorderLayout());
      createMenuBar();

      JPanel mainPanel = new JPanel(new BorderLayout());

      mainPanel.add(createSearchPanel(), BorderLayout.NORTH);

      JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
      splitPane.setLeftComponent(createTablePanel());
      splitPane.setRightComponent(createFormPanel());
      splitPane.setDividerLocation(500);

      mainPanel.add(splitPane, BorderLayout.CENTER);

      add(mainPanel);

      setSize(1000, 700);
      setLocationRelativeTo(null);
      setMinimumSize(new Dimension(800, 600));
   }

   private void createMenuBar() {
      JMenuBar menuBar = new JMenuBar();
      JMenu fileMenu = new JMenu("File");
      JMenuItem newItem = new JMenuItem("New Note (Ctrl+N)");
      JMenuItem exitItem = new JMenuItem("Exit");

      newItem.addActionListener(_ -> clearForm());
      exitItem.addActionListener(_ -> System.exit(0));

      fileMenu.add(newItem);
      fileMenu.addSeparator();
      fileMenu.add(exitItem);

      JMenu editMenu = new JMenu("Edit");
      JMenuItem clearAllItem = new JMenuItem("Delete All Notes");

      clearAllItem.addActionListener(_ -> clearAllNotes());

      editMenu.add(clearAllItem);

      JMenu viewMenu = new JMenu("View");
      JMenuItem refreshItem = new JMenuItem("Refresh");
      JMenuItem statsItem = new JMenuItem("Statistics");

      refreshItem.addActionListener(_ -> refreshTable());
      statsItem.addActionListener(_ -> showStatistics());

      viewMenu.add(refreshItem);
      viewMenu.add(statsItem);

      JMenu databaseMenu = new JMenu("Database");
      JMenuItem settingsItem = new JMenuItem("Database Settings");
      JMenuItem connectItem = new JMenuItem("Connect to Database");
      JMenuItem disconnectItem = new JMenuItem("Disconnect from Database");
      JMenuItem backupItem = new JMenuItem("Backup to File");
      JMenuItem restoreItem = new JMenuItem("Restore from File");

      settingsItem.addActionListener(_ -> openDatabaseSettings());
      connectItem.addActionListener(_ -> connectToDatabase());
      disconnectItem.addActionListener(_ -> disconnectFromDatabase());
      backupItem.addActionListener(_ -> backupNotesToFile());
      restoreItem.addActionListener(_ -> restoreNotesFromFile());

      databaseMenu.add(settingsItem);
      databaseMenu.addSeparator();
      databaseMenu.add(connectItem);
      databaseMenu.add(disconnectItem);
      databaseMenu.addSeparator();
      databaseMenu.add(backupItem);
      databaseMenu.add(restoreItem);

      menuBar.add(fileMenu);
      menuBar.add(editMenu);
      menuBar.add(viewMenu);
      menuBar.add(databaseMenu);

      setJMenuBar(menuBar);
   }

   private JPanel createSearchPanel() {
      JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      panel.setBorder(BorderFactory.createTitledBorder("Search Notes"));

      panel.add(new JLabel("Search:"));
      searchField = new JTextField(20);

      panel.add(searchField);
      searchField.addActionListener(_ -> performSearch());

      return panel;
   }

   private JPanel createTablePanel() {
      JPanel panel = new JPanel(new BorderLayout());
      panel.setBorder(BorderFactory.createTitledBorder("Note List"));

      String[] columns = { "ID", "Title", "Category", "Priority", "Created Date" };
      tableModel = new DefaultTableModel(columns, 0) {
         @Override
         public boolean isCellEditable(int row, int column) {
            return false;
         }
      };

      noteTable = new JTable(tableModel);
      noteTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      sorter = new TableRowSorter<>(tableModel);
      noteTable.setRowSorter(sorter);

      noteTable.getColumnModel().getColumn(0).setPreferredWidth(50);
      noteTable.getColumnModel().getColumn(1).setPreferredWidth(200);
      noteTable.getColumnModel().getColumn(2).setPreferredWidth(100);
      noteTable.getColumnModel().getColumn(3).setPreferredWidth(80);
      noteTable.getColumnModel().getColumn(4).setPreferredWidth(120);

      JScrollPane scrollPane = new JScrollPane(noteTable);
      panel.add(scrollPane, BorderLayout.CENTER);

      return panel;
   }

   private JPanel createFormPanel() {
      JPanel panel = new JPanel(new BorderLayout());
      panel.setBorder(BorderFactory.createTitledBorder("Note Form"));

      JPanel fieldsPanel = new JPanel(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.insets = new Insets(5, 5, 5, 5);
      gbc.anchor = GridBagConstraints.WEST;

      gbc.gridx = 0;
      gbc.gridy = 0;
      fieldsPanel.add(new JLabel("Title:"), gbc);
      gbc.gridx = 1;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.weightx = 1.0;
      titleField = new JTextField(20);
      fieldsPanel.add(titleField, gbc);

      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.fill = GridBagConstraints.NONE;
      gbc.weightx = 0;
      fieldsPanel.add(new JLabel("Category:"), gbc);
      gbc.gridx = 1;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.weightx = 1.0;
      categoryField = new JTextField(20);
      fieldsPanel.add(categoryField, gbc);

      gbc.gridx = 0;
      gbc.gridy = 2;
      gbc.fill = GridBagConstraints.NONE;
      gbc.weightx = 0;
      fieldsPanel.add(new JLabel("Priority:"), gbc);
      gbc.gridx = 1;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.weightx = 1.0;
      priorityComboBox = new JComboBox<>(Note.Priority.values());
      fieldsPanel.add(priorityComboBox, gbc);

      gbc.gridx = 0;
      gbc.gridy = 3;
      gbc.fill = GridBagConstraints.NONE;
      gbc.weightx = 0;
      fieldsPanel.add(new JLabel("Content:"), gbc);
      gbc.gridx = 1;
      gbc.gridy = 4;
      gbc.fill = GridBagConstraints.BOTH;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      gbc.gridwidth = 2;

      contentArea = new JTextArea(10, 25);
      contentArea.setLineWrap(true);
      contentArea.setWrapStyleWord(true);
      JScrollPane contentScroll = new JScrollPane(contentArea);
      fieldsPanel.add(contentScroll, gbc);

      panel.add(fieldsPanel, BorderLayout.CENTER);

      JPanel buttonsPanel = new JPanel(new FlowLayout());
      JButton saveButton = new JButton("Save");
      JButton updateButton = new JButton("Update");
      JButton deleteButton = new JButton("Delete");
      JButton clearButton = new JButton("Clear Form");

      buttonsPanel.add(saveButton);
      buttonsPanel.add(updateButton);
      buttonsPanel.add(deleteButton);
      buttonsPanel.add(clearButton);

      panel.add(buttonsPanel, BorderLayout.SOUTH);

      saveButton.addActionListener(_ -> saveNote());
      updateButton.addActionListener(_ -> updateNote());
      clearButton.addActionListener(_ -> clearForm());
      deleteButton.addActionListener(_ -> deleteSelectedNote());

      return panel;
   }

   private void setupEventHandlers() {
      noteTable.getSelectionModel().addListSelectionListener(e -> {
         if (!e.getValueIsAdjusting()) {
            loadSelectedNote();
         }
      });

      searchField.getDocument().addDocumentListener(new DocumentListener() {
         @Override
         public void insertUpdate(DocumentEvent e) {
            performSearch();
         }

         @Override
         public void removeUpdate(DocumentEvent e) {
            performSearch();
         }

         @Override
         public void changedUpdate(DocumentEvent e) {
            performSearch();
         }
      });
   }

   private void performSearch() {
      String searchTerm = searchField.getText().trim();

      if (searchTerm.isEmpty()) {
         refreshTable();
         return;
      }

      List<Note> results = noteManager.searchNotes(searchTerm);
      updateTable(results);
   }

   private void saveNote() {
      String title = titleField.getText().trim();
      if (title.isEmpty()) {
         return;
      }

      String content = contentArea.getText();
      String category = categoryField.getText().trim();
      if (category.isEmpty())
         category = "General";

      Note.Priority priority = (Note.Priority) priorityComboBox.getSelectedItem();

      noteManager.addNote(title, content, category, priority);
      refreshTable();
      clearForm();
   }

   private void updateNote() {
      int selectedRow = noteTable.getSelectedRow();
      if (selectedRow == -1) {
         return;
      }

      int modelRow = noteTable.convertRowIndexToModel(selectedRow);
      int noteId = (Integer) tableModel.getValueAt(modelRow, 0);

      String title = titleField.getText().trim();
      if (title.isEmpty()) {
         return;
      }

      String content = contentArea.getText();
      String category = categoryField.getText().trim();
      if (category.isEmpty())
         category = "General";

      Note.Priority priority = (Note.Priority) priorityComboBox.getSelectedItem();

      boolean success = noteManager.updateNote(noteId, title, content, category, priority);
      if (success) {
         refreshTable();
      }
   }

   private void deleteSelectedNote() {
      int selectedRow = noteTable.getSelectedRow();
      if (selectedRow == -1) {
         return;
      }

      int confirm = JOptionPane.showConfirmDialog(
            this,
            "Do you want to delete this note?",
            "Confirm Deletion",
            JOptionPane.YES_NO_OPTION);

      if (confirm == JOptionPane.YES_OPTION) {
         int modelRow = noteTable.convertRowIndexToModel(selectedRow);
         int noteId = (Integer) tableModel.getValueAt(modelRow, 0);

         boolean success = noteManager.removeNote(noteId);
         if (success) {
            refreshTable();
            clearForm();
         }
      }
   }

   private void clearAllNotes() {
      if (noteManager.isEmpty()) {
         return;
      }

      int confirm = JOptionPane.showConfirmDialog(
            this,
            "Do you want to delete all notes?\nThis action cannot be undone",
            "Confirm Delete All",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);

      if (confirm == JOptionPane.YES_OPTION) {
         noteManager.clearAllNotes();
         refreshTable();
         clearForm();
      }
   }

   private void loadSelectedNote() {
      int selectedRow = noteTable.getSelectedRow();
      if (selectedRow != -1) {
         int modelRow = noteTable.convertRowIndexToModel(selectedRow);
         int noteId = (Integer) tableModel.getValueAt(modelRow, 0);

         Note note = noteManager.findNoteById(noteId);
         if (note != null) {
            titleField.setText(note.getTitle());
            contentArea.setText(note.getContent());
            categoryField.setText(note.getCategory());
            priorityComboBox.setSelectedItem(note.getPriority());
         }
      }
   }

   private void clearForm() {
      titleField.setText("");
      contentArea.setText("");
      categoryField.setText("");
      priorityComboBox.setSelectedIndex(1);
      noteTable.clearSelection();
   }

   private void refreshTable() {
      updateTable(noteManager.getAllNotesSorted());
   }

   private void updateTable(List<Note> notes) {
      tableModel.setRowCount(0);

      for (Note note : notes) {
         Object[] row = {
               note.getId(),
               note.getTitle(),
               note.getCategory(),
               note.getPriority(),
               note.getFormattedCreatedDate()
         };
         tableModel.addRow(row);
      }
   }

   private void showStatistics() {
      StringBuilder stats = new StringBuilder();
      stats.append("Total Notes: ").append(noteManager.getTotalNotes()).append("\n\n");
      stats.append("Notes by Category:\n");
      for (String category : noteManager.getAllCategories()) {
         stats.append("- ").append(category).append(": ")
               .append(noteManager.getNotesCountByCategory(category)).append("\n");
      }

      stats.append("\nNotes by Priority:\n");
      noteManager.getPriorityStatistics().forEach((priority, count) -> {
         stats.append("- ").append(priority).append(": ").append(count).append("\n");
      });

      showInfo(stats.toString());
   }

   private void showInfo(String message) {
      JOptionPane.showMessageDialog(this, message, "Information", JOptionPane.INFORMATION_MESSAGE);
   }

   private void connectToDatabase() {
      statusLabel.setText("Connecting to database...");

      SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
         @Override
         protected Boolean doInBackground() throws Exception {
            return noteManager.connectToDatabase();
         }

         @Override
         protected void done() {
            try {
               boolean success = get();
               if (success) {
                  statusLabel.setText("Connected to database successfully");
                  JOptionPane.showMessageDialog(MainGUI.this,
                        "Successfully connected to MySQL database!",
                        "Connection Success",
                        JOptionPane.INFORMATION_MESSAGE);
                  refreshTable();
               } else {
                  statusLabel.setText("Failed to connect to database");
                  JOptionPane.showMessageDialog(MainGUI.this,
                        "Failed to connect to MySQL database.\n" +
                              "Please check:\n" +
                              "1. MySQL server is running\n" +
                              "2. Database credentials are correct\n" +
                              "3. Database 'note' exists\n" +
                              "4. Network connectivity",
                        "Connection Failed",
                        JOptionPane.ERROR_MESSAGE);
               }
            } catch (Exception e) {
               statusLabel.setText("Connection error occurred");
               JOptionPane.showMessageDialog(MainGUI.this,
                     "Connection error: " + e.getMessage(),
                     "Error",
                     JOptionPane.ERROR_MESSAGE);
            }
         }
      };

      worker.execute();
   }

   private void disconnectFromDatabase() {
      noteManager.disconnectFromDatabase();
   }

   private void backupNotesToFile() {
      SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
         @Override
         protected Boolean doInBackground() throws Exception {
            return noteManager.getDatabaseManager().backupNotesToFile();
         }
      };

      worker.execute();
   }

   private void restoreNotesFromFile() {
      int result = JOptionPane.showConfirmDialog(this,
            "This will replace all current notes with file backup data.\nContinue?",
            "Restore from File",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);

      if (result == JOptionPane.YES_OPTION) {
         SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
            @Override
            protected Boolean doInBackground() throws Exception {
               return noteManager.getDatabaseManager().restoreNotesFromFile();
            }

            @Override
            protected void done() {
               try {
                  boolean success = get();
                  if (success) {
                     refreshTable();
                  }
               } catch (Exception e) {
               }
            }
         };

         worker.execute();
      }
   }

   private void openDatabaseSettings() {
      gui.SettingsGUI settingsDialog = new gui.SettingsGUI(this, noteManager.getDatabaseManager());

      // boolean wasConnected = noteManager.isDatabaseConnected();

      settingsDialog.setVisible(true);

      SwingUtilities.invokeLater(() -> {
         if (noteManager.isDatabaseConnected()) {
            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
               @Override
               protected Void doInBackground() throws Exception {
                  noteManager.getDatabaseManager().syncNotesFromDatabase();
                  return null;
               }

               @Override
               protected void done() {
                  try {
                     get();
                     refreshTable();

                  } catch (Exception e) {
                  }
               }
            };

            worker.execute();
         }
      });
   }

}
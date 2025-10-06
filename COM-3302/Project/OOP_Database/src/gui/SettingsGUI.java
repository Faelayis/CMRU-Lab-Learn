package gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import database.DatabaseConfig;
import database.DatabaseManager;

import java.awt.*;
import java.awt.event.ActionListener;

public class SettingsGUI extends JDialog {
   private DatabaseManager databaseManager;
   private DatabaseConfig config;

   private JComboBox<DatabaseConfig.DatabaseType> databaseTypeCombo;
   private JTextField hostField;
   private JTextField portField;
   private JTextField databaseField;
   private JTextField usernameField;
   private JPasswordField passwordField;

   private JPanel mysqlPanel;
   private JPanel statusPanel;

   private JLabel statusLabel;
   private JButton saveButton;
   private JButton cancelButton;
   private JButton resetButton;

   public SettingsGUI(JFrame parent, DatabaseManager databaseManager) {
      super(parent, "Database Settings", true);
      this.databaseManager = databaseManager;
      this.config = new DatabaseConfig();

      DatabaseConfig currentConfig = databaseManager.getDatabaseConfig();
      copyConfig(currentConfig, this.config);

      initializeComponents();
      setupLayout();
      setupEventHandlers();
      updateUIBasedOnDatabaseType();

      setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      setResizable(true);
      pack();
      setLocationRelativeTo(parent);
   }

   private void initializeComponents() {
      databaseTypeCombo = new JComboBox<>(DatabaseConfig.DatabaseType.values());
      databaseTypeCombo.setSelectedItem(config.getType());

      hostField = new JTextField(config.getHost(), 20);
      portField = new JTextField(config.getPort(), 8);
      databaseField = new JTextField(config.getDatabase(), 20);
      usernameField = new JTextField(config.getUsername(), 20);
      passwordField = new JPasswordField(config.getPassword(), 20);

      statusLabel = new JLabel("Ready");
      statusLabel.setForeground(Color.BLUE);

      saveButton = new JButton("Save & Apply");
      cancelButton = new JButton("Cancel");
      resetButton = new JButton("Reset to Defaults");

      saveButton.setBackground(new Color(46, 125, 50));
      saveButton.setForeground(Color.WHITE);

      createMySQLPanel();
   }

   private void createMySQLPanel() {
      mysqlPanel = new JPanel(new GridBagLayout());
      mysqlPanel.setBorder(new TitledBorder("MySQL Database Configuration"));

      GridBagConstraints gbc = new GridBagConstraints();
      gbc.insets = new Insets(5, 5, 5, 5);
      gbc.anchor = GridBagConstraints.WEST;

      gbc.gridx = 0;
      gbc.gridy = 0;
      mysqlPanel.add(new JLabel("Host:"), gbc);
      gbc.gridx = 1;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      mysqlPanel.add(hostField, gbc);

      gbc.gridx = 2;
      gbc.fill = GridBagConstraints.NONE;
      mysqlPanel.add(new JLabel("Port:"), gbc);
      gbc.gridx = 3;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      mysqlPanel.add(portField, gbc);

      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.fill = GridBagConstraints.NONE;
      mysqlPanel.add(new JLabel("Database:"), gbc);
      gbc.gridx = 1;
      gbc.gridwidth = 3;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      mysqlPanel.add(databaseField, gbc);

      gbc.gridx = 0;
      gbc.gridy = 2;
      gbc.gridwidth = 1;
      gbc.fill = GridBagConstraints.NONE;
      mysqlPanel.add(new JLabel("Username:"), gbc);
      gbc.gridx = 1;
      gbc.gridwidth = 3;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      mysqlPanel.add(usernameField, gbc);

      gbc.gridx = 0;
      gbc.gridy = 3;
      gbc.gridwidth = 1;
      gbc.fill = GridBagConstraints.NONE;
      mysqlPanel.add(new JLabel("Password:"), gbc);
      gbc.gridx = 1;
      gbc.gridwidth = 3;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      mysqlPanel.add(passwordField, gbc);

      gbc.gridx = 0;
      gbc.gridy = 4;
      gbc.gridwidth = 4;
      JLabel connectionLabel = new JLabel();
      connectionLabel.setFont(connectionLabel.getFont().deriveFont(Font.ITALIC));
      connectionLabel.setForeground(Color.GRAY);
      updateConnectionLabel(connectionLabel);
      mysqlPanel.add(connectionLabel, gbc);

      ActionListener updateConnection = _ -> updateConnectionLabel(connectionLabel);
      hostField.addActionListener(updateConnection);
      portField.addActionListener(updateConnection);
      databaseField.addActionListener(updateConnection);
   }

   private void updateConnectionLabel(JLabel label) {
      String connectionString = String.format("jdbc:mysql://%s:%s/%s",
            hostField.getText(), portField.getText(), databaseField.getText());
      label.setText("Connection: " + connectionString);
   }

   private void setupLayout() {
      setLayout(new BorderLayout());

      JPanel mainPanel = new JPanel(new BorderLayout());
      JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      topPanel.setBorder(new TitledBorder("Database Type"));
      topPanel.add(new JLabel("Select Database:"));
      topPanel.add(databaseTypeCombo);

      JPanel centerPanel = new JPanel(new CardLayout());
      JPanel offlinePanel = new JPanel(new BorderLayout());
      JLabel offlineLabel = new JLabel("", JLabel.CENTER);
      offlinePanel.add(offlineLabel, BorderLayout.CENTER);

      centerPanel.add(offlinePanel, "OFFLINE");
      centerPanel.add(mysqlPanel, "MYSQL");

      statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      statusPanel.setBorder(new TitledBorder("Connection Status"));
      statusPanel.add(statusLabel);

      JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
      buttonPanel.add(resetButton);
      buttonPanel.add(cancelButton);
      buttonPanel.add(saveButton);

      mainPanel.add(topPanel, BorderLayout.NORTH);
      mainPanel.add(centerPanel, BorderLayout.CENTER);
      mainPanel.add(statusPanel, BorderLayout.SOUTH);

      add(mainPanel, BorderLayout.CENTER);
      add(buttonPanel, BorderLayout.SOUTH);
   }

   private void setupEventHandlers() {
      databaseTypeCombo.addActionListener(_ -> {
         updateUIBasedOnDatabaseType();
         autoTestConnection();
      });
      saveButton.addActionListener(_ -> saveConfiguration());
      cancelButton.addActionListener(_ -> dispose());
      resetButton.addActionListener(_ -> resetToDefaults());

      setupAutoTesting();
   }

   private void updateUIBasedOnDatabaseType() {
      DatabaseConfig.DatabaseType selectedType = (DatabaseConfig.DatabaseType) databaseTypeCombo.getSelectedItem();

      Container parent = mysqlPanel.getParent();
      if (parent instanceof JPanel) {
         CardLayout cardLayout = (CardLayout) parent.getLayout();
         cardLayout.show(parent, selectedType.name());
      }

      if (selectedType == DatabaseConfig.DatabaseType.OFFLINE) {
         statusPanel.setVisible(false);
         SwingUtilities.invokeLater(() -> {
            pack();
            setSize(400, 150);
            setLocationRelativeTo(getParent());
         });
      } else {
         statusPanel.setVisible(true);
         statusLabel.setText("Configuration ready for testing");
         statusLabel.setForeground(Color.BLACK);

         SwingUtilities.invokeLater(() -> {
            pack();
            setLocationRelativeTo(getParent());
         });
      }
   }

   private void autoTestConnection() {
      DatabaseConfig.DatabaseType selectedType = (DatabaseConfig.DatabaseType) databaseTypeCombo.getSelectedItem();
      if (selectedType == DatabaseConfig.DatabaseType.OFFLINE) {
         return;
      }

      saveFormDataToConfig();

      statusLabel.setText("Testing connection...");
      statusLabel.setForeground(Color.ORANGE);

      SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
         @Override
         protected Boolean doInBackground() throws Exception {
            DatabaseManager tempManager = new DatabaseManager(null);
            tempManager.updateDatabaseConfig(config);
            return tempManager.testDatabaseConnection();
         }

         @Override
         protected void done() {
            try {
               boolean success = get();
               if (success) {
                  statusLabel.setText("✓ Connection successful!");
                  statusLabel.setForeground(new Color(46, 125, 50));
               } else {
                  statusLabel.setText("✗ Connection failed!");
                  statusLabel.setForeground(Color.RED);
               }
            } catch (Exception e) {
               statusLabel.setText("✗ Connection error: " + e.getMessage());
               statusLabel.setForeground(Color.RED);
            }
         }
      };

      worker.execute();
   }

   private void setupAutoTesting() {
      DocumentListener autoTestListener = new DocumentListener() {
         @Override
         public void insertUpdate(DocumentEvent e) {
            autoTestConnection();
         }

         @Override
         public void removeUpdate(DocumentEvent e) {
            autoTestConnection();
         }

         @Override
         public void changedUpdate(DocumentEvent e) {
            autoTestConnection();
         }
      };

      hostField.getDocument().addDocumentListener(autoTestListener);
      portField.getDocument().addDocumentListener(autoTestListener);
      databaseField.getDocument().addDocumentListener(autoTestListener);
      usernameField.getDocument().addDocumentListener(autoTestListener);
      passwordField.getDocument().addDocumentListener(autoTestListener);
   }

   private void saveConfiguration() {
      saveFormDataToConfig();

      if (!validateConfiguration()) {
         return;
      }

      databaseManager.updateDatabaseConfig(config);
      dispose();
   }

   private void saveFormDataToConfig() {
      config.setType((DatabaseConfig.DatabaseType) databaseTypeCombo.getSelectedItem());
      config.setHost(hostField.getText().trim());
      config.setPort(portField.getText().trim());
      config.setDatabase(databaseField.getText().trim());
      config.setUsername(usernameField.getText().trim());
      config.setPassword(new String(passwordField.getPassword()));
      config.setAutoConnect(true);
   }

   private boolean validateConfiguration() {
      DatabaseConfig.DatabaseType type = config.getType();

      if (type == DatabaseConfig.DatabaseType.MYSQL) {
         if (!config.isValidMySQLConfig()) {
            JOptionPane.showMessageDialog(this,
                  "Please fill in all required MySQL fields:\n" +
                        "Host, Port, Database, and Username are required.",
                  "Invalid Configuration",
                  JOptionPane.ERROR_MESSAGE);
            return false;
         }
      }

      return true;
   }

   private void resetToDefaults() {
      int result = JOptionPane.showConfirmDialog(this,
            "Reset all settings to default values?",
            "Reset Settings",
            JOptionPane.YES_NO_OPTION);

      if (result == JOptionPane.YES_OPTION) {
         config = new DatabaseConfig();
         updateUIFromConfig();
      }
   }

   private void updateUIFromConfig() {
      databaseTypeCombo.setSelectedItem(config.getType());
      hostField.setText(config.getHost());
      portField.setText(config.getPort());
      databaseField.setText(config.getDatabase());
      usernameField.setText(config.getUsername());
      passwordField.setText(config.getPassword());

      updateUIBasedOnDatabaseType();
   }

   private void copyConfig(DatabaseConfig from, DatabaseConfig to) {
      to.setType(from.getType());
      to.setHost(from.getHost());
      to.setPort(from.getPort());
      to.setDatabase(from.getDatabase());
      to.setUsername(from.getUsername());
      to.setPassword(from.getPassword());
      to.setAutoConnect(from.isAutoConnect());
   }
}
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
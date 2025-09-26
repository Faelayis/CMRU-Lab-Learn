`App.java`<br>
Create: 26 ก.ย. 2568 time 10:27<br>
```java
public class App {
   public static void main(String[] args) {
      DbTool stdDB = new DbTool();
      stdDB.insertData("37100501", "Santi", "32 M.6 maerim chiengmai", "0951123140", 20);
      stdDB.insertData("56100501", "Mana", "2 M.1 maerim chiengmai", "0651224440", 19);
      stdDB.displayAllData();
      stdDB.UpdateData("56100501", "Man", "maerim chiengmai", "0951123140", 22);
      stdDB.displayAllData();
   }
}
```
`DbTool.java`<br>
Create: 26 ก.ย. 2568 time 10:27<br>
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DbTool {
   private Connection connection = null;
   private Statement stmt = null;

   DbTool() {
      System.out.println("***** Studenet Constructor ******");
      String url = "jdbc:mysql://localhost:3306/student_his";
      String username = "root";
      String password = "";
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         connection = DriverManager.getConnection(url, username, password);
         System.out.println("Database connection successful!");
         stmt = connection.createStatement();
         String sql = "CREATE TABLE IF NOT EXISTS  student " +
               "(id char(8) NOT NULL," +
               "name char(30) NOT NULL," +
               "address char(50) NOT NULL," +
               "Tel char(10) NOT NULL," +
               "age int(3) NOT NULL)";

         int i = stmt.executeUpdate(sql);
         System.out.println("Table Created at " + i);

      } catch (ClassNotFoundException e) {
         System.out.println("MySQL JDBC driver not found!");
         e.printStackTrace();
      } catch (SQLException e) {
         System.out.println("Failed to connect to the database!");
         e.printStackTrace();
      }
   }

   public void displayAllData() {
      System.out.println("***** In Display All Data ******");
      try {
         Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery("Select * From student");
         while (rs.next()) {
            System.out.print("ID: " + rs.getString("id"));
            System.out.print(", Name: " + rs.getString("name"));
            System.out.print(", Address: " + rs.getString("address"));
            System.out.print(", Telephone: " + rs.getString("Tel"));
            System.out.println(", age: " + rs.getString("age"));
         }
      } catch (Exception e) {
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
         System.exit(0);
      }
   }

   public void CloseDb() {
      System.out.println("***** Close Data ******");
      if (stmt != null) {
         try {
            stmt.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      if (connection != null) {
         try {
            connection.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }

   public void insertData(String id, String name, String address, String tel, int age) {
      System.out.println("***** Insert Data ******");
      String sql;
      sql = "INSERT INTO student (ID,NAME,ADDRESS,TEL,AGE) " +
            "VALUES('" + id + "','" + name + "','" + address + "', '" + tel + "', '" + age + "');";

      System.out.println(sql);
      try {
         Statement stmt = connection.createStatement();
         stmt.executeUpdate(sql);
      } catch (Exception e) {
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
         System.exit(0);
      }
   }

   public List<Student_his> selectAll() {
      System.out.println("***** SELECT ALL ******");
      String sql = "SELECT * FROM student;";
      List<Student_his> data = new java.util.ArrayList<>();
      ResultSet rs;
      try {
         rs = stmt.executeQuery(sql);
         while (rs.next()) {
            String id = rs.getString("id");
            String name = rs.getString("name");
            String address = rs.getString("address");
            String tel = rs.getString("tel");
            byte age = rs.getByte("age");

            Student_his obj = new Student_his(id, name, address, tel, age);
            data.add(obj);
         }
         return data;
      } catch (Exception e) {
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
         System.exit(0);
         return data;
      }
   }

   public void UpdateData(String id, String name, String address, String tel, int age) {
      System.out.println("***** Update ******");
      String sql = "UPDATE student set ";
      sql = sql + " Name = '" + name + "',";
      sql = sql + " Address = '" + address;
      sql = sql + "' ,Tel = '" + tel + "',";
      sql = sql + " Age = " + age;
      sql = sql + " where id='" + id + "';";
      System.out.println(sql);
      try {
         stmt.executeUpdate(sql);
         // conn.commit();
      } catch (Exception e) {
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
         System.out.println(sql);
         System.exit(0);
      }
   }

}
```
`Student_his.java`<br>
Create: 26 ก.ย. 2568 time 10:27<br>
```java

public class Student_his {
   private String id, name, address, tel;
   private int age;

   public Student_his(String id, String name, String address, String tel, int age) {
      this.id = id;
      this.name = name;
      this.address = address;
      this.address = address;
      this.age = age;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public String getTel() {
      return tel;
   }

   public void setTel(String tel) {
      this.tel = tel;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

}

```

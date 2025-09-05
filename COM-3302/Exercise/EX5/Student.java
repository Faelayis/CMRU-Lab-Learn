package Exercise.EX5;

public class Student {
   private String id;
   private String name;
   private String section;
   private String projectName;
   private String borrowDate;

   public Student(String id, String name, String section) {
      this.id = id;
      this.name = name;
      this.section = section;
   }

   public void borrowProject(String projectName, String borrowDate) {
      this.projectName = projectName;
      this.borrowDate = borrowDate;
   }

   public void showProject() {
      System.out.println("Student ID: " + id);
      System.out.println("Name: " + name);
      System.out.println("Section: " + section);
      System.out.println("Borrowed Project: " + projectName);
      System.out.println("Borrow Date: " + borrowDate);
   }

   public static void main(String[] args) {
      Student studentRecord = new Student("66143XXX", "Fae", "4.2");
      studentRecord.borrowProject("test", "29-08-2025");
      studentRecord.showProject();
   }
}

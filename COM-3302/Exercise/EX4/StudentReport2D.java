package Exercise.EX4;

import java.util.Scanner;

public class StudentReport2D {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      System.out.print("Please enter number of students: ");
      int numStudents = scanner.nextInt();

      double[][] scores = new double[numStudents][4];
      String[][] studentInfo = new String[numStudents][2];

      for (int i = 0; i < numStudents; i++) {
         System.out.println("\n--- Student " + (i + 1) + " Information ---");

         scanner.nextLine();
         System.out.print("Student ID: ");
         studentInfo[i][0] = scanner.nextLine();

         System.out.print("Full Name: ");
         studentInfo[i][1] = scanner.nextLine();

         System.out.print("Test 1 Score (out of 30): ");
         scores[i][0] = scanner.nextDouble();

         System.out.print("Test 2 Score (out of 30): ");
         scores[i][1] = scanner.nextDouble();

         System.out.print("Final Exam Score (out of 40): ");
         scores[i][2] = scanner.nextDouble();

         scores[i][3] = scores[i][0] + scores[i][1] + scores[i][2];
      }

      double[] averages = new double[4];

      for (int j = 0; j < 4; j++) {
         double sum = 0;
         for (int i = 0; i < numStudents; i++) {
            sum += scores[i][j];
         }
         averages[j] = sum / numStudents;
      }

      System.out.println("\n=== Student Score Report (2D Array) ===");
      System.out.println("============================================================================");
      System.out.printf("%-12s %-30s %8s %8s %8s %8s%n",
            "Code", "Name", "Test1", "Test2", "Final", "Total");
      System.out.println("============================================================================");

      for (int i = 0; i < numStudents; i++) {
         System.out.printf("%-12s %-30s %8.2f %8.2f %8.2f %8.2f%n",
               studentInfo[i][0],
               studentInfo[i][1],
               scores[i][0],
               scores[i][1],
               scores[i][2],
               scores[i][3]);
      }

      System.out.println("============================================================================");
      System.out.printf("%-42s %8.2f %8.2f %8.2f %8.2f%n",
            "Average", averages[0], averages[1], averages[2], averages[3]);
      System.out.println("============================================================================");

      System.out.println("\n=== 2D Array Data Access Example ===");
      System.out.println("First student:");
      System.out.println("  ID: " + studentInfo[0][0]);
      System.out.println("  Name: " + studentInfo[0][1]);
      System.out.println("  Test1: " + scores[0][0]);
      System.out.println("  Test2: " + scores[0][1]);
      System.out.println("  Final: " + scores[0][2]);
      System.out.println("  Total: " + scores[0][3]);

      scanner.close();
   }
}
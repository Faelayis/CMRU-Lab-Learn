package Exercise.EX4;

import java.util.Scanner;

public class StudentReport1D {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      System.out.print("Please enter number of students: ");
      int numStudents = scanner.nextInt();

      String[] codes = new String[numStudents];
      String[] names = new String[numStudents];
      double[] test1 = new double[numStudents];
      double[] test2 = new double[numStudents];
      double[] finalExam = new double[numStudents];
      double[] total = new double[numStudents];

      for (int i = 0; i < numStudents; i++) {
         System.out.println("\n--- Student " + (i + 1) + " Information ---");

         scanner.nextLine();
         System.out.print("Student ID: ");
         codes[i] = scanner.nextLine();

         System.out.print("Full Name: ");
         names[i] = scanner.nextLine();

         System.out.print("Test 1 Score (out of 30): ");
         test1[i] = scanner.nextDouble();

         System.out.print("Test 2 Score (out of 30): ");
         test2[i] = scanner.nextDouble();

         System.out.print("Final Exam Score (out of 40): ");
         finalExam[i] = scanner.nextDouble();

         total[i] = test1[i] + test2[i] + finalExam[i];
      }

      double avgTest1 = 0, avgTest2 = 0, avgFinal = 0, avgTotal = 0;
      for (int i = 0; i < numStudents; i++) {
         avgTest1 += test1[i];
         avgTest2 += test2[i];
         avgFinal += finalExam[i];
         avgTotal += total[i];
      }
      avgTest1 /= numStudents;
      avgTest2 /= numStudents;
      avgFinal /= numStudents;
      avgTotal /= numStudents;

      System.out.println("\n=== Student Score Report ===");
      System.out.println("============================================================================");
      System.out.printf("%-12s %-30s %8s %8s %8s %8s%n",
            "Code", "Name", "Test1", "Test2", "Final", "Total");
      System.out.println("============================================================================");

      for (int i = 0; i < numStudents; i++) {
         System.out.printf("%-12s %-30s %8.2f %8.2f %8.2f %8.2f%n",
               codes[i], names[i], test1[i], test2[i], finalExam[i], total[i]);
      }

      System.out.println("============================================================================");
      System.out.printf("%-42s %8.2f %8.2f %8.2f %8.2f%n",
            "Average", avgTest1, avgTest2, avgFinal, avgTotal);
      System.out.println("============================================================================");

      scanner.close();
   }
}
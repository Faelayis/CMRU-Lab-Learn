`DivisibleNumbers.java`<br>
Create: 1 ส.ค. 2568 time 10:05<br>
```java
package Exercise.EX3;

import java.util.ArrayList;

public class DivisibleNumbers {
   public static void main(String[] args) {
      System.out.println("=== Find Numbers Divisible by 3 and 5 (1-100) ===\n");
      System.out.println("1. Using for loop:");
      findDivisibleWithFor();
      System.out.println("\n2. Using while loop:");
      findDivisibleWithWhile();
      System.out.println("\n3. Using do-while loop:");
      findDivisibleWithDoWhile();
   }

   public static void findDivisibleWithFor() {
      ArrayList<Integer> numbers = new ArrayList<>();

      for (int i = 1; i <= 100; i++) {
         if (i % 3 == 0 && i % 5 == 0) {
            numbers.add(i);
         }
      }

      displayResults(numbers);
   }

   public static void findDivisibleWithWhile() {
      ArrayList<Integer> numbers = new ArrayList<>();
      int i = 1;

      while (i <= 100) {
         if (i % 3 == 0 && i % 5 == 0) {
            numbers.add(i);
         }
         i++;
      }

      displayResults(numbers);
   }

   public static void findDivisibleWithDoWhile() {
      ArrayList<Integer> numbers = new ArrayList<>();
      int i = 1;

      do {
         if (i % 3 == 0 && i % 5 == 0) {
            numbers.add(i);
         }
         i++;
      } while (i <= 100);

      displayResults(numbers);
   }

   public static void displayResults(ArrayList<Integer> numbers) {
      System.out.print("Numbers divisible by 3 and 5: ");
      for (int i = 0; i < numbers.size(); i++) {
         System.out.print(numbers.get(i));
         if (i < numbers.size() - 1) {
            System.out.print(", ");
         }
      }
      System.out.println("\nTotal count: " + numbers.size() + " numbers");
   }
}
```
`StudentScores.java`<br>
Create: 1 ส.ค. 2568 time 10:05<br>
```java
package Exercise.EX3;

import java.util.Scanner;

public class StudentScores {
   public static void main(String[] args) {
      final int MAX_STUDENTS = 100;
      int[] code = new int[MAX_STUDENTS];
      String[] name = new String[MAX_STUDENTS];
      float[] test1 = new float[MAX_STUDENTS];
      float[] test2 = new float[MAX_STUDENTS];
      float[] finalExam = new float[MAX_STUDENTS];
      float[] total = new float[MAX_STUDENTS];
      float[] average = new float[MAX_STUDENTS];

      Scanner sc = new Scanner(System.in);
      int i = 0;

      System.out.println("===== Student Score Input System =====");
      System.out.println("Type 'exit' or 'Exit' as Name to stop and show results.");

      while (i < MAX_STUDENTS) {
         System.out.println("\n--- Student " + (i + 1) + " ---");

         System.out.print("Enter student code: ");
         while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Enter student code: ");
            sc.next();
         }
         code[i] = sc.nextInt();
         sc.nextLine();

         System.out.print("Enter student name (or 'exit' to quit): ");
         name[i] = sc.nextLine().trim();

         if (name[i].equalsIgnoreCase("exit")) {
            break;
         }

         System.out.print("Enter test 1 score (max 30): ");
         while (!sc.hasNextFloat()) {
            System.out.print("Invalid input. Enter test 1 score (max 30): ");
            sc.next();
         }
         test1[i] = sc.nextFloat();

         System.out.print("Enter test 2 score (max 30): ");
         while (!sc.hasNextFloat()) {
            System.out.print("Invalid input. Enter test 2 score (max 30): ");
            sc.next();
         }
         test2[i] = sc.nextFloat();

         System.out.print("Enter final exam score (max 40): ");
         while (!sc.hasNextFloat()) {
            System.out.print("Invalid input. Enter final exam score (max 40): ");
            sc.next();
         }
         finalExam[i] = sc.nextFloat();
         sc.nextLine();

         total[i] = test1[i] + test2[i] + finalExam[i];
         average[i] = total[i] / 3.0f;

         i++;
      }

      System.out.println("\n\n===== Student Report =====");

      if (i == 0) {
         System.out.println("No student data entered.");
      } else {
         System.out.printf("%-10s %-25s %-8s %-8s %-8s %-8s %-8s\n",
               "Code", "Name", "Test1", "Test2", "Final", "Total", "Average");
         for (int j = 0; j < i; j++) {
            System.out.printf("%-10d %-25s %-8.2f %-8.2f %-8.2f %-8.2f %-8.2f\n",
                  code[j], name[j], test1[j], test2[j], finalExam[j], total[j], average[j]);
         }
      }

      sc.close();
   }
}
```

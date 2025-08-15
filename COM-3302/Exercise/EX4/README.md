`BubbleSortDoWhile.java`<br>
Create: 15 ส.ค. 2568 time 10:51<br>
```java
package Exercise.EX4;

import java.util.Arrays;

public class BubbleSortDoWhile {

   public static void bubbleSortDoWhile(int[] array) {
      int arraySize = array.length;
      System.out.println("Bubble Sort with do-while loop:");
      System.out.println("Initial data: " + Arrays.toString(array));

      int index = 0;
      do {
         int j = 0;

         do {
            if (j < arraySize - index - 1 && array[j] > array[j + 1]) {
               int temp = array[j];
               array[j] = array[j + 1];
               array[j + 1] = temp;
            }
            j++;
         } while (j < arraySize - index - 1);

         System.out.println("Pass " + (index + 1) + ": " + Arrays.toString(array));
         index++;
      } while (index < arraySize - 1);

      System.out.println("Final result: " + Arrays.toString(array));
      System.out.println();
   }

   public static void main(String[] args) {
      int[] data = { 64, 34, 25, 12, 22, 11, 90 };

      System.out.println("=== Bubble Sort with Do-While Loop ===\n");
      bubbleSortDoWhile(data);
   }
}
```
`BubbleSortFor.java`<br>
Create: 15 ส.ค. 2568 time 10:51<br>
```java
package Exercise.EX4;

import java.util.Arrays;

public class BubbleSortFor {

   public static void bubbleSortFor(int[] array) {
      int arraySize = array.length;
      System.out.println("Bubble Sort with for loop:");
      System.out.println("Initial data: " + Arrays.toString(array));

      for (int index = 0; index < arraySize - 1; index++) {
         for (int j = 0; j < arraySize - index - 1; j++) {
            if (array[j] > array[j + 1]) {
               int temp = array[j];
               array[j] = array[j + 1];
               array[j + 1] = temp;
            }
         }
         System.out.println("Pass " + (index + 1) + ": " + Arrays.toString(array));
      }
      System.out.println("Final result: " + Arrays.toString(array));
      System.out.println();
   }

   public static void main(String[] args) {
      int[] data = { 64, 34, 25, 12, 22, 11, 90 };

      System.out.println("=== Bubble Sort with For Loop ===\n");
      bubbleSortFor(data);
   }
}
```
`BubbleSortWhile.java`<br>
Create: 15 ส.ค. 2568 time 10:51<br>
```java
package Exercise.EX4;

import java.util.Arrays;

public class BubbleSortWhile {

   public static void bubbleSortWhile(int[] array) {
      int arraySize = array.length;
      System.out.println("Bubble Sort with while loop:");
      System.out.println("Initial data: " + Arrays.toString(array));

      int index = 0;
      while (index < arraySize - 1) {
         int j = 0;

         while (j < arraySize - index - 1) {
            if (array[j] > array[j + 1]) {
               int temp = array[j];
               array[j] = array[j + 1];
               array[j + 1] = temp;
            }
            j++;
         }
         System.out.println("Pass " + (index + 1) + ": " + Arrays.toString(array));
         index++;
      }
      System.out.println("Final result: " + Arrays.toString(array));
      System.out.println();
   }

   public static void main(String[] args) {
      int[] data = { 64, 34, 25, 12, 22, 11, 90 };

      System.out.println("=== Bubble Sort with While Loop ===\n");
      bubbleSortWhile(data);
   }
}
```
`StudentReport1D.java`<br>
Create: 15 ส.ค. 2568 time 10:51<br>
```java
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
```
`StudentReport2D.java`<br>
Create: 15 ส.ค. 2568 time 10:51<br>
```java
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
```

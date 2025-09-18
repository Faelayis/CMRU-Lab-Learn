
## Exercise/EX1

##### `BMICalculator.java`<br>
Create: 14 ก.ค. 2568 time 22:25<br>
```java
package Exercise.EX1;

public class BMICalculator {
   public static String interpretBMI(double bmi) {
      if (bmi < 18.5) {
         return "Underweight";
      } else if (bmi >= 18.5 && bmi < 25) {
         return "Normal";
      } else if (bmi >= 25 && bmi < 30) {
         return "Overweight";
      } else {
         return "Obese";
      }
   }

   public static double calculateBMI(double weightKg, double heightM) {
      if (heightM <= 0) {
         return Double.NaN;
      }
      return weightKg / (heightM * heightM);
   }
}

```

##### `BMIProgram.java`<br>
Create: 14 ก.ค. 2568 time 22:25<br>
```java
package Exercise.EX1;

import java.util.Scanner;

public class BMIProgram {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("=== Body Mass Index (BMI) Calculator Program ===");

      double weight = 0;
      double heightCm = 0;

      while (true) {
         try {
            System.out.print("Please enter your weight (kilograms): ");
            weight = scanner.nextDouble();

            if (weight <= 0) {
               System.out.println("Weight must be positive. Please try again.");
               continue;
            }

            break;
         } catch (java.util.InputMismatchException error) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
         }
      }

      while (true) {
         try {
            System.out.print("Please enter your height (centimeters): ");
            heightCm = scanner.nextDouble();

            if (heightCm <= 0) {
               System.out.println("Height must be positive. Please try again.");
               continue;
            }

            break;
         } catch (java.util.InputMismatchException error) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
         }
      }

      // BMI
      double heightM = heightCm / 100.0;
      double bmiValue = BMICalculator.calculateBMI(weight, heightM);

      if (Double.isNaN(bmiValue) || Double.isInfinite(bmiValue)) {
         System.out.println("Cannot calculate BMI (invalid height data)");
      } else {
         System.out.printf("\nCalculation Results:\n");
         System.out.printf("Your Body Mass Index (BMI) is: %.2f\n", bmiValue);
         System.out.println("Assessment: " + BMICalculator.interpretBMI(bmiValue));

         System.out.println("\n=== BMI Reference Table ===");
         System.out.println("Less than 18.5       : Underweight");
         System.out.println("18.5 - 24.9          : Normal");
         System.out.println("25.0 - 29.9          : Overweight");
         System.out.println("30.0 and above       : Obese");
      }

      scanner.close();
   }
}

```

##### `BMRCalculator.java`<br>
Create: 14 ก.ค. 2568 time 22:25<br>
```java
package Exercise.EX1;

public class BMRCalculator {
   public static double calculateBMR(String gender, double weightKg, double heightCm, int age) {
      double bmr = Double.NaN;

      if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("m")) {
         // Formula for Male: BMR = 66 + (13.7 x weight) + (5 x height) - (6.8 x age)
         bmr = 66 + (13.7 * weightKg) + (5 * heightCm) - (6.8 * age);
      } else if (gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("f")) {
         // Formula for Female: BMR = 665 + (9.6 x weight) + (1.8 x height) - (4.7 x age)
         bmr = 665 + (9.6 * weightKg) + (1.8 * heightCm) - (4.7 * age);
      }

      return bmr;
   }

   public static String getGenderInThai(String gender) {
      if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("m")) {
         return "Male";
      } else if (gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("f")) {
         return "Female";
      }
      return "Not Specified";
   }
}

```

##### `BMRProgram.java`<br>
Create: 10 ก.ค. 2568 time 02:33<br>
Update: 14 ก.ค. 2568 time 22:25<br>
```java
package Exercise.EX1;

import java.util.Scanner;

public class BMRProgram {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("=== Basal Metabolic Rate (BMR) Calculator Program ===");

      double weight = 0;
      double heightCm = 0;
      String gender = "";
      int age = 0;

      while (true) {
         try {
            System.out.print("Please enter your weight (kilograms): ");
            weight = scanner.nextDouble();

            if (weight <= 0) {
               System.out.println("Weight must be a positive value. Please try again.");
               continue;
            }

            break;
         } catch (java.util.InputMismatchException error) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
         }
      }

      while (true) {
         try {
            System.out.print("Please enter your height (centimeters): ");
            heightCm = scanner.nextDouble();

            if (heightCm <= 0) {
               System.out.println("Height must be a positive value. Please try again.");
               continue;
            }

            break;
         } catch (java.util.InputMismatchException error) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
         }
      }

      while (true) {
         try {
            System.out.print("Please enter your age (years): ");
            age = scanner.nextInt();

            if (age <= 0) {
               System.out.println("Age must be a positive value. Please try again.");
               continue;
            }

            break;
         } catch (java.util.InputMismatchException error) {
            System.out.println("Invalid input. Please enter a whole number.");
            scanner.next();
         }
      }

      while (true) {
         System.out.print("Please select your gender (male/female or m/f): ");
         gender = scanner.next().trim();

         if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("m") ||
               gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("f")) {
            break;
         } else {
            System.out.println("Invalid gender. Please enter 'male', 'female', 'm' or 'f'");
         }
      }

      // BMR
      double bmrValue = BMRCalculator.calculateBMR(gender, weight, heightCm, age);

      if (Double.isNaN(bmrValue) || Double.isInfinite(bmrValue)) {
         System.out.println("Unable to calculate BMR due to invalid gender data");
      } else {
         System.out.printf("\nCalculation Results:\n");
         System.out.printf("Your Basal Metabolic Rate (BMR) is: %.2f calories/day\n", bmrValue);

         System.out.println("\n=== BMR Reference Formula ===");
         if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("m")) {
            System.out.println("For Male: BMR = 66 + (13.7 × weight) + (5 × height) - (6.8 × age)");
         } else {
            System.out.println("For Female: BMR = 665 + (9.6 × weight) + (1.8 × height) - (4.7 × age)");
         }
      }

      scanner.close();
   }
}

```

##### `Switch_to_if_24.java`<br>
Create: 14 ก.ค. 2568 time 22:25<br>
```java
package Exercise.EX1;

import java.io.*;
import java.lang.Integer;

public class Switch_to_if_24 {
   public static void main(String args[]) throws IOException {
      char answer;
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader buffer = new BufferedReader(isr);

      System.out.print("Enter A [Y] or [N] : ");
      String input = buffer.readLine();
      answer = (char) input.charAt(0);

      if (answer == 'Y' || answer == 'y') {
         System.out.print("You Enter Y\n");
      } else if (answer == 'N' || answer == 'n') {
         System.out.print("You Enter N\n");
      } else {
         System.out.print("Error !\n");
      } /* End of If */
   }
}
```

##### `Switch_to_if_25.java`<br>
Create: 14 ก.ค. 2568 time 22:25<br>
```java
package Exercise.EX1;

import java.io.*;
import java.lang.Integer;

public class Switch_to_if_25 {
   public static void main(String args[]) throws IOException {
      int a, b, answer, choice;
      double s = 0.00;
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader buffer = new BufferedReader(isr);

      String input = buffer.readLine();
      a = Integer.parseInt(input);
      input = buffer.readLine();
      b = Integer.parseInt(input);

      System.out.print("1: Add");
      System.out.print("2: Subtract");
      System.out.print("3: Multiply");
      System.out.print("4: Divide");
      System.out.print("Enter choice 1..4 : ");

      input = buffer.readLine();
      answer = Integer.parseInt(input);

      if (answer == 1) {
         s = a + b;
         System.out.print(a + "+" + b + "=" + s);
      } else if (answer == 2) {
         s = a - b;
         System.out.print(a + "-" + b + "=" + s);
      } else if (answer == 3) {
         s = a * b;
         System.out.print(a + "*" + b + "=" + s);
      } else if (answer == 4) {
         s = a / b;
         System.out.print(a + "/" + b + "=" + s);
      } else {
         System.out.print("Error ! \n");
      } /* End of If */
   }
}
```


## Exercise/EX2

##### `Do_While.java`<br>
Create: 25 ก.ค. 2568 time 10:08<br>
```java
package Exercise.EX2;

public class Do_While {
   public static void main(String[] args) {
      int row = 1;

      do {
         int col = 1;

         do {
            System.out.println("row = " + row + " col = " + col);
         } while (++col <= 3);
      } while (++row <= 2);
   }
}

```

##### `Loop.java`<br>
Create: 24 ก.ค. 2568 time 20:55<br>
```java
package Exercise.EX2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loop {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      List<Integer> numbers = new ArrayList<>();

      System.out.println("Please enter integers (press enter input to stop):");

      while (scanner.hasNextLine()) {
         String input = scanner.nextLine();
         if (input.isEmpty()) {
            break;
         }
         try {
            int number = Integer.parseInt(input);
            numbers.add(number);
         } catch (NumberFormatException error) {
            System.out.println("Invalid input. Please enter integers only.");
         }
      }

      if (numbers.isEmpty()) {
         System.out.println("No input data.");
         return;
      }

      int totalCount = numbers.size();
      int evenCount = 0;
      int oddCount = 0;

      long totalSum = 0;
      long evenSum = 0;
      long oddSum = 0;

      for (int number : numbers) {
         totalSum += number;
         if (number % 2 == 0) {
            evenCount++;
            evenSum += number;
         } else {
            oddCount++;
            oddSum += number;
         }
      }

      double totalAverage = (double) totalSum / totalCount;
      double evenAverage = (evenCount > 0) ? (double) evenSum / evenCount : 0;
      double oddAverage = (oddCount > 0) ? (double) oddSum / oddCount : 0;

      System.out.println("\n--- Summary ---");
      System.out.println("1. Data count:");
      System.out.println("Total numbers entered: " + totalCount);
      System.out.println("Even numbers count: " + evenCount);
      System.out.println("Odd numbers count: " + oddCount);
      System.out.println("\n");

      System.out.println("2. Sum of data:");
      System.out.println("Sum of all numbers: " + totalSum);
      System.out.println("Sum of even numbers: " + evenSum);
      System.out.println("Sum of odd numbers: " + oddSum);
      System.out.println("\n");

      System.out.println("3. Average of data:");
      System.out.printf("Average of all numbers: %.2f\n", totalAverage);
      System.out.printf("Average of even numbers: %.2f\n", evenAverage);
      System.out.printf("Average of odd numbers: %.2f\n", oddAverage);

      System.out.println("\n");

      scanner.close();
   }
}

```

##### `While.java`<br>
Create: 25 ก.ค. 2568 time 10:08<br>
```java
package Exercise.EX2;

public class While {
   public static void main(String[] args) {
      int count = 1;

      while (count <= 2) {
         for (int num = 1; num <= 3; num++) {
            System.out.println("count = " + count + " num = " + num);
         }

         count++;
      }
   }
}

```


## Exercise/EX3

##### `DivisibleNumbers.java`<br>
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

##### `StudentScores.java`<br>
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


## Exercise/EX4

##### `BubbleSortDoWhile.java`<br>
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

##### `BubbleSortFor.java`<br>
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

##### `BubbleSortWhile.java`<br>
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

##### `StudentReport1D.java`<br>
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

##### `StudentReport2D.java`<br>
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


## Exercise/EX5

##### `Student.java`<br>
Create: 5 ก.ย. 2568 time 09:00<br>
```java
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

```


## Exercise/EX6

##### `AreaShape.java`<br>
Create: 19 ก.ย. 2568 time 00:39<br>
```java
package Exercise.EX6;

public class AreaShape {
   private double area;
   private String shapeType;
   private String details;

   public AreaShape(double base, double height) {
      this.area = 0.5 * base * height;
      this.shapeType = "Triangle";
      this.details = String.format("Base: %.2f, Height: %.2f", base, height);
   }

   public AreaShape(double width, double length, String type) {
      if (type.equalsIgnoreCase("rectangle")) {
         this.area = width * length;
         this.shapeType = "Rectangle";
         this.details = String.format("Width: %.2f, Length: %.2f", width, length);
      }
   }

   public AreaShape(double radius) {
      this.area = Math.PI * radius * radius;
      this.shapeType = "Circle";
      this.details = String.format("Radius: %.2f", radius);
   }

   public void showArea() {
      System.out.println("Shape Type: " + shapeType);
      System.out.println("Details: " + details);
      System.out.printf("Area: %.2f%n", area);
   }

   public double getArea() {
      return area;
   }

   public String getShapeType() {
      return shapeType;
   }
}
```

##### `TestAreaShape.java`<br>
Create: 19 ก.ย. 2568 time 00:39<br>
```java
package Exercise.EX6;

public class TestAreaShape {
   public static void main(String[] args) {
      System.out.println("Area Shape Calculator with Constructor Overloading\n");

      System.out.println("Creating Triangle:");
      AreaShape triangle = new AreaShape(10.0, 8.0);
      triangle.showArea();

      System.out.println("\nCreating Rectangle:");
      AreaShape rectangle = new AreaShape(12.0, 15.0, "rectangle");
      rectangle.showArea();

      System.out.println("\nCreating Circle:");
      AreaShape circle = new AreaShape(7.0);
      circle.showArea();

      System.out.println("\n=== Summary ===");
      System.out.printf("Triangle Area: %.2f%n", triangle.getArea());
      System.out.printf("Rectangle Area: %.2f%n", rectangle.getArea());
      System.out.printf("Circle Area: %.2f%n", circle.getArea());
   }
}
```


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


## Project/OOP_Database/src

##### `App.java`<br>
Create: 1 ต.ค. 2568 time 03:49<br>
Update: 6 ต.ค. 2568 time 08:11<br>
```java
import javax.swing.SwingUtilities;

import gui.MainGUI;

public class App {
   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> {
         try {
            MainGUI gui = new MainGUI();
            gui.setVisible(true);

         } catch (Exception error) {
            error.printStackTrace();
         }
      });
   }
}

```


## Project/OOP_Database/src/core

##### `Note.java`<br>
Create: 1 ต.ค. 2568 time 03:49<br>
Update: 6 ต.ค. 2568 time 08:11<br>
```java
package core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Note implements Comparable<Note> {
   private static int nextId = 1;

   public static int generateLocalId() {
      return nextId++;
   }

   public static void updateNextIdIfNeeded(int minId) {
      if (minId > nextId) {
         nextId = minId;
      }
   }

   public static void resetIdCounter() {
      nextId = 1;
   }

   private int id;
   private String title;
   private String content;
   private LocalDateTime createdDate;
   private LocalDateTime modifiedDate;
   private String category;
   private Priority priority;

   public enum Priority {
      LOW(1, "Low"),
      MEDIUM(2, "Medium"),
      HIGH(3, "High");

      private final int level;
      private final String description;

      Priority(int level, String description) {
         this.level = level;
         this.description = description;
      }

      public int getLevel() {
         return level;
      }

      public String getDescription() {
         return description;
      }

      @Override
      public String toString() {
         return description;
      }
   }

   public Note(String title, String content, String category, Priority priority) {
      this.id = 0;
      this.title = title;
      this.content = content;
      this.category = category;
      this.priority = priority;
      this.createdDate = LocalDateTime.now();
      this.modifiedDate = LocalDateTime.now();
   }

   public Note(int id, String title, String content, String category, Priority priority,
         LocalDateTime createdDate, LocalDateTime modifiedDate) {
      this.id = id;
      this.title = title;
      this.content = content;
      this.category = category;
      this.priority = priority;
      this.createdDate = createdDate;
      this.modifiedDate = modifiedDate;
   }

   public Note(Note other) {
      this.id = other.id;
      this.title = other.title;
      this.content = other.content;
      this.category = other.category;
      this.priority = other.priority;
      this.createdDate = other.createdDate;
      this.modifiedDate = other.modifiedDate;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getTitle() {
      return title;
   }

   public String getContent() {
      return content;
   }

   public LocalDateTime getCreatedDate() {
      return createdDate;
   }

   public LocalDateTime getModifiedDate() {
      return modifiedDate;
   }

   public String getCategory() {
      return category;
   }

   public Priority getPriority() {
      return priority;
   }

   public void setTitle(String title) {
      if (title != null && !title.trim().isEmpty()) {
         this.title = title;
         updateModifiedDate();
      } else {
         throw new IllegalArgumentException("Title cannot be empty");
      }
   }

   public void setContent(String content) {
      this.content = content != null ? content : "";
      updateModifiedDate();
   }

   public void setCategory(String category) {
      this.category = category != null ? category : "General";
      updateModifiedDate();
   }

   public void setPriority(Priority priority) {
      this.priority = priority != null ? priority : Priority.MEDIUM;
      updateModifiedDate();
   }

   private void updateModifiedDate() {
      this.modifiedDate = LocalDateTime.now();
   }

   public boolean matches(String searchTerm) {
      if (searchTerm == null || searchTerm.trim().isEmpty()) {
         return true;
      }

      String search = searchTerm.toLowerCase();
      return title.toLowerCase().contains(search) ||
            content.toLowerCase().contains(search) ||
            category.toLowerCase().contains(search) ||
            priority.toString().toLowerCase().contains(search) ||
            getFormattedCreatedDate().toLowerCase().contains(search) ||
            getFormattedModifiedDate().toLowerCase().contains(search);
   }

   @Override
   public int compareTo(Note other) {
      return other.createdDate.compareTo(this.createdDate);
   }

   public String getFormattedCreatedDate() {
      return createdDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
   }

   public String getFormattedModifiedDate() {
      return modifiedDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
   }

   @Override
   public String toString() {
      return String.format("ID: %d | Title: %s | Category: %s | Priority: %s | Created: %s",
            id, title, category, priority, getFormattedCreatedDate());
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null || getClass() != obj.getClass())
         return false;
      Note note = (Note) obj;
      return id == note.id;
   }

   @Override
   public int hashCode() {
      return Integer.hashCode(id);
   }
}
```

##### `NoteManager.java`<br>
Create: 1 ต.ค. 2568 time 03:49<br>
Update: 6 ต.ค. 2568 time 08:29<br>
```java

package core;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import database.DatabaseManager;

public class NoteManager {
   private List<Note> notes;
   private Map<String, List<Note>> categoryIndex;
   private DatabaseManager databaseManager;

   public NoteManager() {
      this.notes = new ArrayList<>();
      this.categoryIndex = new HashMap<>();
      this.databaseManager = new DatabaseManager(this);
   }

   public boolean addNote(Note note) {
      return addNote(note, true);
   }

   public boolean addNote(Note note, boolean triggerAutoSync) {
      if (note == null) {
         throw new IllegalArgumentException("Note cannot be null");
      }

      boolean added = notes.add(note);
      if (added) {
         updateCategoryIndex(note);
         if (triggerAutoSync && databaseManager != null) {
            autoSyncToDatabase(note, "ADD");
         }
      }
      return added;
   }

   public Note addNote(String title, String content, String category, Note.Priority priority) {
      Note note = new Note(title, content, category, priority);

      if (isDatabaseConnected() && databaseManager != null) {
         if (!databaseManager.saveNoteToDatabase(note)) {
            note.setId(Note.generateLocalId());
         }
         addNote(note, false);
      } else {
         note.setId(Note.generateLocalId());
         addNote(note, true);
      }

      return note;
   }

   public boolean removeNote(int id) {
      Note noteToRemove = findNoteById(id);
      if (noteToRemove != null) {
         notes.remove(noteToRemove);
         removeCategoryIndex(noteToRemove);
         autoSyncToDatabase(noteToRemove, "DELETE");
         return true;
      }
      return false;
   }

   public Note findNoteById(int id) {
      return notes.stream()
            .filter(note -> note.getId() == id)
            .findFirst()
            .orElse(null);
   }

   public boolean updateNote(int id, String title, String content, String category, Note.Priority priority) {
      Note note = findNoteById(id);
      if (note != null) {
         String oldCategory = note.getCategory();

         note.setTitle(title);
         note.setContent(content);
         note.setCategory(category);
         note.setPriority(priority);

         removeCategoryIndexEntry(note, oldCategory);
         updateCategoryIndex(note);
         autoSyncToDatabase(note, "UPDATE");

         return true;
      }
      return false;
   }

   public List<Note> searchNotes(String searchTerm) {
      return notes.stream()
            .filter(note -> note.matches(searchTerm))
            .collect(Collectors.toList());
   }

   public List<Note> getNotesByCategory(String category) {
      return categoryIndex.getOrDefault(category, new ArrayList<>());
   }

   public List<Note> getNotesByPriority(Note.Priority priority) {
      return notes.stream()
            .filter(note -> note.getPriority() == priority)
            .collect(Collectors.toList());
   }

   public List<Note> searchNotes(Predicate<Note> condition) {
      return notes.stream()
            .filter(condition)
            .collect(Collectors.toList());
   }

   public List<Note> getAllNotes() {
      return new ArrayList<>(notes);
   }

   public List<Note> getAllNotesSorted() {
      return notes.stream()
            .sorted()
            .collect(Collectors.toList());
   }

   public Set<String> getAllCategories() {
      return notes.stream()
            .map(Note::getCategory)
            .collect(Collectors.toSet());
   }

   public int getTotalNotes() {
      return notes.size();
   }

   public int getNotesCountByCategory(String category) {
      return categoryIndex.getOrDefault(category, new ArrayList<>()).size();
   }

   public Map<Note.Priority, Long> getPriorityStatistics() {
      return notes.stream()
            .collect(Collectors.groupingBy(Note::getPriority, Collectors.counting()));
   }

   public void clearAllNotes() {
      clearAllNotes(true);
   }

   public void clearAllNotes(boolean triggerAutoSync) {
      notes.clear();
      categoryIndex.clear();

      if (triggerAutoSync && databaseManager != null && isDatabaseConnected()) {
         Thread syncThread = new Thread(() -> {
            databaseManager.getCurrentDatabase().clearAllNotes();
         });
         syncThread.setDaemon(true);
         syncThread.start();
      }
   }

   public boolean isEmpty() {
      return notes.isEmpty();
   }

   private void updateCategoryIndex(Note note) {
      categoryIndex.computeIfAbsent(note.getCategory(), _ -> new ArrayList<>()).add(note);
   }

   private void removeCategoryIndex(Note note) {
      removeCategoryIndexEntry(note, note.getCategory());
   }

   private void removeCategoryIndexEntry(Note note, String category) {
      List<Note> categoryNotes = categoryIndex.get(category);
      if (categoryNotes != null) {
         categoryNotes.remove(note);
         if (categoryNotes.isEmpty()) {
            categoryIndex.remove(category);
         }
      }
   }

   public DatabaseManager getDatabaseManager() {
      return databaseManager;
   }

   public boolean connectToDatabase() {
      return databaseManager != null && databaseManager.connectToDatabase();
   }

   public void disconnectFromDatabase() {
      if (databaseManager != null) {
         databaseManager.disconnectFromDatabase();
      }
   }

   public boolean isDatabaseConnected() {
      return databaseManager != null && databaseManager.isConnected();
   }

   public String getDatabaseStatus() {
      return databaseManager != null ? databaseManager.getConnectionStatus() : "Database not initialized";
   }

   private void autoSyncToDatabase(Note note, String operation) {
      if (databaseManager == null || !isDatabaseConnected()) {
         return;
      }

      Thread syncThread = new Thread(() -> {
         switch (operation) {
            case "ADD":
            case "UPDATE":
               databaseManager.saveNoteToDatabase(note);
               break;
            case "DELETE":
               databaseManager.deleteNoteFromDatabase(note.getId());
               break;
         }
      });

      syncThread.setDaemon(true);
      syncThread.start();
   }

   public void autoSyncAllToDatabase() {
      if (databaseManager == null || !isDatabaseConnected()) {
         return;
      }

      Thread syncThread = new Thread(() -> {
         databaseManager.syncNotesToDatabase();
      });

      syncThread.setDaemon(true);
      syncThread.start();
   }
}
```


## Project/OOP_Database/src/database

##### `Database.java`<br>
Create: 1 ต.ค. 2568 time 03:49<br>
Update: 6 ต.ค. 2568 time 08:11<br>
```java
package database;

import java.util.List;

import core.Note;

public interface Database {
   boolean connect();

   void disconnect();

   boolean isConnected();

   boolean testConnection();

   boolean saveNote(Note note);

   List<Note> loadAllNotes();

   boolean updateNote(Note note);

   boolean deleteNote(int id);

   List<Note> searchNotes(String searchTerm);

   boolean clearAllNotes();

   String getDatabaseType();

   String getConnectionStatus();
}
```

##### `DatabaseConfig.java`<br>
Create: 1 ต.ค. 2568 time 03:49<br>
Update: 6 ต.ค. 2568 time 08:29<br>
```java
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
   private static final String CONFIG_FILE = "database.properties";

   public DatabaseConfig() {
      this.type = DatabaseType.OFFLINE;
      this.host = "localhost";
      this.port = "3306";
      this.database = "note";
      this.username = "root";
      this.password = "";
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

      try (FileOutputStream fos = new FileOutputStream(CONFIG_FILE)) {
         props.store(fos, "Database Configuration");
      } catch (IOException e) {
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

      } catch (FileNotFoundException e) {
      } catch (IOException e) {
      }
   }

   public static boolean configFileExists() {
      return new File(CONFIG_FILE).exists();
   }

   @Override
   public String toString() {
      return String.format(
            "DatabaseConfig{type=%s, host='%s', port='%s', database='%s', username='%s'}",
            type, host, port, database, username);
   }
}
```

##### `DatabaseManager.java`<br>
Create: 1 ต.ค. 2568 time 03:49<br>
Update: 6 ต.ค. 2568 time 08:29<br>
```java
package database;

import java.util.ArrayList;
import java.util.List;

import core.Note;
import core.NoteManager;
import database.providers.MySQL;

public class DatabaseManager {
   private Database database;
   private DatabaseConfig config;
   private NoteManager noteManager;

   public DatabaseManager(NoteManager noteManager) {
      this.noteManager = noteManager;
      this.config = new DatabaseConfig();

      if (DatabaseConfig.configFileExists()) {
         config.loadFromFile();
      }

      initializeDatabase();
   }

   public void initializeDatabase() {
      if (database != null && database.isConnected()) {
         database.disconnect();
      }

      database = createDatabaseInstance(config.getType());

      connectToDatabase(noteManager != null);
   }

   private Database createDatabaseInstance(DatabaseConfig.DatabaseType type) {
      switch (type) {
         case MYSQL:
            return new MySQL(config);
         case OFFLINE:
         default:
            return new OfflineDatabase();
      }
   }

   public boolean connectToDatabase() {
      return connectToDatabase(true);
   }

   public boolean connectToDatabase(boolean syncAfterConnection) {
      if (database == null) {
         initializeDatabase();
      }

      boolean connected = database.connect();

      if (connected && syncAfterConnection && noteManager != null) {
         syncNotesFromDatabase();
      }

      return connected;
   }

   public void disconnectFromDatabase() {
      if (database != null && database.isConnected()) {
         database.disconnect();
      }
   }

   public boolean testDatabaseConnection() {
      if (database == null) {
         initializeDatabase();
      }
      return database.testConnection();
   }

   public void syncNotesFromDatabase() {
      if (database == null || !database.isConnected() || noteManager == null) {
         return;
      }

      List<Note> dbNotes = database.loadAllNotes();

      noteManager.clearAllNotes(false);

      for (Note note : dbNotes) {
         noteManager.addNote(note, false);
      }
   }

   public boolean syncNotesToDatabase() {
      if (database == null || !database.isConnected() || noteManager == null) {
         return false;
      }

      List<Note> notes = noteManager.getAllNotes();

      database.clearAllNotes();

      for (Note note : notes) {
         if (!database.saveNote(note)) {
            return false;
         }
      }

      return true;
   }

   public boolean saveNoteToDatabase(Note note) {
      if (database == null || !database.isConnected()) {
         return false;
      }

      return database.saveNote(note);
   }

   public boolean updateNoteInDatabase(Note note) {
      if (database == null || !database.isConnected()) {
         return false;
      }

      return database.updateNote(note);
   }

   public boolean deleteNoteFromDatabase(int noteId) {
      if (database == null || !database.isConnected()) {
         return false;
      }

      return database.deleteNote(noteId);
   }

   public List<Note> searchNotesInDatabase(String searchTerm) {
      if (database == null || !database.isConnected()) {
         return noteManager != null ? noteManager.searchNotes(searchTerm) : new ArrayList<>();
      }

      return database.searchNotes(searchTerm);
   }

   public DatabaseConfig getDatabaseConfig() {
      return config;
   }

   public void updateDatabaseConfig(DatabaseConfig newConfig) {
      this.config = newConfig;
      config.saveToFile();
      initializeDatabase();
   }

   public Database getCurrentDatabase() {
      return database;
   }

   public String getConnectionStatus() {
      if (database == null) {
         return "No database initialized";
      }
      return database.getConnectionStatus();
   }

   public String getDatabaseType() {
      if (database == null) {
         return "Unknown";
      }
      return database.getDatabaseType();
   }

   public boolean isConnected() {
      return database != null && database.isConnected();
   }

   public boolean backupNotesToFile() {
      if (noteManager == null) {
         return false;
      }

      OfflineDatabase backupDb = new OfflineDatabase();
      if (backupDb.connect()) {
         List<Note> notes = noteManager.getAllNotes();

         backupDb.clearAllNotes();
         for (Note note : notes) {
            backupDb.saveNote(note);
         }

         backupDb.disconnect();
         return true;
      }
      return false;
   }

   public boolean restoreNotesFromFile() {
      if (noteManager == null) {
         return false;
      }

      OfflineDatabase backupDb = new OfflineDatabase();
      if (backupDb.connect()) {
         List<Note> backupNotes = backupDb.loadAllNotes();

         if (!backupNotes.isEmpty()) {
            noteManager.clearAllNotes();
            for (Note note : backupNotes) {
               noteManager.addNote(note);
            }

            if (isConnected()) {
               syncNotesToDatabase();
            }

            backupDb.disconnect();
            return true;
         }

         backupDb.disconnect();
      }
      return false;
   }

}
```

##### `OfflineDatabase.java`<br>
Create: 1 ต.ค. 2568 time 03:49<br>
Update: 6 ต.ค. 2568 time 08:11<br>
```java
package database;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import core.Note;

import com.fasterxml.jackson.databind.node.ArrayNode;

public class OfflineDatabase implements Database {
   private List<Note> notes;
   private final String DATA_FILE = "notes_data.json";
   private boolean connected;
   private ObjectMapper objectMapper;

   public OfflineDatabase() {
      this.notes = new ArrayList<>();
      this.connected = false;
      this.objectMapper = new ObjectMapper();
   }

   @Override
   public boolean connect() {
      try {
         loadNotesFromFile();
         connected = true;
         return true;
      } catch (Exception e) {
         connected = false;
         return false;
      }
   }

   @Override
   public void disconnect() {
      if (connected) {
         saveNotesToFile();
         connected = false;
      }
   }

   @Override
   public boolean isConnected() {
      return connected;
   }

   @Override
   public boolean testConnection() {
      try {

         File file = new File(DATA_FILE);
         if (!file.exists()) {
            file.createNewFile();
            file.delete();
         }
         return true;
      } catch (Exception e) {
         return false;
      }
   }

   @Override
   public synchronized boolean saveNote(Note note) {
      if (!connected)
         return false;

      if (note.getId() == 0) {
         note.setId(Note.generateLocalId());
      }

      notes.removeIf(n -> n.getId() == note.getId());
      notes.add(note);
      saveNotesToFile();
      return true;
   }

   @Override
   public synchronized List<Note> loadAllNotes() {
      if (!connected)
         return new ArrayList<>();
      return new ArrayList<>(notes);
   }

   @Override
   public boolean updateNote(Note note) {
      return saveNote(note);
   }

   @Override
   public synchronized boolean deleteNote(int id) {
      if (!connected)
         return false;

      boolean removed = notes.removeIf(note -> note.getId() == id);
      if (removed) {
         saveNotesToFile();
      }
      return removed;
   }

   @Override
   public synchronized List<Note> searchNotes(String searchTerm) {
      if (!connected)
         return new ArrayList<>();

      return notes.stream()
            .filter(note -> note.matches(searchTerm))
            .collect(Collectors.toList());
   }

   @Override
   public synchronized boolean clearAllNotes() {
      if (!connected)
         return false;

      notes.clear();
      Note.resetIdCounter();
      saveNotesToFile();
      return true;
   }

   @Override
   public String getDatabaseType() {
      return "Offline File Storage";
   }

   @Override
   public String getConnectionStatus() {
      if (connected) {
         return "Connected to offline storage (" + notes.size() + " notes)";
      }
      return "Disconnected from offline storage";
   }

   private synchronized void saveNotesToFile() {
      try {
         ObjectNode rootNode = objectMapper.createObjectNode();
         ArrayNode notesArray = objectMapper.createArrayNode();
         List<Note> notesCopy = new ArrayList<>(notes);

         for (Note note : notesCopy) {
            ObjectNode noteNode = objectMapper.createObjectNode();
            noteNode.put("id", note.getId());
            noteNode.put("title", note.getTitle());
            noteNode.put("content", note.getContent());
            noteNode.put("category", note.getCategory());
            noteNode.put("priority", note.getPriority().name());
            noteNode.put("createdDate",
                  note.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            noteNode.put("modifiedDate",
                  note.getModifiedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            notesArray.add(noteNode);
         }
         rootNode.set("notes", notesArray);
         objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(DATA_FILE), rootNode);

      } catch (IOException e) {
      }
   }

   private synchronized void loadNotesFromFile() {
      notes.clear();
      Note.resetIdCounter();
      File file = new File(DATA_FILE);

      if (!file.exists()) {
         return;
      }

      try {
         ObjectNode rootNode = (ObjectNode) objectMapper.readTree(file);

         if (rootNode.has("notes")) {
            ArrayNode notesArray = (ArrayNode) rootNode.get("notes");

            for (int i = 0; i < notesArray.size(); i++) {
               ObjectNode noteNode = (ObjectNode) notesArray.get(i);

               int id = noteNode.get("id").asInt();
               String title = noteNode.get("title").asText();
               String content = noteNode.get("content").asText();
               String category = noteNode.get("category").asText();
               String priorityStr = noteNode.get("priority").asText();

               Note.Priority priority = Note.Priority.valueOf(priorityStr);
               Note note = new Note(title, content, category, priority);
               note.setId(id);
               Note.updateNextIdIfNeeded(id + 1);

               notes.add(note);
            }
         }

      } catch (IOException e) {
      }
   }

}
```


## Project/OOP_Database/src/database/providers

##### `MySQL.java`<br>
Create: 1 ต.ค. 2568 time 03:49<br>
Update: 6 ต.ค. 2568 time 08:11<br>
```java
package database.providers;

import java.sql.*;
import java.util.*;

import core.Note;
import database.Database;
import database.DatabaseConfig;

public class MySQL implements Database {
   private Connection connection;
   private DatabaseConfig config;
   private boolean connected;

   public MySQL(DatabaseConfig config) {
      this.config = config;
      this.connected = false;
   }

   @Override
   public boolean connect() {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         String url = config.getMySQLConnectionString();
         connection = DriverManager.getConnection(url, config.getUsername(), config.getPassword());

         createTablesIfNotExists();

         connected = true;
         return true;

      } catch (ClassNotFoundException e) {
         e.printStackTrace();
         connected = false;
         return false;
      } catch (SQLException e) {
         e.printStackTrace();
         connected = false;
         return false;
      }
   }

   @Override
   public void disconnect() {
      if (connection != null) {
         try {
            connection.close();
         } catch (SQLException e) {
         }
         connected = false;
      }
   }

   @Override
   public boolean isConnected() {
      try {
         return connected && connection != null && !connection.isClosed();
      } catch (SQLException e) {
         return false;
      }
   }

   @Override
   public boolean testConnection() {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         String url = config.getMySQLConnectionString();

         try (Connection testConn = DriverManager.getConnection(url, config.getUsername(), config.getPassword())) {
            boolean result = testConn != null && !testConn.isClosed();
            return result;
         }
      } catch (Exception e) {
         e.printStackTrace();
         return false;
      }
   }

   @Override
   public boolean saveNote(Note note) {
      if (!isConnected())
         return false;

      if (note.getId() == 0) {
         String sql = "INSERT INTO notes (title, content, category, priority, created_date, modified_date) " +
               "VALUES (?, ?, ?, ?, ?, ?)";

         try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, note.getTitle());
            stmt.setString(2, note.getContent());
            stmt.setString(3, note.getCategory());
            stmt.setString(4, note.getPriority().name());
            stmt.setTimestamp(5, Timestamp.valueOf(note.getCreatedDate()));
            stmt.setTimestamp(6, Timestamp.valueOf(note.getModifiedDate()));

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
               try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                  if (generatedKeys.next()) {
                     note.setId(generatedKeys.getInt(1));
                     return true;
                  }
               }
            }

         } catch (SQLException e) {
            return false;
         }
      } else {
         String sql = "UPDATE notes SET title=?, content=?, category=?, priority=?, modified_date=? WHERE id=?";

         try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, note.getTitle());
            stmt.setString(2, note.getContent());
            stmt.setString(3, note.getCategory());
            stmt.setString(4, note.getPriority().name());
            stmt.setTimestamp(5, Timestamp.valueOf(note.getModifiedDate()));
            stmt.setInt(6, note.getId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

         } catch (SQLException e) {
            return false;
         }
      }

      return false;
   }

   @Override
   public List<Note> loadAllNotes() {
      List<Note> notes = new ArrayList<>();
      if (!isConnected())
         return notes;

      String sql = "SELECT * FROM notes ORDER BY created_date DESC";

      try (Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

         while (rs.next()) {
            Note note = createNoteFromResultSet(rs);
            if (note != null) {
               notes.add(note);
            }
         }

      } catch (SQLException e) {
      }

      return notes;
   }

   @Override
   public boolean updateNote(Note note) {
      return saveNote(note);
   }

   @Override
   public boolean deleteNote(int id) {
      if (!isConnected())
         return false;

      String sql = "DELETE FROM notes WHERE id = ?";

      try (PreparedStatement stmt = connection.prepareStatement(sql)) {
         stmt.setInt(1, id);
         int rowsAffected = stmt.executeUpdate();
         return rowsAffected > 0;

      } catch (SQLException e) {
         return false;
      }
   }

   @Override
   public List<Note> searchNotes(String searchTerm) {
      List<Note> notes = new ArrayList<>();
      if (!isConnected())
         return notes;

      String sql = "SELECT * FROM notes WHERE " +
            "title LIKE ? OR content LIKE ? OR category LIKE ? OR priority LIKE ? " +
            "ORDER BY created_date DESC";

      try (PreparedStatement stmt = connection.prepareStatement(sql)) {
         String searchPattern = "%" + searchTerm + "%";
         stmt.setString(1, searchPattern);
         stmt.setString(2, searchPattern);
         stmt.setString(3, searchPattern);
         stmt.setString(4, searchPattern);

         try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
               Note note = createNoteFromResultSet(rs);
               if (note != null) {
                  notes.add(note);
               }
            }
         }

      } catch (SQLException e) {
      }

      return notes;
   }

   @Override
   public boolean clearAllNotes() {
      if (!isConnected())
         return false;

      try (Statement stmt = connection.createStatement()) {
         String dropSql = "DROP TABLE IF EXISTS notes";
         stmt.executeUpdate(dropSql);
         createTablesIfNotExists();

         return true;
      } catch (SQLException e) {
         return false;
      }
   }

   @Override
   public String getDatabaseType() {
      return "MySQL Database";
   }

   @Override
   public String getConnectionStatus() {
      if (isConnected()) {
         try {
            String sql = "SELECT COUNT(*) FROM notes";
            try (Statement stmt = connection.createStatement();
                  ResultSet rs = stmt.executeQuery(sql)) {
               if (rs.next()) {
                  int count = rs.getInt(1);
                  return String.format("Connected to MySQL (%d notes) - %s", count, config.getHost());
               }
            }
         } catch (SQLException e) {
            return "Connected to MySQL (error counting notes)";
         }
      }
      return "Disconnected from MySQL";
   }

   private void createTablesIfNotExists() throws SQLException {
      String sql = """
            CREATE TABLE IF NOT EXISTS notes (
                id INT AUTO_INCREMENT PRIMARY KEY,
                title VARCHAR(255) NOT NULL,
                content TEXT,
                category VARCHAR(100),
                priority VARCHAR(20),
                created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                INDEX idx_category (category),
                INDEX idx_priority (priority),
                INDEX idx_created_date (created_date)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
            """;

      try (Statement stmt = connection.createStatement()) {
         stmt.executeUpdate(sql);
      }
   }

   private Note createNoteFromResultSet(ResultSet rs) {
      try {
         int id = rs.getInt("id");
         String title = rs.getString("title");
         String content = rs.getString("content");
         String category = rs.getString("category");
         String priorityStr = rs.getString("priority");
         Timestamp createdTimestamp = rs.getTimestamp("created_date");
         Timestamp modifiedTimestamp = rs.getTimestamp("modified_date");

         Note.Priority priority;
         try {
            priority = Note.Priority.valueOf(priorityStr);
         } catch (IllegalArgumentException e) {
            priority = Note.Priority.MEDIUM;
         }

         Note note = new Note(id, title, content, category, priority,
               createdTimestamp.toLocalDateTime(),
               modifiedTimestamp.toLocalDateTime());

         return note;

      } catch (SQLException e) {
         return null;
      }
   }

}
```


## Project/OOP_Database/src/gui

##### `MainGUI.java`<br>
Create: 1 ต.ค. 2568 time 03:49<br>
Update: 6 ต.ค. 2568 time 08:11<br>
```java
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
......
```

##### `SettingsGUI.java`<br>
Create: 1 ต.ค. 2568 time 03:49<br>
Update: 6 ต.ค. 2568 time 08:29<br>
```java
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
......
```


## Project/Simple/src

##### `App.java`<br>
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

##### `DbTool.java`<br>
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

##### `Student_his.java`<br>
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

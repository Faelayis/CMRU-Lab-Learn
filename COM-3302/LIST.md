
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

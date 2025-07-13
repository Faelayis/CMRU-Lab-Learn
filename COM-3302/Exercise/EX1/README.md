`Calculate.java`<br>
Create: 10 ก.ค. 2568 time 02:33<br>
```java
package Exercise.EX1;

public class Calculate {
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

   public static double BMI(double weightKg, double heightM) {
      if (heightM <= 0) {
         return Double.NaN;
      }
      return weightKg / (heightM * heightM);
   }

   public static double BMR(String gender, double weightKg, double heightCm, int age) {
      double bmr = Double.NaN;

      if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("m")) {
         bmr = 66 + (13.7 * weightKg) + (5 * heightCm) - (6.8 * age);
      } else if (gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("f")) {
         bmr = 665 + (9.6 * weightKg) + (1.8 * heightCm) - (4.7 * age);
      }

      return bmr;
   }
}

```
`Main.java`<br>
Create: 10 ก.ค. 2568 time 02:33<br>
```java
package Exercise.EX1;

import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("--- BMI and BMR Calculator Program ---");

      // BMI
      System.out.println("\n--- Body Mass Index (BMI) Calculation ---");
      double weight = 0;
      double heightCm = 0;

      while (true) {
         try {
            System.out.print("Please enter your weight (kg): ");
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
            System.out.print("Please enter your height (cm): ");
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

      double heightM = heightCm / 100.0;
      double bmiValue = Calculate.BMI(weight, heightM);

      if (Double.isNaN(bmiValue) || Double.isInfinite(bmiValue)) {
         System.out.println("Cannot calculate BMI (invalid height)");
      } else {
         System.out.printf("Your Body Mass Index (BMI) is: %.2f\n", bmiValue);
         System.out.println("Assessment: " + Calculate.interpretBMI(bmiValue));
      }

      // BMR
      System.out.println("\n--- Basal Metabolic Rate (BMR) Calculation ---");
      String gender = "";

      while (true) {

         System.out.print("Please select your gender ((m)male/(f)female): ");
         gender = scanner.next().trim();

         if (gender.equalsIgnoreCase("male")
               || gender.equalsIgnoreCase("m")
               || gender.equalsIgnoreCase("female")
               || gender.equalsIgnoreCase("f")) {
            break;
         } else {
            System.out.println("Invalid gender. Please enter 'male' or 'female'.");
         }
      }

      int age = 0;

      while (true) {
         try {
            System.out.print("Please enter your age (years): ");
            age = scanner.nextInt();

            if (age <= 0) {
               System.out.println("Age must be positive. Please try again.");
               continue;
            }

            break;
         } catch (java.util.InputMismatchException error) {
            System.out.println("Invalid input. Please enter a whole number.");
            scanner.next();
         }
      }

      double bmrValue = Calculate.BMR(gender, weight, heightCm, age);

      if (Double.isNaN(bmrValue) || Double.isInfinite(bmrValue)) {
         System.out.println("Cannot calculate BMR due to invalid gender specification.");
      } else {
         System.out.printf("Your daily Basal Metabolic Rate (BMR) is: %.2f calories/day\n", bmrValue);
      }

      System.out.println("\n--- Program Completed ---");
      scanner.close();
   }

}
```

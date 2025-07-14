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

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

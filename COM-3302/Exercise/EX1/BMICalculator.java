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

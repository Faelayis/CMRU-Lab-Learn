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

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
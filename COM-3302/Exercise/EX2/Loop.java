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

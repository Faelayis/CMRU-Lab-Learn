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
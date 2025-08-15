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
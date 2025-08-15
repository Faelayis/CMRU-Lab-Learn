package Exercise.EX4;

import java.util.Arrays;

public class BubbleSortDoWhile {

   public static void bubbleSortDoWhile(int[] array) {
      int arraySize = array.length;
      System.out.println("Bubble Sort with do-while loop:");
      System.out.println("Initial data: " + Arrays.toString(array));

      int index = 0;
      do {
         int j = 0;

         do {
            if (j < arraySize - index - 1 && array[j] > array[j + 1]) {
               int temp = array[j];
               array[j] = array[j + 1];
               array[j + 1] = temp;
            }
            j++;
         } while (j < arraySize - index - 1);

         System.out.println("Pass " + (index + 1) + ": " + Arrays.toString(array));
         index++;
      } while (index < arraySize - 1);

      System.out.println("Final result: " + Arrays.toString(array));
      System.out.println();
   }

   public static void main(String[] args) {
      int[] data = { 64, 34, 25, 12, 22, 11, 90 };

      System.out.println("=== Bubble Sort with Do-While Loop ===\n");
      bubbleSortDoWhile(data);
   }
}
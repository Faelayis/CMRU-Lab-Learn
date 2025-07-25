package Exercise.EX2;

public class Do_While {
   public static void main(String[] args) {
      int row = 1;

      do {
         int col = 1;

         do {
            System.out.println("row = " + row + " col = " + col);
         } while (++col <= 3);
      } while (++row <= 2);
   }
}

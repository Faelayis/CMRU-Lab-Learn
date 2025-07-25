package Exercise.EX2;

public class While {
   public static void main(String[] args) {
      int count = 1;

      while (count <= 2) {
         for (int num = 1; num <= 3; num++) {
            System.out.println("count = " + count + " num = " + num);
         }

         count++;
      }
   }
}

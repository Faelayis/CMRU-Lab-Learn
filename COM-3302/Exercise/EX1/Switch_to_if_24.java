package Exercise.EX1;

import java.io.*;
import java.lang.Integer;

public class Switch_to_if_24 {
   public static void main(String args[]) throws IOException {
      char answer;
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader buffer = new BufferedReader(isr);

      System.out.print("Enter A [Y] or [N] : ");
      String input = buffer.readLine();
      answer = (char) input.charAt(0);

      if (answer == 'Y' || answer == 'y') {
         System.out.print("You Enter Y\n");
      } else if (answer == 'N' || answer == 'n') {
         System.out.print("You Enter N\n");
      } else {
         System.out.print("Error !\n");
      } /* End of If */
   }
}
import javax.swing.SwingUtilities;

public class App {
   public static void main(String[] args) {
      System.out.println("Starting ...");

      SwingUtilities.invokeLater(() -> {
         try {
            GUI gui = new GUI();
            gui.setVisible(true);

         } catch (Exception error) {
            System.err.println("Error starting application: " + error.getMessage());
            error.printStackTrace();
         }
      });
   }
}

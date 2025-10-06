import javax.swing.SwingUtilities;

import gui.MainGUI;

public class App {
   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> {
         try {
            MainGUI gui = new MainGUI();
            gui.setVisible(true);

         } catch (Exception error) {
            error.printStackTrace();
         }
      });
   }
}

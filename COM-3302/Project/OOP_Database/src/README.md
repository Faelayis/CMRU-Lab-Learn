`App.java`<br>
Create: 1 ต.ค. 2568 time 03:49<br>
Update: 6 ต.ค. 2568 time 08:11<br>
```java
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

```

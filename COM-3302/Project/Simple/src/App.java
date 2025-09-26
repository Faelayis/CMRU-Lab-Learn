public class App {
   public static void main(String[] args) {
      DbTool stdDB = new DbTool();
      stdDB.insertData("37100501", "Santi", "32 M.6 maerim chiengmai", "0951123140", 20);
      stdDB.insertData("56100501", "Mana", "2 M.1 maerim chiengmai", "0651224440", 19);
      stdDB.displayAllData();
      stdDB.UpdateData("56100501", "Man", "maerim chiengmai", "0951123140", 22);
      stdDB.displayAllData();
   }
}
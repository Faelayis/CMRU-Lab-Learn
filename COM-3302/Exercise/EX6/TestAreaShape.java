package Exercise.EX6;

public class TestAreaShape {
   public static void main(String[] args) {
      System.out.println("Area Shape Calculator with Constructor Overloading\n");

      System.out.println("Creating Triangle:");
      AreaShape triangle = new AreaShape(10.0, 8.0);
      triangle.showArea();

      System.out.println("\nCreating Rectangle:");
      AreaShape rectangle = new AreaShape(12.0, 15.0, "rectangle");
      rectangle.showArea();

      System.out.println("\nCreating Circle:");
      AreaShape circle = new AreaShape(7.0);
      circle.showArea();

      System.out.println("\n=== Summary ===");
      System.out.printf("Triangle Area: %.2f%n", triangle.getArea());
      System.out.printf("Rectangle Area: %.2f%n", rectangle.getArea());
      System.out.printf("Circle Area: %.2f%n", circle.getArea());
   }
}
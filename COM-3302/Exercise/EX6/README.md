`AreaShape.java`<br>
Create: 19 ก.ย. 2568 time 00:39<br>
```java
package Exercise.EX6;

public class AreaShape {
   private double area;
   private String shapeType;
   private String details;

   public AreaShape(double base, double height) {
      this.area = 0.5 * base * height;
      this.shapeType = "Triangle";
      this.details = String.format("Base: %.2f, Height: %.2f", base, height);
   }

   public AreaShape(double width, double length, String type) {
      if (type.equalsIgnoreCase("rectangle")) {
         this.area = width * length;
         this.shapeType = "Rectangle";
         this.details = String.format("Width: %.2f, Length: %.2f", width, length);
      }
   }

   public AreaShape(double radius) {
      this.area = Math.PI * radius * radius;
      this.shapeType = "Circle";
      this.details = String.format("Radius: %.2f", radius);
   }

   public void showArea() {
      System.out.println("Shape Type: " + shapeType);
      System.out.println("Details: " + details);
      System.out.printf("Area: %.2f%n", area);
   }

   public double getArea() {
      return area;
   }

   public String getShapeType() {
      return shapeType;
   }
}
```
`TestAreaShape.java`<br>
Create: 19 ก.ย. 2568 time 00:39<br>
```java
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
```

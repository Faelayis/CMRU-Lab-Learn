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
#include <math.h>
#include <stdio.h>

int main() {
   int choice, area;

   while (1) {
      printf("************ MENU ************\n");
      printf("1. Rectangle\n");
      printf("2. Circle\n");
      printf("3. Triangle\n");
      printf("4. Square\n");
      printf("5. Exit\n");
      printf("********************************\n");
      printf("Please enter 1 - 5: ");
      scanf("%d", &choice);

      switch (choice) {
         case 1:

            float length, width;
            printf("Enter length: ");
            scanf("%f", &length);
            printf("Enter width: ");
            scanf("%f", &width);
            area = length * width;
            printf("Rectangle area: %.2f\n", area);
            break;
         case 2:

            float radius;
            printf("Enter Radius: ");
            scanf("%f", &radius);
            area = 3.14159265358979323846 * radius * radius;
            printf("Circle area: %.2f\n", area);
            break;
         case 3:

            float base, height;
            printf("Enter base: ");
            scanf("%f", &base);
            printf("Enter height: ");
            scanf("%f", &height);
            area = 0.5 * base * height;
            printf("Triangle area: %.2f\n", area);
            break;
         case 4:

            float side;
            printf("Enter side length: ");
            scanf("%f", &side);
            area = side * side;
            printf("Square area: %.2f\n", area);
            break;
         case 5:

            printf("Exiting the program. Goodbye!\n");
            return 0;
         default:
            printf("Wrong Number\n");
      }
   }

   printf("\n");
   return 0;
}

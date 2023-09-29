#include <stdio.h>

int main() {
   float sideLength, area, perimeter;

   printf("Please enter the side length of the square (units): ");
   scanf("%f", &sideLength);

   area = sideLength * sideLength;
   perimeter = 4 * sideLength;

   printf("Area of the square: %.2f square units\n", area);
   printf("Perimeter of the square: %.2f units\n", perimeter);

   printf("\n");
   return 0;
}
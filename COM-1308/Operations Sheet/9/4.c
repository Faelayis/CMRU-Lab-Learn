#include <stdio.h>

int main() {
   float x, y = 12.00;

   if (y < 15.00 && y < 5.00)
      x = 5 * y;
   else
      x = 2 + y;

   printf("x = %.2f\n", x);

   printf("\n");
   return 0;

   // output x = 14.00
}

#include <stdio.h>

int main() {
   int x = 3, y = 10;

   if ((3 / x) < y) x = x + 2;
   y = y + 3;

   printf("x = %d\n", x);
   printf("y = %d\n", y);

   printf("\n");
   return 0;

   /* output:
   x = 5
   y = 13
   */
}

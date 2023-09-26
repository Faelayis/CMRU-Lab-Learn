#include <stdio.h>

int main() {
   int x, i;

   for (x = 1; x <= 5; x++) {
      for (i = 1; i <= x; i++) {
         printf("%d ", i);
      }
      printf("\n");
   }

   printf("\n");
   return 0;

   /* output:
   1
   1 2
   1 2 3
   1 2 3 4
   1 2 3 4 5
   */
}

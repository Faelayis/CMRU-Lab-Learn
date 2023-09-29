#include <stdio.h>

int main() {
   int i, j;

   for (i = 2; i <= 8; i += 2) {
      for (j = 1; j <= 5; j++) {
         printf("%d ", i);
      }
      printf("\n");
   }

   printf("\n");
   return 0;

   /* output:
   2 2 2 2 2
   4 4 4 4 4
   6 6 6 6 6
   8 8 8 8 8
   */
}

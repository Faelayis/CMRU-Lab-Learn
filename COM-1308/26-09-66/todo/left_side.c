#include <stdio.h>

int main() {
   int x, i;

   for (x = 5; x >= 1; --x) {
      for (i = 1; i <= x; ++i) {
         printf("* ");
      }
      printf("\n");
   }

   printf("\n");
   return 0;

   /* output:
    * * * * *
    * * * *
    * * *
    * *
    *
    */
}

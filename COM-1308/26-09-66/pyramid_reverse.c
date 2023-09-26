#include <stdio.h>

int main() {
   int rows = 5, x, o, i;

   for (x = 1; x <= rows; x++) {
      for (i = 1; i <= rows - x; i++) {
         printf("  ");
      }

      for (o = 1; o <= x; o++) {
         printf("* ");
      }

      printf("\n");
   }

   printf("\n");
   return 0;

   // clang-format off
   /* output:
            *
          * *
        * * *
      * * * *
    * * * * *
    */
}

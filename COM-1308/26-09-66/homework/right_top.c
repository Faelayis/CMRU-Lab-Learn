#include <stdio.h>

int main() {
   int x, i;

   for (x = 1; x <= 5; ++x) {
      for (i = 1; i < x; ++i) {
         printf("  ");
      }
      for (i = x; i <= 5; ++i) {
         printf("* ");
      }
      printf("\n");
   }

   printf("\n");
   return 0;

   // clang-format off
   /* output:
    * * * * *
      * * * *
        * * *
          * *
            *
    */
}

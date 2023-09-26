#include <stdio.h>

int main() {
   int x, i;

   for (x; x <= 5; x++) {
      for (i = 1; i <= 5; i++) {
         printf("* ");
      }
      printf("\n");
   }

   printf("\n");
   return 0;

   /* output:
    * * * * *
    * * * * *
    * * * * *
    * * * * *
    * * * * *
    */
}

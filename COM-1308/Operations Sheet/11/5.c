#include <stdio.h>

int main() {
   char ch, i;

   for (ch = 'A'; ch <= 'D'; ch++) {
      for (i = 'A'; i <= ch; i++) {
         printf("%c ", ch);
      }
      printf("\n");
   }

   printf("\n");
   return 0;

   /* output:
   A
   B B
   C C C
   D D D D
   */
}

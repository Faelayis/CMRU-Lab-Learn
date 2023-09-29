#include <stdio.h>

int main() {
   int i = 10;

   do {
      printf("Number = %d\n", i + 1);
      i += 5;
   } while (i <= 30);

   printf("\n");
   return 0;
}

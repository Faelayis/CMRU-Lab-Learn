#include <stdio.h>

int main() {
   int A;
   printf("Enter a value A: ");
   scanf("%d", &A);

   if (A >= 10 && A <= 20) {
      printf("A is in the range of 10 - 20\n");
   } else {
      printf("A is not in the range of 10 - 20\n");
   }

   printf("\n");
   return 0;
}

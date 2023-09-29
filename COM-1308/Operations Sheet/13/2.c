#include <stdio.h>

int main() {
   int sum = 0, n;

   do {
      printf("Enter number or 0 to exit: ");
      scanf("%d", &n);
      sum += n;
   } while (n != 0);
   printf("Sum of numbers = %d\n", sum);

   printf("\n");
   return 0;
}

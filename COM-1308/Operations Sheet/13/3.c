#include <stdio.h>

int main() {
   int sum = 0, n, count = 0;

   do {
      printf("Please enter the number: ");
      scanf("%d", &n);
      sum += n;
      count++;
   } while (sum <= 500);

   printf("Amount of numbers is %d\n", count);

   printf("\n");
   return 0;
}

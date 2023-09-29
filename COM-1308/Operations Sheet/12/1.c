#include <stdio.h>

int main() {
   int num, sum = 0;

   printf("Enter a number: ");
   scanf("%d", &num);

   while (num != 0) {
      sum += num;
      printf("Enter a number: ");
      scanf("%d", &num);
   }

   printf("Sum is %d\n", sum);

   printf("\n");
   return 0;
}

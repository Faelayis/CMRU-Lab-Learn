#include <stdio.h>

int main() {
   int num1, num2;
   printf("Enter integer 1: ");
   scanf("%d", &num1);
   printf("Enter integer 2: ");
   scanf("%d", &num2);

   if (num1 > num2) {
      printf("%d is greater than %d\n", num1, num2);
   } else if (num1 < num2) {
      printf("%d is less than %d\n", num1, num2);
   } else {
      printf("%d is equal to %d\n", num1, num2);
   }

   printf("\n");
   return 0;
}

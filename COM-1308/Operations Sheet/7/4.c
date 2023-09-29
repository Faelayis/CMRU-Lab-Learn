#include <stdio.h>

int main() {
   int num1, num2;

   printf("Please enter the first integer: ");
   scanf("%d", &num1);

   printf("Please enter the second integer: ");
   scanf("%d", &num2);

   int sum = num1 + num2;
   int difference = num1 - num2;
   int product = num1 * num2;
   float quotient = (float)num1 / num2;
   int remainder = num1 % num2;

   printf("Sum: %d\n", sum);
   printf("Difference: %d\n", difference);
   printf("Product: %d\n", product);
   printf("Quotient: %.2f\n", quotient);
   printf("Remainder: %d\n", remainder);

   printf("\n");
   return 0;
}
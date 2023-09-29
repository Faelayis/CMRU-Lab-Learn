#include <stdio.h>

int main() {
   int num1, num2, num3;

   printf("Enter three numbers: ");
   scanf("%d %d %d", &num1, &num2, &num3);

   if (num1 > num2) {
      int temp = num1;
      num1 = num2;
      num2 = temp;
   }
   if (num2 > num3) {
      int temp = num2;
      num2 = num3;
      num3 = temp;
   }
   if (num1 > num2) {
      int temp = num1;
      num1 = num2;
      num2 = temp;
   }

   printf("Sorted numbers: %d %d %d\n", num1, num2, num3);

   printf("\n");
   return 0;
}

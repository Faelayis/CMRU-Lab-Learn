#include <stdio.h>

int main() {
   int num, count = 0;
   float sum = 0;

   printf("Enter a number (0 to stop): ");
   scanf("%d", &num);

   while (num != 0) {
      sum += num;
      count++;
      printf("Enter a number (0 to stop): ");
      scanf("%d", &num);
   }

   if (count > 0) {
      float average = sum / count;
      printf("Sum is %.2f\n", sum);
      printf("Average is %.2f\n", average);
   } else {
      printf("No numbers entered.\n");
   }

   printf("\n");
   return 0;
}

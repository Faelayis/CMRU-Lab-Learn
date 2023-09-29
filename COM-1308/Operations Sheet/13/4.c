#include <stdio.h>

int main() {
   int n, factorial = 1;

   printf("Enter a number: ");
   scanf("%d", &n);

   do {
      factorial *= n;
      n--;
   } while (n > 0);

   printf("Factorial = %d\n", factorial);

   printf("\n");
   return 0;
}

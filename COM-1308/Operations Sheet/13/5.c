#include <stdio.h>

int main() {
   int n, i = 0;
   printf("Enter the number: ");
   scanf("%d", &n);

   do {
      if (i % 3 == 0) {
         printf("%d ", i);
      }
      i++;
   } while (i <= n);

   printf("\n");
   return 0;
}

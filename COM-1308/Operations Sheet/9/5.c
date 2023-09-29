#include <stdio.h>

int main() {
   int number;
   printf("Enter a number (0-4): ");
   scanf("%d", &number);

   switch (number) {
      case 0:
         break;
      case 1:
         printf("Blue\n");
         break;
      case 2:
         printf("Yellow\n");
         break;
      case 3:
         printf("Red\n");
         break;
      case 4:
         printf("Green\n");
         break;
      default:
         printf("Black\n");
   }

   printf("\n");
   return 0;
}

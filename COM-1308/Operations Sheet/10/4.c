#include <stdio.h>

int main() {
   float windSpeed;

   printf("Enter wind speed (mph): ");
   scanf("%f", &windSpeed);

   switch ((int)windSpeed) {
      case 0 ... 24:
         printf("Not a strong wind\n");
         break;
      case 25 ... 38:
         printf("Strong wind\n");
         break;
      case 39 ... 54:
         printf("Gale\n");
         break;
      case 55 ... 72:
         printf("Whole gale\n");
         break;
      default:
         printf("Hurricane\n");
   }

   printf("\n");
   return 0;
}

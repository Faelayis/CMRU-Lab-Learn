#include <stdio.h>

int main() {
   int month;

   printf("Please enter month number: ");
   scanf("%d", &month);

   switch (month) {
      case 1:
         printf("No. 1 : January : 31 days\n");
         break;
      case 2:
         printf("No. 2 : February : 28 or 29 days\n");
         break;
      case 3:
         printf("No. 3 : March : 31 days\n");
         break;
      case 4:
         printf("No. 4 : April : 30 days\n");
         break;
      case 5:
         printf("No. 5 : May : 31 days\n");
         break;
      case 6:
         printf("No. 6 : June : 30 days\n");
         break;
      case 7:
         printf("No. 7 : July : 31 days\n");
         break;
      case 8:
         printf("No. 8 : August : 31 days\n");
         break;
      case 9:
         printf("No. 9 : September : 30 days\n");
         break;
      case 10:
         printf("No. 10 : October : 31 days\n");
         break;
      case 11:
         printf("No. 11 : November : 30 days\n");
         break;
      case 12:
         printf("No. 12 : December : 31 days\n");
         break;
      default:
         printf("Invalid month number\n");
   }

   printf("\n");
   return 0;
}

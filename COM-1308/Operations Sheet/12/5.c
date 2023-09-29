#include <stdio.h>

int main() {
   float total = 0, vat, grandTotal;
   int choice;

   printf("\tMENU\n");
   printf("1. French Fries\t25 Baht\n");
   printf("2. Fish Burger\t65 Baht\n");
   printf("3. Hamburger\t55 Baht\n");
   printf("4. Double Cheese\t109 Baht\n");
   printf("5. CocaCola\t15 Baht\n");
   printf("6. End\n");

   while (1) {
      printf("Enter MENU 1-6: ");
      scanf("%d", &choice);

      if (choice == 6) {
         break;
      }

      switch (choice) {
         case 1:
            total += 25;
            break;
         case 2:
            total += 65;
            break;
         case 3:
            total += 55;
            break;
         case 4:
            total += 109;
            break;
         case 5:
            total += 15;
            break;
         default:
            printf("Invalid choice.\n");
            break;
      }
   }

   vat = 0.07 * total;
   grandTotal = total + vat;

   printf("\nTotal\t= %.2f\n", total);
   printf("Vat 7%%\t= %.2f\n", vat);
   printf("Pay\t= %.2f\n", grandTotal);

   printf("\n");
   return 0;
}

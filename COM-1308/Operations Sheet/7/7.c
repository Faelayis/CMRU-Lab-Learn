#include <stdio.h>

int main() {
   int costPricePerLump = 36;
   float profitMarginPercentage = 20.0;
   float costPricePerItem = (float)costPricePerLump / 36;
   float sellingPricePerItem =
       costPricePerItem * (1 + profitMarginPercentage / 100);

   printf("Cost price per item: %.2f\n", costPricePerItem);
   printf("Selling price per item (with 20%% profit margin): %.2f\n",
          sellingPricePerItem);

   printf("\n");
   return 0;
}
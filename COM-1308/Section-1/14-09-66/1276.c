#include <stdio.h>

int main()
{
   int i, sum;

   for (i = 0; i <= 50; i++)
   {
      sum = sum + i;
   }

   printf("sum = %d\n", sum);

   printf("\n");
   return 0;

   // output: 1276
}

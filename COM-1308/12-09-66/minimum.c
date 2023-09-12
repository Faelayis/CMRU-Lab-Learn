#include <stdio.h>

main()
{
   int i, x[2];

   for (i = 0; i < 3; i++)
   {
      printf("Enter number %i: ", i + 1);
      scanf("%i", &x[i]);
   }

   if (x[0] < x[2])
   {
      (x[0] < x[2])
          ? printf("Minimum = %d", x[0])
          : printf("Minimum = %d", x[2]);
   }
   else
   {
      (x[1] < x[2])
          ? printf("Minimum = %d", x[1])
          : printf("Minimum = %d", x[2]);
   }

   printf("\n");
   return 0;

   /* input:
   Enter number 1: 10
   Enter number 2: 110
   Enter number 3: 10
   */

   // output: Minimum = 10
}

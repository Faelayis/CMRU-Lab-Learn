#include <stdio.h>

main(int argc, char const *argv[])
{
   int i, x[2];

   for (i = 0; i < 3; i++)
   {
      printf("Enter number : ");
      scanf("%i", &x[i]);
   }

   (x[0] + x[1] + x[2]) > 50 ? printf("More 100") : (void)NULL;

   printf("\n");
   return 0;

   // output: More 100
}
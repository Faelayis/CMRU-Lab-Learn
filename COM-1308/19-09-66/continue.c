#include <stdio.h>

main()
{
   int x;

   for (x; x <= 10; x++)
   {
      if (x % 2)
         continue;
      printf("% d \n", x);
   }

   printf("\n");
   return 0;
}
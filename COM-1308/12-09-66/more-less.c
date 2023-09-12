#include <stdio.h>

main(int argc, char const *argv[])
{
   int i, x[2], r;

   for (i = 0; i < 3; i++)
   {
      printf("Enter number : ");
      scanf("%i", &x[i]);
   }

   r = x[0] + x[1] + x[2];

   (r) <= 100 ? printf("%d + %d + %d = %d", x[0], x[1], x[2], r) : printf("%d + %d + %d = %d", x[0], x[1], x[2], r + 50);

   printf("\n");
   return 0;

   // output: More 100
}

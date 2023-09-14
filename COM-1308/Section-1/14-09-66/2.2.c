#include <stdio.h>

// for (x = 20; x >= 1; x--)
// {
//    printf("%d\n", x);
// }

int main()
{
   int x = 20;

   while (x > 0)
   {
      printf("%d\n", x);
      x--;
   }

   printf("\n");
   return 0;

   /* ouput:
   10
   9
   8
   7
   6
   5
   4
   3
   2
   1
   */
}

#include <stdio.h>

main()
{
   int x;

   while (x++ < 10)
   {
      printf("x=%d\n", x);
   }

   /* output:
   x=1
   x=2
   x=3
   x=4
   x=5
   x=6
   x=7
   x=8
   x=9
   x=10
   */
}
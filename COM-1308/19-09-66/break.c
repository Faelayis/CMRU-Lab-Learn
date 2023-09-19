#include <stdio.h>

main()
{
   char ch;

   for (;;)
   {
      ch = getch();
      if (ch == "A")
         break;
   }

   printf("\n");
   return 0;
}
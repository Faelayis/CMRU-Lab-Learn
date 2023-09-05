#include <stdio.h>

int main()
{
   char ch = 'A', str[] = "computer";

   printf("%c ", ch);
   printf("%d ", ch);
   printf("%s ", str);
   printf("%3s ", str);

   printf("\n");
   return 0;

   // output: A 65 computer computer
}

#include <stdio.h>

int main()
{
   char x = 'n';

   while (x != 'y')
   {
      printf("input: ");
      scanf("%c", &x);
   }

   printf("Good Bye");

   printf("\n");
   return 0;
}

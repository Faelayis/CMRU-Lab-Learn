#include <stdio.h>

int main()
{
   char text;

   printf("input: ");
   text = getch();

   printf("\noutput: ");
   putchar(text);

   printf("\n");
   return 0;

   // input: wasd
   // output: w
}

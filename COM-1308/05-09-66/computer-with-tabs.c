#include <stdio.h>

int main()
{
   char ch = 'A', str[] = "computer";

   printf("%3c", ch);
   printf("%15.8s ", str);
   printf("%-15.8s ", str);

   printf("\n");
   return 0;

   // output:  A       computer computer
}

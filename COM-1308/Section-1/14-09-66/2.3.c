#include <stdio.h>

int main()
{
   int count, input;

   while (count < 3)
   {
      printf("Enter number: ");
      scanf("%x", &input);

      if ((input % 2) == 0)
      {
         printf("Even Number\n");
      }
      else
      {
         printf("Odd Number\n");
      }
      count++;
   }

   printf("\n");
   return 0;
}

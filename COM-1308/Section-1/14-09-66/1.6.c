#include <stdio.h>

int main()
{
   int input, x, i;

   printf("Enter number: ");
   scanf("%x", &input);

   for (x; x <= input; x++)
   {
      for (i = 1; i <= x; i++)
      {
         printf("%d ", i);
      }
      printf("\n");
   }

   printf("\n");
   return 0;

   // input: Enter number: 5
   /* output:
   1
   1 2
   1 2 3
   1 2 3 4
   1 2 3 4 5
   */
}

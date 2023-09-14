`1276.c`
```c 
#include <stdio.h>

int main()
{
   int i, sum;

   for (i = 0; i <= 50; i++)
   {
      sum = sum + i;
   }

   printf("sum = %d\n", sum);

   printf("\n");
   return 0;

   // output: 1276
}

```
`5.c`
```c 
#include <stdio.h>

int main()
{
   int i, j;

   for (i = 0; i <= 9; i++)
   {
      for (j = 1; j < i; j++)
      {
         printf("*");
      }
   }

   printf("\n");
   return 0;

   // output:  ************************************
}

```
`6.c`
```c 
#include <stdio.h>

int main()
{
   int input, i, j;

   printf("Enter number: ");
   scanf("%i", &input);

   for (i; i <= input; i++)
   {
      for (j = 1; j <= i; j++)
      {
         printf("%d ", j);
      }
      printf("\n");
   }

   printf("\n");
   return 0;

   /* output
   Enter number: 5

   1
   1 2
   1 2 3
   1 2 3 4
   1 2 3 4 5

   */
}

```

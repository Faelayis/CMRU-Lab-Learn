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
   int x, i;

   for (x = 0; x <= 10; x++)
   {
      for (i = 1; i <= 10; i++)
      {
         printf("* ");
      }
      printf("\n");
   }

   printf("\n");
   return 0;

   /* output:
    * * * * * * * * * *
    * * * * * * * * * *
    * * * * * * * * * *
    * * * * * * * * * *
    * * * * * * * * * *
    * * * * * * * * * *
    * * * * * * * * * *
    * * * * * * * * * *
    * * * * * * * * * *
    * * * * * * * * * *
    * * * * * * * * * *
    */
}

```

`6.c`

```c
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

   /* output:
   Enter number: 5

   1
   1 2
   1 2 3
   1 2 3 4
   1 2 3 4 5

   */
}

```

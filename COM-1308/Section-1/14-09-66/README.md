`1.5.c`<br>
สร้าง: 15 ก.ย. 2566 20:54<br>
`
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
`1.6.c`<br>
สร้าง: 15 ก.ย. 2566 20:54<br>
`
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

   // input: Enter number: 5
   /* output:
   1
   1 2
   1 2 3
   1 2 3 4
   1 2 3 4 5
   */
}

```
`2.2.c`<br>
สร้าง: 15 ก.ย. 2566 20:54<br>
`
```c 
#include <stdio.h>

int main()
{
   int x = 20;

   while (x > 0)
   {
      printf("%d\n", x);
      x--;
   }

   printf("\n");
   return 0;

   /* ouput:
   10
   9
   8
   7
   6
   5
   4
   3
   2
   1
   */
}

```
`2.3.c`<br>
สร้าง: 15 ก.ย. 2566 20:54<br>
`
```c 
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

```
`2.4.c`<br>
สร้าง: 15 ก.ย. 2566 20:54<br>
`
```c 
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

```
`_1276.c`<br>
สร้าง: 15 ก.ย. 2566 20:54<br>
`
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

`minimum.c`<br>
สร้าง: 15 ก.ย. 2566 21:08<br>`
```c 
#include <stdio.h>

main()
{
   int i, x[2];

   for (i = 0; i < 3; i++)
   {
      printf("Enter number %i: ", i + 1);
      scanf("%i", &x[i]);
   }

   if (x[0] < x[2])
   {
      (x[0] < x[2])
          ? printf("Minimum = %d", x[0])
          : printf("Minimum = %d", x[2]);
   }
   else
   {
      (x[1] < x[2])
          ? printf("Minimum = %d", x[1])
          : printf("Minimum = %d", x[2]);
   }

   printf("\n");
   return 0;

   /* input:
   Enter number 1: 10
   Enter number 2: 110
   Enter number 3: 10
   */

   // output: Minimum = 10
}

```
`more-less-or-add.c`<br>
สร้าง: 15 ก.ย. 2566 21:08<br>`
```c 
#include <stdio.h>

main(int argc, char const *argv[])
{
   int i, x[3], r;

   for (i = 0; i < 3; i++)
   {
      printf("Enter number : ");
      scanf("%i", &x[i]);
   }

   r = x[0] + x[1] + x[2];

   ((r) <= 100)
       ? printf("%d + %d + %d = %d", x[0], x[1], x[2], r)
       : printf("%d + %d + %d + 50 = %d", x[0], x[1], x[2], r + 50);

   printf("\n");
   return 0;

   // output: 20 + 20 + 20 = 60 or 50 + 30 + 40 + 50 = 170
}

```
`score.c`<br>
สร้าง: 15 ก.ย. 2566 21:08<br>`
```c 
#include <stdio.h>
#include <string.h>

int main()
{
   int score;
   char grade[2];

   printf("Enter score : ");
   scanf("%i", &score);

   if (score >= 80)
      strcpy(grade, "A");
   else if (score >= 70)
      strcpy(grade, "B");
   else if (score >= 60)
      strcpy(grade, "C");
   else if (score >= 50)
      strcpy(grade, "D");
   else
      strcpy(grade, "F");

   printf("Grade: %s", grade);

   printf("\n");
   return 0;

   // input: 49
   // output: Grade: F
}

```

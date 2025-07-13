`1.c`<br>
Create: 29 ก.ย. 2566 เวลา 22:56<br>
```c
#include <stdio.h>

int main() {
   int i;

   for (i = 0; i < 50; i++) {
      printf("A ");
   }

   printf("\n");
   return 0;
}

```
`2.c`<br>
Create: 29 ก.ย. 2566 เวลา 22:56<br>
```c
#include <stdio.h>

int main() {
   int i;

   for (i = 100; i <= 200; i++) {
      if (i % 2 == 0) {
         printf("%d ", i);
      }
   }

   printf("\n");
   return 0;
}

```
`3.c`<br>
Create: 29 ก.ย. 2566 เวลา 22:56<br>
```c
#include <stdio.h>

int main() {
   int num1, num2, i;
   int sum = 0;

   printf("Enter the first number: ");
   scanf("%d", &num1);
   printf("Enter the second number: ");
   scanf("%d", &num2);

   if (num1 > num2) {
      int temp = num1;
      num1 = num2;
      num2 = temp;
   }

   for (i = num1 + 1; i < num2; i++) {
      if (i % 2 != 0) {
         sum += i;
      }
   }

   printf("The sum of odd numbers between %d and %d is %d\n", num1, num2, sum);

   printf("\n");
   return 0;
}

```
`4.c`<br>
Create: 26 ก.ย. 2566 เวลา 11:46<br>
Update: 29 ก.ย. 2566 เวลา 22:56<br>
```c
#include <stdio.h>

int main() {
   int i, j;

   for (i = 2; i <= 8; i += 2) {
      for (j = 1; j <= 5; j++) {
         printf("%d ", i);
      }
      printf("\n");
   }

   printf("\n");
   return 0;

   /* output:
   2 2 2 2 2
   4 4 4 4 4
   6 6 6 6 6
   8 8 8 8 8
   */
}

```
`5.c`<br>
Create: 29 ก.ย. 2566 เวลา 22:56<br>
```c
#include <stdio.h>

int main() {
   char ch, i;

   for (ch = 'A'; ch <= 'D'; ch++) {
      for (i = 'A'; i <= ch; i++) {
         printf("%c ", ch);
      }
      printf("\n");
   }

   printf("\n");
   return 0;

   /* output:
   A
   B B
   C C C
   D D D D
   */
}

```

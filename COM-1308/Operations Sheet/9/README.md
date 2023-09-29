`1.c`<br>
สร้าง: 29 ก.ย. 2566 เวลา 22:09<br>
```c
#include <stdio.h>

int main() {
   int A;
   printf("Enter a value A: ");
   scanf("%d", &A);

   if (A >= 10 && A <= 20) {
      printf("A is in the range of 10 - 20\n");
   } else {
      printf("A is not in the range of 10 - 20\n");
   }

   printf("\n");
   return 0;
}

```
`2.c`<br>
สร้าง: 29 ก.ย. 2566 เวลา 22:09<br>
```c
#include <stdio.h>

int main() {
   int num1, num2;
   printf("Enter integer 1: ");
   scanf("%d", &num1);
   printf("Enter integer 2: ");
   scanf("%d", &num2);

   if (num1 > num2) {
      printf("%d is greater than %d\n", num1, num2);
   } else if (num1 < num2) {
      printf("%d is less than %d\n", num1, num2);
   } else {
      printf("%d is equal to %d\n", num1, num2);
   }

   printf("\n");
   return 0;
}

```
`3.c`<br>
สร้าง: 29 ก.ย. 2566 เวลา 22:09<br>
```c
#include <stdio.h>

int main() {
   int x = 3, y = 10;

   if ((3 / x) < y) x = x + 2;
   y = y + 3;

   printf("x = %d\n", x);
   printf("y = %d\n", y);

   printf("\n");
   return 0;

   /* output:
   x = 5
   y = 13
   */
}

```
`4.c`<br>
สร้าง: 29 ก.ย. 2566 เวลา 22:09<br>
```c
#include <stdio.h>

int main() {
   float x, y = 12.00;

   if (y < 15.00 && y < 5.00)
      x = 5 * y;
   else
      x = 2 + y;

   printf("x = %.2f\n", x);

   printf("\n");
   return 0;

   // output x = 14.00
}

```
`5.c`<br>
สร้าง: 29 ก.ย. 2566 เวลา 22:09<br>
```c
#include <stdio.h>

int main() {
   int number;
   printf("Enter a number (0-4): ");
   scanf("%d", &number);

   switch (number) {
      case 0:
         break;
      case 1:
         printf("Blue\n");
         break;
      case 2:
         printf("Yellow\n");
         break;
      case 3:
         printf("Red\n");
         break;
      case 4:
         printf("Green\n");
         break;
      default:
         printf("Black\n");
   }

   printf("\n");
   return 0;
}

```

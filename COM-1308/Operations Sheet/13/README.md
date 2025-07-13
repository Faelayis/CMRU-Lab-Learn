`1.c`<br>
Create: 29 ก.ย. 2566 time 22:56<br>
```c
#include <stdio.h>

int main() {
   int i = 10;

   do {
      printf("Number = %d\n", i + 1);
      i += 5;
   } while (i <= 30);

   printf("\n");
   return 0;
}

```
`2.c`<br>
Create: 29 ก.ย. 2566 time 22:56<br>
```c
#include <stdio.h>

int main() {
   int sum = 0, n;

   do {
      printf("Enter number or 0 to exit: ");
      scanf("%d", &n);
      sum += n;
   } while (n != 0);
   printf("Sum of numbers = %d\n", sum);

   printf("\n");
   return 0;
}

```
`3.c`<br>
Create: 29 ก.ย. 2566 time 22:56<br>
```c
#include <stdio.h>

int main() {
   int sum = 0, n, count = 0;

   do {
      printf("Please enter the number: ");
      scanf("%d", &n);
      sum += n;
      count++;
   } while (sum <= 500);

   printf("Amount of numbers is %d\n", count);

   printf("\n");
   return 0;
}

```
`4.c`<br>
Create: 29 ก.ย. 2566 time 22:56<br>
```c
#include <stdio.h>

int main() {
   int n, factorial = 1;

   printf("Enter a number: ");
   scanf("%d", &n);

   do {
      factorial *= n;
      n--;
   } while (n > 0);

   printf("Factorial = %d\n", factorial);

   printf("\n");
   return 0;
}

```
`5.c`<br>
Create: 29 ก.ย. 2566 time 22:56<br>
```c
#include <stdio.h>

int main() {
   int n, i = 0;
   printf("Enter the number: ");
   scanf("%d", &n);

   do {
      if (i % 3 == 0) {
         printf("%d ", i);
      }
      i++;
   } while (i <= n);

   printf("\n");
   return 0;
}

```

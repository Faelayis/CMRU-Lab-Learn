`asterisk.c`<br>
Create: 26 ก.ย. 2566 เวลา 11:46<br>
```c
#include <stdio.h>

int main() {
   int x;

   for (x; x <= 5; x++) {
      printf("*");
   }

   printf("\n");
   return 0;

   // output: ******
}

```
`asterisk_box.c`<br>
Create: 26 ก.ย. 2566 เวลา 11:46<br>
```c
#include <stdio.h>

int main() {
   int x, i;

   for (x; x <= 5; x++) {
      for (i = 1; i <= 5; i++) {
         printf("* ");
      }
      printf("\n");
   }

   printf("\n");
   return 0;

   /* output:
    * * * * *
    * * * * *
    * * * * *
    * * * * *
    * * * * *
    */
}

```
`pyramid_12345.c`<br>
Create: 26 ก.ย. 2566 เวลา 11:46<br>
```c
#include <stdio.h>

int main() {
   int x, i;

   for (x = 1; x <= 5; x++) {
      for (i = 1; i <= x; i++) {
         printf("%d ", i);
      }
      printf("\n");
   }

   printf("\n");
   return 0;

   /* output:
   1
   1 2
   1 2 3
   1 2 3 4
   1 2 3 4 5
   */
}

```
`pyramid_reverse.c`<br>
Create: 26 ก.ย. 2566 เวลา 11:46<br>
```c
#include <stdio.h>

int main() {
   int rows = 5, x, o, i;

   for (x = 1; x <= rows; x++) {
      for (i = 1; i <= rows - x; i++) {
         printf("  ");
      }

      for (o = 1; o <= x; o++) {
         printf("* ");
      }

      printf("\n");
   }

   printf("\n");
   return 0;

   // clang-format off
   /* output:
            *
          * *
        * * *
      * * * *
    * * * * *
    */
}

```

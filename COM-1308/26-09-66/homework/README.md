`left_top.c`<br>
สร้าง: 26 ก.ย. 2566 เวลา 11:46<br>
อัปเดต: 28 ก.ย. 2566 เวลา 18:43<br>
```c
#include <stdio.h>

int main() {
   int x, i;

   for (x = 5; x >= 1; --x) {
      for (i = 1; i <= x; ++i) {
         printf("* ");
      }
      printf("\n");
   }

   printf("\n");
   return 0;

   /* output:
    * * * * *
    * * * *
    * * *
    * *
    *
    */
}

```
`right_top.c`<br>
สร้าง: 26 ก.ย. 2566 เวลา 11:46<br>
อัปเดต: 28 ก.ย. 2566 เวลา 18:43<br>
```c
#include <stdio.h>

int main() {
   int x, i;

   for (x = 1; x <= 5; ++x) {
      for (i = 1; i < x; ++i) {
         printf("  ");
      }
      for (i = x; i <= 5; ++i) {
         printf("* ");
      }
      printf("\n");
   }

   printf("\n");
   return 0;

   // clang-format off
   /* output:
    * * * * *
      * * * *
        * * *
          * *
            *
    */
}

```
`triangle.c`<br>
สร้าง: 26 ก.ย. 2566 เวลา 11:46<br>
แก้ไขล่าสุด: เวลา 11:49<br>

```c
#include <stdio.h>

int main() {
   int x, i;

   for (x = 1; x <= 5; ++x) {
      for (i = 1; i <= 5 - x; ++i) {
         printf(" ");
      }

      for (i = 1; i <= x; ++i) {
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

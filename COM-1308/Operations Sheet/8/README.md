`4.c`<br>
สร้าง: 23 มิ.ย. 2567 เวลา 12:39<br>
```c
#include <stdio.h>

int main() {
   printf("************************************\n");
   printf("****     Welcome to Turbo C     ****\n");
   printf("************************************\n");
   printf("\n");
   return 0;
}

```
`5.c`<br>
สร้าง: 23 มิ.ย. 2567 เวลา 12:39<br>
```c
#include <stdio.h>

int main() {
   int num1, num2, num3;

   printf("Enter three numbers: ");
   scanf("%d %d %d", &num1, &num2, &num3);

   if (num1 > num2) {
      int temp = num1;
      num1 = num2;
      num2 = temp;
   }
   if (num2 > num3) {
      int temp = num2;
      num2 = num3;
      num3 = temp;
   }
   if (num1 > num2) {
      int temp = num1;
      num1 = num2;
      num2 = temp;
   }

   printf("Sorted numbers: %d %d %d\n", num1, num2, num3);

   printf("\n");
   return 0;
}

```
`6.c`<br>
สร้าง: 23 มิ.ย. 2567 เวลา 12:39<br>
```c
#include <stdio.h>

int main() {
   char character;

   printf("Enter a character: ");
   scanf(" %c", &character);

   if (character >= 'A' && character <= 'Z') {
      printf("Uppercase: %c\n", character);
      printf("Lowercase: %c\n", character + 32);
   } else if (character >= 'a' && character <= 'z') {
      printf("Uppercase: %c\n", character - 32);
      printf("Lowercase: %c\n", character);
   } else {
      printf("Not a valid alphabet character.\n");
   }

   printf("\n");
   return 0;
}

```

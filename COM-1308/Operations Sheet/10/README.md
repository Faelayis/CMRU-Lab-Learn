`1.c`<br>
สร้าง: 29 ก.ย. 2566 เวลา 22:56<br>
```c
#include <stdio.h>

int main() {
   int month;

   printf("Please enter month number: ");
   scanf("%d", &month);

   switch (month) {
      case 1:
         printf("No. 1 : January : 31 days\n");
         break;
      case 2:
         printf("No. 2 : February : 28 or 29 days\n");
         break;
      case 3:
         printf("No. 3 : March : 31 days\n");
         break;
      case 4:
         printf("No. 4 : April : 30 days\n");
         break;
      case 5:
         printf("No. 5 : May : 31 days\n");
         break;
      case 6:
         printf("No. 6 : June : 30 days\n");
         break;
      case 7:
         printf("No. 7 : July : 31 days\n");
         break;
      case 8:
         printf("No. 8 : August : 31 days\n");
         break;
      case 9:
         printf("No. 9 : September : 30 days\n");
         break;
      case 10:
         printf("No. 10 : October : 31 days\n");
         break;
      case 11:
         printf("No. 11 : November : 30 days\n");
         break;
      case 12:
         printf("No. 12 : December : 31 days\n");
         break;
      default:
         printf("Invalid month number\n");
   }

   printf("\n");
   return 0;
}

```
`2.c`<br>
สร้าง: 29 ก.ย. 2566 เวลา 22:56<br>
```c
#include <stdio.h>

int main() {
   float weight, height, bmi;

   printf("Enter weight (kg): ");
   scanf("%f", &weight);
   printf("Enter height (m): ");
   scanf("%f", &height);

   bmi = weight / (height * height);

   printf("BMI: %.2f\n", bmi);

   switch ((int)bmi) {
      case 0 ... 15:
         printf("Severe Thinness\n");
         break;
      case 16 ... 16:
         printf("Moderate Thinness\n");
         break;
      case 17 ... 18:
         printf("Mild Thinness\n");
         break;
      case 19 ... 24:
         printf("Normal\n");
         break;
      case 25 ... 29:
         printf("Overweight\n");
         break;
      case 30 ... 34:
         printf("Obese Class I\n");
         break;
      case 35 ... 39:
         printf("Obese Class II\n");
         break;
      default:
         printf("Obese Class III\n");
   }

   printf("\n");
   return 0;
}

```
`3.c`<br>
สร้าง: 29 ก.ย. 2566 เวลา 22:56<br>
```c
#include <stdio.h>

int main() {
   char letter;
   printf("Enter your letter: ");
   scanf(" %c", &letter);

   switch (letter) {
      case 'A':
      case 'E':
      case 'I':
      case 'O':
      case 'U':
      case 'a':
      case 'e':
      case 'i':
      case 'o':
      case 'u':
         printf("%c is a vowel\n", letter);
         break;
      default:
         printf("%c is a consonant\n", letter);
   }

   printf("\n");
   return 0;
}

```
`4.c`<br>
สร้าง: 29 ก.ย. 2566 เวลา 22:56<br>
```c
#include <stdio.h>

int main() {
   float windSpeed;

   printf("Enter wind speed (mph): ");
   scanf("%f", &windSpeed);

   switch ((int)windSpeed) {
      case 0 ... 24:
         printf("Not a strong wind\n");
         break;
      case 25 ... 38:
         printf("Strong wind\n");
         break;
      case 39 ... 54:
         printf("Gale\n");
         break;
      case 55 ... 72:
         printf("Whole gale\n");
         break;
      default:
         printf("Hurricane\n");
   }

   printf("\n");
   return 0;
}

```
`5.c`<br>
สร้าง: 29 ก.ย. 2566 เวลา 22:56<br>
```c
#include <math.h>
#include <stdio.h>

int main() {
   int choice, area;

   while (1) {
      printf("************ MENU ************\n");
      printf("1. Rectangle\n");
      printf("2. Circle\n");
      printf("3. Triangle\n");
      printf("4. Square\n");
      printf("5. Exit\n");
      printf("********************************\n");
      printf("Please enter 1 - 5: ");
      scanf("%d", &choice);

      switch (choice) {
         case 1:

            float length, width;
            printf("Enter length: ");
            scanf("%f", &length);
            printf("Enter width: ");
            scanf("%f", &width);
            area = length * width;
            printf("Rectangle area: %.2f\n", area);
            break;
         case 2:

            float radius;
            printf("Enter Radius: ");
            scanf("%f", &radius);
            area = 3.14159265358979323846 * radius * radius;
            printf("Circle area: %.2f\n", area);
            break;
         case 3:

            float base, height;
            printf("Enter base: ");
            scanf("%f", &base);
            printf("Enter height: ");
            scanf("%f", &height);
            area = 0.5 * base * height;
            printf("Triangle area: %.2f\n", area);
            break;
         case 4:

            float side;
            printf("Enter side length: ");
            scanf("%f", &side);
            area = side * side;
            printf("Square area: %.2f\n", area);
            break;
         case 5:

            printf("Exiting the program. Goodbye!\n");
            return 0;
         default:
            printf("Wrong Number\n");
      }
   }

   printf("\n");
   return 0;
}

```

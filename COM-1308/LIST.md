
## 05-09-66

`computer.c`<br>
สร้าง: 5 ก.ย. 2566 เวลา 11:47<br>
```c
#include <stdio.h>

int main()
{
   char ch = 'A', str[] = "computer";

   printf("%c ", ch);
   printf("%d ", ch);
   printf("%s ", str);
   printf("%3s ", str);

   printf("\n");
   return 0;

   // output: A 65 computer computer
}

```

`computer-with-tabs.c`<br>
สร้าง: 5 ก.ย. 2566 เวลา 11:47<br>
```c
#include <stdio.h>

int main()
{
   char ch = 'A', str[] = "computer";

   printf("%3c", ch);
   printf("%15.8s ", str);
   printf("%-15.8s ", str);

   printf("\n");
   return 0;

   // output:  A       computer computer
}

```

`getch.c`<br>
สร้าง: 5 ก.ย. 2566 เวลา 11:47<br>
```c
#include <stdio.h>

int main()
{
   char text;

   printf("input: ");
   text = getchar();

   printf("\noutput: ");
   putchar(text);

   printf("\n");
   return 0;

   // input: wasd & enter
   // output: w
}

```

`getchar.c`<br>
สร้าง: 5 ก.ย. 2566 เวลา 11:47<br>
```c
#include <stdio.h>

int main()
{
   char text;

   printf("input: ");
   text = getch();

   printf("\noutput: ");
   putchar(text);

   printf("\n");
   return 0;

   // input: wasd
   // output: w
}

```

`test.c`<br>
สร้าง: 5 ก.ย. 2566 เวลา 11:47<br>
```c
#include <stdio.h>

int main()
{
   int a = 12, b = 20;

   printf("%10d%5d ", a, b);

   printf("\n");
   return 0;

   // output:        12   20
}

```

`the-sum-is.c`<br>
สร้าง: 5 ก.ย. 2566 เวลา 11:47<br>
```c
#include <stdio.h>

int main()
{
   int sum = 68;

   printf("The Sum is = %c ", sum);

   printf("\n");
   return 0;

   // output: The Sum is = D
}

```


## 12-09-66

`minimum.c`<br>
สร้าง: 12 ก.ย. 2566 เวลา 11:59<br>
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
สร้าง: 12 ก.ย. 2566 เวลา 10:24<br>
อัปเดต: 13 ก.ย. 2566 เวลา 13:23<br>
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
สร้าง: 12 ก.ย. 2566 เวลา 11:59<br>
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


## 12-09-66/homework

`main.c`<br>
สร้าง: 14 ก.ย. 2566 เวลา 11:41<br>
แก้ไขล่าสุด: เวลา 14:02<br>

```c
#include <stdio.h>

typedef double (*CalculationFunction)(double);

double inchesToMeters(double inches)
{
    return inches * 0.0254;
}

double metersToInches(double meters)
{
    return meters / 0.0254;
}

struct MenuItem
{
    char item[256];
    CalculationFunction cal;
};

struct MenuData
{
    int length;
};

int main()
{
    int i, choice;

    struct MenuItem menus[] = {
        {"Inches to Meters", inchesToMeters},
        {"Meters to Inches", metersToInches},
    };

    struct MenuData menu = {
        .length = sizeof(menus) / sizeof(menus[0]),
    };

    printf("Conversion menu:\n");
    for (i = 0; i < menu.length; i++)
    {
        printf("%d.%s\n", i + 1, menus[i].item);
    }
    printf("\nSelect an option (1-%d): ", menu.length);
    scanf("%d", &choice);

    if (choice >= 1 && choice <= menu.length)
    {
        double input;

        printf("\nEnter value: ");
        scanf("%lf", &input);
        printf("Result: %0.4f \n", menus[choice - 1].cal(input));
    }
    else
    {
        printf("\nInvalid choice");
    }

    printf("\n");
    return 0;
}

/* Previews
  Conversion Menu:
  1. Inches to Meters
  2. Meters to Inches

  Select an option (1-2): 1

  Enter value: 1
  Result: 0.0254
*/

```


## 19-09-66

`break.c`<br>
สร้าง: 19 ก.ย. 2566 เวลา 10:54<br>
```c
#include <stdio.h>

main()
{
   char ch;

   for (;;)
   {
      ch = getch();
      if (ch == "A")
         break;
   }

   printf("\n");
   return 0;
}
```

`continue.c`<br>
สร้าง: 19 ก.ย. 2566 เวลา 10:54<br>
```c
#include <stdio.h>

main()
{
   int x;

   for (x; x <= 10; x++)
   {
      if (x % 2)
         continue;
      printf("% d \n", x);
   }

   printf("\n");
   return 0;
}
```

`for.c`<br>
สร้าง: 19 ก.ย. 2566 เวลา 10:54<br>
```c
#include <stdio.h>

int main()
{
   int x;

   for (x = 1; x <= 100; x++)
   {
      printf("%d\t", x);
   }

   printf("\n");
   return 0;

   /* output:
   1       2       3       4       5       6       7       8       9       10      11      12      13      14      15     16       17      18
   19      20      21      22      23      24      25      26      27      28      29      30     31       32      33      34      35      36
   37      38      39      40      41      42      43      44      45     46       47      48      49      50      51      52      53      54
   55      56      57      58      59      60     61       62      63      64      65      66      67      68      69      70      71      72
   73      74      75     76       77      78      79      80      81      82      83      84      85      86      87      88      89      90
   91       92      93      94      95      96      97      98      99      100
   */
}

```

`while.c`<br>
สร้าง: 19 ก.ย. 2566 เวลา 10:54<br>
```c
#include <stdio.h>

main()
{
   int x;

   while (x++ < 10)
   {
      printf("x=%d\n", x);
   }

   /* output:
   x=1
   x=2
   x=3
   x=4
   x=5
   x=6
   x=7
   x=8
   x=9
   x=10
   */
}
```


## 19-09-66/homework

`main.c`<br>
สร้าง: 19 ก.ย. 2566 เวลา 21:29<br>
อัปเดต: 26 ก.ย. 2566 เวลา 09:36<br>
```c
#include <stdio.h>
#include <stdlib.h>

typedef float (*AreaFunction)(float, float);

float circleArea(float radius, float _nope)
{
   return 3.14 * radius * radius;
}

float triangleArea(float base, float height)
{
   return 0.5 * base * height;
}

float rectangleArea(float width, float length)
{
   return width * length;
}

struct MenuItem
{
   char item[256];
   AreaFunction cal;
};

struct MenuData
{
   int length;
};

void clearScreen()
{
#ifdef _WIN32
   system("cls");
#else

   system("clear");
#endif
}

int main()
{
   int choice;
   char continueChoice;

   struct MenuItem menus[] = {
       {"Circle", circleArea},
       {"Triangle", triangleArea},
       {"Rectangle", rectangleArea},
   };

   struct MenuData menu = {
       .length = sizeof(menus) / sizeof(menus[0]),
   };

   do
   {
      clearScreen();

      printf("Area Calculation Menu:\n");

      int i = 0;
      for (i; i < menu.length; i++)
      {
         printf("%d. %s\n", i + 1, menus[i].item);
      }
      printf("\nSelect an option (1-%d): ", menu.length);
      scanf("%d", &choice);
      printf("\n");

      if (choice >= 1 && choice <= menu.length)
      {
         float result;
         if (choice == 1)
         {
            float radius;

            printf("Enter the radius: ");
            scanf("%f", &radius);
            result = menus[choice - 1].cal(radius, 0);
         }
         else if (choice == 2)
         {
            float base, height;

            printf("Enter length: ");
            scanf("%f", &base);
            printf("Enter height: ");
            scanf("%f", &height);
            result = menus[choice - 1].cal(base, height);
         }
         else if (choice == 3)
         {
            float width, length;

            printf("Enter width: ");
            scanf("%f", &width);
            printf("Enter length: ");
            scanf("%f", &length);
            result = menus[choice - 1].cal(width, length);
         }

         printf("\nResult: %.2f\n", result);
      }
      else
      {
         printf("\nNot in the menu.\n");
      }

      printf("\nDo you want to continue (y/n): ");
      scanf(" %c", &continueChoice);

   } while (continueChoice == 'y' || continueChoice == 'Y');

   printf("\n");
   return 0;
}

/* Previews
  Area Calculation Menu:
  1. Circle
  2. Triangle
  3. Rectangle

  Select an option (1-3): 1

  Enter value: 1
  Result: 0.0254
*/

```


## 19-09-66/todo

`main.c`<br>
สร้าง: 19 ก.ย. 2566 เวลา 10:54<br>
แก้ไขล่าสุด: เวลา 11:41<br>

```c
#include <stdio.h>

typedef int (*OperationFunction)(int, int);

int add(int a, int b)
{
   return a + b;
}

int subtract(int a, int b)
{
   return a - b;
}

int multiply(int a, int b)
{
   return a * b;
}

int divide(int a, int b)
{
   if (b == 0)
   {
      printf("\nError: division by zero\n");
      return 0;
   }
   return a / b;
}

struct MenuItem
{
   char item[256];
   OperationFunction op;
};

struct MenuData
{
   int length;
};

int main()
{
   int i, choice;

   struct MenuItem menus[] = {
       {"+", add},
       {"-", subtract},
       {"x", multiply},
       {"%", divide},
   };

   struct MenuData menu = {
       .length = sizeof(menus) / sizeof(menus[0]),
   };

   printf("Math Menu:\n");
   for (i = 0; i < menu.length; i++)
   {
      printf("%d.%s\n", i + 1, menus[i].item);
   }
   printf("\nSelect an option (1-%d): ", menu.length);
   scanf("%d", &choice);
   printf("\n");

   if (choice >= 1 && choice <= menu.length)
   {
      int x[2];

      for (i = 0; i < 2; i++)
      {
         printf("Enter number %i: ", i + 1);
         scanf("%i", &x[i]);
      }

      printf("Result: %d \n", menus[choice - 1].op(x[0], x[1]));
   }
   else
   {
      printf("\nOut of menu.\n");
   }

   printf("\n");
   return 0;
}

/* Previews
  Math Menu:
  1.+
  2.-
  3.x
  4.%

  Select an option (1-4): 1

  Enter number 1: 1
  Enter number 2: 1
  Result: 2
*/
```


## 26-09-66

`asterisk.c`<br>
สร้าง: 26 ก.ย. 2566 เวลา 11:46<br>
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
สร้าง: 26 ก.ย. 2566 เวลา 11:46<br>
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
สร้าง: 26 ก.ย. 2566 เวลา 11:46<br>
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
สร้าง: 26 ก.ย. 2566 เวลา 11:46<br>
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


## 26-09-66/homework

`[merge].c`<br>
สร้าง: 28 ก.ย. 2566 เวลา 19:01<br>
```c
#include <stdio.h>

void left_top() {
   int x, i;

   for (x = 5; x >= 1; --x) {
      for (i = 1; i <= x; ++i) {
         printf("* ");
      }
      printf("\n");
   }

   printf("\n");
}

void right_top() {
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
}

void triangle() {
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
}

int main() {
   left_top();
   right_top();
   triangle();

   return 0;
}

```

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


## 29-08-66

`calculator.c`<br>
สร้าง: 29 ส.ค. 2566 เวลา 10:25<br>
อัปเดต: 5 ก.ย. 2566 เวลา 09:34<br>
```c
#include <stdio.h>

main()
{
    int y;
    int x;

    printf("Enter number: ");
    scanf("%d", &y);
    printf("Enter another number: ");
    scanf("%d", &x);
    printf("You entered %d and %d result = %d \n", y, x, y + x);
    return 0;
}

```


## Operations Sheet/10

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


## Operations Sheet/11

`1.c`<br>
สร้าง: 29 ก.ย. 2566 เวลา 22:56<br>
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
สร้าง: 29 ก.ย. 2566 เวลา 22:56<br>
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
สร้าง: 29 ก.ย. 2566 เวลา 22:56<br>
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
สร้าง: 26 ก.ย. 2566 เวลา 11:46<br>
อัปเดต: 29 ก.ย. 2566 เวลา 22:56<br>
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
สร้าง: 29 ก.ย. 2566 เวลา 22:56<br>
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


## Operations Sheet/12

`1.c`<br>
สร้าง: 29 ก.ย. 2566 เวลา 22:56<br>
```c
#include <stdio.h>

int main() {
   int num, sum = 0;

   printf("Enter a number: ");
   scanf("%d", &num);

   while (num != 0) {
      sum += num;
      printf("Enter a number: ");
      scanf("%d", &num);
   }

   printf("Sum is %d\n", sum);

   printf("\n");
   return 0;
}

```

`2.c`<br>
สร้าง: 29 ก.ย. 2566 เวลา 22:56<br>
```c
#include <stdio.h>

int main() {
   int num = 1;

   while (num <= 100) {
      if (num % 2 == 0 && num % 5 == 0) {
         printf("%d\n", num);
      }
      num++;
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
   int numStudents, i = 1;
   float total = 0.0, score;

   printf("Please enter the number of students: ");
   scanf("%d", &numStudents);

   while (i <= numStudents) {
      printf("Enter score student_%d: ", i);
      scanf("%f", &score);
      total += score;
      i++;
   }

   float average = total / numStudents;
   printf("Average Score is %.2f\n", average);

   printf("\n");
   return 0;
}

```

`4.c`<br>
สร้าง: 29 ก.ย. 2566 เวลา 22:56<br>
```c
#include <stdio.h>

int main() {
   int num, count = 0;
   float sum = 0;

   printf("Enter a number (0 to stop): ");
   scanf("%d", &num);

   while (num != 0) {
      sum += num;
      count++;
      printf("Enter a number (0 to stop): ");
      scanf("%d", &num);
   }

   if (count > 0) {
      float average = sum / count;
      printf("Sum is %.2f\n", sum);
      printf("Average is %.2f\n", average);
   } else {
      printf("No numbers entered.\n");
   }

   printf("\n");
   return 0;
}

```

`5.c`<br>
สร้าง: 29 ก.ย. 2566 เวลา 22:56<br>
```c
#include <stdio.h>

int main() {
   float total = 0, vat, grandTotal;
   int choice;

   printf("\tMENU\n");
   printf("1. French Fries\t25 Baht\n");
   printf("2. Fish Burger\t65 Baht\n");
   printf("3. Hamburger\t55 Baht\n");
   printf("4. Double Cheese\t109 Baht\n");
   printf("5. CocaCola\t15 Baht\n");
   printf("6. End\n");

   while (1) {
      printf("Enter MENU 1-6: ");
      scanf("%d", &choice);

      if (choice == 6) {
         break;
      }

      switch (choice) {
         case 1:
            total += 25;
            break;
         case 2:
            total += 65;
            break;
         case 3:
            total += 55;
            break;
         case 4:
            total += 109;
            break;
         case 5:
            total += 15;
            break;
         default:
            printf("Invalid choice.\n");
            break;
      }
   }

   vat = 0.07 * total;
   grandTotal = total + vat;

   printf("\nTotal\t= %.2f\n", total);
   printf("Vat 7%%\t= %.2f\n", vat);
   printf("Pay\t= %.2f\n", grandTotal);

   printf("\n");
   return 0;
}

```


## Operations Sheet/13

`1.c`<br>
สร้าง: 29 ก.ย. 2566 เวลา 22:56<br>
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
สร้าง: 29 ก.ย. 2566 เวลา 22:56<br>
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
สร้าง: 29 ก.ย. 2566 เวลา 22:56<br>
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
สร้าง: 29 ก.ย. 2566 เวลา 22:56<br>
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
สร้าง: 29 ก.ย. 2566 เวลา 22:56<br>
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


## Operations Sheet/7

`1.c`<br>
สร้าง: 29 ก.ย. 2566 เวลา 22:09<br>
```c
#include <stdio.h>

int main() {
   int number;

   printf("Please enter an integer: ");
   scanf("%d", &number);

   printf("You entered: %d\n", number);

   printf("\n");
   return 0;
}
```

`2.c`<br>
สร้าง: 29 ก.ย. 2566 เวลา 22:09<br>
```c
#include <stdio.h>

int main() {
   char firstName[50], lastName[50], gender;
   int age;
   float gpa;

   printf("Please enter your first name: ");
   scanf("%s", firstName);

   printf("Please enter your last name: ");
   scanf("%s", lastName);

   printf("Please enter your gender (M/F): ");
   scanf(" %c", &gender);

   printf("Please enter your age: ");
   scanf("%d", &age);

   printf("Please enter your GPA: ");
   scanf("%f", &gpa);

   printf("First Name: %s\n", firstName);
   printf("Last Name: %s\n", lastName);
   printf("Gender: %c\n", gender);
   printf("Age: %d years\n", age);
   printf("GPA: %.2f\n", gpa);

   printf("\n");
   return 0;
}
```

`3.c`<br>
สร้าง: 29 ก.ย. 2566 เวลา 22:09<br>
```c
#include <stdio.h>

int main() {
   int ageA, ageB, ageC;

   printf("Please enter the age of person A: ");
   scanf("%d", &ageA);

   printf("Please enter the age of person B: ");
   scanf("%d", &ageB);

   printf("Please enter the age of person C: ");
   scanf("%d", &ageC);

   int totalAge = ageA + ageB + ageC;

   printf("The total age of all three people is: %d years\n", totalAge);

   printf("\n");
   return 0;
}
```

`4.c`<br>
สร้าง: 29 ก.ย. 2566 เวลา 22:09<br>
```c
#include <stdio.h>

int main() {
   int num1, num2;

   printf("Please enter the first integer: ");
   scanf("%d", &num1);

   printf("Please enter the second integer: ");
   scanf("%d", &num2);

   int sum = num1 + num2;
   int difference = num1 - num2;
   int product = num1 * num2;
   float quotient = (float)num1 / num2;
   int remainder = num1 % num2;

   printf("Sum: %d\n", sum);
   printf("Difference: %d\n", difference);
   printf("Product: %d\n", product);
   printf("Quotient: %.2f\n", quotient);
   printf("Remainder: %d\n", remainder);

   printf("\n");
   return 0;
}
```

`5.c`<br>
สร้าง: 29 ก.ย. 2566 เวลา 22:09<br>
```c
#include <stdio.h>

int main() {
   float sideLength, area, perimeter;

   printf("Please enter the side length of the square (units): ");
   scanf("%f", &sideLength);

   area = sideLength * sideLength;
   perimeter = 4 * sideLength;

   printf("Area of the square: %.2f square units\n", area);
   printf("Perimeter of the square: %.2f units\n", perimeter);

   printf("\n");
   return 0;
}
```

`6.c`<br>
สร้าง: 29 ก.ย. 2566 เวลา 22:09<br>
```c
#include <stdio.h>

int main() {
   int birthYear, currentYear;

   printf("Please enter your birth year (B.E.): ");
   scanf("%d", &birthYear);

   printf("Please enter the current year (B.E.): ");
   scanf("%d", &currentYear);

   int age = currentYear - birthYear;

   printf("Your age is: %d years\n", age);

   printf("\n");
   return 0;
}

```

`7.c`<br>
สร้าง: 29 ก.ย. 2566 เวลา 22:09<br>
```c
#include <stdio.h>

int main() {
   int costPricePerLump = 36;
   float profitMarginPercentage = 20.0;
   float costPricePerItem = (float)costPricePerLump / 36;
   float sellingPricePerItem =
       costPricePerItem * (1 + profitMarginPercentage / 100);

   printf("Cost price per item: %.2f\n", costPricePerItem);
   printf("Selling price per item (with 20%% profit margin): %.2f\n",
          sellingPricePerItem);

   printf("\n");
   return 0;
}
```


## Operations Sheet/8

`4.c`<br>
สร้าง: 29 ก.ย. 2566 เวลา 22:09<br>
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
สร้าง: 29 ก.ย. 2566 เวลา 22:09<br>
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
สร้าง: 29 ก.ย. 2566 เวลา 22:09<br>
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


## Operations Sheet/9

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


## Section-1/14-09-66

`_1276.c`<br>
สร้าง: 14 ก.ย. 2566 เวลา 15:00<br>
แก้ไขล่าสุด: เวลา 16:41<br>

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

`1.5.c`<br>
สร้าง: 14 ก.ย. 2566 เวลา 15:00<br>
แก้ไขล่าสุด: เวลา 16:11<br>

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
สร้าง: 14 ก.ย. 2566 เวลา 15:00<br>
แก้ไขล่าสุด: เวลา 16:11<br>

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
สร้าง: 14 ก.ย. 2566 เวลา 16:11<br>
แก้ไขล่าสุด: เวลา 16:41<br>

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
สร้าง: 14 ก.ย. 2566 เวลา 16:11<br>
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
สร้าง: 14 ก.ย. 2566 เวลา 16:11<br>
แก้ไขล่าสุด: เวลา 16:41<br>

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


## Section-1/21-09-66/exam

`main.c`<br>
สร้าง: 21 ก.ย. 2566 เวลา 13:58<br>
แก้ไขล่าสุด: เวลา 14:27<br>

```c
#include <stdio.h>

void clearScreen()
{
#ifdef _WIN32
   system("cls");
#else
   system("clear");
#endif
}

int main()
{
   int num, max = 0;
   char input;

   do
   {
      clearScreen();

      printf("Enter a number: ");
      scanf("%d", &num);

      if (num > max)
         max = num;

      printf("Enter another number ? (y/n): ");
      scanf(" %c", &input);

   } while (input == 'y' || input == 'Y');

   printf("Maximum number is %d\n", max);

   printf("\n");
   return 0;
}

/* Previews
  # take 1
  Enter a number: 10

  # take 2
  Enter a number: 50

  # take 3
  Enter a number: 30

  # end
  Enter another number ? (y/n): n
  Maximum number is 50
*/
```

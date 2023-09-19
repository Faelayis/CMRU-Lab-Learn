`main.c`<br>
สร้าง: 19 ก.ย. 2566 เวลา 10:54<br>
แก้ไขล่าสุด: เวลา 11:01<br>

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

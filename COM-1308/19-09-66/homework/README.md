`main.c`<br>
Create: 19 ก.ย. 2566 เวลา 21:29<br>
Update: 26 ก.ย. 2566 เวลา 09:36<br>
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

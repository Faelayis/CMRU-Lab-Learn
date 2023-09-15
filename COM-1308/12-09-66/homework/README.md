`main.c`<br>

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

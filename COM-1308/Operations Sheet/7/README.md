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

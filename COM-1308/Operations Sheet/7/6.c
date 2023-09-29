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

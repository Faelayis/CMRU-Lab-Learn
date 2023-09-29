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
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
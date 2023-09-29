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

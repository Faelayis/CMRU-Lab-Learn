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

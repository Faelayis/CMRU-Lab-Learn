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

#include <stdio.h>

int main() {
   char character;

   printf("Enter a character: ");
   scanf(" %c", &character);

   if (character >= 'A' && character <= 'Z') {
      printf("Uppercase: %c\n", character);
      printf("Lowercase: %c\n", character + 32);
   } else if (character >= 'a' && character <= 'z') {
      printf("Uppercase: %c\n", character - 32);
      printf("Lowercase: %c\n", character);
   } else {
      printf("Not a valid alphabet character.\n");
   }

   printf("\n");
   return 0;
}

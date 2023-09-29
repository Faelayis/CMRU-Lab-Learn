#include <stdio.h>

int main() {
   char letter;
   printf("Enter your letter: ");
   scanf(" %c", &letter);

   switch (letter) {
      case 'A':
      case 'E':
      case 'I':
      case 'O':
      case 'U':
      case 'a':
      case 'e':
      case 'i':
      case 'o':
      case 'u':
         printf("%c is a vowel\n", letter);
         break;
      default:
         printf("%c is a consonant\n", letter);
   }

   printf("\n");
   return 0;
}

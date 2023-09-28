#include <stdio.h>

void left_top() {
   int x, i;

   for (x = 5; x >= 1; --x) {
      for (i = 1; i <= x; ++i) {
         printf("* ");
      }
      printf("\n");
   }

   printf("\n");
}

void right_top() {
   int x, i;

   for (x = 1; x <= 5; ++x) {
      for (i = 1; i < x; ++i) {
         printf("  ");
      }
      for (i = x; i <= 5; ++i) {
         printf("* ");
      }
      printf("\n");
   }

   printf("\n");
}

void triangle() {
   int x, i;

   for (x = 1; x <= 5; ++x) {
      for (i = 1; i <= 5 - x; ++i) {
         printf(" ");
      }

      for (i = 1; i <= x; ++i) {
         printf("* ");
      }
      printf("\n");
   }

   printf("\n");
}

int main() {
   left_top();
   right_top();
   triangle();

   return 0;
}

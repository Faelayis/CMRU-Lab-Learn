#include <stdio.h>

int main() {
   float weight, height, bmi;

   printf("Enter weight (kg): ");
   scanf("%f", &weight);
   printf("Enter height (m): ");
   scanf("%f", &height);

   bmi = weight / (height * height);

   printf("BMI: %.2f\n", bmi);

   switch ((int)bmi) {
      case 0 ... 15:
         printf("Severe Thinness\n");
         break;
      case 16 ... 16:
         printf("Moderate Thinness\n");
         break;
      case 17 ... 18:
         printf("Mild Thinness\n");
         break;
      case 19 ... 24:
         printf("Normal\n");
         break;
      case 25 ... 29:
         printf("Overweight\n");
         break;
      case 30 ... 34:
         printf("Obese Class I\n");
         break;
      case 35 ... 39:
         printf("Obese Class II\n");
         break;
      default:
         printf("Obese Class III\n");
   }

   printf("\n");
   return 0;
}

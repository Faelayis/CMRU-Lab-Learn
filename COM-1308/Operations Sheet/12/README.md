`1.c`<br>
Create: 29 ก.ย. 2566 time 22:56<br>
```c
#include <stdio.h>

int main() {
   int num, sum = 0;

   printf("Enter a number: ");
   scanf("%d", &num);

   while (num != 0) {
      sum += num;
      printf("Enter a number: ");
      scanf("%d", &num);
   }

   printf("Sum is %d\n", sum);

   printf("\n");
   return 0;
}

```
`2.c`<br>
Create: 29 ก.ย. 2566 time 22:56<br>
```c
#include <stdio.h>

int main() {
   int num = 1;

   while (num <= 100) {
      if (num % 2 == 0 && num % 5 == 0) {
         printf("%d\n", num);
      }
      num++;
   }

   printf("\n");
   return 0;
}

```
`3.c`<br>
Create: 29 ก.ย. 2566 time 22:56<br>
```c
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

```
`4.c`<br>
Create: 29 ก.ย. 2566 time 22:56<br>
```c
#include <stdio.h>

int main() {
   int num, count = 0;
   float sum = 0;

   printf("Enter a number (0 to stop): ");
   scanf("%d", &num);

   while (num != 0) {
      sum += num;
      count++;
      printf("Enter a number (0 to stop): ");
      scanf("%d", &num);
   }

   if (count > 0) {
      float average = sum / count;
      printf("Sum is %.2f\n", sum);
      printf("Average is %.2f\n", average);
   } else {
      printf("No numbers entered.\n");
   }

   printf("\n");
   return 0;
}

```
`5.c`<br>
Create: 29 ก.ย. 2566 time 22:56<br>
```c
#include <stdio.h>

int main() {
   float total = 0, vat, grandTotal;
   int choice;

   printf("\tMENU\n");
   printf("1. French Fries\t25 Baht\n");
   printf("2. Fish Burger\t65 Baht\n");
   printf("3. Hamburger\t55 Baht\n");
   printf("4. Double Cheese\t109 Baht\n");
   printf("5. CocaCola\t15 Baht\n");
   printf("6. End\n");

   while (1) {
      printf("Enter MENU 1-6: ");
      scanf("%d", &choice);

      if (choice == 6) {
         break;
      }

      switch (choice) {
         case 1:
            total += 25;
            break;
         case 2:
            total += 65;
            break;
         case 3:
            total += 55;
            break;
         case 4:
            total += 109;
            break;
         case 5:
            total += 15;
            break;
         default:
            printf("Invalid choice.\n");
            break;
      }
   }

   vat = 0.07 * total;
   grandTotal = total + vat;

   printf("\nTotal\t= %.2f\n", total);
   printf("Vat 7%%\t= %.2f\n", vat);
   printf("Pay\t= %.2f\n", grandTotal);

   printf("\n");
   return 0;
}

```

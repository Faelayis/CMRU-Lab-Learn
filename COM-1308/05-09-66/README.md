`computer-with-tabs.c`
```c 
#include <stdio.h>

int main()
{
   char ch = 'A', str[] = "computer";

   printf("%3c", ch);
   printf("%15.8s ", str);
   printf("%-15.8s ", str);

   printf("\n");
   return 0;

   // output:  A       computer computer
}

```
`computer.c`
```c 
#include <stdio.h>

int main()
{
   char ch = 'A', str[] = "computer";

   printf("%c ", ch);
   printf("%d ", ch);
   printf("%s ", str);
   printf("%3s ", str);

   printf("\n");
   return 0;

   // output: A 65 computer computer
}

```
`getch.c`
```c 
#include <stdio.h>

int main()
{
   char text;

   printf("input: ");
   text = getchar();

   printf("\noutput: ");
   putchar(text);

   printf("\n");
   return 0;

   // input: wasd & enter
   // output: w
}

```
`getchar.c`
```c 
#include <stdio.h>

int main()
{
   char text;

   printf("input: ");
   text = getch();

   printf("\noutput: ");
   putchar(text);

   printf("\n");
   return 0;

   // input: wasd
   // output: w
}

```
`test.c`
```c 
#include <stdio.h>

int main()
{
   int a = 12, b = 20;

   printf("%10d%5d ", a, b);

   printf("\n");
   return 0;

   // output:        12   20
}

```
`the-sum-is.c`
```c 
#include <stdio.h>

int main()
{
   int sum = 68;

   printf("The Sum is = %c ", sum);

   printf("\n");
   return 0;

   // output: The Sum is = D
}

```

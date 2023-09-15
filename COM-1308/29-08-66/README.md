`calculator.c`<br>
สร้าง: 15 ก.ย. 2566 21:23<br>

```c 
#include <stdio.h>

main()
{
    int y;
    int x;

    printf("Enter number: ");
    scanf("%d", &y);
    printf("Enter another number: ");
    scanf("%d", &x);
    printf("You entered %d and %d result = %d \n", y, x, y + x);
    return 0;
}

```

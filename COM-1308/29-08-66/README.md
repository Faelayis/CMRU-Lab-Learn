`calculator.c`<br>
Create: 29 ส.ค. 2566 time 10:25<br>
Update: 5 ก.ย. 2566 time 09:34<br>
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

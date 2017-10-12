#include <stdio.h>
#include <stdlib.h>

int main (void) {

    int number;
    do {
        printf("Enter a number greater than 0: ");
        scanf("%i", &number);
        if (number <= 0)
            return(EXIT_SUCCESS);
        int i;
        for (i = 0; i <= number; i++)
        printf("%i\n", i);
    } while (1);

}

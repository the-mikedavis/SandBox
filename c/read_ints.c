#include <stdio.h>
#include <stdlib.h>

int main(void) {

    int n;

    printf("How many integers: ");
    scanf("%i", &n);
    int input[n];

    for (int i = 0; i < n; i++)
        scanf("%d", &(input[i]));

    printf("The array is: [");
    for (int i = 0; i < n; i++)
        printf("%i,", input[i]);

    printf("]\n");

}

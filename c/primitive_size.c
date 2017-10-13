# include <stdio.h>

int main (void) {
    printf("A long uses %lu byte(s) of memory\n", sizeof(long));
    printf("An int uses %lu byte(s) of memory\n", sizeof(int));
    printf("A float uses %lu byte(s) of memory\n", sizeof(float));
    printf("A double uses %lu byte(s) of memory\n", sizeof(double));
    printf("A char uses %lu byte(s) of memory\n", sizeof(char));
    return 0;
}

#include <stdio.h>
#include <stdlib.h>

#define MAX(A, B) (((A) > (B)) ? (A) : (B))

int* revenues(int* p, int n);
void print(int* a, int n);

int main(void) {
    //int p[] = {2, 6, 11, 10, 12, 24, 23, 25, 33};
    int p[] = {1, 5, 8, 9, 10};
    int* r = revenues(p, 5);;
    print(r, 5);
}

int* revenues(int* p, int n) {
    int* r = malloc(sizeof(int) * n);
    r[0] = 0;
    int j = 1;
    for (; j < n; j++) {
        int q = -100;
        int i = 1;
        for (; i <= j; i++)
            q = MAX(q, p[i] + r[j - i]);
        r[j] = q;
    }
    return r;
}

void print(int* a, int n) {
    printf("[");
    int i = 0;
    for (; i < n; i++)
        printf("%d,", a[i]);
    printf("]\n");
}

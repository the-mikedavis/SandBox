#include <iostream>

void changeX (int &a) {
    a -= 5;
}

void changePtr (int *a) {
    *a += 3;
}

void changeY (int a) {
    a++;
}

int main() {
    int x = 5;

    std::cout << "X is starting at " << x << std::endl;

    changeX(x);
    std::cout << "X after the & change: " << x << std::endl;

    changePtr(&x);
    std::cout << "X after the * change: " << x << std::endl;

    changeY(x);
    std::cout << "X after the regular change: " << x << std::endl;

    return 0;
}

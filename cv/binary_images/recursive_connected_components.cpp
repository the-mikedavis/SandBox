#include <iostream>
#include <vector>

#define ROWS 8
#define COLS 8

typedef int image[ROWS][COLS];

typedef struct {
    int row;
    int col;
} neighbor;

void negate(image img);
void find_components(image img);
void search(image img, int label, int row, int col);
std::vector< neighbor > neighbors(int row, int col);
void input_image(image img);
void print_image(image img);

int main(void) {
    image img;
    input_image(img);
    negate(img);
    find_components(img);
    print_image(img);
    return 0;
}

// turn all 1's into negative 1's without branching
void negate(image img) {
    int i;
    int j;
    for (i = 0; i < ROWS; i++)
        for (j = 0; j < COLS; j++)
            img[i][j] = 0 - img[i][j];
}

void find_components(image img) {
    int label = 0;
    int i;
    int j;
    for (i = 0; i < ROWS; i++)
        for (j = 0; j < COLS; j++)
            if (img[i][j] == -1)
                search(img, ++label, i, j);
}

void search(image img, int label, int row, int col) {
    img[row][col] = label;
    std::vector<neighbor> n_set = neighbors(row, col);
    for (neighbor n : n_set)
        if (img[n.row][n.col] == -1)
            search(img, label, n.row, n.col);
}

std::vector< neighbor > neighbors(int row, int col) {
    neighbor left;
    left.row = row - 1;     left.col = col;

    neighbor right;
    right.row = row + 1;    right.col = col;

    neighbor up;
    up.row = row;           up.col = col - 1;

    neighbor down;
    down.row = row;         down.col = col + 1;

    std::vector<neighbor> neighbors;
    if (row > 0)
        neighbors.push_back(left);
    if (row < ROWS - 1)
        neighbors.push_back(right);
    if (col > 0)
        neighbors.push_back(up);
    if (col < COLS - 1)
        neighbors.push_back(down);

    return neighbors;
}

void input_image(image img) {
    std::string inputLine;
    int i;
    int line = 0;
    while (getline(std::cin, inputLine)) {
        for (i = 0; i < COLS; i++)
            img[line][i] = inputLine[i] - '0';
        line++;
    }
}

void print_image(image img) {
    int i;
    int j;
    for (i = 0; i < ROWS; i++) {
        for (j = 0; j < COLS; j++) {
            std::cout << img[i][j];
        }
        std::cout << "\n";
    }
}

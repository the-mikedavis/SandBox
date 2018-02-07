/* Counting four-connected objects in a binary image using masks. */
#include <stdlib.h>
#include <stdio.h>

// dimensions of input matrix
#define ROW 16
#define COL 16

// external masks
const int EMS[4][4] = { {0,0,0,1}, {0,0,1,0}, {0,1,0,0}, {1,0,0,0} };
// internal masks
const int IMS[4][4] = { {1,1,1,0}, {1,1,0,1}, {1,0,1,1}, {0,1,1,1} };

// enable booleans
typedef int bool;
#define true 1
#define false 0

bool external_match (int img[ROW][COL], int row, int col) {
    int i;
    for (i = 0; i < 4; i++) {
        if (img[row][col] == EMS[i][0] &&
                img[row][col + 1] == EMS[i][1] &&
                img[row + 1][col] == EMS[i][2] &&
                img[row + 1][col + 1] == EMS[i][3])
            return true;
    }
    return false;
}

bool internal_match (int img[ROW][COL], int row, int col) {
    int i;
    for (i = 0; i < 4; i++) {
        if (img[row][col] == IMS[i][0] &&
                img[row][col + 1] == IMS[i][1] &&
                img[row + 1][col] == IMS[i][2] &&
                img[row + 1][col + 1] == IMS[i][3])
            return true;
    }
    return false;
}

int count_objects (int img[ROW][COL]) {
    int e = 0;
    int i = 0;
    int l;
    int p;
    for (l = 0; l < ROW - 1; l++) {
        for (p = 0; p < COL - 1; p++) {
            if (external_match(img, l, p)) e++;
            if (internal_match(img, l, p)) i++;
        }
    }
    return((e - i) / 4);
}

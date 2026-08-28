#include <stdio.h>
//Sawp function swaps values because the function receives address not the values using method pass by referance
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

//broken swap Function fails to copy the values beacuse it  receives copies method pass by value 
void broken_swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
}

int main() {
    int x = 10;
    int y = 20;
    printf("Broken Swap Function Results\n");
    printf("Before broken_swap: x = %d, y = %d\n", x, y);
    broken_swap(x, y);
    printf("After broken_swap:  x = %d, y = %d \n\n\n\n", x, y);
    printf("Swap Function Results\n");
    printf("Before swap values: x = %d, y = %d\n", x, y);
    swap(&x, &y);
    printf("After swap values:  x = %d, y = %d\n", x, y);

    return 0;
}


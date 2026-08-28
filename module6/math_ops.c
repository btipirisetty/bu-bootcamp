#include <stdio.h> 
 
int add(int a, int b);
int div(int a, int b);
void print_result(int sum, int product, int div); 
 
int main() { 
    int x, y;
    printf("Enter first number: ");
    scanf("%d", &x);
    printf("Enter second number: ");
    scanf("%d", &y);
    if (y == 0) {
        printf("Error: Division by zero is not allowed.\n");
        return 1;
    }
    int s = add(x, y); 
    int d = div(x, y); 
    print_result(s, x * y, d); 
    return 0;
} 
 
int add(int a, int b) { 
    return a + b; 
} 

int div(int a, int b) { 
    return a / b; 
} 

void print_result(int sum, int product, int div) { 
    printf("\n--- Results ---\n");
    printf("Sum: %d\n", sum); 
    printf("Product: %d\n", product);
    printf("Division: %d\n", div);
}
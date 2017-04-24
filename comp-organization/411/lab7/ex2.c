#include <stdio.h>

int a_to_i(char* str);
int factorial(int n);
int main(int argc, char *argv[])
{
    int sentinel = 1;
    int returnVal = 0;
    while(sentinel != 0){
        char* temp;
        fgets(temp, 20, stdin);
        sentinel = a_to_i(temp);
        returnVal = factorial(sentinel);
        printf("%d\n", returnVal);
    }
    return 0;
}
int a_to_i(char* str){
    int i, count;
    count = 0;
    while((*str >= '0') && (*str <= '9')){
        count = count * 10 + (*str - '0');
        str++;
    }
    return count;
}
int factorial(int n){
    int i;
    int fact = 1;
    for(i = n; i > 1; i--){
        fact = fact * i;
    }
    return fact;
}

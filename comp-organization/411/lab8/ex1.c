#include <stdio.h>

int factorial(int n);
int main(int argc, char *argv[])
{
    int sentinel, n;
    char* str;
    fgets(str, 20, stdin);
    n = str.atoi()

    return 0;
}
int factorial(int n){
    if(n == 1 || n == 0) return 1;
    else return n * factorial(n -1);
}

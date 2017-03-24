#include <stdio.h>

int a_to_i(char* str);
int main(int argc, char *argv[])
{
    int returnVal = 1;
    while(returnVal != 0){
        char* temp;
        fgets(temp, 20, stdin);
        returnVal = a_to_i(temp);
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

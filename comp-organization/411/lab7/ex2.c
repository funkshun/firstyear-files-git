#include <stdio.h> 

int average(int red, int green, int blue, int max);
int main(int argc, char *argv[]){
    int i, j, val, max, height, width, x1, y1, x2, y2;
    char magic[3];
    scanf("%d%d%d%d", &x1, &x2, &y1, &y2);
    scanf("%d%d", &width, &height);
    scanf("%d", &max);
    printf("P2\n%d\n%d\n%d\n", ((x2 - x1)+1), ((y2 - y1)+1), max);
    for(i = 0; i < height; i++){
        for(j = 0; j < width; j++){
            scanf("%d", &val);
            if(i >= x1 && i <= x2 && j >= y1 && j <= y2){
                printf("%d\n", val);
            }
        }
    }
    return 0;
}

int average(int red, int green, int blue, int max){
    return ((red * 30 + green * 59 + blue * 11) * 255) / (100 * max);
}

#include <stdio.h> 

int average(int red, int green, int blue, int max);
int main(int argc, char *argv[]){
    int i, r, g, b, max, height, width;
    char magic[3];
    scanf("%s", &magic);
    scanf("%d%d%d", &width, &height, &max);
    //scanf("%d", &max);
    printf("P2\n%d\n%d\n%d\n", width, height, 255);
    for(i = 0; i < width * height; i++){
        scanf("%d%d%d", &r, &g, &b);
        printf("%d\n", average(r, g, b, max));
    }
    return 0;
}

int average(int red, int green, int blue, int max){
    return ((red * 30 + green * 59 + blue * 11) * 255) / (100 * max);
}

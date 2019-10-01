#include<stdio.h>

//Rotate an array 90 degrees without using any extra auxilary space

int main(){
    int n;
    scanf("%d",&n);
    int arr[n][n];
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            scanf("%d",&arr[i][j]);
        }
    }
    for(int i=0;i<n/2;i++){
        for(int j=i;j<n-i-1;j++){
            int temp = arr[i][j];
            arr[i][j] = arr[n-j-1][i];
            arr[n-j-1][i] = arr[n-i-1][n-j-1];
            arr[n-i-1][n-j-1] = arr[j][n-i-1];
            arr[j][n-i-1] = temp;
        }
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            printf("%d ",arr[i][j]);
        }
        printf("\n");
    }
}
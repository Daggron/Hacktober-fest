#include<stdio.h>

//Fill a 2D array in spiral order

int main(){
    int n,count=1;
    scanf("%d",&n);
    int **arr=(int**)malloc(sizeof(int*)*n);
    for(int i=0;i<n;i++){
        arr[i] = (int*)malloc(sizeof(int)*n);
    }
    int top=0, right=n-1, bottom=n-1, left=0;
    while(top<=bottom && left<=right){
        for(int i=left;i<=right;i++)
            arr[top][i] = count++;
        top++;
        for(int i=top;i<=bottom;i++)
            arr[i][right] = count++;
        right--;
        for(int i=right;i>=left;i--)
            arr[bottom][i] = count++;
        bottom--;
        for(int i=bottom;i>=top;i--)
            arr[i][left] = count++;
        left++;
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            printf("%d ",arr[i][j]);
        }
        printf("\n");
    }
}
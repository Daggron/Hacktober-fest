#include<stdio.h>
#include<stdlib.h>
int main(){
  int n;
  scanf("%d",&n);
  int count = 1;
  int *arr = (int *)malloc(sizeof(int)*n);
  int *arra = (int *)malloc(sizeof(int)*n);
  for(int i=0;i<n;i++){
    scanf("%d", &arr[i]);
  }

  for(int i=0;i<n;i++){

    int flag = 0;
    count = 1;

    for(int j=i+1;j<n;j++){

      if(arr[j-1]>0){
        if(arr[j]<0){
          flag = 0;
          count++;
        }
        else{
          break;
        }
      }
      else if(arr[j-1]<0){
        if(arr[j]>0){
          flag = 0;
          count++;
        }
        else{
          break;
        }
      }
    }

    arra[i]=count;



  }

  for(int i=0;i<n;i++){
    printf("%d\n",arra[i]);
  }

}

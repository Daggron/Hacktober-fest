#include<stdio.h>
#include<string.h>
#include<stdlib.h>
int main(){
  char *a = (char*) malloc(sizeof(char)*60);
  gets(a);
  int len = strlen(a)-1;
  int temp_data = len;

  int start  = 0;

  while(start<temp_data)
  {
    if(a[start]==a[temp_data]){
      start++;
      temp_data--;
    }
    else{
      start  = 0;
      temp_data=--len;
    }
  }

  printf("%d\n",(strlen(a)-(len+1)) ) ;

}

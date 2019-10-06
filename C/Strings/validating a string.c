#include <stdio.h>
#include <stdlib.h>

int main()
{
    char a[1000];
    int i;
    scanf("%[^\n]s",a);
int   flag = 0;
    for(i=0;a[i]!='\0';i++){
        if((a[i]>=65 && a[i] <=90) || (a[i] >=90 && a[i]<=122) || (a[i]>=48 && a[i]<=57)){

        }else{
            flag = 1;
        }
    }
    if(flag == 1){
        printf("this is not a good number");
    }else{
       printf("this is a good number");
    }
}

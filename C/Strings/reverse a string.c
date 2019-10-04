#include <stdio.h>
#include <stdlib.h>

int main()
{
    char a[100];
    int i;

    scanf("%s",a);

    for(i=0;a[i]!='\0';i++){

    }
  i = i-1;s
    int j,temp;
    for(j=0;j<i;i--,j++){
       temp = a[j];
       a[j] = a[i];
       a[i] = temp;
    }

    printf("%s",a);

}

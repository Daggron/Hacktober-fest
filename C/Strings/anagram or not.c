#include <stdio.h>

int check_anagram(char [], char []);

int main()
{
  char a[100],b[100];
  scanf("%[^\n]s",&a);
  scanf(" %[^\n]s",&b);

  int k = strlen(a);
  int l = strlen(b);
  int temp;

  if(k !=l){
    printf("not anagram");
  }else{
  int i,j;

  for(i=0;i<k;i++){
    for(j=0;j<k;j++){
        if(a[j] < a[i]){
            temp = a[j];
            a[j] = a[i];
            a[i] = temp;
        }
        if(b[j] <b[i]){
            temp = b[j];
            b[j] = b[i];
            b[i] = temp;
        }
    }
  }
  if(strcmp(a) == strcmp(b)){
    printf("yes");
  }else{
   printf("no");
  }
  }


}

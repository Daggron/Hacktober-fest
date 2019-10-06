#include <stdio.h>
#include <stdlib.h>

int main()
{
   char a[1000];
   scanf("%[^\n]s",a);

   int i,vowels=0,c=0,w=0;
   for(i=0;a[i]!='\0';i++){
    if(a[i] == 'a' || a[i] == 'e' ||a[i] =='i' ||a[i] == 'o' || a[i] == 'u'||
       a[i] == 'A' || a[i] == 'E' || a[i] == 'I' || a[i] == 'O'|| a[i] == 'U'){
        vowels++;
    }
    else if( (a[i] >= 65 && a[i] <=90) || (a[i] >=97 && a[i]<=122) ){
        c++;
    }
    else if(a[i] == ' ' && a[i-1] != ' '){
        w++;
    }
   }


   printf("consonents %d\nvowels %d\nword %d",c ,vowels,w+1);
}

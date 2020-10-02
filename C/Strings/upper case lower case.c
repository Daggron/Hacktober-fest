#include <stdio.h>
#include <stdlib.h>

int main()
{
   int i;
   char s[100];
   scanf("%s",s);

   for(i=0;s[i] != '\0';i++){
      // comparing ascii values for upper and lower case
    if(s[i]>=65 && s[i] <=90){
        s[i] = s[i]+32;
    }else if(s[i] >= 97 && s[i] <=122){
       s[i] = s[i] -32;
    }
   }

   printf("%s",s);
}

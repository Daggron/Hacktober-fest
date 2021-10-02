#include<bits/stdc++.h>
using namespace std;

string conversion(int num){

  int number[] = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
  string roman[] = {"I" ,"IV","V" , "IX", "X" , "XL" , "L" ,"XC" , "C" , "CD", "D" , "CM" ,"M"};

  int i =12;
  string res;

  while(num>0){
    int div = num / number[i];
    num = num % number[i];

    while(div--){
      res+=roman[i];
    }
    i--;
  }

  return res;
}


int main(){
    int number;
    printf("Enter The number you want to convert\n");
    printf("commit3");
    scanf("%d",&number);
    string a = conversion(number);
    cout<<a;
}

/*
Write a function binaryToDecimal that accepts an integer parameter whose digits are meant to represent binary (base-2) digits,
 and returns an integer of that number's representation in decimal (base-10).
 For example, the call of binaryToDecimal(101011) should return 43.
 */

#include <math.h>
#include <stdio.h>

int binaryToDecimal(int n)
{
  int d=0, i=0,r=0;
  while(n!=0)
  {
    r=n%10;
    n=n/10;
    d=d+r*pow(2,i);
    i++;
  }
  return d;
}

int main()
{
    int n;
    scanf("%d",&n);
    printf("%d",binaryToDecimal(n));
    return 0;
}
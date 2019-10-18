/*
Given an array of integers, find the minimum number of rotations performed on some sorted array to create this given array.
*/

#include <stdio.h>

int rotationCount(int a[], int size)
{
  int i,j,t=0,m=0;
  for(i=0;i<size;i++)
  {
    for(j=i;j<size;j++)
    {
      if(a[i]>a[j])
      {
        m++;
      break;
      }
    }
  }
  if(m==0)
    return -1;
  else
    return m;
  
  
}
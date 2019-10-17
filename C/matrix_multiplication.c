/*
Given two matrices A and B in the form of two dimensional arrays, find the dot product of these two matrices.
First line of input will contain an integer T = no. of test cases. Each test case will follow in multiple lines. 
First line of each test case will contain two integers R1 = no. of rows in matrix A and C1 = no. of columns in matrix A. 
Next R1 lines will each contain C1 space separated integers. 
Next line again contain two integers R2 = no. of rows in B and C2 = no. columns in B. C1 will be equal to R2. 1 <= R1,R2,C1,C2 <= 50
For each test case print matrix of size R1*C2 in R1 lines with each line containing C2 space separated integers of corresponding row.
*/

#include <stdio.h>

int main()
{
  int t,i,j,k,r1,c1,r2,c2;
  scanf("%d",&t);                           //scan no. of test cases
  for(k=0;k<t;k++)
  {
    
    scanf("%d %d",&r1,&c1);
    int a[r1][c1];
    for(i=0;i<r1;i++)
    {
      for(j=0;j<c1;j++)
      {
        scanf("%d",&a[i][j]);
      }
    }
    scanf("%d %d",&r2,&c2);
    int b[r2][c2];
    int m[50][50];
    for(i=0;i<r2;i++)
    {
      for(j=0;j<c2;j++)
      {
        scanf("%d",&b[i][j]);
      }
    }
    
      for(i=0;i<r1;i++)
      {
        for(j=0;j<c2;j++)
        {
          for(int d=0;d<c1;d++)
          m[i][j] = m[i][j] + (a[i][d])*(b[d][j]);
        }
      }
    
    for(i=0;i<r1;i++)
    {
      for(j=0;j<c2;j++)
      {
        printf("%d ",m[i][j]);
      }
      printf("\n");
    }
    
    for(i=0;i<r1;i++)
    {
      for(j=0;j<c2;j++)
      {
        m[i][j]=0;
      }
    }
  }
    return 0;
}
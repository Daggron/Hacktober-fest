#include<iostream>
using namespace std;
class matrix
{
int a[4][4],b[4][4],i,j,x,y;
public:
void getvalues();
void displaysum();
};
void matrix::getvalues()
{
cin>>x>>y;

cout<<"Enter values for the matrix A";
for(i=0;i<x;i++)
for(j=0;j<y;j++)
cin>>a[i][j];
cout<<"Enter the values for matrix b";
for(i=0;i<x;i++)
for(j=0;j<y;j++)
cin>>b[i][j];
}
void matrix::displaysum()
{
cout<<"The sum of matrix A and B is";
for(i=0;i<x;i++)
{
for(j=0;j<y;j++)
cout<<a[i][j]+b[i][j];
}
}
int main()
{
matrix m;
m.getvalues();
m.displaysum();
}

#include<iostream>
using namespace std;
class A
{
    int m3[10][10],m1[10][10],m2[10][10],m,n,i,j;
    public:
    void scan1()
    {
    cin>>m>>n;
        for (int i=0;i<=n;i++)
        {
            for (int j=0;j<=m;j++)
            {
                cin>>m3[i][j];
            }
        }
    }
    void scan()
    {
    cin>>n>>m;
        for (int i=0;i<=n;i++)
        {
            for (int j=0;j<=m;j++)
            {
                cin>>m1[i][j];
            }
        }
    }
    void add()
    {        int m,n;
    cin>>n>>m;
        for (int i=0;i<=n;i++)
        {
            for (int j=0;j<=m;j++)
            {
                m2[i][j]=m1[i][j]+m3[i][j];
            }
        }
    }
    void display()
    {
        cout<<m2[i][j];
    }
};

main()
{
    A a1;
    void scan1();
    void scan();
    void add();
    void display();
}

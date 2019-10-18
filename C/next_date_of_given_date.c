/*
Given a date with three elements date, month & year, your task is to print the next date of it.
The first line of input contains an integer T denoting the no of test cases. Each test case will contain a date in format '{date} {month} {year}'.
For each test case, print the next date in DD-MM-YYYY format on new lines.
*/

#include <stdio.h>

int main()
{
  int i,j,k,t,date,month,year;
  scanf("%d",&t);
  for(k=0;k<t;k++)
  {
    
    struct tareek
    {
      int date,month,year;
    }d;
    
    scanf("%d",&d.date);
    scanf("%d",&d.month);
    scanf("%d",&d.year);
    
    date=d.date+1;
    month=d.month;
    year=d.year;
    if(d.month==1 || d.month==3 || d.month==5 || d.month==7 || d.month==8 || d.month==10 || d.month==12)
    {
      if(date==32)
      {
        date=1;
        month=d.month+1;
      }
    }
    else if(d.month==4 || d.month==6 || d.month==9 || d.month==11)
    {
      if(date==31)
      {
        date=1;
        month=d.month+1;
      }
    }
    else if(d.month==2)
    {
      if(date==30 && d.year%4==0 && d.year%100!=0)
      {
        date=1;
        month=d.month+1;
      }
      else if(date==29  && d.year%100==0 )
      {
        date=1;
        month=d.month+1;
      }
    }
    if(month==13)
    {
      month=1;
      year=d.year+1;
    }
    
    if(month/10==1 && date/10>=1)
    printf("%d-%d-%d\n",date,month,year);
    else if(month/10==0 && date/10>=1)
    printf("%d-0%d-%d\n",date,month,year);
    else if(month/10==0 && date/10==0)
    printf("0%d-0%d-%d\n",date,month,year);
    else if(month/10==1 && date/10==0)
    printf("0%d-%d-%d\n",date,month,year);
      
  }
    return 0;
}






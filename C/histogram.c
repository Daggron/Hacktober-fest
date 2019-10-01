/*program to find maximum largest area in histogram
input-
6   //sizeof array
2 1 5 6 2 3  //element of array

output-
10
*/

#include<stdlib.h>
#include<stdio.h>
struct stack1
 {
     int data;
     struct stack1 *next;
 };
 typedef struct stack1 stack;
 void push(stack **s,int data)
 {
     stack *new1=(stack *)malloc(sizeof(stack));
    new1->data=data;
    new1->next=(*s);
    (*s)=new1;   
 }
 void pop(stack **s)
 {
     (*s)=(*s)->next;
 }
 int poll(stack **s)
 {
     int d=(*s)->data;
     (*s)=(*s)->next;
     return d;
 }
 int top(stack **s)
 {
     return (*s)->data;
 } 
 int empty(stack **s)
 {
     if(*s==NULL)
        return 1;
    return 0;
 }
int largestRectangleArea(int* hist, int n) {
    stack *s=(stack *)malloc(sizeof(stack)); 
    int max_area = 0; 
    int tp;
    int area_with_top; 
    int i = 0; 
    while (i < n) 
    { 
        if (empty(&s) || hist[top(&s)] <= hist[i]) 
            push(&s,i++); 
        else
        { 
            tp = top(&s); 
            pop(&s);
            area_with_top = hist[tp] * (empty(&s) ? i : i - top(&s) - 1); 
            if (max_area < area_with_top) 
                max_area = area_with_top; 
        } 
    } 
    while (empty(&s) == 0) 
    { 
        tp = top(&s); 
        pop(&s); 
        area_with_top = hist[tp] * (empty(&s) ? i : i - top(&s) - 1); 

        if (max_area < area_with_top) 
            max_area = area_with_top; 
    } 
    return max_area; 
}
int main()
{
    int n;
    scanf("%d",&n);
    int a[n];
    for(int i=0;i<n;i++)
        scanf("%d",&a[i]);
    printf("this is ans %d",largestRectangleArea(a,n));
}

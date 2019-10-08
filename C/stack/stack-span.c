#include<stdio.h>
#include<stdlib.h>

struct node{
  int data;
  struct node* next;

};

struct node * head = NULL;

void insert(int data){
  struct node * new_node = (struct node *)malloc(sizeof(struct node));
  new_node->data = data;
  new_node->next = head;
  head = new_node;
}

void pop(){
  head = head->next;
}

int top(){
  return (head->data);
}

void stockspan(int *a, int n){
  int *b = (int *)calloc(1,n * sizeof(int));


  for(int i=0;i<n;){

    if(head == NULL){
      b[i]+=1;
      insert(i++);
      

    }
    else if(a[i]<a[top()]){
      b[i]+=1;
      insert(i++);

    }
    else{
      int t = top();
      pop();
      b[i]+=b[t];
    }
  }

  for(int i=0;i<n;i++){
    printf("%d\n",b[i]);
  }
}

int main(){

  int n;
  scanf("%d",&n);
  int a[n];
  for(int i=0;i<n;i++){
    scanf("%d",&a[i]);
  }

   stockspan(&a[0],n);


}

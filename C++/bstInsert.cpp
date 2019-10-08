#include<stdio.h>
#include<stdlib.h>
struct node{
	int data;
	struct node* left;
	struct node* right;
};

struct node *newNode(int item) 
{ 
    struct node *temp =  (struct node *)malloc(sizeof(struct node)); 
    temp->data = item; 
    temp->left = temp->right = NULL; 
    return temp; 
} 

struct node* insert(struct node* h,int data){
		if(h==NULL){
			return newNode(data);
		}
		
		if(h->data > data)
			h->left=insert(h->left,data);
		if(h->data < data) 
			h->left=insert(h->right,data);
			
		return h;
}

int main(){
	struct node* head=NULL;
	head=insert(head,2);
	printf("%d",head->data);
}

#include <stdio.h> 
#include <stdlib.h>
struct node{
	int data;
	struct node* next;
};
 
void insertBeg(struct node **h,int val){
	struct node* n=(struct node*)malloc(sizeof(struct node));
	n->data=val;
	n->next=*h;
	*h=n;
}

struct node* addBoth(struct node** l1,struct node** l2){
	struct node* dumy=NULL;
	struct node* curr1=*l1;
	struct node* curr2=*l2;
	int num=0;
	int car=0;
	while(curr1!=NULL&&curr2!=NULL){
		num=curr1->data+curr2->data+car;
		car=num/10;
		num=num%10;
		insertBeg(&dumy,num);
		curr1=curr1->next;
		curr2=curr2->next;
	}
	
	while(curr1!=NULL){
		num=curr1->data+car;
		car=num/10;
		num=num%10;
		insertBeg(&dumy,num);
		curr1=curr1->next;
	}
	
	while(curr2!=NULL){
		num=curr2->data+car;
		car=num/10;
		num=num%10;
		insertBeg(&dumy,num);
		curr2=curr2->next;
	}
	
	if(car!=0){
		insertBeg(&dumy,car);
	}
	
 	return dumy;
} 

int main()
{
	struct node* l1=NULL;
	struct node* l2=NULL;
	int n;
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		int k;
		scanf("%d",&k);
		insertBeg(&l1,k);
	}
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		int k;
		scanf("%d",&k);
		insertBeg(&l2,k);
	}
	struct node* res=addBoth(&l1,&l2);
 	struct node* curr=res;
 	while(curr!=NULL){
 		printf("%d",curr->data);
 		curr=curr->next;
 	}
}

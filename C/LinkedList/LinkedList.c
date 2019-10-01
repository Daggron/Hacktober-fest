#include <stdio.h>

struct node{
    int data;
    struct node* next;
};

struct node* head = NULL;

void append(){
    struct node* temp = (struct node*)malloc(sizeof(struct node));
    printf("Enter the data : ");
    scanf("%d",&temp->data);
    temp->next = NULL;
    if(head == NULL){
        head = temp;
    }
    else{
        struct node* p;
        p = head;
        while(p->next != NULL){
            p = p->next;
        }
        p->next = temp;
    }
    display();
}

void addAtbegin(){
    struct node* temp = (struct node*)malloc(sizeof(struct node));
    printf("Enter the data : ");
    scanf("%d",&temp->data);
    temp->next = head;
    head = temp;
    display();
}

void addAfter(){
    int loc,i=1;
    struct node* temp = (struct node*)malloc(sizeof(struct node));
    struct node* p;
    printf("Enter the location : ");
    scanf("%d",&loc);
    if(loc >=length()){
        printf("Invalid Location\n");
        return;
    }
    printf("Enter the data : ");
    scanf("%d",&temp->data);
    p = head;
    while(i<loc){
        p = p->next;
        i++;
    }
    temp->next = p->next;
    p->next = temp;
    display();
}

void display(){
    struct node* temp;
    temp = head;
    while(temp->next != NULL){
        printf("%d-->",temp->data);
        temp = temp->next;
    }
    printf("%d\n",temp->data);
}


int length(){
    int count = 0;
    struct node* temp;
    temp = head;
    while(temp->next != NULL){
        temp = temp->next;
        count++;
    }
    return count+1;
}

void delete(){
    int loc = 0;
    struct node* temp;
    printf("Enter the location to delete : ");
    scanf("%d",&loc);
    if(loc > length()){
        printf("Invalid Location\n");
        return;
    }
    else if(loc == 1){
        temp = head;
        head = temp->next;
        temp->next = NULL;
        free(temp);
    }
    else{
        int i=1;
        temp = head;
        struct node* p;
        while(i < loc-1){
            temp = temp->next;
            i++;
        }
        p = temp->next;
        temp->next = p->next;
        p->next = NULL;
        free(p);
    }
    display();
}

int main()
{
    int choice;
    printf("Single Linked List Operations :\n");
    printf("1.Append\n");
    printf("2.Add at Beginning\n");
    printf("3.Add After\n");
    printf("4.Length\n");
    printf("5.Display\n");
    printf("6.Delete\n");
    printf("7.Quit\n");
    while(1){
        
        printf("Enter your Choice : ");
        scanf("%d",&choice);
        
        switch(choice){
            case 1: append();
                    break;
            case 2: addAtbegin();
                    break;
            case 3: addAfter();
                    break;
            case 4: printf("Length : %d\n",length());
                    break;
            case 5: display();
                    break;
            case 6: delete();
                    break;
            case 7: exit(1);
            default: printf("Invalid Choice\n");
        }
    }
    return 0;
}
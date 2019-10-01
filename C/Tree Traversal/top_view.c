#include <stdio.h>
//Tree
typedef strcut Tree{
    int data;
    struct Tree* left;
    struct Tree* right;
}Tree;
//Tree with distance
typedef strcut sTree{
    Tree* node;
    int dist;
}sTree;
//Data node for Queue
typedef struct Node{
    sTree* snode;
    struct Node* next;
}Node;
//Queue
typedef struct Queue{
    struct Node* front;
    struct Node* rear;
}Queue;
//Map for key value pairs
typedef struct map{
    int key;
    int value;
}Map;
//Linked List for Map to connect
typedef struct LL{
    Map m;
    struct LL* next;
}LL;

//Queue fucntions

Node* top(Queue* head){
    return head->front->snode;
}

void push(Queue* head, stree* nn){
    Node* n= (Node*)malloc(sizeof(Node));
    n->snode = nn;
    n->next = NULL;
    if(q->rear == NULL){
        q->front = n;
        q->rear = n;
    }
    else{
    q->rear->next = n;
    q->rear = n;
    }
}

void pop(Queue* head){
    if(head->front->next)
    head->front = head->front->next;
    else
    head->front = NULL;
}

int isEmpty(Queue* head){
    if(!head->front)
        return 1;
    return 0;
}

Tree* BST(Tree* root,int d){
    if(root == NULL){
        Tree* nn = (Tree*)malloc(sizeof(Tree));
        nn->data = d;
        nn->left = NULL;
        nn->right = NULL;
    }
    else if(root->data > d){
        root->left = BST(root->left,d);
    }
    else{
        root->right = BST(root->right,d);
    }
}


int main()
{
    Tree* head = NULL;
    printf("Enter the number of elements in the tree:\n");
    scanf("%d",&n);
    printf("Enter the node values");
    for(int i=0;i<n;i++){
        int val;
        scanf("%d",&val);
        head = BST(head,val);
    }
    stree* nn = (stree*)malloc(sizeof(stree));
    nn->node = head;
    nn->dist = 0;
    push(head,nn);
    while(!isEmpty(head)){
        sTree* temp = top(head);
        pop(head);
        //left node push
        stree* newnl = (stree*)malloc(sizeof(stree));
        newnl->node = temp->node->left;
        newnl->dist = temp->dist-1;
        //right node push
        stree* newnr = (stree*)malloc(sizeof(stree));
        newnr->node = temp->node->right;
        newnr->dist = temp->dist+1;
        //Add in Map
        
    }
    return 0;
}

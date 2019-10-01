/*
In this there can be 3 possibilities of diameter to be max:-
1) When the max diameter is in Left SubTree
2)When it's in right SubTree
3)When it includes the root node and it's made of left+right SubTree (we can do this using height of both left ST & right ST)

The max val among these will be the max diameter.
*/

int height(Node* root){
    if(!root)
        return 0;
    else
        return 1+max(height(root->left),height(root->right));
}
int diameter(Node* node)
{
   if(!node)
    return 0;
    int lst = diameter(node->left);     //LEFT SUBTREE
    int rst = diameter(node->right);    //RIGHT SUBTREE
   return max(height(node->left)+height(node->right)+1, max(lst,rst));
}
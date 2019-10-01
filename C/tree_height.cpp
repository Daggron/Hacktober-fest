// Height of a tree

int height(Node* root){
    if(!root)
        return 0;
    else
        return 1+max(height(root->left),height(root->right));
}
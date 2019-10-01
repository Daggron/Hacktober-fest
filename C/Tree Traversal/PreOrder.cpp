void preOrder(Node *root) {
        if(!root)
            return;
        cout<<root->data<<" ";
        preOrder(root->left);
        preOrder(root->right);
    }
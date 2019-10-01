void inOrder(Node *root) {
        if(!root)
            return;
        inOrder(root->left);
        cout<<root->data<<" ";
        inOrder(root->right);
    }
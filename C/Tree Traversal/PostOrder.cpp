void postOrder(Node *root) {
        if(!root)
            return;
        postOrder(root->left);
        postOrder(root->right);
        cout<<root->data<<" ";
    }
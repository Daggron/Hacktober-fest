Node *lca(Node *root, int v1,int v2) {
		// Write your code here.
        if(!root)
            return NULL;
        if(root->data == v1 || root->data == v2)
            return root;
        Node* x = lca(root->left,v1,v2);
        Node* y = lca(root->right,v1,v2);
        if(x&&y)
            return root;
        else if(x)
            return x;
        else if(y)
            return y;
        else
            return NULL;
    }
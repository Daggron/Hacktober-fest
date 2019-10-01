    void levelOrder(Node * root) {
        queue<Node*> s;
        queue<int> ans;
        s.push(root);
        while(!s.empty()){
            Node* temp = s.front();
            s.pop();
            ans.push(temp->data);
            if(temp->left)
            s.push(temp->left);
            if(temp->right)
            s.push(temp->right);
        }
        while(!ans.empty()){
            cout<<ans.front()<<" ";
            ans.pop();
        }
    }
vector<int> Solution::inorderTraversal(TreeNode* A) {
    vector<int> v;
    stack<TreeNode*> s;
    TreeNode* curr = A;
    while(curr || !s.empty()){
        while(curr){
            s.push(curr);
            curr = curr->left;
        }
        TreeNode* temp = s.top();
        s.pop();
        v.push_back(temp->val);
        if(temp->right)
        curr = temp->right;
        else
        curr = NULL;
    }
    return v;
}
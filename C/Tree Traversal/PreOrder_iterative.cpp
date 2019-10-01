vector<int> Solution::preorderTraversal(TreeNode* A) {
    vector<int> v;
    stack<TreeNode*> s;
    TreeNode* curr = A;
    while(curr || !s.empty()){
        while(curr){
            v.push_back(curr->val);
            s.push(curr);
            curr = curr->left;
        }
        TreeNode* temp = s.top();
        s.pop();
        if(temp->right)
        curr = temp->right;
        else
        curr = NULL;
    }
    return v;
}
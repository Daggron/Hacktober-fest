vector<int> Solution::postorderTraversal(TreeNode* A) {
    vector<int> res;
    stack<TreeNode*> stack;
    if (!A)
        return res;
    stack.push(A);
    
    while (!stack.empty())
    {
        TreeNode* node = stack.top();
        res.emplace_back(node->val);
        stack.pop();
        if (node->left)
            stack.push(node->left);
        if (node->right)
            stack.push(node->right);
    }
    reverse(res.begin(), res.end());
    return res;
}
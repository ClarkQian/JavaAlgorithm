vector<int> storage;

void printPath(TreeNode* root){
    if(root == NULL)
        return;
    if(root -> left == NULL && root -> right == NULL){//leaf node
        storage.push_back(root -> data);
        for(int i = storage.size()-1; i>=0; i--){
            cout<<storage[i]<<" ";
        }
        cout<<endl;
        storage.pop_back();
        return;
    }

    storage.push_back(root -> data);
    if(root -> left)
        printPath(root -> left);
    if(root -> right)
        printPath(root -> right);

    storage.pop_back();

}

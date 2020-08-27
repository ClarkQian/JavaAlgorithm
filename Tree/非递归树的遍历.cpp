//post one
void postOrder2(TreeNode* root){

	stack<TreeNode*> mainStk;
	TreeNode*p = root;
	while(p != NULL || !mainStk.empty()){
		while(p != NULL){
			mainStk.push(p);
			p -> visited = true;
			p = p -> left;
		}
		TreeNode* tmp = mainStk.top();//judgement
		if(tmp -> visited == true){
			p = tmp;
			p -> visited = false;
			p = p -> right;
	 	} else {
			 cout<<tmp -> data <<" ";
			 mainStk.pop();
		}
	}

}
//inorder one

void inorderTraverse2(TreeNode* root){
	stack<TreeNode*> mainStack;
	if(root == NULL)
		return;
	TreeNode* p = root;
	while(p != NULL || !mainStack.empty()){
		while(p != NULL){
			mainStack.push(p);
			p = p -> left;
		}
		p = mainStack.top();
		cout<<p -> data << endl;
		mainStack.pop();
		p = p -> right;


	}
}


//preorder one
void preorderTraverse2(TreeNode* root){
	stack<TreeNode*> mainStack;
	if(root == NULL)
		return;
	TreeNode* p = root;
	while(p != NULL || !mainStack.empty()){
		while(p != NULL){
			cout<<p -> data << endl;
			mainStack.push(p);
			p = p -> left;
		}
		p = mainStack.top();
		mainStack.pop();
		p = p -> right;


	}

}

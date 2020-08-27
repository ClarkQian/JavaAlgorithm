#include<iostream>
#include<vector>
#include<string>
#include<string.h>
#include<stdio.h>
#include<stdlib.h>
using namespace std;



class TreeNode
{
public:
	int data;
	TreeNode* left;
	TreeNode* right;
	TreeNode(int data){
		this -> data = data;	
		this -> left = NULL;
		this -> right = NULL;
	}
};

vector<string>* vec = new vector<string>();

void getNumber(TreeNode* root, string elem){ //element doesn't contain current node data

	if(root == NULL)
		return;
	if(root -> left == NULL && root -> right == NULL){
		vec->push_back(elem+(char)(48+root -> data));
	}


	getNumber(root -> left, elem+(char)(48+root -> data));
	getNumber(root -> right, elem+(char)(48+root -> data));



}

int getSum(TreeNode* root){
	getNumber(root, "");
	//get sum
	int res = 0;
	for(vector<string>::iterator itr = vec -> begin(); itr != vec -> end(); itr++){
		res += atoi((*itr).c_str());
	}
	return res;	
}

int main(int argc, char const *argv[])
{
	TreeNode* root = new TreeNode(4);
	root -> right = new TreeNode(0);
	root -> left = new TreeNode(9);
	root -> left -> right = new TreeNode(1);
	root -> left -> left = new TreeNode(5);




	// for(vector<string>::iterator itr = vec -> begin(); itr != vec -> end(); itr++){
	// 	cout<<*itr<<endl;
	// }
	cout<<getSum(root)<<endl;

	getchar();
}

#include <iostream>
#include <stack>
#include <algorithm>
#include <queue>
#include <stdio.h>
#include <vector>
#include <string>
#include <ctype.h>
#include <stdlib.h>
#include <string.h>
using namespace std;

class Node
{
public:
	Node *next = NULL;
	int data;
	Node(int data)
	{
		this->data = data;
	}

	void show()
	{
		Node *p = this;
		while (p != NULL)
		{
			cout << (*p).data << " ";
			p = p->next;
		}
		cout << endl;
	}
};

class TreeNode
{
public:
	int data;
	int data2;
	bool isLeft;
	bool isRight;
	TreeNode *lchild;
	TreeNode *rchild;
	TreeNode *parent;
	TreeNode(int data)
	{
		this->data = data;
		this->lchild = NULL;
		this->rchild = NULL;
		this->parent = NULL;
	}
	TreeNode(int data, int data2)
	{
		this->data = data;
		this->data2 = data2;
		this->lchild = NULL;
		this->rchild = NULL;
		this->parent = NULL;
	}
};

Node *reverse(Node *head)
{
	if (head == NULL || head->next == NULL)
	{
		return head;
	}

	Node *behindOne = reverse(head->next);
	head->next->next = head;
	head->next = NULL;
	return behindOne;
}

// void levelTraverse(TreeNode *root)
// {

// 	if (root == NULL)
// 		return;

// 	queue<TreeNode *> *que = new queue<TreeNode *>;
// 	que->push(root);
// 	TreeNode *last = root;
// 	TreeNode *next = NULL;

// 	while (!que->empty())
// 	{
// 		TreeNode *tmp = que->front();
// 		cout << tmp->data << " ";
// 		que->pop();

// 		if (tmp->lchild != NULL)
// 		{
// 			que->push(tmp->lchild);
// 			next = tmp->lchild;
// 		}
// 		if (tmp->rchild != NULL)
// 		{
// 			que->push(tmp->rchild);
// 			next = tmp->rchild;
// 		}

// 		if (tmp == last)
// 		{
// 			cout << endl;
// 			last = next;
// 		}
// 	}
// 	cout << endl;

// 	return;
// }

int getHeight(TreeNode *root)
{

	if (root == NULL)
		return 0;

	int lHeight = getHeight(root->lchild);
	int rHeight = getHeight(root->rchild);

	return ((lHeight > rHeight) ? (lHeight + 1) : (rHeight + 1));
}

stack<int> stackSort(stack<int> stk)
{
	stack<int> dst;
	dst.push(stk.top());
	stk.pop();
	while (!stk.empty())
	{
		int tmp = stk.top();
		stk.pop();
		while (!dst.empty() && dst.top() > tmp)
		{
			stk.push(dst.top());
			dst.pop();
		}
		dst.push(tmp);
	}

	return dst;
}

void showStack(stack<int> stk)
{
	while (!stk.empty())
	{
		cout << stk.top() << endl;
		stk.pop();
	}
	return;
}

void levelTraverse(TreeNode *root)
{
	queue<TreeNode *> que;
	TreeNode *p = root;
	TreeNode *next = NULL;
	que.push(p);

	while (!que.empty())
	{
		TreeNode *tmp = que.front();
		cout << (*tmp).data << " ";
		que.pop();
		if (tmp->lchild != NULL)
		{
			que.push(tmp->lchild);
			next = tmp->lchild;
		}
		if (tmp->rchild != NULL)
		{
			que.push(tmp->rchild);
			next = tmp->rchild;
		}

		if (tmp == p)
		{
			p = next;
			cout << endl;
		}
	}
}

TreeNode *insertor;
TreeNode *rroot;

TreeNode *insertNode(TreeNode *root, int data)
{
	if (root == NULL)
	{
		insertor = new TreeNode(data);
		return insertor;
	}
	else
	{
		if (data < root->data)
		{
			root->lchild = insertNode(root->lchild, data);
			root->lchild->parent = root;
			root->lchild->isLeft = true;
			root->lchild->isRight = false;
		}
		else
		{
			root->rchild = insertNode(root->rchild, data);
			root->rchild->parent = root;
			root->rchild->isLeft = false;
			root->rchild->isRight = true;
		}
	}
	rroot = root;
	return root;
}

bool unbalanced(TreeNode *p, TreeNode *q)
{
	int delta = getHeight(p) - getHeight(q);
	if (delta > 1 || delta < -1)
		return true;
	else
		return false;
}

TreeNode **getFirstUnbalance(TreeNode *node)
{
	TreeNode **pqs = new TreeNode *[3];
	TreeNode *s = node;
	if (s == NULL)
		return NULL;
	TreeNode *q = s->parent;
	if (q == NULL)
		return NULL;
	TreeNode *p = q->parent;
	if (p == NULL)
		return NULL;
	//pqs are available
	if (unbalanced(p->lchild, p->rchild))
	{
		pqs[0] = p;
		pqs[1] = q;
		pqs[2] = s;
		return pqs;
	}
	else
	{
		return getFirstUnbalance(q);
	}
}

void rightRotate(TreeNode *q, TreeNode *p)
{
	TreeNode *qRight = q->rchild;
	TreeNode *pParent = p->parent;
	if (pParent != NULL) // do not impact root
	{
		if (p->isLeft)
		{
			pParent->lchild = q;
			q -> parent = pParent;
			q -> isLeft = true;
			q -> isRight = false;
		}
		else
		{
			pParent->rchild = q;
			q -> parent = pParent;
			q -> isRight = true;
			q -> isLeft = false;
		}
		q->rchild = p;
		p -> parent = q;
		p -> isRight = true;
		p -> isLeft = false;

		p->lchild = qRight;
		if(qRight != NULL){
		 	qRight -> parent = p;
			qRight -> isLeft = true;
			qRight -> isRight = false;
		}
	}
	else // root -> q;
	{
		q->rchild = p;
		p->lchild = qRight;
		if(qRight != NULL){
			qRight -> parent = p;
			qRight -> isLeft = true;
			qRight -> isRight = false;
		}
		rroot = q;
		rroot -> parent = NULL;
	}
}

void leftRotate(TreeNode *q, TreeNode *p)
{
	TreeNode *qLeft = q->lchild;
	TreeNode *pParent = p->parent;
	if (pParent != NULL)
	{
		if (p->isLeft)
		{
			pParent->lchild = q;
			q-> parent = pParent;
			q -> isLeft = true;
			q -> isRight = false;
		}
		else
		{
			pParent->rchild = q;
			q -> parent = pParent;
			q -> isRight = true;
			q -> isLeft = false;
		}
		q->lchild = p;
		p -> parent = q;
		p -> isLeft = true;
		p -> isRight = false;
		p->rchild = qLeft;
		if(qLeft != NULL){
			qLeft -> parent = p;
			q -> isRight = true;
			q -> isLeft = false;

		}
	} else {
		q->lchild = p;
		p -> parent = q;
		p -> isLeft = true;
		p -> isRight = false;
		p->rchild = qLeft;
		if(qLeft!=NULL){
			qLeft -> parent = p;
			qLeft -> isRight = true;
			qLeft -> isLeft = false;
		}
		rroot = q;
		rroot -> parent = NULL;
	}
}

TreeNode *avlInsert(TreeNode *root, int data)
{
	root = insertNode(root, data);
	rroot = root;
	//get the insertor <- initialization as the s ### p -> q -> s
	TreeNode **pqs = getFirstUnbalance(insertor); // get p q s ## if none -> means the tree is balanced.
	if (pqs == NULL)
	{
		return rroot;
	}
	else
	{
		//equilibration: make it balance
		//#mode 1 LL |||  mode 2 RR ||| mode3 LR ||| mode4 RL
		//make the judgement and then equilibratoin
		//rotate only have two ways: 1. seq  2. antiseq,  and only have two objects to be executed
		TreeNode *p = pqs[0];
		TreeNode *q = pqs[1];
		TreeNode *s = pqs[2];
		if (q->isLeft && s->isLeft)
		{
			//right rotate
			rightRotate(q, p);
		}
		else if (q->isRight && s->isRight)
		{
			//left rotate
			leftRotate(q, p);
		}
		else if (q->isLeft && s->isRight)
		{
			//left rotate
			//down is p, up is q
			leftRotate(s, q);
			//right rotate
			//s -> q p -> p
			rightRotate(s, p);
		}
		else
		{ //r l
			//right rotate
			rightRotate(s, q);
			//left rotate
			leftRotate(s, p);
		}
	}

	return rroot;
}

int binarySearch(TreeNode *root, int key)
{

	if (root == NULL)
		return -1;

	if (root->data == key)
	{
		return root->data2;
	}
	else if (key < root->data)
	{
		return binarySearch(root->lchild, key);
	}
	else
	{ // >=
		return binarySearch(root->rchild, key);
	}
}

void inorderTraverse(TreeNode *root)
{

	if (root == NULL)
	{
		return;
	}

	inorderTraverse(root->lchild);
	cout << root->data << endl;
	inorderTraverse(root->rchild);
}

int getMin(TreeNode *root)
{
	if (root == NULL)
	{
		return -1;
	}

	TreeNode *p = root;
	while (p->lchild != NULL)
	{
		p = p->lchild;
	}
	return p->data;
}

int getMax(TreeNode *root)
{
	if (root == NULL)
	{
		return -1;
	}

	TreeNode *p = root;
	while (p->rchild != NULL)
	{
		p = p->rchild;
	}
	return p->data;
}

void remove(TreeNode* node){
	if(node == NULL)
		return;

	if(node -> lchild != NULL && node -> rchild != NULL){
		TreeNode* p = node -> rchild;
		while(p -> lchild != NULL){
			p = p -> lchild;
		}
		node -> data = p -> data;
		remove(p);


	} else if(node -> lchild == NULL && node -> rchild != NULL){//which means only have right child
		cout<<"I'm in right"<<endl;
		if(node -> parent != NULL){
			if(node -> isLeft){
				node -> parent -> lchild = node -> rchild;
			} else {
				node -> parent -> rchild = node -> rchild;
			}
		} else {
			rroot = node -> rchild;
		}
	} else if(node -> rchild == NULL && node -> lchild != NULL){ // only have left child
		cout<<"i'm in left"<<endl;
		if(node -> parent != NULL){
			if(node -> isLeft){
				node -> parent -> lchild = node -> lchild;
			} else {
				node -> parent -> rchild = node -> lchild;
			}
		} else {
			rroot = node -> lchild;
		}

	} else { // leaf
		// cout<<endl;
		// levelTraverse(node);
		if(node -> parent != NULL){
			if(node -> isLeft){
				node -> parent -> lchild = NULL;
			} else {
				node -> parent -> rchild = NULL;
			}

		} else {
			cout<<"wrong"<<endl;
			rroot = NULL;
		}
	}

}

int main(int argc, char const *argv[])
{

	// TreeNode* root = new TreeNode(1);

	// root -> lchild = new TreeNode(2);
	// root -> rchild = new TreeNode(3);

	// root -> lchild -> lchild = new TreeNode(4);
	// root -> lchild -> rchild = new TreeNode(5);

	// root -> rchild -> lchild = new TreeNode(6);
	// root -> rchild -> rchild = new TreeNode(7);

	// root -> lchild -> lchild -> lchild = new TreeNode(8);
	// root -> lchild -> lchild -> rchild = new TreeNode(9);

	// root -> lchild -> lchild -> rchild -> lchild = new TreeNode(10);

	// levelTraverse(root);

	// Node* head = new Node(1);
	// head -> next = new Node(2);
	// head -> next -> next = new Node(3);
	// head -> next -> next -> next = new Node(4);
	// head -> show();
	// Node* reverseHead = reverse(head);
	// reverseHead -> show();

	// levelTraverse(root);

	// TreeNode* root = new TreeNode();
	// cout<<root -> data;
	// int sum, value = 0;
	// while(std::cin >> value)
	// 	sum += value;
	// cout<<sum<<endl;

	// TreeNode a = TreeNode(12);
	// cout<<a.data<<endl;
	// cout<<ccb<<endl;

	// vector<int> vec;
	// for(int i = 0; i < 10; i++){
	// 	vec.push_back(i);
	//  }
	// vector<int>::iterator itr = vec.begin();
	// itr[2] = 23;
	// cout<<itr[2]<<endl;

	// int a = 1234;
	// char *b = new char[100];
	// itoa(a,b,2);
	// cout<<b<<endl;

	// for(int i = 0; i < vec.size(); i++){
	// 	cout<<vec.at(i)<<endl;
	// }

	// stack<int> stk;
	// for(int i = 0; i < 10; i++){
	// 	stk.push(10-i);
	// }
	// stack<int> dst = stackSort(stk);
	// showStack(dst);

	TreeNode *root = avlInsert(NULL, 2);
	levelTraverse(root);
	cout << "_________________________" << endl;
	root = avlInsert(root, 1);
	levelTraverse(root);
	cout << "_________________________" << endl;
	root = avlInsert(root, 3);
	levelTraverse(root);
	cout << "_________________________" << endl;
	root = avlInsert(root, 4);
	levelTraverse(root);
	cout << "_________________________" << endl;
	root = avlInsert(root, 5);
	levelTraverse(root);
	cout << "_________________________" << endl;
	root = avlInsert(root, 6);
	levelTraverse(root);
	cout<<"_________________________"<<endl;
	root = avlInsert(root, 7);
	levelTraverse(root);
	cout<<"_________________________"<<endl;
	root = avlInsert(root, 8);
	levelTraverse(root);
	cout<<"_________________________"<<endl;
	remove(root);
	levelTraverse(rroot);
	// cout<<(root -> rchild -> lchild -> parent) -> data<<endl;

	// TreeNode* root = new TreeNode(6);
	// root -> lchild = new TreeNode(1);
	// root -> lchild -> lchild = new TreeNode(2);
	// root -> lchild -> lchild -> rchild = new TreeNode(4);
	// root -> lchild -> lchild -> lchild = new TreeNode(3);
	// root -> lchild -> lchild -> lchild -> rchild = new TreeNode(5);
	// levelTraverse(root);
	// rightRotate(root -> lchild -> lchild, root -> lchild);
	// cout<<"________________________________________"<<endl;
	// levelTraverse(root);

	// ending part: mimic the cv6.0
	cout << "ENTER ANY KEY TO QUIT>>";
	getchar();
	// char gpu = cin.get()；;
	return 0;
}

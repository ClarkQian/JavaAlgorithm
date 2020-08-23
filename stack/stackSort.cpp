#include<iostream>
#include<stack>
#include <queue>
#include <stdio.h>
#include <vector>
using namespace std;


class Node
{
public:
	Node* next = NULL;
	int data;
	Node(int data){
		this -> data = data;
	}

	void show(){
		Node* p = this;
		while(p != NULL){
			cout<<(*p).data<<" ";
			p = p -> next;
		}
		cout<<endl;
	}
	
};


int main(int argc, char const *argv[])
{

	stack<int> srcStack;
	srcStack.push(2);
	srcStack.push(4);
	srcStack.push(1);
	srcStack.push(9);
	srcStack.push(0);

	stack<int> dstStack;

	while(!srcStack.empty()){
		int tmp = srcStack.top();
		srcStack.pop();
		if(dstStack.empty()){
			dstStack.push(tmp);
		} else {
			//comp
			while(!dstStack.empty() && tmp < dstStack.top()){
				srcStack.push(dstStack.top());
				dstStack.pop();
			} 
			//put down
			dstStack.push(tmp);

		}

	}

	while(!dstStack.empty()){
		cout<<dstStack.top()<<endl;	
		dstStack.pop();
	}

	return 0;
}

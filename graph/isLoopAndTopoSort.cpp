#include <iostream>
#include <stdio.h>
using namespace std;

int* topo;
int point;
int n;
int index;
int* visited;

bool dfs(int matrix[][5],int p){

    visited[p] = -1;// occupied

    for(int i = 0; i < n; i++){
        if(matrix[p][i] != 0){//has road
            if(visited[i] == -1)
                return false;
            if(visited[i] == 0){
                bool res = dfs(matrix,i);
                if(res == false)
                    return false;
            }
            //if vivsited[i] = 1 continue;

        }
    }

    topo[index--] = p;
    visited[p] = 1;

    return true;
}


bool topoSort(int matrix[][5]){
    for(int i = 0; i < n; i++){
        if(visited[i] == 0){ // no visited before
            bool res = dfs(matrix,i);

            if(res == false) // has loop no topo sort sequence
                return false;
        }
    }
    return true;
}


int main() {
    const int n = 5;
    ::n = n;
    index = n-1;
    visited = new int[n]{};
    topo = new int[n];
    int matrix[][n] = {
            {0,1,1,0,0},
            {0,0,1,1,0},
            {0,0,0,1,1},
            {0,0,0,0,0},
            {0,0,0,0,0}
    };
    if(topoSort(matrix)){
        for(int i = 0; i < n; i++){
            cout<<topo[i]<<" ";
        }
        cout<<endl;
    } else {
        cout<<"WARNING LOOP OCCURING"<<endl;
    }


    return 0;

}

#include <iostream>
#include <stdio.h>
using namespace std;

int visited[][4] = {{},{},{},{}};
void euler(int matrix[][4],int p){
    for(int i = 0; i < 4; i++){
        if(matrix[p][i] > 0 && visited[p][i] < matrix[p][i]){// have road and have remainder road
            visited[p][i]++;
            visited[i][p]++;
            euler(matrix,i);
            cout<<(char)(p+97)<<" -> "<<(char)(i+97)<<endl;//这里一定要放在最后，因为第一次走到这里是不一定能通的，但是走到死胡同，这个一定是最后一步了，所以应该方向放进去
        }
    }
}


int main() {
    int matrix[][4] = {
            {0,1,2,1},
            {1,0,0,0},
            {2,0,0,1},
            {1,0,1,0}
    };

    //start from b:1 or c:2
    euler(matrix,2);



    return 0;

}

class UN{
private:
    int* parent;
    int* rank;
    int n;
public:
    UN(int n){
        parent = new int[n];
        rank = new int[n];
        this -> n = n;
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }

    }

    int find(int index){
        int p = parent[index];
//        while (p != parent[p]){
//            parent[p] = parent[parent[p]];
//            p = parent[p];
//        }

        if(parent[p] != p){ parent[p] = find(parent[p]);
        }

        return parent[p];
    }

    void unionElement(int p, int q){
        int pID = find(p);
        int qID = find(q);

        if(pID == qID)
            return; //
        if(rank[pID] < rank[qID]){ //确保高度低的树挂在高度高的树上
            parent[qID] = pID;
        } else if(rank[pID] > rank[qID]){
            parent[qID]  = pID;
        } else {
            parent[qID]  = pID;
            rank[pID]+= 1;
        }

    }

    void showParent(){
        for(int i = 0; i < n; i++){
            cout << parent[i] << " ";
        }
        cout<<endl;
    }
    void showRank(){
        for(int i = 0; i < n; i++){
            cout << rank[i] << " ";
        }
        cout<<endl;
    }
    bool isConnect(int p, int q){
        return find(p) == find(q);
    }


    ~UN(){
        delete []parent;
    }

};

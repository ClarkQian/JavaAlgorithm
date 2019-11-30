//rk[index_i] -> 用来查找src串中index为i的后缀在排序之后的位置
//sa(suffix Array) -> src所有的后缀进行排序之后的string[]

makeRk from suffixArray(sa[]);  -> rk[]
int k = 0;

for(int i = 0 ;i < strLength; i++){

    int rk_ith = rk[i];
    if(rk_ith == 0){
        height[0] = 0;
        continue;
    } 

    int rk_i_1 = rk_ith - 1;

    int j = sa[rk_i_1].index;

    if(k > 0)
        k--;

    for(; i+k < strLength && j+k <strLength;k++){
        if(!=)
            break;
    }

    height[rk_i] = k;



}

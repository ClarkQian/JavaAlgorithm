
i = 0;
j = -1;
minLen = Integer.MAX;

//确定i的左边界

//update() -> 用来更新最小的长度
//尺

for(int i = 0; i < words.length; i++){
    //about i
    if(left_match)
    {
        if(match_all){
            update();
            continue;
        }
    }else//notmatch
    {
        continue;
    }
    //about j
    while(j < words.length){
        if(j == -1)
            j = i+1;

        if(right_match){
            if(match_all){
                update();
                break;
            } else {
                j++;
            }
        }else{
            j++;
        }


    }




}


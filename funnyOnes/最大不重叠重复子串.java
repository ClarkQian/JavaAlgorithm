public class MaxRepeatSubString2 {

    public static void main(String[] args) {
        int res = maxRepeatSubString2("1x23231923263");
        System.out.println(res);  // 输出 3
    }
    
    /**
     * 不允许交叉
     * 
     * @param src
     * @return
     */
    public static int maxRepeatSubString2(String src) {
        SuffixArray.Suff[] sa = SuffixArray.getSa2(src);
        int[] height = SuffixArray.getHeight(src, sa);
        int l = 0;
        int r = height.length;
        int ans = 0;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);// check的重叠长度
            if (check(height, sa, mid)) {
                if (mid == height.length / 2) {
                    return mid;
                }// 如果一半的符合了，就不用继续查更长的了，这个一定是最长的了。
                l = mid + 1;
                ans = mid;
                // return mid;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
    
    /**
     * 用len将height分组,小于组和大于等于组交替
     * 在大于组中更新最大最小原始小标,大转小的时候检查上一个大于组是否满足不重叠
     * 在小于组中,只需持续地将原始下标付给max和min,这样小转大的时候,可以保留小于组最后一个元素的下标
     *  -> 小：结算 -> 大：更新下标
     */
    private static boolean check(int []height,SuffixArray.Suff[]sa,int len){
        int minIndex = Integer.MAX_AVLUE;
        int maxIndex = sa[0].index;
        for(int i = 1;i<height.length;i++){
            int index = sa[i].index;
            if(height[i]>=len){ // lcp 大于 len
                minIndex = Math.min(minIndex,index);
                maxIndex = Math.max(maxIndex, index);
            } else {
                if (maxIndex - minIndex >= len) {
                    return true;
                }
                maxIndex = index;
                minIndex = index;
            }
        }
        return (maxIndex - minIndex) >= len;
    }

}

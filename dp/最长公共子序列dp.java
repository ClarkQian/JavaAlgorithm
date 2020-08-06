package leetcode;

import java.util.Arrays;

public class 最长公共子序列 {


    public static void show(int[][]table){
        for(int i = 0; i < table.length; i++){
            for(int j = 0; j < table[0].length; j++){
                System.out.printf("%d ",table[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * This algorithm using dp by record fromer col's jump point, keep it in the next col
     * and then find the next match place, and this position's next rows by the same value;
     * @param a
     * @param b
     * @return
     */
    public static int LPS(String a, String b){
        int[][]table = new int[a.length()][b.length()];
        int n = a.length();
        int c = b.length();
        for(int i = 0; i < n; i++){
            Arrays.fill(table[i],0);
        }


        //initializtion
        boolean flag = false;
        int jp = -1;
        for(int i = 0; i < a.length();i++){
            if(a.charAt(i)!= b.charAt(0)) {
                table[i][0] = 0;
            } else {
                flag = true;
                jp = i;
                for(int i2 = i; i2 < n; i2++){
                    table[i2][0] = 1;
                }
                break;
            }
        }


        for(int j = 1; j < c; j++){
            flag = false;
            if(jp == -1){
                //none;
            } else {
                for(int i = 0; i <= jp; i++){
                    table[i][j] = table[i][j-1];
                }
            }
            for(int i = jp+1; i < n; i++){
                if(flag == false){
                    if(a.charAt(i)!=b.charAt(j))  {
                        table[i][j] = table[i][j-1];
                    } else {
                        flag = true;
                        table[i][j] = table[i][j-1]+1;
                        jp = i;
                    }
                } else {
                    table[i][j] = table[jp][j];
                }
            }
        }


        show(table);
        return table[n-1][c-1];
    }

    public static void main(String[] args) {
        int res = LPS("ABBBCB","ABBBB");
        System.out.println(res);

    }
}

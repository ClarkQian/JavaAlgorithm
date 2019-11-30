import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//cc150 92
//机器人只能向下或者是右走
public class Main {

	public static int count = 0;

	public static void solve(int x, int y) {

		if (x <= 0 || y <= 0)
			return;
		if (x == 1 && y == 1) {
			count++;
		}

		solve(x - 1, y);
		solve(x, y - 1);

	}

	public static int solve2(int x, int y){
		
		if(x == 1 || y== 1)
			return 1;
		
		return solve2(x-1,y) + solve2(x,y-1);
	}
	
	/**
   * 迭代形式
   * @param m
   * @param n
   * @return
   */
  public static int solve1(int m, int n) {
    int[][] state = new int[m + 1][n + 1];
    for (int i = 1; i <= n; i++) {//第一行和第一列全都是1，因为只有一种走法
      state[1][i] = 1;
    }
    for (int i = 1; i <= m; i++) {
      state[i][1] = 1;
    }
	  //规律为：右下角等于上方和左方的值的和
    for (int i = 2; i <= m; i++) {
      for (int j = 2; j <= n; j++) {
        state[i][j] = state[i][j - 1] + state[i - 1][j];
      }
    }
    return state[m][n];
  }

	
	public static void main(String[] args) {
		solve(1, 1);
		System.out.println(count);

	}

}

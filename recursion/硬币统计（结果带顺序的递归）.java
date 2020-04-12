import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



//1,2,5 -> n
public class Main {
	//1, 2, 5 -> 10
	
	public static int solve(int sum){
		if(sum <= 0)
			return 0;
		else
			return _solve(sum, new int[]{1,2,5}, 2);
		
	}
	
	
	//带次序的递归下去
	public static int _solve(int sum, int[]coins,int current_index){
		
		if(current_index == 0)
			return 1;
		
		
		int res = 0;
	
		for(int i = 0; i*coins[current_index]<=sum; i++){
			res += _solve(sum-i*coins[current_index],coins,current_index-1);
		}
		
		return res;
		
		
	}
	

	//new one
	public static int calc(int total, int[] coins, int n, int index) {
		if (total < 0) {

//			System.out.println("为负");
			return 0;
		}
		if (total == 0) {
//			System.out.println("正达");
			return 1;
		}

		//一定要先检测是否达成，因为可能存在5元用了一个然后index加超过的情况。
		if (index >= n) {
			
//			System.out.println("超过界限");
			return 0;
		}
		// get the moderate number of index coin
		int res = 0;
		for (int i = 0; coins[index] * i <= total; i++) {
//			System.out.printf("检测%d元的使用了%d个\n", coins[index], i);
			res += calc(total - coins[index] * i, coins, n, index + 1);
		}

		return res;

	}

	public static void main(String[] args) {
		int res = calc(10, new int[] { 1, 2, 5 }, 3, 0);
		System.out.println(res);
	}
}

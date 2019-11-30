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
	

	public static void main(String[]args){
		System.out.println(solve(10));
	}
}

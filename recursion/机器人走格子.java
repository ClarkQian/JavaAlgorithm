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
	
	
	
	public static void main(String[] args) {
		solve(1, 1);
		System.out.println(count);

	}

}

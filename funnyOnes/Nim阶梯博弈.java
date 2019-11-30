import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//POJ 1704
public class Main {

	public static boolean solve(int[]a){
		
		Arrays.sort(a);
		int res = 0;
		int n = a.length;
		
//		System.out.println(a.toString());
		ArrayList<Integer> distanceStack = new ArrayList<Integer>();
		
		
		//分堆
		if(n%2 == 1){//奇数
			distanceStack.add(a[0]-0-1);
			for(int i = 1; i < a.length; i += 2){
				distanceStack.add(a[i+1]-a[i]-1);
			}
			
		}else {//偶数
			for(int i = 0; i < a.length; i += 2){

				distanceStack.add(a[i+1]-a[i]-1);
			}
			
		}
		
		
		//异或计算
		
		for(int i = 0; i < distanceStack.size(); i++){
			res ^= distanceStack.get(i);
		}
		
		return res != 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0; i < N; i++){
			int n = sc.nextInt();
			int[] seq = new int[n];
			for(int j = 0; j < n; j++){
				seq[j] = sc.nextInt();
			}
			boolean res = solve(seq);
			if(res == true){
				System.out.println("Georgia will win");
			}else {
				System.out.println("Bob will win");
			}
		}
	}

}

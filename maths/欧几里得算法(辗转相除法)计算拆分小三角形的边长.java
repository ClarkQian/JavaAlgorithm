import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//POJ 1704
public class Main {
	
	
	public static int getGcd(int m, int n){
		
		return n == 0? m:getGcd(n, m%n);
	}
	
	
	public static void main(String[] args) {
		int x1 = 1;
		int y1 = 11;
		int x2 = 5;
		int y2 = 3;
		double k =  y2/((x2-x1)+y1);
//		y2 = k(x2-x1)+y1;
		
		//公约数其实是点的个数
		int gcd = getGcd(Math.abs(x2-x1), Math.abs(y2-y1));
		
		System.out.println(String.format("小正方形的边长是",Math.abs(x1-x2)/gcd,Math.abs(y1-y2)/gcd));
		
		
		
	}

}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	
	public static boolean find(String a, String pattern){
		//旋转拼接从而构成原串中的所有组合
		a = a+a;
		int res = a.indexOf(pattern);
		if(res < 0 )
			return false;
		else
			return true;
	}
	
	
	public static void main(String[] args) {
		
		
		String a = "bcda";
		String pattern = "abcd";
		System.out.println(find(a, pattern));



	}
}

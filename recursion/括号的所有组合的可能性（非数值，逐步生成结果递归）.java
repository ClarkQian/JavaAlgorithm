import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;



public class Main {
	
	public static HashSet<String> getParenthesis(int n){
		
		//对于()
		//有三种可能
		//()左  (())包含 ()()右
		
		//使用集合是为了避免重复的情况
		//比如n = 2 -> ()()左  ()()右是重复的
		HashSet<String>hs = new HashSet<String>();
		if(n == 1){
			hs.add("()");
			return hs;
		}
		
		
		HashSet<String>hs_new = getParenthesis(n-1);
		
		for(String elem:hs_new){
			hs.add("()"+elem);
			hs.add("("+elem+")");
			hs.add(elem+"()");
		}
		
		return hs;
		
		
	}


	public static void main(String[]args){
		HashSet<String> hs = getParenthesis(3);
		for(String e: hs){
			System.out.println(e);
		}
	}
}

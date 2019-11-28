import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	public static int seed;
	{
		seed = 5;
	}
	public static long getHash(String a){ 
		
		long res = 0;
		
		for(int i =0; i < a.length(); i++){
			res += res*seed+a.charAt(i);
		}
		
		return res;
	}
	

	
	public static int match(String a, String pattern){
		long srcHash = getHash(pattern);
		int patternLength = pattern.length();
		
		if(patternLength > a.length()){
			return -1;
		}
		
		long dstHash = getHash(pattern.substring(0,patternLength-1));
		
		

		for(int i =0 ; i+patternLength < a.length(); i++){
			if(dstHash == srcHash)
				return i;
			else{
				dstHash -= a.charAt(i)*Math.pow(seed, patternLength-1)%Long.MAX_VALUE;
				dstHash += a.charAt(i+patternLength)%Long.MAX_VALUE;
			}
		}
		
		return -1;
		
	}	
	
	
	public static void main(String[] args) {
		String a = "abcde";
		String pattern = "bcdf";
		System.out.println(match(a,pattern));
	}

}

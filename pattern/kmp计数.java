import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {



	public static int[] getNext(String pattern) {
		int[] next = new int[pattern.length()];
		//0的位置为了理解偏移，必须设置为-1，因为0的话还在原地
		next[0] = -1;
		
		//判断是一位的情况
		if(pattern.length() == 1)
			return next;
//		这个理解为往右移一位
		next[1] = 0;
		
		int j = 2;
		int k = next[j - 1];
		//注意与本位是无关的
		
		
		//最后一位的时候就匹配了，其实没有必要判断pattern.length()的时候的回溯，
		//但是解最大首位匹配串的时候可能有用
		while (j < pattern.length()) {
			if (k == -1 || pattern.charAt(k) == pattern.charAt(j - 1)) {
				next[j++] = ++k;
			} else {
				//寻找更小的匹配串
				k = next[k];
			}
		}

		return next;

	}
	
	
	public static int indexOf(String a, String pattern) {
		
		if(pattern.length() > a.length() || pattern.length() == 0 || a.length() == 0)
			return -1;
		
		
		int count = 0;
		int i = 0;
		int j = 0;
		
		int[] next = getNext(pattern);

		while (i < a.length()) {
			if (j == -1 || a.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j];
			}
			if (j == pattern.length()){
				count++;
				j = 0;
				i = i - pattern.length()+1;

			}
//				return i - pattern.length();
		}
//		return -1;
		return count;
	}

	public static void main(String[] args) {

		String a = "abababa";
		// int[] next = getNext(a);
		// for (int i = 0; i < next.length; i++) {
		// System.out.print(next[i] + " ");
		// }
		// System.out.println();

		String p = "a";
//		System.out.println(a.indexOf(p));
		System.out.println(indexOf(a, p));
	}

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

	// public static int[] getNext2(String ps){
	// int plength = ps.length();
	// int[]next = new int[plength];
	// char[] p = ps.toCharArray();
	// next[0] = -1;
	// if(ps.length() == 1)
	// return next;
	//
	// int j = 1;//指向的是适配的前一个位置
	// int k = next[j];
	//
	//
	// while(j < plength-1){
	// if(k < 0 || p[j] == p[k]){
	// next[++j] = ++k;
	// }else {
	// k = next[k];
	// }
	// }
	// return next;
	// }

	// public static int[] getNext(String pattern) {
	// int[] next = new int[pattern.length() + 1];
	//
	// next[0] = -1;
	// next[1] = 0;
	//
	// int j = 2;
	// int k = next[j - 1];
	//
	// while (j <= pattern.length()) {
	// // int k = next[j - 1];//前一个的k的值都在
	// //
	// // l: while (true) {
	// //
	// // if (k == -1) {
	// // k++;
	// // break;
	// // }
	// // if (pattern.charAt(k) == pattern.charAt(j - 1)) {
	// // k++;
	// // break;
	// // } else {
	// // k = next[k];
	// // }
	// //
	// // }
	// //
	// // next[j] = k;
	// // j++;
	//
	// if (k == -1 || pattern.charAt(k) == pattern.charAt(j - 1)) {
	// next[j++] = ++k;
	// } else {
	// k = next[k];
	// }
	//
	// }
	//
	// return next;
	//
	// }

	public static int[] getNext(String pattern) {
		int[] next = new int[pattern.length()];
		//0的位置为了理解偏移，必须设置为-1，因为0的话还在原地
		next[0] = -1;
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
			if (j == pattern.length())
				return i - pattern.length();
		}
		return -1;
	}

	public static void main(String[] args) {

		String a = "abcabc";
		// int[] next = getNext(a);
		// for (int i = 0; i < next.length; i++) {
		// System.out.print(next[i] + " ");
		// }
		// System.out.println();

		String p = "cabe";
		System.out.println(a.indexOf(p));
		System.out.println(indexOf(a, p));
	}

}

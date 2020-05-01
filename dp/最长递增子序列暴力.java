package alo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static int count = 0;

	public static void solveWarp(int[] a) {
		int max = 0;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i + 1] >= a[i]) {
				count++;
				solve(a, i + 1, a[i + 1]);
				max = max > count?max:count;
				count = 0;
			}
		}
		
		
		System.out.println(max);
	}

	public static void solve(int[] a, int start, int before) {

		for (int i = start; i < a.length; i++) {
			if (a[i] >= before) {
				count++;
				solve(a, i + 1, a[i]);
				break;
			}
		}

	}

	public static void main(String[] args) {
		int[] a = new int[] { 10, 5, 6, 1, 2, 3, 4,5};
		solveWarp(a);
	}
}

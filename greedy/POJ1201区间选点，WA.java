You are given n closed, integer intervals [ai, bi] and n integers c1, ..., cn.
Write a program that:
reads the number of intervals, their end points and integers c1, ..., cn from the standard input,
computes the minimal size of a set Z of integers which has at least ci common elements with interval [ai, bi], for each i=1,2,...,n,
writes the answer to the standard output.

The first line of the input contains an integer n (1 <= n <= 50000) -- the number of intervals. The following n lines describe the intervals. The (i+1)-th line of the input contains three integers ai, bi and ci separated by single spaces and such that 0 <= ai <= bi <= 50000 and 1 <= ci <= bi - ai+1.

The output contains exactly one integer equal to the minimal size of set Z sharing at least ci elements with interval [ai, bi], for each i=1,2,...,n.

5
3 7 3
8 10 3
6 8 1
1 3 1
10 11 1

output: 
6

//可以使用高度数组的思路，之后补充

package alo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	private static class Element implements Comparable<Element> {
		public int start;
		public int end;
		public int points;

		public Element(int start, int end, int points) {
			this.start = start;
			this.end = end;
			this.points = points;
		}

		public Element() {

		}

		public int getStart() {
			return this.start;
		}

		public int getEnd() {
			return this.end;
		}

		public int getPoint() {
			return this.points;
		}

		public boolean reamin() {
			return points > 0;
		}

		public void deduct() {
			points--;
		}

		public boolean check(int point) {
			if (point >= start && point <= end) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public int compareTo(Element o) {

			return this.end - o.end;
		}

		public String toString() {
			return String.format("start from %d to %d, points: %d", start, end,
					points);
		}

	}

	public static int count = 0;
	public static ArrayList<Integer> counter = new ArrayList<Integer>();
	
	//多余的点不能随便放，可以用来打底下的
	public static void solve(Element[] intervals) {
		for (int i = 0; i < intervals.length; i++) {
			Collections.sort(counter);
			if (counter.size() > 0) {
				for (int j = 0; j < counter.size(); j++) {
					if (intervals[i].check((counter.get(j)))) {
						intervals[i].deduct();
					}

				}

				if (intervals[i].reamin()) {
					counter.add(intervals[i].getEnd());
					intervals[i].deduct();
				}
			} else {
				counter.add(intervals[i].getEnd());
				intervals[i].deduct();
			}

		}
		for (int i = 0; i < intervals.length; i++) {
			if (intervals[i].reamin()) {
				count += intervals[i].getPoint();
			}
		}
		count += counter.size();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Element[] intervals = new Element[n];
		for (int i = 0; i < n; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int points = sc.nextInt();
			intervals[i] = new Element(start, end, points);
		}

		Arrays.sort(intervals);
		
		for(int i = 0; i < n; i++){
			System.out.println(intervals[i].toString());
		}
	}
}

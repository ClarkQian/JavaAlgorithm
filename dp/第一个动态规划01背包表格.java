package alo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//n = 4
//(2,3)
//(1,2)
//(3,4)
//(2,2)
//w = 5

public class Main {

	public static class Element {
		public int w;
		public int v;

		public Element(int w, int v) {
			this.w = w;
			this.v = v;
		}

	}

	public static int[][] f;
	public static int x_m;
	public static int y_m;

	public static void showF() {

		for (int i = 0; i < f.length; i++) {
			for (int j = 0; j < f[0].length; j++) {
				System.out.printf("%d ", f[i][j]);
			}
			System.out.println();
		}
	}

	public static void dp(Element[]container, int x, int y) {
		
		
		if(f[x_m][y_m] != -1){
			return;
		}
		
		if(x == container.length){
			x = 1;
			y++;
		}
		
		
		//不取
		int res1 = 0 + f[x-1][y];
		//取
		if(y < container[x].w){
			f[x][y] = res1;
		} else {//enough
			int res2 = container[x].v + f[x-1][y - container[x].w];
			f[x][y] = res1 > res2?res1:res2;
		}
		
		dp(container,x+1, y);
		
		
	}

	public static void main(String[] args) {

		// get input
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Element[] container = new Element[n];
		for (int i = 0; i < n; i++) {
			container[i] = new Element(sc.nextInt(), sc.nextInt());
		}
		int w = sc.nextInt();

		int[][] f = new int[n][w + 1];

		for (int i = 0; i < f.length; i++) {
			Arrays.fill(f[i], -1);
		}

		for (int i = 0; i < f.length; i++) {
			f[i][0] = 0;
		}

		int firstWeight = container[0].w;
		// f[0][i]
		for (int i = 0; i < w + 1; i++) {
			if (i < firstWeight) {
				f[0][i] = 0;
			} else {
				f[0][i] = container[0].v;
			}
		}

		Main.f = f;
		x_m = n-1;
		y_m = w;
		
		// finish initialization

		dp(container,1,1);
		showF();
	}
}

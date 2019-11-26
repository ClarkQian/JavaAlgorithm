import java.io.ObjectInputStream.GetField;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicBorders.MarginBorder;

import org.omg.PortableServer._ServantLocatorStub;

public class Main {

	//预处理，计算右侧和下侧有多少相同的1
	public static int[][][] pretreatment(int[][] a) {
		int[][][] b = new int[a.length][a[0].length][2];
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				// set the (x,1)
				for (int k = j; k < a[i].length; k++) {
					if (a[i][k] == 1)
						b[i][j][0]++;
					else
						break;
				}
				// set the (1, x)
				for (int k = i; k < a.length; k++) {
					if (a[k][j] == 1)
						b[i][j][1]++;
					else
						break;
				}
			}
		}

		return b;
	}

	//本处是否能够作为起点，和组成正方形的另外两个顶点是否正确
	public static boolean check(int[][][]b, int i, int j, int n){
		if(b[i][j][0] >= n && b[i][j][1] >= n &&b[i][j+n-1][1]>= n && b[i+n-1][j][0] >= n){
				return true;
		}else
			return false;
		
	}

	public static void showBigestOne(int[][] a) {

		int N = a.length;
		int[][][] b = pretreatment(a);
		int n = N;
		while (n >= 1) {
			for (int i = 0; i < N; i++) {
				if (i + n > N)
					break;
				l1: for (int j = 0; j < N; j++) {
					if (j + n > N)
						break;
					if (check(b, i, j, n)) {
						System.out.println(n);
						return;
					}
				}
			}

			n--;
		}

		System.out.println(0);
		return;

	}

	/**
	 * @param args
	 */

	public static void main(String[] args) {

		int[][] a = new int[][] { 
				{ 1, 1, 1, 1, 1 },
				{ 1, 0, 1, 0, 1 },
				{ 1, 1, 0, 1, 1 }, 
				{ 1, 0, 1, 0, 1 },
				{ 1, 1, 1, 1, 0 }, };

		 showBigestOne(a);
//		int[][][] b = pretreatment(a);
//		for (int i = 0; i < b.length; i++) {
//			for (int j = 0; j < b[i].length; j++) {
//				System.out.print(String.format("(%d,%d) ", b[i][j][0],
//						b[i][j][1]));
//			}
//			System.out.println();
//		}

	}
}

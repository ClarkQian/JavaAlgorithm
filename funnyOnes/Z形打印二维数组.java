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

	public static void print(int[][] matrix) {
		int r11 = 0;
		int c11 = 0;
		int ree = matrix.length - 1;
		int cee = matrix[0].length - 1;

		int count = 0;

		while (r11 <= ree) {
			int r = r11;
			int c = c11;

			while (c <= cee) {
				System.out.print(matrix[r][c++] + " ");
			}
			r++;
			c = cee;

			while (r <= ree) {
				System.out.print(matrix[r++][c] + " ");
			}

			c--;
			r = ree;

			while (c >= c11) {
				System.out.print(matrix[r][c--] + " ");
			}

			r--;
			c = c11;

			while (r > r11) {
				System.out.print(matrix[r--][c] + " ");
			}

			r11++;
			c11++;
			ree--;
			cee--;
		}

	}

	public static void printZ(int[][] matrix) {

		int r11 = 0;
		int c11 = 0;
		int ree = matrix.length - 1;
		int cee = matrix[0].length - 1;
		
		int count =0;
		
		
		
		int r = r11;
		int c = c11;

		boolean clockwise = true;


//直接用计数的方式判断是否结束而不是找判停的点条件，更加方便
//		while (!(((r == ree + 1) && (c == cee)) || ((r == ree) && (c == cee + 1)))) {
		while(count < (ree+1)*(cee+1)){

      //一共有四面墙壁，围住了这个二维数组，每次撞墙就要调整
			if (r < 0 || c > matrix[0].length - 1) {
				if (r < 0 && c <= matrix[0].length-1)
					c++;
				else
					r++;

				r++;
				c--;

				clockwise = !clockwise;
			}
			if (c < 0 || r > matrix.length - 1) {
				// go back
				if (c < 0 && r <= matrix.length - 1)
					r++;
				else
					c++;

				r--;
				c++;
				clockwise = !clockwise;
			}

			if (clockwise == true) {
				System.out.print(matrix[r--][c++] + " ");
				count++;
			} else {
				System.out.print(matrix[r++][c--] + " ");
				count++;
			}

		}

	}

	/**
	 * @param args
	 */

	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		printZ(matrix);
	}

}

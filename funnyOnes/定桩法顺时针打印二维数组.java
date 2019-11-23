import java.io.ObjectInputStream.GetField;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

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

			r11++;c11++;ree--;cee--;
		}

	}

	/**
	 * @param args
	 */

	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		 print(matrix);
	}

}

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

	
	public static void showBigestOne(int[][]a){


		int N = a.length;

		int n = N;
		while (n >= 1) {
			for (int i = 0; i < N; i++) {
				if (i + n > N)
					break;
				l1:for (int j = 0; j < N; j++) {
					if (j + n > N)
						break;
					
					//上
					for(int k1 = j; k1 < j+n; k1++){
						if(a[i][k1] == 0)
							continue l1;
					}
					
					
					//右
					for(int k2 = i; k2 < i+n; k2++){
						if(a[k2][j+n-1] == 0)
							continue l1;
					}
					//下
					for(int k3 = j; k3 < j + n; k3++){
						if(a[i+n-1][k3] == 0)
							continue l1;
					}

					//左
					
					for(int k4 = i; k4 < i + n; k4++){
						if(a[k4][j] == 0)
							continue l1;
					}
					
					System.out.println(n);
					return;
					
				}
			}

			n--;
		}

		
	}
	
	

	/**
	 * @param args
	 */

	public static void main(String[] args) {

		int[][] a = new int[][] { 
				{ 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1 },
				{ 1, 1, 0, 1, 1 }, 
				{ 1, 1, 1, 0, 1 },
				{ 1, 1, 1, 1, 0 },
		};

		showBigestOne(a);

	}
}

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static int getMin(int[]a, int begin, int end){
		
		if(begin > end){
			return begin + 1;
		}
	
		int mid = partition(a, begin, end);
		if(a[mid] <= mid+1)
			return getMin(a, mid+1, end);
		else
			return getMin(a, begin, mid - 1);
			
		
	}
	
	public static void swap(int[]a, int src, int dst){
		int tmp = a[src];
		a[src] = a[dst];
		a[dst] = tmp;
	}
	private static int partition(int[] a, int begin, int end) {
		int pivot = a[begin];
		int sp = begin + 1;
		int bp = end;
		while(sp <= bp){
			if(a[sp] <= pivot){
				sp++;
			} else {
				if(sp < bp)
					swap(a, sp, bp);
				bp--;
			}
		}
		swap(a, begin, bp);
		return bp;
	}


	/**
	 * @param args
	 */

	public static void main(String[] args) {
		int[] a = new int[]{1,2,4,5,6};
		int res = getMin(a, 0, a.length-1);
		System.out.println(String.format("%s",res));
		
	}

}

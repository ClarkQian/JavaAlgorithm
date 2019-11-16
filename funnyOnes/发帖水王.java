import java.util.Arrays;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		int [] a = new int[]{1,8,2,8,3,8};
		int tag = a[0];
		int Count = 1;
		int candidateElement = a[a.length-1];
		int candidateCount = 1;
		for(int i = 1; i < a.length; i++){
			if(a[i] == candidateElement)
				candidateCount++;
			if(tag == a[i]){
				Count++;
			} else {
				if(Count == 0)
					tag = a[i];
				else
					Count--;
			}
		}
		
		if(candidateCount == a.length/2)
			tag = candidateElement;
		
		System.out.println(tag);

	}

}

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		int[]a1 = new int[100]; 
		
		
		int[] tmp = new int[]{1,4,5,7,9,10,11,12};
		for(int i = 0; i < tmp.length; i++){
			a1[i] = tmp[i];
		}
		

		int[]a2 = new int[]{2,4,6,8,10};
		
		
		
		
		int current = 8 + a2.length - 1;
		int p1 = 7;
		int p2 = a2.length-1;
		
		for(int i = current; i >= 0; i--){
			if(p1 >= 0 && p2 >= 0){
				if(a1[p1] >= a2[p2]){
					a1[i] = a1[p1];
					p1 --;
				} else {
					a1[i] = a2[p2];
					p2 --;
				}
			} else if(p1 < 0){
				a1[i] = a2[p2];
				p2--;
			}else if(p2 < 0){
				a1[i] = a1[p1];
			} else {
				continue;
			}
		}
		
		
		for (int i = 0; i < 8+a2.length-1; i++) {
			System.out.println(a1[i]);
			
		}
		
		
	}

}

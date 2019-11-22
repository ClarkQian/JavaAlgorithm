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

	
	
	
	/**
	 * @param args
	 */

	public static void main(String[] args) {
		Integer[]a = {3,32,321};
		Arrays.sort(a,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				String s1 = o1+""+o2;
				String s2 = o2+""+o1;
				return s1.compareTo(s2);
			}
		});
		
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < a.length; i++){
			sb.append(a[i]);
		}
		
		System.out.println(Integer.parseInt(sb.toString()));
		
		
	}

}

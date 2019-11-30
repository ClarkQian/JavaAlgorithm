import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	
	//对结果进行异或，如果我方是异或不为1的那么，必定赢
	//因为每一次修改都会打破原来的01局面
	public static boolean getResult(int[]a){
		
		int res = 0;
		
		for(int i =0; i < a.length; i++){
			res ^= a[i];
		}
		System.out.println(res);
		return res != 0;
		
		
	}

	public static void main(String[] args) {
		int[] a= {7,6,1};
		System.out.println(getResult(a));
	}

}

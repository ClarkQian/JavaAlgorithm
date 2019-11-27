import java.util.Scanner;

public class Main {
	
	public static String replacement(String a){
		return a.replaceAll("\\s", "%20");
		
	}
	
	public static String replacement2(char[]a, int length){
		int count = length;
		for(int i = 0 ;i < a.length; i++){
			if(a[i] == ' ')
				count += 2;
		}
		
		int lp = length - 1;
		int rp = count - 1;
		
		while(lp < rp){
			if(a[lp] != ' '){
				a[rp--] = a[lp--];
			} else {
				a[rp--] = '0';
				a[rp--] = '2';
				a[rp--] = '%';
				lp--;
			}
		}
		
		return new String(a,0,count);
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(replacement("Today is a good day!"));
		String str = "Today is a good day!";
		char[] a = new char[100];
		for(int i = 0; i < str.length(); i++){
			a[i] = str.charAt(i);
		}

		System.out.println(replacement2(a,str.length()));

	}
}

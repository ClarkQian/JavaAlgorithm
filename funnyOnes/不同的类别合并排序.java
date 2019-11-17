import java.io.ObjectInputStream.GetField;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Container implements Comparable<Container>{
	public String category = "";
	public double sum = 0;
	public Container(String category, double sum){
		this.category = category;
		this.sum = sum;
	}
	
	public void add(Container another){
		this.sum += another.sum;
	}

	@Override
	public int compareTo(Container o) {
		if(this.sum < o.sum)
			return 1;
		else if(this.sum == o.sum)
			return 0;
		else
			return -1;
		
	}
	
}

public class Main {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Container> tmp = new ArrayList<Container>();
		int n = sc.nextInt();
		for(int i = 0; i < n; i++){
			String category = sc.next();
			double sum = sc.nextInt();
			sum *= sc.nextDouble();
			Container ct = new Container(category, sum);
			boolean tag = true;
			for(int j = 0; j < tmp.size();j++){
				if(tmp.get(j).category.compareTo(category) == 0){
					tmp.get(j).add(ct);
					tag = false;
					break;
				}
					
			}
			if(tag){
				tmp.add(ct);
			}
		}
		
		Collections.sort(tmp);
		System.out.println("no");
		for(int i = 0; i < tmp.size();i++){
			System.out.println(tmp.get(i).category+" "+tmp.get(i).sum);
		}
		
	}

}

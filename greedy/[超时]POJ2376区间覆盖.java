import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	private static class Element implements Comparable<Element> {
		public int start;
		public int end;

		public Element(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int getStart() {
			return this.start;
		}

		public int getEnd() {
			return this.end;
		}

		@Override
		public int compareTo(Element o) {
			return this.start - o.start;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = 1;
		int r = sc.nextInt();
		ArrayList<Element> al = new ArrayList<Main.Element>();
		int count = 0;
		for (int i = 0; i < n; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			if(e < l){
				continue;
			}
			if(s > r)
				continue;
			
			al.add(new Element(s, e));
		}
		Collections.sort(al);
		while(l < r){
			if(al.size() == 0){
				System.out.println(-1);
				return;
			}
			
			int maxIndex = 0;
			int max = al.get(0).getEnd();
			for (int i = 1; i < al.size(); i++) {
				if(al.get(i).getStart()<= l){
					if(al.get(i).getEnd() > max){
						maxIndex = i;
						max = al.get(i).getEnd();
					}
				}
			}
			
			if(maxIndex == 0 && al.get(maxIndex).getStart()>l){
				System.out.println(-1);
				return;
			}
			
			count++;
			
			//update arrayList
			l = al.get(maxIndex).getEnd()+1;
			for(int i = 0; i < al.size(); i++){
				if(al.get(i).end <= l){
					al.remove(i);
				}
			}
			
		}
		
		System.out.println(count);

	}
}

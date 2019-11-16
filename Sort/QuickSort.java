public class QuickSort {

	public static void swap(int[] a, int src, int dst) {
		int tmp = a[src];
		a[src] = a[dst];
		a[dst] = tmp;
	}


	public static void quickSort(int[]a, String category){
		if(category == "oneway"){
			oneWayQuickSort(a, 0, a.length-1);
		}
		if(category == "twoway"){
			twoWayQuickSort(a, 0, a.length-1);
		}
		if(category == "threeway"){
			threeWayQuickSort(a, 0, a.length-1);
		}
		
	}
	public static void threeWayQuickSort(int[] a, int begin, int end) {

		if (end < begin)
			return;

		int[] edge = _partition3(a, begin, end);
		threeWayQuickSort(a, begin, edge[0] - 1);
		threeWayQuickSort(a, edge[1] + 1, end);

	}
	
	
	private static int[] _partition3(int[] a, int begin, int end) {
		int pivot = a[begin];
		int ep = begin;
		int sp = begin +1;
		int bp = end;
		while(sp <= bp){
			if(a[sp] < pivot){
				swap(a, ep, sp);
				ep++;sp++;
			} else if(a[sp] > pivot){
				swap(a, bp, sp);
				bp--;
			} else {
				sp++;
			}
		}
//		swap(a, begin, ep);
		
		//!!!!
		int[]res = new int[2];
		res[0] = ep;
		res[1] = bp;
		
		return res;
	}


	public static void twoWayQuickSort(int[] a, int begin, int end) {

		if (end < begin)
			return;

		int edge = _partition2(a, begin, end);
		twoWayQuickSort(a, begin, edge - 1);
		twoWayQuickSort(a, edge + 1, end);

	}
	
	private static int _partition2(int[] a, int begin, int end) {
		int pivot = a[begin];
		int lp = begin+1;
		int rp = end;
		while(lp <= rp){
			while(lp <= rp&& a[lp]<= pivot){
				lp++;
			}
			while(lp <= rp&& a[rp] > pivot){
				rp--;
			}
			if(lp < rp)
				swap(a,lp, rp);
		}
		
		swap(a, begin, rp);
		
		return rp;
	}


	public static void oneWayQuickSort(int[] a, int begin, int end) {

		if (end < begin)
			return;

		int edge = _partition(a, begin, end);
		oneWayQuickSort(a, begin, edge - 1);
		oneWayQuickSort(a, edge + 1, end);

	}

	private static int _partition(int[] a, int begin, int end) {
		int pivot = a[begin];
		int sp = begin + 1;
		int bigger = end;

		while (sp <= bigger) {
			if (a[sp] <= pivot)
				sp++;
			else {
				swap(a, sp, bigger);
				bigger--;
			}
		}
		
		swap(a, begin, bigger);

		return bigger;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[]a = new int[10];
		for (int i = 0; i < a.length; i++) {
			a[i] = 10;
		}
		
		quickSort(a, "threeway");
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
			
		}
		
		
		
		
		

	}

}

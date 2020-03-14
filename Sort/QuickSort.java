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
	
	/*
	 * ep is the pointer used to point to the begin of the equal
	 * sp is the scan pointer
	 * bp is the pointer uesd to point to the end of the equal(the same the head -1 of bigger sequence)
	 * */
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



//recommend

	private static void _quickSort3(int[] a, int n, int l, int r) {
		if(l >= r)
			return;
		
		int pivot = a[l];
		int lp = l + 1; // the left edge of j=
		int rp = r; // the right edge of =
		int sp = l + 1;
		
		while(sp <= rp){
			if(a[sp] < pivot){
				swap(a, sp, lp);
				sp++;
				lp++;
			} else if(a[sp] > pivot){
				swap(a, sp, rp);
				rp--;
			} else { // == 
				sp++;
			}
		}
		
		swap(a, l, lp-1);
		lp--;
		
		_quickSort3(a, n, l, lp-1);
		_quickSort3(a, n, rp+1, r);
		
		
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

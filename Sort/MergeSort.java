import java.util.Arrays;

public class MergeSort {

	public static void mergeSort(int[] a) {
		_mergeSort(a, 0, a.length - 1);
	}

	public static void _mergeSort(int[] a, int begin, int end) {

		if (begin >= end)
			return;

		int mid = begin + ((end - begin) >> 1);
		_mergeSort(a, begin, mid);
		_mergeSort(a, mid + 1, end);
		merge(a, begin, mid, end);

	}

	private static void merge(int[] a, int begin, int mid, int end) {
		int size = end - begin + 1;
		int[] aux = new int[size];
		int lp = begin;
		int rp = mid + 1;

		for (int i = 0; i < size; i++) {
			if (lp <= mid && rp <= end) {
				if (a[lp] <= a[rp]) {
					aux[i] = a[lp];
					lp++;
				} else {
					aux[i] = a[rp];
					rp++;
				}
			} else if (lp > mid) {
				aux[i] = a[rp];
				rp++;
			} else if (rp > end) {
				aux[i] = a[lp];
				lp++;
			} else {
				continue;
			}
		}

		for (int i = 0; i < size; i++) {
			a[begin + i] = aux[i];
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = new int[10];
		for (int i = 0; i < a.length; i++) {
			a[i] = 10-i;
		}

		String res = "";
		for (int i = 0; i < a.length; i++) {
			res += a[i] + " ";

		}

		mergeSort(a);

		String res1 = "";
		for (int i = 0; i < a.length; i++) {
			res1 += a[i] + " ";

		}

		System.out.println(res + "\n" + res1);
	}

}

//一段错误的代码
//		if(l >= r)
//			return;
//
//		int mid = l + ((r - l) >> 1);
//		System.out.printf("%s %s %s\n",l,mid,r);
//		_mergeSort(a, n, l, mid-1); // left sort
//		_mergeSort(a, n, mid, r); // right sort

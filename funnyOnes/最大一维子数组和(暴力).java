public class Main {
	public static void main(String[] args) {
		int[] a = new int[] { 1, -2, 3, 5, -2, 6, -1 };
		int sum = a[0];
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				int sum_tmp = MyTool.sum(a, i, j);
				if (sum_tmp > sum)
					sum = sum_tmp;
			}
		}
		System.out.println(sum);
	}
}

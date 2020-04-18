	public static boolean isPrime(int n) {
		for (int i = 2; i <= (int) (Math.sqrt(n)); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void testShow(int[] a, int cur) {

		if (cur == a.length) {
			int i = 0;
			for (; i < a.length; i++) {
				int tmp = a[i] + a[(i + 1) % a.length];
				if (isPrime(tmp) == false) {
					break;
				}
			}

			if (i == a.length && a[0] == 1) {
				for (int j = 0; j < a.length; j++) {
					System.out.printf("%d ", a[j]);
				}
			} else {
				return;
			}
			System.out.println();

		}

		for (int i = cur; i < a.length; i++) {
			swap(a, i, cur);
			testShow(a, cur + 1);
			swap(a, i, cur);

		}

	}

	public static void main(String[] args) {
		int n = 6;
		int[] a = new int[n];

		for (int i = 0; i < a.length; i++) {
			a[i] = i + 1;
		}

		testShow(a, 0);

	}

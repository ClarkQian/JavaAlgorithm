	private static int getMax(int[] a, int n) {
		int max = a[0];
		int tmp = a[0];
		for (int i = 1; i < n; i++) {
			if (tmp < 0) {
				tmp = a[i];
			} else {
				tmp += a[i];
			}

			if (tmp > max) {
				max = tmp;
			}
		}

		return max;

	}

	private static int traverseContainer(int[][] a, int n) {

		int max = a[0][0];

		int[] tmp = new int[a[0].length];

		for (int i = 0; i < n; i++) {
			Arrays.fill(tmp, 0);

			for (int j = i; j < n; j++) {
				for (int k = 0; k < tmp.length; k++) {
					tmp[k] += a[j][k];
				}

				int res = getMax(tmp, tmp.length);
				if (res > max)
					max = res;
			}
		}

		return max;

	}

	public static void main(String[] args) {
		int[][] a = new int[][] { 
				{ -1, -1, -1 },
				{ -100, -2, 2 }, 
				{ -1, -1, -1 } };
		System.out.println(traverseContainer(a, a.length));
	}

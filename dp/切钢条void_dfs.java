public static int max = 0;
	public static int tmpPrice = 0;
	public static int[] f = new int[100];

	// it is sorted in default
	public static void dfs(int left, int[] length, int price[]) {

		if (left == 0) {
			if (tmpPrice > max)
				max = tmpPrice;
		}

		for (int i = 0; i < length.length && left >= length[i]; i++) {
			tmpPrice += price[i];
			dfs(left - length[i], length, price);
			tmpPrice -= price[i];
		}

	}

public static int resMoney;

	public static void dfs(int n, int radix) {
		if (n == 0) {
			System.out.println(resMoney);
			System.exit(0);
		}
		if (n < 0)
			return;
//		System.out.println(n);
		for (int i = radix; radix <= n; radix *= 7) {
			for (int j = 5; j >= 0; j--) {
				resMoney += j;
				dfs(n - radix * j, radix * 7);
				resMoney -= j;
			}
		}

	}

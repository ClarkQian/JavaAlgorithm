	public static int dfs2(int left) {

		if (left == 0)
			return 0;

		int ans = 0; // 最高层的一个记录最大值的变量
		for (int i = 0; i < length.length && left >= length[i]; i++) {
			int v = price[i] + dfs2(left - length[i]); //这个分支的值
			ans = ans > v ? ans : v; //比较一下
		}

		return ans;

	}

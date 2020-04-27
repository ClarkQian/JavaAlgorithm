	public static int dfs2(int left) {
		if(f[left] != -1){
			return f[left];
		}
		if(left == 0)
			return 0;
		
		int ans = 0;

		for(int i =0; i < length.length && left >= length[i]; i++ ){
			int branch = price[i] + dfs2(left - length[i]);
			ans = ans > branch?ans:branch;
		}
		
		f[left] = ans;
		
		return ans;
	}

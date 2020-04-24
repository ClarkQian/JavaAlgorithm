public static int rec[][] = new int[10][10];//fill with -1 as initialization
	public static int solve(int w, Element2[] container, int cur) {

		if (w <= 0)
			return 0;
		if (cur == container.length)
			return 0;

		int ans;
		
		//查询是否有结果已经存在
		if(rec[w][cur] >0){
			return rec[w][cur];
		}
		
		
		// 不选
	
	
		int res2 = 0 + solve(w, container, cur + 1);

		// 还装的下
		if (w - container[cur].weight >= 0) {
			int res1 = container[cur].value
					+ solve(w - container[cur].weight, container, cur + 1);
			ans =  res1 > res2 ? res1 : res2;
		} else {
			ans = res2;
		}
		
		
		//这个分支出结果的时候记录
		rec[w][cur] = ans;
		return ans;
	}

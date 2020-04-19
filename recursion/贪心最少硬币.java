	public static int count6 = 0;
	public static int price[] = new int[]{500,100,50,10,5,1};
	private static void getMinCoins(int num[], int cur, int n) {
		
		if(n < 0)
			return;
		
		if (n == 0){
			System.out.println(count6);
			System.exit(0);
		}

		if (cur == num.length) {
			return;
		}
	
		int maxRadix = n / price[cur];
		for (int i = num[cur]< maxRadix?num[cur]:maxRadix; i >= 0; i--) {
			System.out.printf("extract%d*%d\n",price[cur],i);
			count6 += i;
			getMinCoins(num, cur + 1, n - i * price[cur]);
			count6 -= i;
		}

	}

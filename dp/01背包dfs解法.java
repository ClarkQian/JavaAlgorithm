

//添加一个max判断就可以了
	public static int value;

	public static void solve(int w, Element2[] container, int cur) {

		if (w == 0) {
			System.out.println(value);
			return;
		}
		if (w < 0)
			return;
		if (cur == container.length) {
			return;
		}


		// choose current

		value += container[cur].value;
		solve(w - container[cur].weight, container, cur + 1);
		value -= container[cur].value;

		// not
		solve(w, container, cur + 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Element2[]contianer = new Element2[n];
		for(int i = 0; i < n; i++){
			contianer[i] = new Element2(sc.nextInt(), sc.nextInt());
		}
		int w = sc.nextInt();
		solve(w, contianer, 0);
		
	}



	public static int solve2(int w, Element2[] container, int cur) {

		if (w <= 0)
			return 0;
		if (cur == container.length)
			return 0;

		// 不选
		int res2 = 0 + solve2(w, container, cur + 1);

		// 还装的下
		if (w - container[cur].weight >= 0) {
			int res1 = container[cur].value
					+ solve2(w - container[cur].weight, container, cur + 1);
			return res1 > res2 ? res1 : res2;
		} else {
			return res2;
		}

	}

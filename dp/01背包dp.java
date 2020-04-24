public static int sum = 0;

	public static int solve2(int w, Element2[] container, int cur) {

		if (w == 0) {
			return sum;

		}
		if (w < 0)
			return 0;
		
		if (cur == container.length)
			return 0;


		sum += container[cur].value;
		int res1 = solve2(w - container[cur].weight, container, cur + 1);
		sum -= container[cur].value;

		int res2 = solve2(w, container, cur + 1);

		return res1 > res2 ? res1 : res2;

	}

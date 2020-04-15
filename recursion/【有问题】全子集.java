	public static Stack<Integer> stack1 = new Stack<Integer>();

	private static void dfs(int[] a, int k, int cur) {

		if (cur >= a.length)
			return;

		for (int i = cur; i < a.length; i++) {
			int tmp = a[i];
			k = k - tmp;
			System.out.printf("正在检查以%d为基准的循环位置为%d的元素的结果, 如果减去得到的结果将会是%d\n", cur, i,k);
			if (k > 0) {
				System.out.printf("正常推入%d\n",a[i]);
				stack1.push(a[i]);
				System.out.println("我已经推进去了，这个时候stack里面有");
				for (Integer elem : stack1) {
					System.out.printf("%d ", elem);
				}
				System.out.println();
				dfs(a, k, cur + 1);
				stack1.pop();
				k += tmp;
			} else if (k < 0) {
				System.out.printf("加上就负了\n");
				k += tmp;
			} else {
				System.out.println("遇到结果了");
				System.out.println("yes");
				for (Integer elem : stack1) {
					System.out.printf("%d ", elem);
				}
				System.out.println();
				System.exit(0);
			}

		}

	}

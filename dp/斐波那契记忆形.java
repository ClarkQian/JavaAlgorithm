
public class Main {

	public static int rec[] = new int[1000];

	public static int fibonacci1(int n) {

		if (n == 1 || n == 2) {
			return 1;
		}

		if (rec[n] > 0)
			return rec[n];

		int part1 = fibonacci1(n - 1);
		int part2 = fibonacci1(n - 2);

		rec[n] = part1 + part2;

		return part1 + part2;
	}
	public static int fibonacci2(int n) {

		if (n == 1 || n == 2) {
			return 1;
		}

		return fibonacci2(n-1) + fibonacci2(n-2);
	}

	
	
	
	public static void main(String[] args) {
		long startTime = System.nanoTime(); // 获取开始时间
		System.out.println(fibonacci1(40));
		long endTime = System.nanoTime(); // 获取结束时间
		System.out.println("程序运行时间： " + (endTime- startTime) + "ns");

		long startTime2 = System.nanoTime(); // 获取开始时间
		System.out.println(fibonacci2(40));
		long endTime2 = System.nanoTime(); // 获取结束时间
		System.out.println("程序运行时间： " + (endTime2- startTime2) + "ns");
	}
}


//性能差距
//	102334155
//	程序运行时间： 159200ns
//	102334155
//	程序运行时间： 264417000ns


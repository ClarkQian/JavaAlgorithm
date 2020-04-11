	static long x;
	static long y;

	public static long ext_gcd(long a, long b) {
		if (b == 0) {
			x = 1;
			y = 0;
			return a;
		}
		long res = ext_gcd(b, a % b);
		long x1 = x;
		x = y;
		y = x1 - a / b * y;
		return res;

	}

	public static long linearEquation(long a, long b, long m) throws Exception {
		long d = ext_gcd(a, b);
		if (m % d != 0)
			throw new Exception("no solution");
		long n = m / d;
		x *= n;
		y *= n;
		return d;

	}
	//获取不同的解，此消彼长   x = x0 + b/gcc*t        y = y0 - a/gcc*t

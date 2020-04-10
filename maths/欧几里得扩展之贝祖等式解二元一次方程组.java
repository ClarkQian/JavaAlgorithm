
	public static int getGCD(int m, int n){
		if(n == 0)
			return m;
		else
			return getGCD(n, m%n);
	}
	
	public static Stack<Integer> stack = new Stack<Integer>();
	
	public static int[]goBack(int a, int b){
		if(stack.empty()){
			return new int[]{a,b};
		}
		
		int b1 = stack.pop();
		int a1 = stack.pop();
		//print tmp value
		System.out.printf("%d %d %d %d\n", a1, b1, b,a - (a1/b1)*b);
		return goBack(b, a - (a1/b1)*b);
		
	}
	
	// ax + by = kd(d为gcd否则没有整数解)
	public static int[] resolve(int a, int b){
		
		if(b == 0) return goBack(a, b);
		
		stack.push(a);
		stack.push(b);
		
		return resolve(b, a%b);
		
		
		
	}
	
	
	public static void main(String[] args) {
		int[]res = resolve(2, 7); 
		
		System.out.printf("%d %d",res[0],res[1]);
	}

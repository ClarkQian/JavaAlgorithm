
public static int rec[] = new int[1000];
public static int getStair1(int n){
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		
		return getStair1(n-1) + getStair1(n-2) + getStair1(n-3);
	}
	
	public static int getStair2(int n){
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		if(rec[n] > 0)
			return rec[n];
		
		int part1 = getStair2(n-1);
		int part2 = getStair2(n-2);
		int part3 = getStair2(n-3);
		
		int ans = part1 + part2 + part3;
		
		rec[n] = ans;
		return ans;
		
	}
  
  
  
//2555757
//程序运行时间： 17511200ns
//2555757
//程序运行时间： 22200ns

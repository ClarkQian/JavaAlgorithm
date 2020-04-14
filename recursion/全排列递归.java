	public static void getFullPermutation(int[]a, int cur){
		
		if(cur >= a.length - 1){
			show(a);
			return;
			
		}
		
		
		for(int i = cur; i < a.length; i++){
			swap(a, cur, i);
			getFullPermutation(a, cur+1);
			swap(a, cur, i);

		}
		
	}

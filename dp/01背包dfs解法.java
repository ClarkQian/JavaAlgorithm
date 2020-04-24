

//添加一个max判断就可以了
public static int value;
	public static void solve(int w, Element2[] container, int cur) {
		
		if(cur  == container.length){
			return;
		}
		
		if(w == 0){
			System.out.println(value);
			return;
		}
		if(w < 0)
			return;
		
		// choose current

		value += container[cur].value;
		solve(w - container[cur].weight, container, cur+1);
		value -= container[cur].value;
		
		//not 
		solve(w, container, cur+1);
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

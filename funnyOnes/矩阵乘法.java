	public static int[][] multiply(int[][]a, int[][]b){
		
		int res[][] = new int[a.length][b[0].length];
		
		for(int col = 0; col < b[0].length; col++){
			for(int row = 0; row < a.length; row++){
				for(int i = 0; i < a[0].length; i++){
					res[row][col] += a[row][i]*b[i][col];
				}
			}
		}
		
		
		return res;
		
	}

	public static void main(String[] args) {
		int[][] a = new int[][] { { 1, 0, 3, -1 }, { 2, 1, 0, 2 }, };

		int[][] b = new int[][] { { 4, 1, 0 }, { -1, 1, 3 }, { 2, 0, 1 },
				{ 1, 3, 4 } };

		int[][] res = multiply(a, b);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}

	}

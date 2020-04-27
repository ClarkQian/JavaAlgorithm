public static void dp(int n) {

		int[][] f1 = new int[10][n + 1];
		f1[0][1] = 1;
		for (int i = 0; i <= n; i++) {
			f1[0][i] = i;
			if(i < 10)
				f1[i][0] = 0;
			if(i > 0 && i < 10){
				f1[i][1] = 1;
			}
		}

		
		

		for (int j = 2; j <= n; j++) {
			for (int i = 1; i < n; i++) {
				int step = j / (i + 1);
//				System.out.printf("%d:%d -> %d\n", i + 1, j + 1, step);
				if (step == 0) {
					f1[i][j] = f1[i-1][j];
					break;
				}
				int[] tmp = new int[step + 1];
				for (int k = 0; k <= step; k++) {// choose k
					tmp[k] = f1[i - 1][j - k * (i+1)] + k * price[i];
				}
				f1[i][j] = getMax(tmp);
			}
		}

		// show table
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= n; j++) {
				System.out.printf("%4d ", f1[i][j]);
			}
			System.out.println();
		}

	}

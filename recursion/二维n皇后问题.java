	public static int count3 = 0;

	public static void show(boolean[][] table) {
		System.out.println("__");
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				if (table[i][j] == false) {
					System.out.printf("0");
				} else {

					System.out.printf("1");
				}
			}
			System.out.println();
		}
		System.out.println("——");
	}

	public static void nQueen(boolean[][] checkerboard, int x, int n) {

		if (x == n) {
			count3++;
//			show(checkerboard);
			return;
		}

		for (int i = 0; i < n; i++) {
			checkerboard[x][i] = true;
			if (check(checkerboard, x, i, n) == true) {
				nQueen(checkerboard, x + 1, n);
			}
			checkerboard[x][i] = false;
		}

	}

	private static boolean check(boolean[][] checkerboard, int x, int y, int n) {
//		show(checkerboard);
		int count_y = 0;
		int count_diagonal_s = 0;
		int count_diagonal_r = 0;
		for (int i = 0; i < n; i++) {
			if (checkerboard[i][y] == true) {
				count_y++;
			}
			if (count_y >= 2) {
//				System.out.println(1);
//				System.out.println(count_y);
				return false;
			}

		}
		// bias
		int tmp_x = x;
		int tmp_y = y;
		while (tmp_x >= 0 && tmp_y >= 0) {
			if (checkerboard[tmp_x--][tmp_y--] == true) {
				count_diagonal_s++;
			}
		}
		tmp_x = x+1;
		tmp_y = y+1;
		while (tmp_x < n && tmp_y < n) {
			if (checkerboard[tmp_x++][tmp_y++] == true) {
				count_diagonal_s++;
			}
		}

		if (count_diagonal_s >= 2){
//			System.out.println(count_diagonal_s);
//			System.out.println(2);
			return false;

		}


		tmp_x = x;
		tmp_y = y;
		while (tmp_x >= 0 && tmp_y < n) {
			if (checkerboard[tmp_x--][tmp_y++] == true) {
				count_diagonal_r++;
			}
		}

		tmp_x = x+1;
		tmp_y = y-1;
		while (tmp_x < n && tmp_y >= 0) {
			if (checkerboard[tmp_x++][tmp_y--] == true) {
				count_diagonal_r++;
			}
		}
		
		if(count_diagonal_r >=2){
//			System.out.println(3);
			return false;
			
		}
		
		
		return true;

	}

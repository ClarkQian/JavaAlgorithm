	public static void solve(char[][] table, int x, int y) {

		if (x == 9) {
			show(table);
			System.exit(0);
		}

		if (table[x][y] == '0') {
			for (int i = 1; i <= 9; i++) {
				boolean judge = check2(table, x, y, (char)(i+'0'));
				if (judge == true) {
					table[x][y] = (char) ('0' + i);
					solve(table, x + (y + 1) / 9, (y + 1) % 9);
				}
			}

			// backTrace
			table[x][y] = '0';

		} else {
			solve(table, x + (y + 1) / 9, (y + 1) % 9);
		}

	}

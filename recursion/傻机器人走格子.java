	public static int droidGrid(int x, int y) {

		if (x <= 0)
			return 0;
		if (y <= 0)
			return 0;
		if (x == 1 && y == 1)
			return 1;

		//or if (x == 1 || y == 1) return 1; //much more better
		return droidGrid(x - 1, y) + droidGrid(x, y - 1);
	}
  //iteration: fill the grid with number // from lower-right to top-left
  public static int droidGridIteration(int x, int y) {
		int[][] a = new int[x][y];
		a[0][0] = -1;

		// initialize
		for (int i = x - 1; i >= 0; i--) {
			a[i][y - 1] = 1;
		}

		for (int i = y - 1; i >= 0; i--) {
			a[x-1][i] = 1;
		}

		while (a[0][0] == -1) {
			x--;
			y--;
			if (x < 0)
				x++;
			if (y < 0)
				y++;
			for (int i = x - 1; i >= 0; i--) {
				a[i][y - 1] = a[i][y]+a[i+1][y-1];
			}

			for (int i = y - 1; i >= 0; i--) {
				a[x-1][i] = a[x][i]+a[x-1][i+1];
			}

		}

		return a[0][0];
	}

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

		// initialize fill up
		for (int i = x - 1; i >= 0; i--) {
			a[i][y - 1] = 1;
		}

		for (int i = y - 1; i >= 0; i--) {
			a[x-1][i] = 1;
		}
		
	  	//using inital elements to fill whole grid.
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

	  	//much better one
	  	for(int i = 2; i <= m; i++){
			for(int j = 2; j <= n; j++){
				state[i][j] = state[i][j-1]+state[i-1][j];
			}
		}
	  
		return a[0][0];
	}

题目：

　　有一个大小为 N*M 的园子，雨后积起了水。八连通的积水被认为是连接在一起的。请求出园子里总共有多少水洼？（八连通指的是下图中相对 W 的*的部分）

***
*W*
***
　　限制条件：N, M ≤ 100

　　样例输入：

N=10, M=12
　　园子如下图（'W'表示积水， '.'表示没有积水）

复制代码
W........WW.
.WWW.....WWW
....WW...WW.
.........WW.
.........W..
..W......W..
.W.W.....WW.
W.W.W.....W.
.W.W......W.
..W.......W.
复制代码
　　输出：

1
3



public static int count = 0;

	
	public static void test8Wrap(char[][]pond){
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 12; j++){
				if(pond[i][j] == 'W'){
					count++;
					test8(pond, i, j, i, j);
				}
			}
		}
	}
	
	public static void test8(char[][] pond, int x, int y, int x_1, int y_1) {
		
		
		if (x < 0 || x >= pond.length || y < 0 || y >= pond[0].length) {
			return;
		}
		System.out.printf("进入%d:%d,验证位置%d:%d\n", x, y, x_1, y_1);
		if ((x != x_1 || y != y_1) && pond[x][y] == '.') {
			System.out.printf("终止于验证%d:%d\n", x_1, y_1);
			return;
		}

		if (pond[x][y] == 'W') {
			System.out.printf("回填%d:%d 验证:%d:%d\n", x, y, x_1, y_1);
			pond[x][y] = '.';
			// count++;
			// search in 8 directions

			test8(pond, x - 1, y - 1, x, y);
			test8(pond, x - 1, y, x, y);
			test8(pond, x - 1, y + 1, x, y);
			test8(pond, x, y - 1, x, y);
			test8(pond, x, y + 1, x, y);
			test8(pond, x + 1, y - 1, x, y);
			test8(pond, x + 1, y, x, y);
			test8(pond, x + 1, y + 1, x, y);
		} else {
//			test8(pond, x + (y + 1) / 12, (y + 1) % 12, x + (y + 1) / 12,
//					(y + 1) % 12);
		}
	}

	public static void main(String[] args) {

		String a = "W........WW.\n .WWW.....WWW\n ....WW...WW.\n .........WW.\n .........W..\n ..W......W..\n .W.W.....WW.\n W.W.W.....W.\n .W.W......W.\n ..W.......W.\n ";
		String[] t = a.split("\n ");
		char[][] t1 = new char[10][12];
		for (int i = 0; i < t.length; i++) {
			t1[i] = t[i].toCharArray();
		}

		 for (int i = 0; i < 10; i++) {
		 for (int j = 0; j < 12; j++) {
		 System.out.printf("%c", t1[i][j]);
		 }
		 System.out.println();
		 }

		test8Wrap(t1);
		System.out.println(count);
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 for (int i = 0; i < 10; i++) {
		 for (int j = 0; j < 12; j++) {
		 System.out.printf("%c", t1[i][j]);
		 }
		 System.out.println();
		 }
		 System.out.println(count);
	}

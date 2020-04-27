	static void dp2(int n) {
		vs[0] = 0;
		for (int i = 1; i <= n; i++) {// 拥有钢条的长度
			for (int j = 1; j <= i; j++) {// 保留j为整段
				vs[i] = max(vs[i],price[j-1]+vs[i - j]);
			}
		}

	}
  //将钢条分成两段，一段用之前的最优，一段用目前的价格表进行对比
//vs是新创建的局部最优
//price:是题目给出的价格表

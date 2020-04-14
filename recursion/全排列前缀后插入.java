	public static void getFullpermutation2(Integer[] a, ArrayList<Integer> res) {

		if (res.size() == a.length) {
			count2++;
			System.out.println(res.toString());
			return;
		}

		for (int i = 0; i < a.length; i++) {
			int index = a[i];
			if (!res.contains(index)) {//简易写法，如果存在重复，要写一个计数判断函数
				ArrayList<Integer> al = (ArrayList<Integer>) res.clone();
				al.add(index);
				getFullpermutation2(a, al);
			}
		}

	}

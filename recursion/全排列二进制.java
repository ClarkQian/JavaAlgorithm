	public static ArrayList<String> getFullPermutation(String a) {
		int n = a.length();
		ArrayList<String> al = new ArrayList<String>();
		int start = (int) (Math.pow(2, n) - 1);
		for (; start >= 1; start--) {
			String tmp = "";
			for (int i = n-1; i >= 0; i--) {
				if (((start >> i) & 1) == 1) {
					tmp += a.charAt(i);
				}
			}
			al.add(tmp);

		}
		return al;

	}

public static void main(String[] args) {

		int a = 8;
		StringBuilder src = new StringBuilder(Integer.toString(a, 3));
		src.reverse();
		StringBuilder counter = new StringBuilder();

		for (int i = 0; i < src.length(); i++) {
			if (src.charAt(i) <= '1') { //0, 1不动
				counter.append('0');
			} else if (src.charAt(i) == '2') { // 2右盘+1,左边进位
				counter.append('1');
				src.setCharAt(i, '0');
				if (i < src.length() - 1) {
					src.setCharAt(i + 1, (char) (src.charAt(i + 1) + 1));
				} else {// the last one
					src.append('1');
				}
			} else { // 3        收到进位溢出， 进位
				counter.append( '0');
				src.setCharAt(i, '0');
				if (i < src.length() - 1) {
					src.setCharAt(i + 1, (char) (src.charAt(i + 1) + 1));
				} else {// the last one
					src.append('1');
				}

			}

		}

		for (int i = 0; i < src.length(); i++) {
			if (src.charAt(i) == '1') {
				System.out.printf("%d", (int) Math.pow(3, i));
			}
		}
		for (int i = 0; i < counter.length(); i++) {
			if (counter.charAt(i) == '1') {
				System.out.printf("-%d", (int) Math.pow(3, i));
			}
		}

	}

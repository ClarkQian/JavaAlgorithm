	public static int count5 = 0;

	public static void hardSeq(String seq, int n, int l) {

		for (char a = 'A'; a < 'A' + l; a++) {
			String newOne = seq;
			newOne += a;
			if (check(newOne) == true) {
//				System.out.println(newOne);
				count++;
				if (count == n) {
					System.out.println(newOne);
					System.exit(0);
				}

				hardSeq(newOne, n, l);

			}
		}

	}

	private static boolean check(String seq) {
		int index = seq.length() - 1;
		for (int breadth = 1; breadth <= seq.length() / 2; breadth++) {
//			System.out.printf("%d:%d\n",index - breadth + 1, index + 1);
			String subEnd = seq.substring(index - breadth + 1, index + 1);
//			System.out.printf("%d:%d\n", index - breadth + 1 - breadth, index - breadth+1);
			String prefixStart = seq.substring(index-breadth+1-breadth,index-breadth+1);
//			System.out.println(subEnd.length());
//			System.out.printf("%s | %s\n",subEnd, prefixStart);
//			System.out.println(subEnd == prefixStart);
			if(subEnd.compareTo(prefixStart) == 0){
				return false;
			}
		}
		return true;
	}

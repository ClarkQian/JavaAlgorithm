public class Main {

	public static StringBuilder sb = new StringBuilder();

	public static void solve(String a, int index1, String b, int index2) {

		if(index1 == a.length() || index2 == b.length()){
			System.out.println(sb.toString());
			System.exit(0);
		}

		
		for (int i = index1; i < a.length(); i++) {

			for (int j = index2; j < b.length(); j++) {
//				System.out.printf("%d %d\n",i,j);
				if (a.charAt(i) == b.charAt(j)) {
					// partition
					sb.append(a.charAt(i));
					solve(a, i + 1, b, j + 1);
					break;
				} else {
					continue;
				}

			}

		}

	}

	public static void main(String[] args) {
		String a = "AB34C";
		String b = "A1BC2";
		
		solve(a, 0, b, 0);
		
		
		System.out.println(sb.toString());
	}
}

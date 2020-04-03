	public static class Element implements Comparable<Element> {

		int index;
		String value;

		public Element(int index, String value) {
			this.index = index;
			this.value = value;
		}

		@Override
		public int compareTo(Element o) {

			return this.value.compareTo(o.value);
		}

	}

	public static Element[] getSuffixArray(String src) {

		Element[] elems = new Element[src.length()];
		for (int i = 0; i < src.length(); i++) {
			elems[i] = new Element(i, src.substring(i));
		}

		Arrays.sort(elems);

		return elems;
	}

	public static int find2(String a, String pattern) {

		Element[] sa = getSuffixArray(a);

		int l = 0;
		int r = a.length() - 1;
		int mid;
		while (l <= r) {
			mid = l + ((r - l) >> 1);
			System.out.printf("%d   %d    %d\n",l,mid ,r);
			if (sa[mid].value.length() < pattern.length()) {
				int compRes = pattern.compareTo(sa[mid].value);
				if (compRes < 0) {
					r = mid - 1;
				} else if (compRes == 0) {
					System.out.println("Impossible");
				} else {
					l = mid + 1;
				}
			} else {
				String tmp = sa[mid].value.substring(0, pattern.length());
				int compRes = pattern.compareTo(tmp);
				if (compRes == 0)
					return sa[mid].index;
				else if (compRes > 0) {
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			}

		}

		return -1;
	}

	public static void main(String[] args) {

		Element[] a = getSuffixArray("ABCABDA");
		for(int i = 0;i < a.length;i++){
			System.out.println(a[i].value);
		}
		System.out.println(find2("ABCABDA", "DA"));

	}

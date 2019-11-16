public static int binarySearch(int[] a, int length, int target) {
		int begin = 0;
		int end = length - 1;
		while (begin <= end) {
			int mid = begin + ((end - begin) >> 1);
			if (target < a[mid])
				end = mid - 1;
			else if (target > a[mid])
				begin = mid + 1;
			else
				return mid;
		}
		return -1;

	}
	

	public static int recursiveBinarySearch(int[] a, int target) {
		return _binarySearch(a, 0, a.length - 1, target);
	}

	private static int _binarySearch(int[] a, int begin, int end, int target) {

		if (end < begin)
			return -1;

		int mid = begin + ((end - begin) >> 1);

		if (target < a[mid])
			return _binarySearch(a, begin, mid - 1, target);
		else if (target > a[mid])
			return _binarySearch(a, mid + 1, end, target);
		else
			return mid;
	}

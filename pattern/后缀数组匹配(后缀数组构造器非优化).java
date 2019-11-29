import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

	
	//非优化的构造排序后缀子串的方法
	public static suffContainer[] getSuffArray(String a) {
		suffContainer[] suffArray = new suffContainer[a.length()];

		for (int i = 0; i < suffArray.length; i++) {
			suffContainer container = new suffContainer(a.substring(i), i);
			suffArray[i] = container;
		}

		Arrays.sort(suffArray);
		return suffArray;

	}

	public static void showIndexOf(String a, String pattern) {

		suffContainer[] suffContainers = getSuffArray(a);
		int l = 0;
		int r = a.length() - 1;

		//二分查找法
		while (l <= r) {
			int mid = l + ((r - l) >> 1);
			suffContainer midItem = suffContainers[mid];
			String src = midItem.stuffStr;
			if (pattern.length() < src.length()) {
				src = src.substring(0, pattern.length());
				System.out.println(String.format("切割字符串至%s", src)); 
				System.out.println(String.format("匹配字符串为%s", pattern));
			}

			if (pattern.compareTo(src) == 0) {
				System.out.println(midItem.index);
				break;
			} else if (pattern.compareTo(src) < 0) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
	}

	public static void main(String[] args) {
		// String a = "ABABABABB";
		// suffContainer[] suffArray = getSuffArray(a);
		// for (suffContainer suffContainer : suffArray) {
		// System.out.println(suffContainer.stuffStr+" "+suffContainer.index);
		//
		// }

		// System.out.println("abc".substring(0,1));
		String a = "abcdef";
		String pattern = "des";

		showIndexOf(a, pattern);

	}

	
	//用来存放后缀子串，和对应的起始位置的index
	static class suffContainer implements Comparable<suffContainer> {

		public String stuffStr = null;
		public Integer index;

		public suffContainer(String stuffStr, Integer index) {
			this.stuffStr = stuffStr;
			this.index = index;
		}

		@Override
		public int compareTo(suffContainer o) {
			return this.stuffStr.compareTo(o.stuffStr);
		}

	}
}

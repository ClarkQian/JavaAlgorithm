import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		int n = 5;
		String raidx_3 = Integer.toString(n, 3);
		StringBuilder sb_raidx_3 = new StringBuilder(raidx_3);
		ArrayList<Integer> resList = new ArrayList<Integer>();

		for (int i = sb_raidx_3.length() - 1; i >= 0; i--) {
			if (sb_raidx_3.charAt(i) == '0' || sb_raidx_3.charAt(i) == '1') {
				resList.add(sb_raidx_3.charAt(i) - 48);
			} else if (sb_raidx_3.charAt(i) == '2') {
				// System.out.println("yes");
				resList.add(-1);
				if (i - 1 < 0) {
					resList.add(1);
					break;
				} else {
					sb_raidx_3.setCharAt(i - 1,
							(char) (sb_raidx_3.charAt(i - 1) + 1));
				}
			} else if (sb_raidx_3.charAt(i) == '3') {
				resList.add(0);
				sb_raidx_3.setCharAt(i - 1,
						(char) (sb_raidx_3.charAt(i - 1) + 1));
			} else {
				System.out.println("else");
			}
		}
		int point = 0;
		for (int i = 0; i < resList.size(); i++) {
			System.out.print((int) (resList.get(i) * Math.pow(3, point)) + " ");
			point++;
		}
		System.out.println();

	}

}

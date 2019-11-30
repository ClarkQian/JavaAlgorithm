import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	//递归
	public static HashSet<HashSet<String>> getSubSet2(String[] src){
		return _getSubSet2(src, src.length-1);
	}
	
	public static HashSet<HashSet<String>> _getSubSet2(String[] src, int index){ 
		
		HashSet<HashSet<String>> hs_new = new HashSet<HashSet<String>>();
		if(index == 0){
			hs_new.add(new HashSet<String>());
			HashSet<String> toBeAddObj = new HashSet<String>();
			toBeAddObj.add(src[index]);
			hs_new.add(toBeAddObj);
			
			return hs_new;
		}
		HashSet<HashSet<String>> hs_old = _getSubSet2(src, index-1);
		
		for(HashSet<String> e:hs_old){
			HashSet<String>hs_new_element = (HashSet<String>) e.clone();
			hs_new_element.add(src[index]);
			hs_new.add(e);
			hs_new.add(hs_new_element);
		}

		return hs_new;
		
	}
	
	
	//递推
	public static HashSet<String> getSubSet(String[] src) {
		HashSet<String> hs = new HashSet<String>();

		hs.add("{}");

		for (int i = 0; i < src.length; i++) {
			HashSet<String> hs_new = new HashSet<String>();
			for (String e : hs) {
				hs_new.add(e);
				hs_new.add(e.replaceAll("}", "," + src[i] + "}"));
			}
			hs = hs_new;
		}
		for (String e : hs) {
			e.replace("{,", "{");
		}
		return hs;

	}

	public static void main(String[] args) {
		// HashSet<String> hs = getParathesis(2);
		// for(String e: hs){
		// System.out.println(e);
		// }
		HashSet<HashSet<String>> hs = getSubSet2(new String[] { "A", "B", "C" });
		for (HashSet<String>e : hs) {
			System.out.println(e);
		}
	}
}

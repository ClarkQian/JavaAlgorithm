import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	//下一个是在上一个的基础上添加得到的
	//添加括号
	
		//二进制选择法
	public static HashSet<HashSet<String>> getSubSet3(String[]src){
		
		HashSet<HashSet<String>> res = new HashSet<HashSet<String>>();

		for(int i = 0; i <= Math.pow(2, src.length)-1; i++){
			HashSet<String> tmp = new HashSet<String>();
			for(int j = 0; j < src.length; j++){
				if(((i>>j)&1) == 1){
					tmp.add(src[j]);
				}
			}
			res.add(tmp);
		}
		
		
		
		return res;
		
	}
	
	
	
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

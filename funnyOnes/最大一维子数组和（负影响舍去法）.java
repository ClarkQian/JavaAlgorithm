public class Main {
	public static int getMax(int[]a){
		
		int max = a[0];
		for(int i = 1 ;  i < a.length; i++){
			if(a[i] > max)
				max = a[i];
		}
		
		//碰到负数累加，说明对后面的增长是没有益处的（但是要考虑之前的总和是不是<0）,重新从下一个位置开始定位
		l:for (int i = 0; i < a.length; i++) {
			int tmp = a[i];
			for(int j = i+ 1; j <a.length; j++){
				tmp += a[j];
				if(tmp < 0 && tmp < max){
					i = j+1;
					i--;
					continue l;
				} else {
					if(tmp > max)
						max = tmp;
				}
					
			}
		}
		
		
		
		return max;
	}
	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 4, -2, 6, -1 };
		System.out.println(getMax(a));
	}
}

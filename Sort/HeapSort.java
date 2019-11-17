import java.io.ObjectInputStream.GetField;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	
	public static void makeMaxHeap(int[]a, int root, int length){
		
		int lchild = 2*root+1;
		int rchild = 2*root+2;

		if(lchild <= length-1)
			makeMaxHeap(a, lchild, length);
		if(rchild <= length -1)
			makeMaxHeap(a, rchild, length);
		
		if(lchild <= length-1){
			int max = a[lchild];
			int index = lchild;
			if(rchild<=length-1){
				if(a[rchild] > max){
					max = a[rchild];
					index = rchild;
				}
				
			}
			if(a[root] < max){
//				System.out.println(String.format("此时的最小值为%d,将节点%d与节点%d交换",a[index],a[root], a[index]));
				MyTool.swap(a, root, index);
				if(2*index-1 <= length)
					makeMinHeap(a, index, length);
			}
		}else{
			return;
		}
			
		
	}

	public static void makeMinHeap(int[]a, int root, int length){
		
		int lchild = 2*root+1;
		int rchild = 2*root+2;

		if(lchild <= length-1)
			makeMinHeap(a, lchild, length);
		if(rchild <= length -1)
			makeMinHeap(a, rchild, length);
		
		if(lchild <= length-1){
			int min = a[lchild];
			int index = lchild;
			if(rchild<=length-1){
				if(a[rchild] < min){
					min = a[rchild];
					index = rchild;
				}
				
			}
			if(a[root] > min){
//				System.out.println(String.format("此时的最小值为%d,将节点%d与节点%d交换",a[index],a[root], a[index]));
				MyTool.swap(a, root, index);
				if(2*index-1 <= length)
					makeMinHeap(a, index, length);
			}
		}else{
			return;
		}
			
		
	}
	
	public static void heapSort(int[]a){
		makeMaxHeap(a, 0, a.length);
		_heapSort(a, a.length);
	}
	
	public static void _heapSort(int[] a, int length){
		
		if(length <= 1)
			return;
		
		MyTool.swap(a, 0, length-1);
		makeMaxHeap(a, 0, length-1);
		_heapSort(a, length-1);
		
	}
	
//	public static void printTree(int[]a){
//		int length = a.length;
//		
//		
//		
//		
//		
//		
//	}
	
	/**
	 * @param args
	 */

	public static void main(String[] args) {
		int a[] = new int[]{12,56,34,43,4,1,15,2,23};
		heapSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
			
		}

	}

}

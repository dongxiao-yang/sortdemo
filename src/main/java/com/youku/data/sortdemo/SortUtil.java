package com.youku.data.sortdemo;

import java.util.Arrays;

public class SortUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int[] a = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
		// 14,
		// 15, 16, 17, 18, 19, 20 };

		int[] a = new int[] { 10, 32, 44, 65, 78, 87, 76, 54, 43, 34, 56, 99,
				9, 3, 4, 2, 7, 1, 6,60,47,67};
		int[] a2 = new int[] { 10, 32, 44, 65, 78, 87, 76, 54, 43, 34, 56, 99,
				9, 3, 4, 2, 7, 1, 6,60 };
		// [10, 6, 1, 7, 2, 4, 3, 9, 43, 34, 56, 99, 54, 76, 87, 78, 65, 44, 32]
		
		int[] a3 = new int[] { 10,15,14,13,9 };

		// int[] ret = bubble_sort(a);

//		quick_sort(a2, 0, a2.length - 1);
//		
//		quick_sort2(a, 0, a.length - 1);
//
//		// System.out.println(Arrays.toString(ret));
//
//		System.out.println(Arrays.toString(a2));
//		System.out.println(Arrays.toString(a));
		
		
		quick_sort2(a3,0,a3.length-1);

	}

	public static int[] bubble_sort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {//每次循环代表一轮冒泡，一轮冒泡后顶端的数字一定是最大的
			for (int j = 0; j < n - 1 - i; j++) {
				if (arr[j] < (arr[j + 1])) {
					int tmp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = tmp;
				}

			}
		}

		return arr;

	}

	public static void quick_sort(int[] arr, int start, int end) {

		if (start >= end) {
			// System.out.println("qs finish");
			return;
		}
		int x = arr[start];
		int s = start;
		int e = end;

		while (s < e) {
			if (arr[e] < x) {
				for (; s < e; s++) {
					if (arr[s] > x) {
						int tmp = arr[s];
						arr[s] = arr[e];
						arr[e] = tmp;
						// System.out.println("switch " + arr[s] + " " +
						// arr[e]);
						// System.out.println("s is " + s + " e is " + e);
						break;
					}
				}
			} else {
				e--;

			}
		}
		// System.out.println(" the end s is " + s + " e is " + e +
		// " arr[s] is "
		// + arr[s]+"  arr[start] is "+arr[start]);

		arr[start] = arr[s];

		arr[s] = x;


		System.out.println("quick_sort is "+Arrays.toString(arr));

		quick_sort(arr, start, s - 1);
		quick_sort(arr, s + 1, end);

	}

	public static void quick_sort2(int[] arr, int start, int end) {

		if (start < end) {

			int x = arr[start];
			int s = start;
			int e = end;

			while (s < e) { //退出循环代表一轮排序结束，首尾游标相遇
				while (s < e && (arr[e] >= x)) // 从右向左找第一个小于x的数
				{
					e--;
				}

				while (s < e && (arr[s] <= x)) // 从右向左找第一个小于x的数
				{
					s++;
				}

				if (s < e) {// 左右两个数交换
					int tmp = arr[s];
					arr[s] = arr[e];
					arr[e] = tmp;

//					System.out.println("switch " + arr[s] + " " + arr[e]);
//					System.out.println("s is " + s + " e is " + e);
				}

			}

			arr[start] = arr[s]; //基准数归位到数组中正确位置

			arr[s] = x;

			System.out.println("quick_sort2 is "+Arrays.toString(arr));

			quick_sort2(arr, start, s - 1);
			quick_sort2(arr, s + 1, end);

		}

	}

}

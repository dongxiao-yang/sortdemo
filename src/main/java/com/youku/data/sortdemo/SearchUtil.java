package com.youku.data.sortdemo;

public class SearchUtil {

	// 有序队列查找方法

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
				15, 16, 17, 18, 19, 20, 33, 35, 37, 44, 45, 46, 54, 57, 58 };

		SearchUtil.search1(a, 21);
		// int x=20;
		// SearchUtil.midsearch1(a, 0, a.length-1, x,0);
		//
		// SearchUtil.midsearch2(a, x);
	}

	public static int search1(int[] arr, int x) {

		int i = 0;
		boolean exit = false;
		int snum = (int) (Math.sqrt(2 * arr.length + 0.25) - 1);

		System.out.println("snum is " + snum);
		int posnum = 0;

		for (int S = snum; S > 0; S--) {
			i += S;
			posnum++;
			if (arr[i] == x) {
				exit = true;
				System.out.println("index is " + i);

				break;
			} else if (arr[i] > x) {

				System.out.println("I is " + i);
				System.out.println("S is " + S);
				int j = i - S;
				while (i > j) {
					i--;
					if (arr[i] == x) {
						exit = true;
						System.out.println("index is " + i);

						break;
					}
					posnum++;
					S--;

				}

				if (exit) {
					break;
				}
			}

		}
		System.out.println("posnum is " + posnum);

		return i;

	}

	public static void midsearch1(int[] arr, int from, int to, int x, int posnum) {

		boolean ret = false;

		if (from <= to) {
			posnum++;
			int midindex = (from + to) / 2;

			if (arr[midindex] == x) {
				System.out.println("index is " + midindex);

				System.out.println("posnum is " + posnum);

			} else if (arr[midindex] > x) {
				midsearch1(arr, from, midindex - 1, x, posnum);
			} else {
				midsearch1(arr, midindex + 1, to, x, posnum);
			}

		} else {
			System.out.println("index is  out-range");
			System.out.println("posnum is " + posnum);
		}

	}

	public static void midsearch2(int[] arr, int x) {
		int from = 0;
		int to = arr.length - 1;
		int posnum = 0;
		while (from <= to) {
			posnum++;
			int midindex = (from + to) / 2;

			if (arr[midindex] == x) {
				System.out.println("index is " + midindex);

				System.out.println("posnum is " + posnum);
				break;

			} else if (arr[midindex] > x) {
				to = midindex - 1;
			} else {
				from = midindex + 1;
			}
		}

		System.out.println("index is  out-range");
		System.out.println("posnum is " + posnum);
	}
}

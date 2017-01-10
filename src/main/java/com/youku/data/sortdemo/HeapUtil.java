package com.youku.data.sortdemo;

import java.util.Arrays;

public class HeapUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = { -3, 4, 2, 5, 6, 7, 1, 0, -5, -8, 9, 10, -1, 13, -6 };

		// int[] a = {1,2,3,4,5,6,7};

		// int[] a = new int[] { 10, 32, 44, 65, 78, 87, 76, 54, 43, 34, 56, 99,
		// 9, 3, 4, 2, 7, 1, 6, 60 };

		System.out.println("Before heap:" + Arrays.toString(a));

		heapSort2(a);

		System.out.println("After heap sort:" + Arrays.toString(a));

	}

	public static void heapSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}

		buildMaxHeap(array);

		System.out.println("buildMaxHeap " + Arrays.toString(array));

		for (int i = array.length - 1; i >= 1; i--) {
			exchangeElements(array, 0, i);

			maxHeap(array, i, 0);

			System.out.println("maxHeap " + Arrays.toString(array) + " i is "
					+ i);
		}

	}

	public static void heapSort2(int[] array) {
		for (int i = 0; i < array.length; i++) {
			maxHeap2(array, array.length - 1 - i);
			exchangeElements(array, 0, array.length - 1 - i);
			System.out.println(Arrays.toString(array));
		}

	}

	private static void buildMaxHeap(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}

		int half = array.length / 2 - 1;
		// 根据二叉树性质，深度为k的二叉树至多有2的k次方-1个结点(k≥1）
		// 所以如果最末尾节点为右节点，array.length为奇数，那么上一层父节点的编号应该为（array.length-1）/2=array.length/2
		// 所以如果最末尾节点为左节点，array.length为偶数，那么上一层父节点的编号也为array.length/2
		// 由于数组下标从0开始，所以应该要在堆对应的编号基础上-1

		// 从下往上把比较中最大的值往顶上冒，冒过后要把被换下来的值对应的子树再做一遍堆调整。
		for (int i = half; i >= 0; i--) {
			maxHeap(array, array.length, i);
		}
	}

	private static void maxHeap(int[] array, int heapSize, int index) {
		// 堆编号x ，数组编号index ，a=index+1;
		// 所以左节点数组编号=2a-1=index * 2 + 1
		// 右节点数组编号=2a+1-1=index * 2 + 2

		int left = index * 2 + 1;
		int right = index * 2 + 2;

		int largest = index;
		if (left < heapSize && array[left] > array[index]) {
			largest = left;
		}

		if (right < heapSize && array[right] > array[largest]) {
			largest = right;
		}

		if (index != largest) {
			exchangeElements(array, index, largest);// 将子节点更大的值换到父节点

			System.out.println("maxHeap " + Arrays.toString(array)
					+ " index is " + index + " left is " + left + " right is "
					+ right + " largest is " + largest + " heapSize is "
					+ heapSize);

			maxHeap(array, heapSize, largest);// 原有父节点的值放到了子节点后可能不满足堆的性质，需要调整修改后largest节点对应的子树
		}
	}

	private static void exchangeElements(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	private static void maxHeap2(int[] data, int lastIndex) {

		//lastIndex= array.length - 1
		//所以(lastIndex+1)/2-1等于上层最后一个有子节点的节点在数组中的索引
		//(lastIndex+1)/2-1=(lastIndex-1)/2
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			// 保存当前正在判断的节点
			int k = i;
			
		
			
			// 若当前节点的左节点存在
			while (2 * k + 1 <= lastIndex) {//
				
				// biggerIndex总是记录较大节点的值,先赋值为当前判断节点的左子节点
				int biggerIndex = 2 * k + 1;
				if (biggerIndex < lastIndex) {
					// 若右子节点存在，比较左右子节点大小，右节点不存在biggerIndex为左节点
					if (data[biggerIndex] < data[biggerIndex + 1]) {
						// 若右子节点值比左子节点值大，则biggerIndex记录的是右子节点的值
						biggerIndex++;
					}
				}
				if (data[k] < data[biggerIndex]) {
					// 若当前节点值比子节点最大值小，则交换2者得值，交换后将biggerIndex值赋值给k
					exchangeElements(data, k, biggerIndex);
					k = biggerIndex; //k记录了原来的父节点被换到了什么位置，原来的父节点下来后不一定比子节点更大
					//while循环继续去判断它对应的子树符不符合堆的性质并调整
					System.out.println("k is "+k+" "+Arrays.toString(data));
					
				} else {
					//父节点已经比子节点大了，不需要调整
					break;
				}
				
				//System.out.println();
			}
		}

	}
}

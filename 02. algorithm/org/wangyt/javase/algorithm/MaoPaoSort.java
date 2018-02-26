package org.wangyt.javase.algorithm;

/**
 * 冒泡排序(快速排序算法有问题，日后研究)
 * 
 * @author 王永涛
 * 
 * @date 2012-9-10 下午04:23:45
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,wangyongtao. All Rights Reserved.
 */
public class MaoPaoSort {
	public static void main(String[] args) {
		int[] maopao = { 3, 5, 7, 1, 8, 11, 9 };
		int[] insert = { 3, 5, 7, 1, 8, 11, 9 };
		int[] fast = { 3, 5, 7, 1, 8, 11, 9 };

		System.out.println("冒泡排序算法");
		maopao(maopao);
		System.out.println("\n插入排序算法");
		doInsertSort(insert);
		System.out.println("\n快速排序算法");
		fastSort(fast, 0, fast.length - 1);
		printSort(fast);
	}

	/**
	 * 冒泡排序
	 * 
	 * @param arr
	 */
	public static void maopao(int[] arr) {
		int temp = 0;
		for (int j = 0; j < arr.length; j++) {
			for (int k = 0; k < arr.length - j - 1; k++) {
				if (arr[k] > arr[k + 1]) {
					temp = arr[k];
					arr[k] = arr[k + 1];
					arr[k + 1] = temp;
				}
			}
		}
		printSort(arr);
	}

	/**
	 * 插入排序算法
	 * 
	 * @param arr
	 */
	public static void doInsertSort(int[] arr) {
		int len = arr.length;
		for (int i = 1; i < len; i++) {
			int j;
			int temp = arr[i];
			for (j = i; j > 0; j--) {
				if (arr[j - 1] > temp) {
					arr[j] = arr[j - 1];
				} else {
					break;
				}
			}
			arr[j] = temp;
		}
		printSort(arr);
	}

	/**
	 * 快速排序算法
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 */
	public static void fastSort(int[] arr, int low, int high) {
		if (low >= high)
			return;
		if ((high - low) == 1) {
			if (arr[0] > arr[1])
				swap(arr, 0, 1);
			return;
		}
		int pivot = arr[low];
		int left = low + 1;
		int right = high;
		while (left < right) {
			while (left < right && left <= high) {
				if (arr[left] > pivot)
					break;
				left++;
			}
			while (left <= right && right > low) {
				if (arr[right] <= pivot)
					break;
				right--;
			}
			if (left < right)
				swap(arr, right, left);
		}
		swap(arr, low, right);
		fastSort(arr, low, right);
		fastSort(arr, right + 1, high);
	}

	/**
	 * 掉位方法
	 * 
	 * @param array
	 * @param i
	 * @param j
	 */
	private static void swap(int[] array, int i, int j) {
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * 通用的数组打印方法
	 * 
	 * @param iArr
	 */
	public static void printSort(int[] iArr) {
		for (int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i] + " ");
		}
	}
}
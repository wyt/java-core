package org.wangyt.javase.algorithm;

/**
 * {1,2,3,4,5,6,7,8,9,10,11,12,13} 逆转 => {5,6,7,8,9,10,11,12,13 ,1,2,3,4}
 * 
 * 求数组逆转后的最小值
 * 
 * @author wangyt
 *
 */

public class 逆转数组 {

	/**
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	public static void getMin(int[] arr, int left, int right) {

		// 范围缩小到两个相邻的元素的时候，终止递归
		if (left == (right - 1)) {
			System.out.println("最小值为：" + arr[right]);
			return;
		} else {

			int middle = (left + right) / 2;

			if (arr[middle] > arr[left]) {
				// 说明arr[middle]位于前面的递增数组中,那么最小的元素应该位于arr[middle]之后
				left = middle;
				getMin(arr, left, right);

			} else if (arr[middle] < arr[right]) {
				// 说明arr[middle]位于后面的递增数组中,那么最小的元素应该位于arr[middle]之前
				right = middle;
				getMin(arr, left, right);
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 5, 6, 7, 8, 9, 10, 11, 12, 13, 1, 2, 3, 4 };
		getMin(arr, 0, arr.length - 1);
	}
}

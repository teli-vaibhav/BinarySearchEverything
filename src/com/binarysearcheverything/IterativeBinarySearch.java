package com.binarysearcheverything;

public class IterativeBinarySearch {

	public int iterativeBinarySearch(int[] inputArray, int key) {
		if (inputArray == null || inputArray.length <= 0)
			return -1;
		int left = 0;
		int right = inputArray.length - 1;
		while (left <= right) {
			int mid = (right - left) / 2 + left;
			if (key == inputArray[mid])
				return mid;
			if (key < inputArray[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		return -1;
	}
}

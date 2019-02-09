package com.binarysearcheverything;

public class PeakInAMountainArray {

	public int peakIndexInMountainArray(int[] inputArray) {
		if (inputArray == null || inputArray.length <= 0)
			return -1;
		int left = 0;
		int right = inputArray.length - 1;

		while (left <= right) {
			int mid = (right - left) / 2 + left;
			if (inputArray[mid] < inputArray[mid + 1])
				left = mid + 1;
			else
				right = mid - 1;
		}
		return left;
	}
}

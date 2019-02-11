package com.binarysearcheverything.easy;

import java.util.Arrays;

public class Q475Heaters {
	public int findRadius(int[] houses, int[] heaters) {
		if (houses == null || houses.length <= 0 || heaters == null || heaters.length <= 0)
			return -1;
		Arrays.sort(heaters);

		int result = Integer.MIN_VALUE;

		for (int currentHouse : houses) {
			int leftHeater = getLeftPositionBinarySearch(heaters, currentHouse);
			int rightHeater = getRightPositionBinarySearch(heaters, currentHouse);
			result = Math.max(result,
					Math.min(Math.abs(currentHouse - leftHeater), Math.abs(rightHeater - currentHouse)));
		}
		return result;
	}

	private int getLeftPositionBinarySearch(int[] inputArray, int key) {
		int start = 0;
		int end = inputArray.length - 1;
		while (start <= end) {
			int mid = (end - start) / 2 + start;
			if (key == inputArray[mid])
				return inputArray[mid];
			if (mid == 0 && key < inputArray[mid])
				return Integer.MAX_VALUE;
			if (key < inputArray[mid] && key > inputArray[mid - 1])
				return inputArray[mid - 1];
			if (key < inputArray[mid])
				end = mid - 1;
			else
				start = mid + 1;
		}
		return inputArray[end];
	}

	private int getRightPositionBinarySearch(int[] inputArray, int key) {
		int start = 0;
		int end = inputArray.length - 1;
		while (start <= end) {
			int mid = (end - start) / 2 + start;
			if (key == inputArray[mid])
				return inputArray[mid];
			if (mid == inputArray.length - 1 && key > inputArray[mid])
				return Integer.MAX_VALUE;
			if (key > inputArray[mid] && key < inputArray[mid + 1])
				return inputArray[mid + 1];
			if (key < inputArray[mid])
				end = mid - 1;
			else
				start = mid + 1;
		}
		return inputArray[start];
	}
}

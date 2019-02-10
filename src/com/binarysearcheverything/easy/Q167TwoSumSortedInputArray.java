package com.binarysearcheverything.easy;

public class Q167TwoSumSortedInputArray {

	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		if (numbers == null || numbers.length <= 1)
			return result;
		for (int index = 0; index < numbers.length - 1; index++) {
			int secondElementIndex = getBinarySearchIndex(numbers, index + 1, numbers.length - 1,
					target - numbers[index]);
			if (secondElementIndex != -1) {
				result[0] = index + 1;
				result[1] = secondElementIndex + 1;
			}
		}
		return result;
	}

	private int getBinarySearchIndex(int[] numbers, int start, int end, int key) {
		while (start <= end) {
			int mid = (end - start) / 2 + start;
			if (numbers[mid] == key)
				return mid;
			if (key < numbers[mid])
				end = mid - 1;
			else
				start = mid + 1;
		}
		return -1;
	}
}

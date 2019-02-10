package com.binarysearcheverything.easy;

public class Q704RecursiveBinarySearch {

	public int recursiveBinarySearch(int[] inputArray, int key) {
		if (inputArray == null || inputArray.length <= 0)
			return -1;
		return recursiveBinarySearchImpl(inputArray, 0, inputArray.length - 1, key);
	}

	private int recursiveBinarySearchImpl(int[] inputArray, int startIndex, int endIndex, int key) {
		if (startIndex > endIndex)
			return -1;
		int midIndex = (endIndex - startIndex) / 2 + startIndex;
		if (key == inputArray[midIndex])
			return midIndex;
		if (key < inputArray[midIndex])
			return recursiveBinarySearchImpl(inputArray, startIndex, midIndex - 1, key);
		else
			return recursiveBinarySearchImpl(inputArray, midIndex + 1, endIndex, key);
	}
}

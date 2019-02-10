package com.binarysearcheverything.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q349IntersectionOfTwoArrays {

	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> resultSet = new HashSet<>();

		if (nums1 == null || nums1.length <= 0 || nums2 == null || nums2.length <= 0) {
			return new int[] {};
		}

		int length1 = nums1.length;
		int length2 = nums2.length;
		int[] smallerArray = (length1 < length2) ? nums1 : nums2;
		int[] largerArray = (length1 < length2) ? nums2 : nums1;
		Arrays.sort(smallerArray);

		for (int currentElementInLongArray : largerArray) {
			if (isElementFoundInBinarySearch(smallerArray, currentElementInLongArray)) {
				resultSet.add(currentElementInLongArray);
			}
		}
		int[] result = new int[resultSet.size()];
		int index = 0;
		for (int currentElementFromSet : resultSet) {
			result[index++] = currentElementFromSet;
		}
		return result;
	}

	private boolean isElementFoundInBinarySearch(int[] inputArray, int key) {
		int left = 0;
		int right = inputArray.length - 1;
		while (left <= right) {
			int mid = (right - left) / 2 + left;
			if (inputArray[mid] == key)
				return true;
			if (key < inputArray[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		return false;
	}
}

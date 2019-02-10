package com.binarysearcheverything.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q350IntersectionOfTwoArraysWithDuplicates {
	public int[] intersect(int[] nums1, int[] nums2) {
		List<Integer> resultList = new ArrayList<>();
		if (nums1 == null || nums1.length <= 0 || nums2 == null || nums2.length <= 0) {
			return new int[] {};
		}
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int length1 = nums1.length;
		int length2 = nums2.length;

		int[] shorter = (length1 < length2) ? nums1 : nums2;
		int[] longer = (length1 < length2) ? nums2 : nums1;

		int shorterIndex = 0;
		while (shorterIndex < shorter.length) {
			int firstIndexOfTargetInLonger = getFirstIndexInBinarySearch(longer, shorter[shorterIndex]);
			if (firstIndexOfTargetInLonger == -1) {
				shorterIndex++;
				continue;
			}
			int lastIndexOfTargetInLonger = getLastIndexInBinarySearch(longer, shorter[shorterIndex]);
			int lastIndexOfTargetInShorter = getLastIndexInBinarySearch(shorter, shorter[shorterIndex]);
			int noOfCommonOccurences = Math.min(lastIndexOfTargetInLonger - firstIndexOfTargetInLonger,
					lastIndexOfTargetInShorter - shorterIndex) + 1;
			while (noOfCommonOccurences > 0) {
				resultList.add(shorter[shorterIndex]);
				noOfCommonOccurences--;
			}
			shorterIndex = lastIndexOfTargetInShorter + 1;
		}
		int[] result = new int[resultList.size()];
		int resIndex = 0;
		for (int currentResult : resultList) {
			result[resIndex++] = currentResult;
		}
		return result;
	}

	private int getFirstIndexInBinarySearch(int[] inputArray, int key) {
		int left = 0;
		int right = inputArray.length - 1;
		while (left <= right) {
			int mid = (right - left) / 2 + left;
			if (inputArray[mid] == key && (mid == 0 || inputArray[mid - 1] != key))
				return mid;
			if (key <= inputArray[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		return -1;
	}

	private int getLastIndexInBinarySearch(int[] inputArray, int key) {
		int left = 0;
		int right = inputArray.length - 1;
		while (left <= right) {
			int mid = (right - left) / 2 + left;
			if (inputArray[mid] == key && (mid == inputArray.length - 1 || inputArray[mid + 1] != key))
				return mid;
			if (key < inputArray[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		return -1;
	}
}

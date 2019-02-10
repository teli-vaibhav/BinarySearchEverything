package com.binarysearcheverything.easy;

public class Q35SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length <= 0)
			return -1;
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (right - left) / 2 + left;
			if (target == nums[mid])
				return mid;
			if (target < nums[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		return left;
	}
}

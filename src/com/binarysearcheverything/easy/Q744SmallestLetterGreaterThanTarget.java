package com.binarysearcheverything.easy;

public class Q744SmallestLetterGreaterThanTarget {
	public char nextGreatestLetter(char[] letters, char target) {
		if (letters == null || letters.length <= 0)
			return '*';
		int left = 0;
		int right = letters.length - 1;

		while (left <= right) {
			int mid = (right - left) / 2 + left;
			if (target == letters[mid] && isRightmostElement(letters, mid)) {
				if (mid == letters.length - 1)
					return letters[0];
				return letters[mid + 1];
			}

			if (target < letters[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		if (right == -1 || left == letters.length)
			return letters[0];
		return letters[left];
	}

	private boolean isRightmostElement(char[] letters, int index) {
		if (index == letters.length - 1 || letters[index] != letters[index + 1])
			return true;
		return false;
	}
}

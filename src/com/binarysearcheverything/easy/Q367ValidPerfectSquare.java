package com.binarysearcheverything.easy;

public class Q367ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
		int start = 1;
		int end = num;

		while (start <= end) {
			int mid = (end - start) / 2 + start;
			int square = mid * mid;
			if (square == num)
				return true;
			if (isSquareOverflow(mid) || num < square)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return false;
	}

	private boolean isSquareOverflow(int mid) {
		if (mid > Integer.MAX_VALUE / mid)
			return true;
		return false;
	}
}

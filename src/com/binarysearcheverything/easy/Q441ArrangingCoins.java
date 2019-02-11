package com.binarysearcheverything.easy;

public class Q441ArrangingCoins {
	public int arrangeCoins(int n) {
		int start = 0;
		int end = n;

		while (start <= end) {
			int mid = (end - start) / 2 + start;
			int noOfCoinsUptoMidLevel = 0;
			if (mid % 2 == 0)
				noOfCoinsUptoMidLevel = (mid / 2) * (mid + 1);
			else
				noOfCoinsUptoMidLevel = ((mid + 1) / 2) * (mid);
			boolean isOverFlow = isOverflown(mid);
			long noOfCoinsUptoMidLevelAndNext = (long) noOfCoinsUptoMidLevel + mid + 1;

			if (!isOverFlow && n >= noOfCoinsUptoMidLevel && n < noOfCoinsUptoMidLevelAndNext)
				return mid;
			if (!isOverFlow && n >= noOfCoinsUptoMidLevel)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return -1;
	}

	private boolean isOverflown(int mid) {
		if (mid == 0 || mid == 1)
			return false;
		long intMax=(long) Integer.MAX_VALUE;
		long temp= (long) intMax*2;
		temp = (long) (temp / (mid - 1));
		if (mid != 0 && mid > temp)
			return true;
		return false;
	}
}

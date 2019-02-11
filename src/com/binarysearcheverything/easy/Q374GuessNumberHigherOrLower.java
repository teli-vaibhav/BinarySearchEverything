package com.binarysearcheverything.easy;

public class Q374GuessNumberHigherOrLower {
	public int guessNumber(int n) {
		int start = 1;
		int end = n;

		while (start <= end) {
			int mid = (end - start) / 2 + start;
			int currentGuess = guess(mid);
			if (currentGuess == 0)
				return mid;
			if (currentGuess == -1)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return -1;
	}
}

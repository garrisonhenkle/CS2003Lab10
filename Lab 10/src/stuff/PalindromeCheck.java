package stuff;

import java.lang.Math;

public class PalindromeCheck {

	public static void main(String[] args) {

		// objects
		PalindromeCheck pc = new PalindromeCheck();

		// variables
		// holds an integer indicating the greatest amount of digits a number can
		// possess
		int digits = 4;
		// converts the digits integer into a maximum value
		int max = (int) Math.round(Math.pow(10, digits));
		// hold the current numbers that are being multiplied
		int num1 = 1;
		int num2 = 1;
		// holds the current product of num1 and num2
		int product;
		// holds the largest palindrome
		int currLargest = 1;
		// holds the num1 and num2 of the largest palindrome
		int num1Largest = 1;
		int num2Largest = 1;

		// checks every combination of num1 * num2 while both num1 and num2 are below
		// the max number (10^digits)
		while (true) {
			// calculates the product
			product = num1 * num2;
			// if the product is a palindrome and is greater than the current largest
			// palindrome, register the product, num1, and num2 as the largest
			if (pc.isaPalindrome(Integer.toString(product))) {
				if (product > currLargest) {
					currLargest = product;
					num1Largest = num1;
					num2Largest = num2;
				}
			}

			// increases num1 by one unless num1 exceeds the maximum size (max). If num1
			// exceeds the maximum size, then num1 will be reset to 0 and num2 will be
			// incremented by one. If both values exceed the maximium, the loop breaks
			num1++;
			if (num1 >= max) {
				num1 = 1;
				num2++;
				if (num2 >= max) {
					break;
				}
			}
		}

		// prints out the largest number
		System.out.println("The largest palindromic number that is made from the product of two " + digits
				+ "-digit numbers is " + num1Largest + " X " + num2Largest + " = " + Integer.toString(currLargest));
	}

	// checks to see if the input string is a palindrome. Returns true if it is a
	// palindrome and false if it is not.
	public boolean isaPalindrome(String in) {

		// base case for words with an odd length
		if (in.length() == 1)
			return true;
		// base case for words with an even length
		else if (in.length() == 2 && in.charAt(0) == in.charAt(1))
			return true;
		// recursion
		else if (in.charAt(0) == in.charAt(in.length() - 1))
			return isaPalindrome(in.substring(1, in.length() - 1));
		// false if the characters do not pass the equality test
		else
			return false;

	}
}

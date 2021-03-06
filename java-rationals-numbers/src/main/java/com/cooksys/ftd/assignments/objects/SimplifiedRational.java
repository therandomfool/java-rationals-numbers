package com.cooksys.ftd.assignments.objects;

import java.util.Arrays;

public class SimplifiedRational implements IRational {

	private int numerator;
	private int denominator;

	/**
	 * Determines the greatest common denominator for the given values
	 *
	 * @param a the first value to consider
	 * @param b the second value to consider
	 * @return the greatest common denominator, or shared factor, of `a` and `b`
	 * @throws IllegalArgumentException if a <= 0 or b < 0
	 */
//	gcd() for establishment of greatest common denominator using modulus operator
	public static int gcd(int a, int b) throws IllegalArgumentException {
		if (a <= 0) {
			throw new IllegalArgumentException("First value is less or equal to 0");
		}
		if (b < 0) {
			throw new IllegalArgumentException("Second value is less than 0");
		}
//		if block to handle b = 0 case
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);

	}

	/**
	 * Simplifies the numerator and denominator of a rational value.
	 * <p>
	 * For example: `simplify(10, 100) = [1, 10]` or: `simplify(0, 10) = [0, 1]`
	 *
	 * @param numerator   the numerator of the rational value to simplify
	 * @param denominator the denominator of the rational value to simplify
	 * @return a two element array representation of the simplified numerator and
	 *         denominator
	 * @throws IllegalArgumentException if the given denominator is 0
	 */
	
//	 simplifyArray[n,d] creation to contain the reduction or simplification of a rational value for LCD
	public static int[] simplify(int numerator, int denominator) throws IllegalArgumentException {
		int simplifyArray[] = new int[2];
		if (denominator == 0) {
			throw new IllegalArgumentException("given denominator is 0");
		}
		if (numerator == 0) {
			simplifyArray[0] = 0;
			simplifyArray[1] = 1;

		} else {
			int grcode = gcd(Math.abs(numerator), Math.abs(denominator));
			simplifyArray[0] = numerator / grcode;
			simplifyArray[1] = denominator / grcode;

		}
		return simplifyArray;

	}

	/**
	 * Constructor for rational values of the type:
	 * <p>
	 * `numerator / denominator`
	 * <p>
	 * Simplification of numerator/denominator pair should occur in this method. If
	 * the numerator is zero, no further simplification can be performed
	 *
	 * @param numerator   the numerator of the rational value
	 * @param denominator the denominator of the rational value
	 * @throws IllegalArgumentException if the given denominator is 0
	 */
	
	public SimplifiedRational(int numerator, int denominator) throws IllegalArgumentException {

		if (denominator == 0) {
			throw new IllegalArgumentException("given denominator is 0");

		} else if (numerator == 0) {
			denominator = 1;
			
//			Sending positive values to gcd() for an int simplification based on SimplifiedRational numerator and denominator argumentss
		} else {
			int grcode = gcd(Math.abs(numerator), Math.abs(denominator));
			this.numerator = numerator / grcode;
			this.denominator = denominator / grcode;

		}

	}

	/**
	 * @return the numerator of this rational number
	 */
	
//	 numerator getter
	@Override
	public int getNumerator() {
		return this.numerator;
	}

	/**
	 * @return the denominator of this rational number
	 */
	
//	denominator getter
	@Override
	public int getDenominator() {
		return this.denominator;
	}

	/**
	 * Specializable constructor to take advantage of shared code between Rational
	 * and SimplifiedRational
	 * <p>
	 * Essentially, this method allows us to implement most of IRational methods
	 * directly in the interface while preserving the underlying type
	 *
	 * @param numerator   the numerator of the rational value to construct
	 * @param denominator the denominator of the rational value to construct
	 * @return the constructed rational value (specifically, a SimplifiedRational
	 *         value)
	 * @throws IllegalArgumentException if the given denominator is 0
	 */
	
	
//  SimplifiedRational construct function creating SimplifiedRational object to access parent / child relationship(inheritance)
	@Override
	public SimplifiedRational construct(int numerator, int denominator) throws IllegalArgumentException {
		if (denominator == 0) {
			throw new IllegalArgumentException("given denominator is 0");
		}
		SimplifiedRational sRational = new SimplifiedRational(numerator, denominator);

		return sRational;
	}

	/**
	 * @param obj the object to check this against for equality
	 * @return true if the given obj is a rational value and its numerator and
	 *         denominator are equal to this rational value's numerator and
	 *         denominator, false otherwise
	 */
	
//  equals() to boolean check an object's numerator and denominator are the same the SimplifiedRational's numerator and denominator
	@Override
	public boolean equals(Object obj) {

		return (obj instanceof SimplifiedRational) 
				&& ((SimplifiedRational) obj).getNumerator() == this.numerator
				&& ((SimplifiedRational) obj).getDenominator() == this.denominator;
	}

	/**
	 * If this is positive, the string should be of the form `numerator/denominator`
	 * <p>
	 * If this is negative, the string should be of the form
	 * `-numerator/denominator`
	 *
	 * @return a string representation of this rational value
	 */
	
//  if the numerator OR denominator are less than 0 make return -n/d  If greater than 0 make return n/d
	@Override
	public String toString() {

//    	using exclusive ^ or
		if (numerator < 0 ^ denominator < 0) {
			return "-" + Math.abs(numerator) + "/" + Math.abs(denominator);
		} else {
			return Math.abs(numerator) + "/" + Math.abs(denominator);
		}

	}

}

package com.cooksys.ftd.assignments.objects;



interface IRational {

	/**
	 * @return the numerator of this rational number
	 */
	
//	numerator getter
	int getNumerator();
	

	/**
	 * @return the denominator of this rational number
	 */
//	denominator getter
	int getDenominator();

	/**
	 * Specializable constructor to take advantage of shared code between
	 * Rational and SimplifiedRational
	 * <p>
	 * Essentially, this method allows us to implement most of IRational methods
	 * directly in the interface while preserving the underlying type
	 *
	 * @param numerator
	 *            the numerator of the rational value to construct
	 * @param denominator
	 *            the denominator of the rational value to construct
	 * @return the constructed rational value
	 * @throws IllegalArgumentException
	 *             if the given denominator is 0
	 */
	
//	construct abstract method.  All the methods of an interface are public abstract by default.
	IRational construct(int numerator, int denominator) throws IllegalArgumentException;
	


	/**
	 * negation of rational values
	 * <p>
	 * definition: `negate(n / d) = -n / d`
	 *
	 * @return the negation of this
	 */
//	 calling negate() for negative rational 
	default IRational negate() {
		
		
		return this.construct(this.getNumerator() * -1, this.getDenominator());

	}

	/**
	 * inversion of rational values
	 * <p>
	 * definition: `invert(n / d) = d / n`
	 *
	 * @return the inversion of this
	 * @throws IllegalStateException
	 *             if the numerator of this rational value is 0
	 */
	
//	 calling invert for positive rational
	default IRational invert() throws IllegalStateException {
		if (getNumerator() == 0) {
			throw new IllegalStateException("the numerator of this rational value is 0");	
		};
		return construct(getDenominator(), getNumerator());
	}

	/**
	 * addition of rational values
	 * <p>
	 * definition: `(n1 / d1) + (n2 / d2) = ((n1 * d2) + (n2 * d1)) / (d1 * d2)`
	 *
	 * @param that
	 *            the value to add to this
	 * @return the sum of this and that
	 * @throws IllegalArgumentException
	 *             if that is null
	 */
	
//	calling add() for addition of rationals
	default IRational add(IRational that) throws IllegalArgumentException {
		if (that == null) {
			throw new IllegalArgumentException("the sum is null");	
		};
		int n1 = this.getNumerator();
		int n2 = that.getNumerator();	
		int d1 = this.getDenominator();
		int d2 = that.getDenominator();
		 
//		return call the construct method establishing two variables
		return construct((n1*d2)+(n2* d1), (d1*d2));
	}

	/**
	 * subtraction of rational values
	 * <p>
	 * definition: `(n1 / d1) - (n2 / d2) = ((n1 * d2) - (n2 * d1)) / (d1 * d2)`
	 *
	 * @param that
	 *            the value to subtract from this
	 * @return the difference between this and that
	 * @throws IllegalArgumentException
	 *             if that is null
	 */
	
//	calling sub() for subtraction of rationals
	default IRational sub(IRational that) throws IllegalArgumentException {
		if (that == null) {
			throw new IllegalArgumentException("that is null");	
		};
		int n1 = this.getNumerator();
		int n2 = that.getNumerator();	
		int d1 = this.getDenominator();
		int d2 = that.getDenominator();
		
//		doing the math on subtraction of rationals for construct()
		return construct((n1*d2)-(n2* d1), (d1*d2));
	}

	/**
	 * multiplication of rational values
	 * <p>
	 * definition: `(n1 / d1) * (n2 / d2) = (n1 * n2) / (d1 * d2)`
	 *
	 * @param that
	 *            the value to multiply this by
	 * @return the product of this and that
	 * @throws IllegalArgumentException
	 *             if that is null
	 */
	
//	calling muls() for multiplication of rationals
	default IRational mul(IRational that) throws IllegalArgumentException {
		if (that == null) {
			throw new IllegalArgumentException("the sum is null");	
		};
		int n1 = this.getNumerator();
		int n2 = that.getNumerator();	
		int d1 = this.getDenominator();
		int d2 = that.getDenominator();
		
//		doing the math on calling constructor() for multiplication of rational variables
		return construct((n1 * n2) , (d1 * d2));
	}

	/**
	 * division of rational values
	 * <p>
	 * definition: `(n1 / d1) / (n2 / d2) = (n1 * d2) / (d1 * n2)`
	 *
	 * @param that
	 *            the value to divide this by
	 * @return the ratio of this to that
	 * @throws IllegalArgumentException
	 *             if that is null or if the numerator of that is 0
	 */
	
//	calling div() for division of rationals
	default IRational div(IRational that) throws IllegalArgumentException {
		if (that == null || getNumerator() ==0) {
			throw new IllegalArgumentException("the sum is null");	
		};
		int n1 = this.getNumerator();
		int n2 = that.getNumerator();	
		int d1 = this.getDenominator();
		int d2 = that.getDenominator();
		
//		doing the math on calling constructor() for division of rational variables
		return construct((n1 * d2) , (d1 * n2));
	}
}

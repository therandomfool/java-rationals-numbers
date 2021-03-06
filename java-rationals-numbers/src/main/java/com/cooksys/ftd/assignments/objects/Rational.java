package com.cooksys.ftd.assignments.objects;



public class Rational implements IRational {
	
	private int numerator, denominator;
	
    /**
     * Constructor for rational values of the type:
     * <p>
     * `numerator / denominator`
     * <p>
     * No simplification of the numerator/denominator pair should occur in this method.
     *
     * @param numerator   the numerator of the rational value
     * @param denominator the denominator of the rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
	
//	Rational constructor
    public Rational(int numerator, int denominator) throws IllegalArgumentException {
    	if (denominator == 0) {
    		throw new IllegalArgumentException("given denominator is 0");	
    	};
    	
        this.numerator= numerator;
        this.denominator = denominator;
    }

    /**
     * @return the numerator of this rational number
     */

    
    
//	numerator getter
    @Override
    public int getNumerator() {
    	return this.numerator;
        
    }

    /**
     * @return the denominator of this rational number
     */
//    denomiator getter
    @Override
    public int getDenominator() {
        return this.denominator;
    	
    }

    /**
     * Specializable constructor to take advantage of shared code between Rational and SimplifiedRational
     * <p>
     * Essentially, this method allows us to implement most of IRational methods directly in the interface while
     * preserving the underlying type
     *
     * @param numerator the numerator of the rational value to construct
     * @param denominator the denominator of the rational value to construct
     * @return the constructed rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
    
//    Rational construct function creating rational object to access parent / child relationship(inheritance)
    @Override
    public Rational construct(int numerator, int denominator) throws IllegalArgumentException {
    	if(denominator == 0) {
     	   throw new IllegalArgumentException("given denominator is 0");
        }
    	
    	Rational rational = new Rational(numerator, denominator);
    	
        return rational;
        
    }

    /**
     * @param obj the object to check this against for equality
     * @return true if the given obj is a rational value and its
     * numerator and denominator are equal to this rational value's numerator and denominator,
     * false otherwise
     */
    
//     equals() to boolean check an object's numerator and denominator are the same the rational's numerator and denominator
    @Override
    public boolean equals(Object obj) {

//  new object is same as Rational object and new object's numerator and denominator are the same the Rational's   	
       return (obj instanceof Rational)
    		   && ((Rational) obj).getNumerator() == numerator
    		   && ((Rational) obj).getDenominator() == denominator;
    }

    /**
     * If this is positive, the string should be of the form `numerator/denominator`
     * <p>
     * If this is negative, the string should be of the form `-numerator/denominator`
     *
     * @return a string representation of this rational value
     */
    
//     if the numerator OR denominator are less than 0 make return -n/d  If greater than 0 make return n/d
    @Override
    public String toString() {
    	
//    	using exclusive ^ or to handle 0 case if greater than zero return positive using Math.abs()
    	if(numerator <0 ^ denominator <0 ) {
    		return "-" + Math.abs(numerator) + "/" + Math.abs(denominator);
    	}else {
    		return Math.abs(numerator) + "/" + Math.abs(denominator);
    	}
    	
    	
//    	DIFFERENT VARIATION CASTING DOUBLE TO FIND THE NEGATIVE AND POSITIVE
    	
//    	if((double) numerator / (double)denominator < 0 ) {
//    		return  "-" + Math.abs(numerator) + "/" + Math.abs(denominator);
//    	}else {
//    		return Math.abs(numerator) + "/" + Math.abs(denominator);
//    	}
    	
    	
//    	DIFFERENT VARIATION CASTING FLOAT TO FIND THE NEGATIVE AND POSITIVE
    	
//    	if((float) numerator / (float)denominator < 0 ) {
//    		return  "-" + Math.abs(numerator) + "/" + Math.abs(denominator);
//    	}else {
//    		return Math.abs(numerator) + "/" + Math.abs(denominator);
//    	}
    	
    	
    	
    	
    	
    	
    	
//    	return numerator + "/" + denominator;
        
    }
}

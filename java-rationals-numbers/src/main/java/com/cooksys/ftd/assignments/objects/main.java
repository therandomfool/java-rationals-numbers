package com.cooksys.ftd.assignments.objects;

public class main {

	public static void main(String[] args) {
		Rational rational = new Rational(200,-400);
		
		
		System.out.println(rational.toString());
		System.out.println(rational.getNumerator()/rational.getDenominator());
		
	}

}

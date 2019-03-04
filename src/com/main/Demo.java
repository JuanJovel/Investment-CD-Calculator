package com.main;

import com.APYCalculator.*;

public class Demo {

	public static void main(String[] args) {
	
		Calculator t = new Calculator(4.30, 3000, 12, 5);
		System.out.println(t.computeYield());

	}

}

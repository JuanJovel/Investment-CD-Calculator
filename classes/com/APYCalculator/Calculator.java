package com.APYCalculator;

public class Calculator {
		
		private double P;
		private double r;
		private int n = 365;
		private double T;
		
		public Calculator (double r, double P, int n, double T) {
			this.r = r/100;
			this.n = n;
			this.P = P;
			this.T = T;
		}
		
		public Calculator (double r, double P, double T) {
			this.r = r/100;
			this.P = P;
			this.T = T;
		}
		
		public double computeYield() {
			double yield = 0;
			yield = P*Math.pow((1+(this.r/this.n)), (this.n*T));
			yield = yield - this.P;
			return yield;
		}
		
		public double computeFinalAmount() {
			double finalAmount = 0;
			finalAmount = P*Math.pow((1+(this.r/this.n)), (this.n*T));
			return finalAmount;
		}
		

	}




package leetcode;

import java.util.Scanner;

public class Function {

	public Function() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0;i<n;i++) {
			double a = in.nextDouble();
			double b = in.nextDouble();
			double sum = 0.0;
			double e = divide(a,b,10000.0);
			
			for(int j=1;j<=10000;j++) {
				double x = mid(a,b,10000.0,j);
				sum += findAns(x);
			}
			double ans = sum*e;
			System.out.println(Math.round(ans));
		}
	}
	
	public static double findAns(double x) {
		if(x<0) {
			return 0;
		}else if(x>=0 && x<=2) {
			return (2-x)*Math.sqrt(x);
		}else if(x>2 && x<=5) {
			return x*x*x-2*x*x-x+2;
		}else if(x>5 && x<=10) {
			return 72-Math.sqrt((x-5)*Math.sqrt((x-5)*Math.sqrt(x-5)));
		}else {
			return 10;
		}
	}
	
	public static double mid(double a, double b, double n, int index) {
		return a+index*(b-a)/n;
	}
	
	public static double divide(double a, double b, double part) {
		return (b-a)/part;
	}
}

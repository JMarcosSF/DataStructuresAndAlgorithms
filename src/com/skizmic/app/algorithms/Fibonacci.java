package com.skizmic.app.algorithms;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	
	public static void main(String[] args) {
		int n = 50;
//		for(int i = 0; i < n; i++) {
//			System.out.print(fibonacci(i) + " ");
//		}
//		System.out.println();
//		for(int i = 0; i < n; i++) {
//			System.out.print(recursiveFib(i) + " ");
//		}
//		(new Thread() {
//			public void run() {
//				System.out.println();
//				for(int i = 0; i < 100; i++) {
//					System.out.print(recursiveFib(i) + " ");
//				}
//			}
//		}).start();
		(new Thread() {
			public void run() {
				System.out.print("\nFlyweight: ");
				for (int i = 0; i < 100; i++) {
					System.out.print(flyweightFibonacci(i) + " ");
				}
			}
		}).start();
	}
	
	static long fibonacci(long n) {
		if(n == 0 || n == 1)
			return 1;

		int x = 0, y = 0, z = 1;
		for(int i = 0; i < n; i++) {
			x = y;
			y = z;
			z = x + y;
		}
		return z;
	}
	
	public static long recursiveFib(long n)  {
		if(n < 2) {
			return 1;
		} else {
			return recursiveFib(n - 1) + recursiveFib(n - 2);
		}
		
	}
	
	private static Map<Long, Long> map = new HashMap<Long, Long>();
	// Initialize init data in map
	static {
		map.put(1l, 1l);
		map.put(2l, 2l);
	}
	
	public static long flyweightFibonacci(final long n) {

		if(n < 2)
			return 1;

		if (map.containsKey(n)) {
			return map.get(n);
		}

		long a, b;

		if (map.containsKey(n - 1))
			a = map.get(n - 1);
		else {
			a = flyweightFibonacci(n - 1);
			map.put(n - 1, a);
		}

		if (map.containsKey(n - 2))
			b = map.get(n - 2);
		else {
			b = flyweightFibonacci(n - 2);
			map.put(n - 2, b);
		}

		return a + b;
	}
	
}

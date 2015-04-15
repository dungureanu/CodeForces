package dungureanu.problems.problem1;

// Theatre Square in the capital city of Berland has a rectangular shape with the size n × m meters. On the occasion of the city's anniversary, a
// decision was taken to pave the Square with square granite flagstones. Each flagstone is of the size a × a.
//
// What is the least number of flagstones needed to pave the Square? It's allowed to cover the surface larger than the Theatre Square, but the Square
// has to be covered. It's not allowed to break the flagstones. The sides of flagstones should be parallel to the sides of the Square.
// Input
//
// The input contains three positive integer numbers in the first line: n,  m and a (1 ≤  n, m, a ≤ 109).
// Output
//
// Write the needed number of flagstones.
// Sample test(s)
// Input
//
// 6 6 4
//
// Output
//
// 4

import java.util.Scanner;

public class A1 {

	public static void main(final String[] args) {
		final Scanner scanner = new Scanner(System.in);

		final A1 a1 = new A1();
		a1.solution(scanner.nextLong(), scanner.nextLong(), scanner.nextLong());

		scanner.close();
	}

	private void solution(final long n, final long m, final long a) {
		final long total = (n % a == 0 ? n / a : n / a + 1) * (m % a == 0 ? m / a : m / a + 1);
		System.out.println(total);
	}

}

package dungureanu.problems.problem1;

// Nowadays all circuses in Berland have a round arena with diameter 13 meters, but in the past things were different.
//
// In Ancient Berland arenas in circuses were shaped as a regular (equiangular) polygon, the size and the number of angles could vary from one circus
// to another. In each corner of the arena there was a special pillar, and the rope strung between the pillars marked the arena edges.
//
// Recently the scientists from Berland have discovered the remains of the ancient circus arena. They found only three pillars, the others were
// destroyed by the time.
//
// You are given the coordinates of these three pillars. Find out what is the smallest area that the arena could have.
// Input
//
// The input file consists of three lines, each of them contains a pair of numbers –– coordinates of the pillar. Any coordinate doesn't exceed 1000 by
// absolute value, and is given with at most six digits after decimal point.
// Output
//
// Output the smallest possible area of the ancient arena. This number should be accurate to at least 6 digits after the decimal point. It's
// guaranteed that the number of angles in the optimal polygon is not larger than 100.
// Sample test(s)
// Input
//
// 0.000000 0.000000
// 1.000000 1.000000
// 0.000000 1.000000
//
// Output
//
// 1.00000000

import java.util.Scanner;

public class C1 {

	public static void main(final String[] args) {
		final Scanner scanner = new Scanner(System.in);

		final C1 c1 = new C1();

		final Point point1 = c1.new Point(scanner.nextDouble(), scanner.nextDouble());
		final Point point2 = c1.new Point(scanner.nextDouble(), scanner.nextDouble());
		final Point point3 = c1.new Point(scanner.nextDouble(), scanner.nextDouble());

		System.out.println(c1.getArea(point1, point2, point3));

		scanner.close();
	}

	private double getArea(final Point point1, final Point point2, final Point point3) {
		final double lineA = getLine(point1, point2);
		final double lineB = getLine(point1, point3);
		final double lineC = getLine(point2, point3);

		final double semiPerimeter = Math.sqrt(lineA + lineB + lineC);

		final double area = Math.sqrt(semiPerimeter * (semiPerimeter - lineA) * (semiPerimeter - lineB) * (semiPerimeter - lineC));

		final double radious = (lineA * lineB * lineC) / (4 * area);

		final int nLines = getNnumberOfLines(radious, lineA, lineB, lineC);

		final double nArea = nLines * Math.pow(radious, 2) * Math.sin(Math.PI * 2 / nLines) / 2;

		return nArea;
	}

	private int getNnumberOfLines(final double radious, final double lineA, final double lineB, final double lineC) {
		//
		System.out.println(getAngle(radious, lineA));
		System.out.println(Math.PI / getAngle(radious, lineB));
		System.out.println(getAngle(radious, lineC));
		return 4;
	}

	private double getAngle(final double radious, final double line) {
		final double OM = Math.sqrt(Math.abs(Math.pow(radious, 2) - Math.pow(line, 2) / 4));
		System.out.println(radious + " - " + line + " - " + OM);
		return Math.acos(OM * line / Math.pow(radious, 2));
	}

	private double getLine(final Point point1, final Point point2) {
		return Math.sqrt(Math.pow(point1.getPossition1() - point2.getPossition1(), 2)
				+ Math.pow(point1.getPossition2() - point2.getPossition2(), 2));
	}

	private class Point {
		private final double possition1;
		private final double possition2;

		public Point(final double possition1, final double possition2) {
			super();
			this.possition1 = possition1;
			this.possition2 = possition2;
		}

		public double getPossition1() {
			return possition1;
		}

		public double getPossition2() {
			return possition2;
		}
	}

}

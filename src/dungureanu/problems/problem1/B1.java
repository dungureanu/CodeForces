package dungureanu.problems.problem1;

// In the popular spreadsheets systems (for example, in Excel) the following numeration of columns is used. The first column has number A, the second
// — number B, etc. till column 26 that is marked by Z. Then there are two-letter numbers: column 27 has number AA, 28 — AB, column 52 is marked by
// AZ. After ZZ there follow three-letter numbers, etc.
//
// The rows are marked by integer numbers starting with 1. The cell name is the concatenation of the column and the row numbers. For example, BC23 is
// the name for the cell that is in column 55, row 23.
//
// Sometimes another numeration system is used: RXCY, where X and Y are integer numbers, showing the column and the row numbers respectfully. For
// instance, R23C55 is the cell from the previous example.
//
// Your task is to write a program that reads the given sequence of cell coordinates and produce each item written according to the rules of another
// numeration system.
// Input
//
// The first line of the input contains integer number n (1 ≤ n ≤ 105), the number of coordinates in the test. Then there follow n lines, each of them
// contains coordinates. All the coordinates are correct, there are no cells with the column and/or the row numbers larger than 106 .
// Output
//
// Write n lines, each line should contain a cell coordinates in the other numeration system.
// Sample test(s)
// Input
//
// 2
// R23C55
// BC23
//
// Output
//
// BC23
// R23C55

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B1 {

	private final static String cellNumber = "ZABCDEFGHIJKLMNOPQRSTUVWXY";

	public static void main(final String[] args) {
		final Scanner scanner = new Scanner(System.in);
		int lines = scanner.nextInt();

		final B1 b1 = new B1();

		for (; lines > 0; lines--) {
			final String coordinates = scanner.next();
			System.out.println(b1.getNewCoordinates(coordinates));
		}

		scanner.close();
	}

	private String getNewCoordinates(final String coordinates) {
		final String newCoordinates;
		if (Pattern.matches("R\\d+C\\d+", coordinates)) {
			final Matcher matcher = Pattern.compile("\\d+").matcher(coordinates);

			matcher.find();
			final int coordinate1 = Integer.valueOf(matcher.group());

			matcher.find();
			final int coordinate2 = Integer.valueOf(matcher.group());

			newCoordinates = getCellString(coordinate2) + coordinate1;
		} else {
			final Matcher matcher = Pattern.compile("\\d+").matcher(coordinates);

			matcher.find();
			final int coordinate2 = Integer.valueOf(matcher.group());

			final String coordinate1 = coordinates.replace(String.valueOf(coordinate2), "");

			newCoordinates = "R" + coordinate2 + "C" + getCellNumber(coordinate1);
		}
		return newCoordinates;
	}

	private String getCellString(int coordinate) {
		final StringBuffer buffer = new StringBuffer();
		while (coordinate > 0) {
			buffer.append(cellNumber.charAt(coordinate % 26));
			coordinate = coordinate % 26 == 0 ? coordinate / 26 - 1 : coordinate / 26;
		}
		buffer.reverse();
		return buffer.toString();
	}

	private int getCellNumber(final String coordinate) {
		int numberCoordinate = 0;
		final StringBuffer buffer = new StringBuffer(coordinate);
		buffer.reverse();

		for (int index = 0; index < buffer.length(); index++) {
			final int cellValue = cellNumber.indexOf(buffer.charAt(index));
			numberCoordinate += (cellValue == 0 ? 26 : cellValue) * Math.pow(26, index);
		}
		return numberCoordinate;
	}
}

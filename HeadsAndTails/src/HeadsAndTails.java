import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class HeadsAndTails {
	private static Scanner scanner;

	public static void main(String[] args) {

		scanner = new Scanner(System.in);
		String input;
		System.out.print("Input: ");
		input = scanner.nextLine();
		input = input.replaceAll(", ", "");
		System.out.println(input);
		LinkedList<String> listH = new LinkedList<String>(Arrays.asList(input.split("T+")));
		Collections.sort(listH);
		int maxLengthH = listH.getLast().length();
		LinkedList<String> listT = new LinkedList<String>(Arrays.asList(input.split("H+")));
		Collections.sort(listT);
		int maxLengthT = listT.getLast().length();
		if (maxLengthH > maxLengthT) {
			System.out.println("Output: H wins!");
		}
		if (maxLengthT > maxLengthH) {
			System.out.println("Output: T wins!");
		}
		if (maxLengthH == maxLengthT) {
			System.out.println("Output: Draw!");
		}
	}
}
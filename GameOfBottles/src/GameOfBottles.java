import java.util.Scanner;

public class GameOfBottles {
	static int n = 0;
	static int min_path = Integer.MAX_VALUE;
	private static Scanner sc;
	static int[][] table = new int[9][9];

	public static void perm(int[] list, int p) {
		int weight = 0;
		if (p == 1) {
			for (int i = 0; i < n - 1; i++) {
				weight = weight + table[list[i]][list[i + 1]];
			}
			if (min_path > weight)
				min_path = weight;
		} else {
			for (int c = 0; c < p; c++) {
				perm(list, p - 1);
				if (p % 2 == 0) {
					list[c] = list[c] + list[list.length - 1];
					list[list.length - 1] = list[c] - list[list.length - 1];
					list[c] = list[c] - list[list.length - 1];
				} else {
					list[0] = list[0] + list[list.length - 1];
					list[list.length - 1] = list[0] - list[list.length - 1];
					list[0] = list[0] - list[list.length - 1];
				}
			}
		}
	}

	public static void main(String[] args) {

		int[] xcoor = { 1, 1, 3, 3, 15, 20, 3, 20, 25 };
		int[] ycoor = { 1, 2, 3, 2, 9, 8, 18, 5, 3 };
		System.out.print("n=");
		sc = new Scanner(System.in);
		n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			xcoor[i] = sc.nextInt();
			ycoor[i] = sc.nextInt();
		}
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				table[r][c] = Math.abs(xcoor[r] - xcoor[c]) + Math.abs(ycoor[r] - ycoor[c]);
			}
		}
		int[] arr = new int[n];
		for (int c = 0; c < n; c++) {
			arr[c] = c;
		}
		perm(arr, n);
		System.out.print(min_path);

	}
}

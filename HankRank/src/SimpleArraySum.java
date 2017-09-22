import java.util.Scanner;

public class SimpleArraySum {

	public static void main(String[] args) {

		int n;

		Scanner in = new Scanner(System.in);
		System.out.println("Enter size of array");
		n = in.nextInt();
		int a[] = new int[n];
		System.out.println("Enter array variables");
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}

		int sum = 0;

		for (int num : a) {
			sum = sum + num;
		}
		System.out.println(sum);
	}

}

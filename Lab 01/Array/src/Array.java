import java.util.Scanner;
import java.util.Arrays;
public class Array {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n; int sum = 0; float avg;
		System.out.print("Enter n: ");
		n = input.nextInt();
		int A[] = new int[n];
		for(int i=0;i<n;i++) {
			System.out.print("Enter A[" + i + "]: ");
			A[i] = input.nextInt();
		}
			Arrays.sort(A);
			System.out.print("Sorted: ");
			for(int x:A) {
				System.out.print( x + " ");
				sum += x;
			}
			avg = sum/n;
			System.out.println();
			System.out.println("Sum: " + sum);
			System.out.println("Avg: " + avg);
		input.close();
	}
}

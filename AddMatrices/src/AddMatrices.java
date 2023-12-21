import java.util.Scanner;
public class AddMatrices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int r,c;
		System.out.println("Enter rows, columns: ");
		r = input.nextInt();
		c = input.nextInt();	
		int a[][] = new int[r][c];
		int b[][] = new int[r][c];
		int s[][] = new int[r][c];
		for(int i=0;i<r;i++)
			for(int j=0;j<c;j++) {
				System.out.print("a[" + i + "][" + j + "] = ");
				a[i][j] = input.nextInt();
			}
		for(int i=0;i<r;i++)
			for(int j=0;j<c;j++) {
				System.out.print("b[" + i + "][" + j + "] = ");
				b[i][j] = input.nextInt();
			}
		for(int i=0;i<r;i++)
			for(int j=0;j<r;j++) s[i][j] = a[i][j] + b[i][j];
		System.out.println("Sum of a and b: ");
		for(int i=0;i<r;i++) {
			for(int j=0;j<r;j++) System.out.print(s[i][j] + " ");
			System.out.println();
		}
		input.close();
	}

}

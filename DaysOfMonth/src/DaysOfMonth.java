import java.util.Scanner;
public class DaysOfMonth {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// TODO Auto-generated method stub
		String A[] = {"January", "March", "May", "July", "August", "November", "December", "Jan.", "Mar."
					, "Aug.", "Oct.", "Dec.", "Jan", "Mar", "Jul", "Aug", "Oct", "Dec", "1", "3", "5", "7", "8"
					, "10", "12"};
		String B[] = {"April", "June", "September", "November", "Apr.", "Sept.", "Nov.", "Apr", "Jun"
					, "Sep", "Nov", "4", "6", "9", "11"};
		String C[] = {"February", "Feb.", "Feb", "2"};
		
		int year;
		String month;
		do {
			System.out.print("Enter year: ");
			year = input.nextInt();
		} while(year<0);
		
		do{
			System.out.print("Enter month: ");
			month = input.next();
			for(String s: A) if(s.equals(month)) {
				System.out.println("31 days.");
				continue;
			}
			for(String s: B) if(s.equals(month)) {
				System.out.println("30 days.");
				continue;
			}
			for(String s: C) if(s.equals(month)) {
				if(year % 400 == 0) System.out.println("29 days.");
				else if(year % 4 == 0 && year % 100 != 0) System.out.println("29 days.");
				else System.out.println("28 days.");
				continue;
			}
			month = "*";
		} while(month != "*");
	input.close();
	}
}

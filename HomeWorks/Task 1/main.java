import java.util.Scanner;

class Program {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		
		int i = scanner.nextInt();
		
		System.out.println(i/64%2 + "" + i/32%2 + "" + i/16%2 + "" + i/8%2 + "" + i/4%2 + "" + i/2%2 + "" + i%2);
	}
}
import java.util.Scanner;

class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("MENU:");
			System.out.println("1. Show in range");
			System.out.println("2. Sum of numbers");
			System.out.println("3. Sum of digits");
			System.out.println("4. Exit");

			int command = scanner.nextInt();

			switch (command) {
				case 1: {
					int a = scanner.nextInt();
					int b = scanner.nextInt();
					for(int i = a; i <= b; i++){
						if(i%2 == 0){
						   System.out.println(i + "");
						   }					
						}
					break;
				}
				case 2: {
					int n = scanner.nextInt();
					int summ = 0;
					for (int i = 0; i < n; i++){
					 int x = scanner.nextInt();
					 summ = summ + x;
					 }
					System.out.println(summ);
					break;
				}
				case 3: {
					int num = scanner.nextInt();
					int summ = 0;
					while(num != 0){
					  summ = summ + num%10;
					  num = num/10;
					}
					System.out.println(summ);
					break;
				}
				default: {
					System.exit(0);
					break;
				}
			}
		}
	}
}
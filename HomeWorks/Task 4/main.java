import java.util.Scanner;

class main {

public static int addLine(String line) {
        char text[] = line.toCharArray();
		int N = text.length;
		int a[] = new int[N];
		int b[] = new int[N];

		int num = 0;
		for (int i = N-1; i >=0; i--) {
			a[N-1-i]=text[i]-'0';
		    
			}
	    for (int i = N-1; i >=0; i--) {
		num = num + (a[i]*(int)Math.pow(10, i));
    }
	return num;
	}


    public static void main(String[] args) {  
			Scanner scanner = new Scanner(System.in);	
            String line = scanner.nextLine();
			System.out.println("char = "+line);
            int num = addLine(line);
			System.out.println("num = "+num);
        }

    
}
import java.util.Scanner;

class MainA {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("N = ");
	    int N = scanner.nextInt();
	    int a[] = new int[N];
	    System.out.println("a[i] = ");
	    for (int i = 0; i < N; i++) 
	    {
            a[i] = scanner.nextInt(); 
        }
	    System.out.print ("a[N] =");
        for (int i = 0; i < N; i++) 
	    {
          System.out.print (" " + a[i]);
        }
        System.out.println();
	  }
}
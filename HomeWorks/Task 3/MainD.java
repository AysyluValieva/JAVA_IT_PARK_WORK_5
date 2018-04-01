import java.util.Scanner;

class MainD {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("N = ");
	    int N = scanner.nextInt();
		
	    int a[][] = new int[N][N];
	    System.out.println("a[i][j] = ");
	    for (int i = 0; i < N; i++) 
	    {
			for(int j = 0; j < N; j++){
                 a[i][j] = scanner.nextInt(); 
			}
        }
	    System.out.println ("a[N][N] = ");
        for (int i = 0; i < N; i++) 
	    {
			for(int j = 0; j < N; j++){
                System.out.print (a[i][j]+" ");
			}
			System.out.println();
        }
		
		int sum = 0;
		int d[] = new int[N];
		for (int i = 0; i < N; i++) 
	    {
			for(int j = 0; j < N; j++){
				d[i] = a[i][N-1-i];
			}
			sum=sum+d[i];
			

		}
		System.out.print (sum+" ");

		System.out.println();
	  }
}
import java.util.Scanner;

class MainB {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("N = ");
	    int N = scanner.nextInt();
		System.out.println("M = ");
	    int M = scanner.nextInt();
	    int a[][] = new int[N][M];
	    System.out.println("a[i][j] = ");
	    for (int i = 0; i < N; i++) 
	    {
			for(int j = 0; j < M; j++){
                 a[i][j] = scanner.nextInt(); 
			}
        }
	    System.out.print ("a[N][M] = ");
		System.out.println();
        for (int i = 0; i < N; i++) 
	    {
			for(int j = 0; j < M; j++){
                System.out.print (a[i][j]+" ");
			}
			System.out.println();
        }
		
		
		
		
		
	  }
}
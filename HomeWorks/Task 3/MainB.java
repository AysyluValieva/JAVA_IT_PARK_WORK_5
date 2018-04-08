import java.util.Scanner;

class MainB {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("N = ");
	    int N = scanner.nextInt();
		System.out.println("M = ");
	    int M = scanner.nextInt();
		
	    int a[][] = new int[N][M];
		int i, j, k;
	    System.out.println ("a[N][M] = ");
		
		k = 1;
		
        for ( i = 0; i < N ; ++i ){
            if((i%2==0)){
			for(j = 0; j < M; j++){
			   a[i][j] =k;
               k++;
			   System.out.print (a[i][j]+" ");
			   }
			   }
			else {
			  for (j = 0; j < M; j++){
			  //a[i][j]=k;
			  a[i][j]=k+M-1-j;
			  System.out.print (a[i][j]+" ");
			  }
			  k = k + M;

			}
			System.out.println();

			}
			
				
		
		
	  }
}
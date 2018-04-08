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
		
		for (int i = 0; i < N; i++){
		  boolean f = false;
		  for (int j = i+1; j < N; j++){
		    if(a[i]==a[j]){
			   f = true;
			   a[j]=0;
			}
			
			
		  }
		  if(f == true){a[i]=0;}else{a[i]=a[i];}
			System.out.print (" " + a[i]);
		  System.out.println();
		}
		
		
		
	  }
}

public class recursion_factorial {

	public static void main(String[] args) {
		
		solution4 sol4 = new solution4();

        int test = 5;
		
		System.out.println(sol4.factorial(test));
		
		
	}
/////////////////////////////////////////////////////////////////////////////	
static class solution4{
//	
		public static int factorial(int n) {		
			if (n==0)
				return 1; 							// Base Case
			else
				return (n * factorial(n-1));		// General Case			
		}
	
	}

}
import java.util.*;

public class HW10_2 {
   public static void main(String[] args) {

      Solution sol = new Solution();

      // Your solution methods will be tested with random input; the following is just
      // an example. The actual test cases will be different.
      int[] output = sol.getN(new int[]{1,2,3,4,5,6}, 3);

      // You may use this approach to print your output to console to validate
      System.out.println("[2,3,6], [1,2,3], [4,5,6], etc. => "+Arrays.toString(output)+"\n"); // combination of any 3 input integers
                                                   // [2,3,6], [1,2,3], [4,5,6], etc. 

      // If you wish to repeat with a different test case, you may as follows:
      output = sol.getN(new int[]{1,1,1,2,2,3,3,3,3,3,3,4,4,4,4,4,4,4,4,5,5,6}, 3);
      System.out.println("[6,5,2] in any order => "+Arrays.toString(output)+"\n"); // [6,5,2] or them 3 in any order
      
      output = sol.getN(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2}, 1);
      System.out.println("[2] => "+Arrays.toString(output)+"\n"); // [2]       
      
      output = sol.getN(new int[]{1}, 1);
      System.out.println("[1] => "+Arrays.toString(output)+"\n"); // [1]  
      
      output = sol.getN(new int[]{11,12,1,2,10,100}, 3);
      System.out.println("Any combination of 3 from array => "+Arrays.toString(output)+"\n"); // Any combination of 3 from array 
   }
} 

class Solution {

   // YOU MAY ADD ANY ADDITIONAL METHODS, VARIABLES, ETC., HERE
  
   /**
   * PURPOSE: 
   * PARAMETERS: 
   * RETURN VALUES:
   */ 
   public int[] getN(int[] input, int N) {
      // YOUR CODE HERE 

	   
	   
	   /*PSEUDOCODE
	    * You may consider building a HashMap that stores each integer's value and its corresponding frequency first. 
	    * This hash map is your dictionary of key-value pairs that give you each integer's number of occurrences in the input.
	    * Then, use that HashMap to build a heap of size N. Will this heap be a min or max heap? 
	    * At the end, your new heap should only have N integers
	    * You will get these N integers from the heap into your output array to return; these N integers can be in any order in your output array.
	    * Lastly: sometimes, you may have a test case where all of the integers in input occur exactly for the same number of times. 
	    * For example: [1,1,2,2,3,3,4,4] and N=2. 
	    * In this case, your output array of size 2 can be any combination of these integers.
	    */
	   
	   
	   // no duplicate keys!
	   //key is the element
	   //value is the number of ocurrences 
	   Map<Integer,Integer> hMap = new HashMap<Integer,Integer>();
	   
	   Queue<Integer> q = new PriorityQueue<Integer>();
	   
	   int size = input.length;
	   
	   int count = 0;
	   // am experiment - try printing hashmap
	   
	   int aptr=0; // initialize pointers
	   int bptr=0;
	   
	   boolean [] visited = new boolean[size]; /// initialize boolean array to track visited elements
	   Arrays.fill(visited, false); // fill array with false to use in test boolean condition
	   
	   for(int i = 0; i<size;i++) {
		   
		   if (visited[i]==true) {
			   continue;
		   }
		   
		   count = 1;
		   
		   for(int j=i+1;j<size;j++) {
			   
			   if(input[i]==input[j]) {
				   visited[j] = true;
				   count++;
			   }
				   
		   }
		   
		   hMap.put(input[i], count);
		   
	   }
	   
	   System.out.println(hMap);
	   //for loop
	   //	key = x
	   //	value = y
	   //	hash.put(x,y)
	   
	   
	   
	   //place holder
	   int[] arr = {0};
	   return arr;

	   
	   /////idea 1
//	   int i = q.get(0);
//	   int j = q.get(1);
//	   int k = q.get(2);
//	   
//	   return new int[] {i,j,k};
	   
   }
}

/*
 * Constraints and Assumptions
-1 <= input.length <= 10000.
-Input integers are in the range of Integer.MIN_VALUE and Integer.MAX_VALUE.
-Input integers do not have to be in any order.
-1 <= N <= # of unique integers in input. For example, your input cannot be [1,2,2,3,3,3,10,11,12,100] 
while N = 12 because the number of unique integers (7) in the input is less than N (12).
*/

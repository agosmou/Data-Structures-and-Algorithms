import java.util.*;

public class HW4_1 {    
   public static void main(String[] args) {
      // your solution will be tested as such, sequentially with random input
      Solution sol = new Solution();
      //System.out.println("false-"+ sol.canDistribute(new int[]{1}, 2)); // false
      System.out.println("false-"+ sol.canDistribute(new int[]{1, 3, 2, 3, 3, 2}, 3)); // false
      //System.out.println("true-"+ sol.canDistribute(new int[]{3,4,5,6}, 2)); // true
      //System.out.println("false-"+ sol.canDistribute(new int[]{3,4,5,6}, 3)); // false
      //System.out.println("true-"+ sol.canDistribute(new int[]{5,4,5,4}, 2)); // true
      //System.out.println("true-"+ sol.canDistribute(new int[]{1}, 1)); // true
      //System.out.println("true-"+ sol.canDistribute(new int[]{1,3,2,3,4,1,3,5,2,1}, 5)); // true 
      //System.out.println("false-"+ sol.canDistribute(new int[]{1}, 4)); // false
        
   }
}
//

/**
 * PURPOSE: Check if the given number of "resources" can be divided into a given number of "groups" of equal sum.
 * PARAMETERS:int[] resources, int groups. These parameters are used to instantiate the solution class and will be passed as arguments/parameters in the canDistribute function
 * RETURN VALUES: the boolean function will return either true or false
*/
class Solution {
   public boolean canDistribute(int[] resources, int groups) { 
      // YOUR CODE HERE 
	   
//Pseudocode
	   
	   int sum = 0;
	   
	   int k = groups;
	   	   
	   for (int i = 0; i< resources.length; i++) { //Iterative loop to find the sum of the array elements given by the user
		   sum = resources[i] + sum;
	   }
	   
// Find the purported (i.e. alleged) allocation for each group, i.e. allocation = SUM(resources)/k   
	   int allocation = sum/groups; // setting the integer to find the allocation of resources for each group
   	
//Sort the resources in either ascending or descending order
	   Arrays.sort(resources); 	   

// Check for all boundary conditions to return result immediately if known, e.g., resources.length()=1 and k=1, return true; resources.length()=1 and k=4, return false, etc.
	   
	   if (resources.length == 1 && k == 1) {
		   return true;
	   }

	   /*
	   false if any of these conditions are met:
	   1. You are looking to create MORE groups than there are elements in the array
	   2. You cannot evenly distribute the elements into the required groups, k
	   3. groups, k, is 0 or a negative number
	   */
	   
	   if (resources.length < k || sum % k != 0 || k <=0) {
		   return false;
	   }
	   
// 1. Create an empty array of integers with k elements. This is your "memory buffer"

	   int[] memoryBuffer = new int[k];  // empty array created as memory buffer
	   
	   
	   /*
	    * Initial Parameters passed to recursiveCall: EXAMPLE (new int[]{3,4,5,6}, 2)
	    * .....
	    * 
	    * resources:int[]{3,4,5,6}
	    * k: 2
	    * allocation: sum(3,4,5,6)/2 = 9
	    * memoryBuffer: ["", ""]
	    * resourceIndex: 0
	   */
	   
	   return recursiveCall(resources, k, allocation, memoryBuffer, 0);// Return boolean recursive call
	   
   } // ***end of canDistribute

   // solution method to enable recursion		   
   public boolean recursiveCall(int[] resources, int k, int allocation,int[] memoryBuffer, int resourceIndex) { 
	   
// Check if every element in your memory buffer has the same value. If so, you have an evenly allocated distribution - return true. Otherwise, return false.   
	   
	   if (resourceIndex == resources.length) { 
		   Integer first = memoryBuffer[0];
	       for (int i=1; i<memoryBuffer.length; i++)
	           if (memoryBuffer[i] != first)
	                return false;
	       return true;
	   }
	   
	   int selectedResource = resources[resourceIndex]; // select your resource to pass through recursive function
	   	   
	   for (int i = 0; i < k; i++) { // Loops over the amount of indexes in the memoryBuffer array, i.e. the k amount
		   
		   if (selectedResource <= allocation){ // check if selected resource is <= allocation
			   memoryBuffer[i] = memoryBuffer[i] + selectedResource; // if yes add that to the first available element in your memory buffer of "k" elements
			   if (recursiveCall(resources, k,allocation,memoryBuffer,resourceIndex+1)) { // advance to the next resource. Repeat these steps. If all resources have been considered and there is no more next, move on.
				   return true;
			   }
			   memoryBuffer[i] = memoryBuffer[i] - selectedResource; // balance memoryBuffer
	       }
	   
	   }   

	   // Base case - return false to exit recursion
	   return false;  // if not, move on (return false) to allow recursion to go back, servicing the recursive calls already in your memory buffer

   }  //***end of recursiveCall 

}  // ***end of Solution class
		 		   
import java.util.*;

public class HW10_2 {
   public static void main(String[] args) {

      Solution sol = new Solution();

      // Your solution methods will be tested with random input; the following is just
      // an example. The actual test cases will be different.
      int[] output = sol.getN(new int[]{1,2,3,4,5,6}, 3);

      // You may use this approach to print your output to console to validate
      System.out.println(Arrays.toString(output)); // combination of any 3 input integers
                                                   // [2,3,6], [1,2,3], [4,5,6], etc. 

      // If you wish to repeat with a different test case, you may as follows:
      output = sol.getN(new int[]{1,1,1,2,2,3,3,3,3,3,3,4,4,4,4,4,4,4,4,5,5,6}, 3);
      System.out.println(Arrays.toString(output)); // [6,5,2] or them 3 in any order
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
   }
}
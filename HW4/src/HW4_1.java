public class HW4_1 {    
   public static void main(String[] args) {
      // your solution will be tested as such, sequentially with random input
      Solution sol = new Solution();
      sol.canDistribute(new int[]{1}, 2); // false
      sol.canDistribute(new int[]{1,2,2,3,3,5,5}, 12); // false
      sol.canDistribute(new int[]{3,4,5,6}, 2); // true
      sol.canDistribute(new int[]{1}, 1); // true
      sol.canDistribute(new int[]{1,3,2,3,4,1,3,5,2,1}, 5); // true 
      sol.canDistribute(new int[]{1}, 4); // false
      // etc.
   }
}

/**
 * PURPOSE:
 * PARAMETERS:
 * RETURN VALUES:
*/
class Solution {
   public boolean canDistribute(int[] resources, int groups) { 
      // YOUR CODE HERE 
	   return true;
   }
   
   
}
public class HW9_2 {
   public static void main(String[] args) {
      Solution sol = new Solution();
      // Your solution method will be tested with random input 
      // such as the following; the actual test cases will be 
      // different
      sol.put("app", 100); 
      sol.getSum("ap");     // returns 100 as "ap" is a prefix  to "app"
      sol.put("ap", 1);
      sol.getSum("a");      // returns 101 as "a" is a prefix to both keys in map
      sol.getSum("xyz");    // returns 0 as "xyz" is not a prefix to any keys in map 
      sol.put("app", 8);    // replaces the value of the existing key "app" from 100 to 8
      sol.getSum("ap");     // returns 9 as "ap" is a prefix to both keys in map 
   }
} 


class Solution {

   // You may add any global variables here

   public Solution() { 
      // YOUR CODE HERE, IF NEEDED 
   } 

   /**
   * PURPOSE: 
   * PARAMETERS: 
   * RETURN VALUES:
   */ 
   public void put(String key, int value) { 
      // YOUR CODE HERE 
   } 

   /**
   * PURPOSE: 
   * PARAMETERS: 
   * RETURN VALUES:
   */ 
   public int getSum(String key) { 
      // YOUR CODE HERE 
   } 
}
public class HW9_1 {
   public static void main(String[] args) {
      Solution sol = new Solution();
      // Your solution method will be tested with random input 
      // such as the following; the actual test cases will be 
      // different
      sol.put(1, 1); 
      sol.put(2, 3); 
      sol.get(1);       // returns 1 
      sol.get(30);      // returns -1 (not found) 
      sol.put(1, 100);  // update the existing value 
      sol.get(1);       // returns 100 
      sol.remove(2);    // removes the mapping for 2
      sol.remove(1);    // removes the mapping for 1 
      sol.get(2);       // returns -1 (not found)
      sol.get(1);       // returns -1 (not found) 
   }
} 

class Solution {

   // You may add any global variables you need here 

   public Solution() { 
      // YOUR CODE HERE, IF NEEDED
   } 

   /**
   * PURPOSE: 
   * PARAMETERS: 
   * RETURN VALUES:
   */ 
   public void put(int key, int value) { 
      // YOUR CODE HERE 
   } 

   /**
   * PURPOSE: 
   * PARAMETERS: 
   * RETURN VALUES:
   */    
   public int get(int key) { 
      // YOUR CODE HERE 
   } 

   /**
   * PURPOSE: 
   * PARAMETERS: 
   * RETURN VALUES:
   */ 
   public void remove(int key) { 
      // YOUR CODE HERE 
   } 
}
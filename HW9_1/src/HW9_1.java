public class HW9_1 {
   public static void main(String[] args) {
	   
      Solution sol = new Solution();
      // Your solution method will be tested with random input 
      // such as the following; the actual test cases will be 
      // different
      sol.put(1, 1); 
      sol.put(2, 3); 
      System.out.println(" 1 -> " + sol.get(1));       // returns 1 
      System.out.println(" -1 -> " + sol.get(30));      // returns -1 (not found) 
      sol.put(1, 100);  // update the existing value 
      System.out.println(" 100 -> " + sol.get(1));       // returns 100 
      sol.remove(2);    // removes the mapping for 2
      sol.remove(1);    // removes the mapping for 1 
      System.out.println(" -1 -> " + sol.get(2));       // returns -1 (not found)
      System.out.println(" -1 -> " + sol.get(1));       // returns -1 (not found) 
   }
} 

class Solution {

   // You may add any global variables you need here 
	
	int[] hashmapArray; // initialize integer array

   public Solution() { 
      // YOUR CODE HERE, IF NEEDED
	   
	   hashmapArray = new int[10000];  // create array to hold 10,000 elements. Empty arrays default to "0" values     

	   // Use for-loop to fill the array indexes to "-1" for all elements
	   for (int i = 0; i < hashmapArray.length; i++) {

		   hashmapArray [i] = -1;
	   }
	   
   } 

   /**
   * PURPOSE: To create a map item with a key (i.e. assign an array index to an integer element)
   * PARAMETERS: key value and the integer value
   * RETURN VALUES: void method will not return value
   */ 
   public void put(int key, int value) { 
      // YOUR CODE HERE 
	   hashmapArray[key] = value;
	   
   } 

   /**
   * PURPOSE: to print the map value for the given key (i.e. print the integer element of an array index)
   * PARAMETERS: key value
   * RETURN VALUES: Return value is an integer value for the requested array index
   */    
   public int get(int key) { 
      // YOUR CODE HERE 
	   return hashmapArray[key];
   } 

   /**
   * PURPOSE: return a value to show a non-existing map item (i.e. reassign a -1 element integer to a given index)
   * PARAMETERS: key value
   * RETURN VALUES: void method will not return value
   */ 
   public void remove(int key) { 
      // YOUR CODE HERE 
	   hashmapArray[key] = -1;
   } 
}



/*
-You are NOT allowed to pull in any native Java hash table libraries like HashMap, Map, Hashtable, etc., from java.util to complete this problem; doing so receives -5 logic points.  You may however make use of any non-HashMap related libraries in java.util for this problem.
-You may use any native integer array or your custom LinkedList Node class from our previous lectures as your starting data structure of choice for this problem. If you include a class from our lectures, please make sure you include that class in the same Java solution you submit.
-It is completely up to you as to how your logic is implemented to deliver the required outcome. 
-The size of your hashmap will not exceed 10,000 elements.
-Both keys and values are within the allowable integer ranges of Integer.MAX_VALUE and Integer.MIN_VALUE.
-For this problem, do not worry about handling exceptions; meaning, for example, you won't have to handle use cases that lead to an error in operation, such as removing an element from an empty HashMap. 

Hints
-Think simple. This problem can be solved with either a linked list of your custom implementation or an array.
-You are allowed to create any additional methods of your choice. Caveat: you CANNOT modify the provided method signatures or your solution will not pass autograder.
*/
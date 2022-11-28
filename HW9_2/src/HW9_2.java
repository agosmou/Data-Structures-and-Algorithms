import java.util.*;


public class HW9_2 {
   public static void main(String[] args) {
      Solution sol = new Solution();
      // Your solution method will be tested with random input 
      // such as the following; the actual test cases will be 
      // different
      sol.put("app", 100); 
      sol.getSum("ap");     // returns 100 as "ap" is a prefix  to "app"
      sol.put("ap", 1);
      System.out.println("101 == " + sol.getSum("a"));      // returns 101 as "a" is a prefix to both keys in map
      System.out.println("0 == " + sol.getSum("xyz"));    // returns 0 as "xyz" is not a prefix to any keys in map 
      sol.put("app", 8);    // replaces the value of the existing key "app" from 100 to 8
      System.out.println("9 == " + sol.getSum("ap"));     // returns 9 as "ap" is a prefix to both keys in map 
   }
} 


class Solution {

   // You may add any global variables here
	
	Map <String, Integer> myMap; // initialize

   public Solution() { 
      // YOUR CODE HERE, IF NEEDED 
	   
	   myMap = new HashMap<String,Integer>(); // constructor
	   
   } 

   /**
   * PURPOSE: inserts a key,value pair into the map
   * PARAMETERS: parameter passed is the string key and integer value
   * RETURN VALUES: the void method will not return any values
   */ 
   public void put(String key, int value) { 
      // YOUR CODE HERE 
	   myMap.put(key, value);
   } 

   /**
   * PURPOSE: to find the sum of values associated with the string key
   * PARAMETERS: the parameter passed is a string
   * RETURN VALUES: will return an int sum of the values associated with the key
   */ 
   public int getSum(String key) { 
      // YOUR CODE HERE 
	   
	   int sum = 0;
	   
	   for (var entry : myMap.entrySet()) {
		    
		   String hashKey = entry.getKey();
		   Integer hashValue = entry.getValue();
		   
		   if (hashKey.startsWith(key)) {
			   sum = sum + hashValue;
		   }
		    
		}
	   
	   return sum;	   
   } 
   
}

/*
*Constraints and Assumptions
-You are allowed to use any data structures via import java.util.* for this problem.
-For the put method, the input key is an English prefix (String), and the value is a non-negative integer.
-For the getSum method, the input key is a non-empty String.
-It is completely up to you as to how your logic is implemented to deliver the required outcome. 
-The size of your hashmap will not exceed 10,000 elements.
-The values are within allowable integer ranges of Integer.MAX_VALUE and Integer.MIN_VALUE.
-The length of your English prefix is from 1 to 50 characters inclusive. Note, this means an empty string, "", cannot be a valid prefix because its length is 0. 
*/
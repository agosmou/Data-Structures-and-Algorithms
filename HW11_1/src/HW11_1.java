import java.util.*;

public class HW11_1 {
   public static void main(String[] args) {
      Solution sol = new Solution();

      // Your solution may be tested with random input like this. 
      // The actual test cases will vary. 
      ArrayList<List<String>> routes = new ArrayList<List<String>>();
      routes.add(Arrays.asList("B", "C")); 
      routes.add(Arrays.asList("D", "B"));
      routes.add(Arrays.asList("C", "A"));
      System.out.println(sol.getDestination(routes)=="A");
   }
}

/**
* PURPOSE: Find the string thats the source sink which is evaluated in boolean condition in main method
* PARAMETERS: List of lists created in main method
* RETURN VALUES: string value
*/ 
class Solution {
   public String getDestination(List<List<String>> routes) {
      // YOUR CODE HERE
	   
	   // create hashmap to create adjacency list
	   Map<String, String> adjList = new HashMap<>();
	   
	   for (List<String> route : routes) {
		   adjList.put(route.get(0), route.get(1));
	   }
	   
	   // Iterate through the entries to find the value that is NOT also a key. return this value as the sourcesink
	   for (Map.Entry<String, String> entry : adjList.entrySet()) {
		   if (!adjList.containsKey(entry.getValue())) {
			   // check to return the source sink
			   //System.out.println(entry.getValue());
			   return entry.getValue();
			   
		   }
	   }
	   
	   // return null typically when input routes list length is 0
	   return null;
   }
}
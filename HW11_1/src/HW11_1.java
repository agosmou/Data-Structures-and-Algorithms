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
* PURPOSE: 
* PARAMETERS: 
* RETURN VALUES:
*/ 
class Solution {
   public String getDestination(List<List<String>> routes) {
      // YOUR CODE HERE
   }
}
import java.util.*;
public class HW10_1 {
   public static void main(String[] args) {

      // Your solution methods will be tested with 
      // random tree input; the following is just
      // an example. The actual test cases will be different.

      // EXAMPLE: max heap; arraylist representation in 
      // Breadth-First Traversal is [5,4,3,2,1]
      //       5
      //      / \
      //     4   3
      //    / \
      //   2   1

      // First, take the above array representation of the 
      // input heap and convert it into an ArrayList 
      // instance via the following:
      ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5,4,3,2,1));

      // Then, create an instance of solution by passing 
      // this list in. Note this solution class is basically
      // a heap wrapper, using ArrayList as its buffer to store/manipulate data.
      Solution sol = new Solution(list);

      // Test the operations: enqueue(element) & dequeue(). You may use print() to 
      // display your ArrayList instance in String. 
      sol.enqueue(6);
      sol.print();      // [6,4,5,2,1,3]
      sol.dequeue();    // [5,4,3,2,1]
      sol.enqueue(5);   
      sol.print();      // [5,4,5,2,1,3]
      // etc.
   }
} 


class Solution {
   ArrayList<Integer> list;
   public Solution(ArrayList<Integer> list) {
      this.list = list;
   }
   // This method is for printing the heap's buffer
   public String print() {
      return Arrays.toString(list.toArray());
   }
   // -------------------------------------------
   // !!! PLESE DO NOT MODIFY THE ABOVE !!!
   //     - CONSTRUCTOR 
   //     - ARRAYLLIST DECLARATION
   //     - PRINT METHOD
   // !!! PLESE DO NOT MODIFY THE ABOVE !!!
   // -------------------------------------------

   // YOU MAY ADD ANY ADDITIONAL METHODS, 
   // VARIABLES, ETC., HERE
  
   /**
   * PURPOSE: 
   * PARAMETERS: 
   * RETURN VALUES:
   */ 
   public void enqueue(int element) {
      // YOUR CODE HERE 
   }

   /**
   * PURPOSE: 
   * PARAMETERS: 
   * RETURN VALUES:
   */ 
   public void dequeue() {
      // YOUR CODE HERE 
   }

   /**
   * PURPOSE: 
   * PARAMETERS: 
   * RETURN VALUES:
   */ 
   private void reheapUp(int x) {
      // YOUR CODE HERE - THIS METHOD IS ONLY
      // CALLED BY ENQUEUE(int)
   }

   /**
   * PURPOSE: 
   * PARAMETERS: 
   * RETURN VALUES:
   */ 
   private void reheapDown(int x) {
      // YOUR CODE HERE - THIS METHOD IS ONLY
      // CALLED BY DEQUEUE()
   }

}
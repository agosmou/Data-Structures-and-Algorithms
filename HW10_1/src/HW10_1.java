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
	      System.out.println("[6,4,5,2,1,3] => "+sol.print());      // [6,4,5,2,1,3]
	      
//	      sol.enqueue(7);
//	      System.out.println("[7,4,6,2,1,3,5] => "+sol.print());      // [7,4,6,2,1,3,5]
	      
	      
	      sol.dequeue();    										// [5,4,3,2,1]
	      System.out.println("[5,4,3,2,1] => "+sol.print());
	      sol.enqueue(5);   
	      System.out.println("[5,4,5,2,1,3] => "+sol.print());      // [5,4,5,2,1,3]
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
   
   int refIndex;// initialize
   
   int nodeIndex; 
   
   int lastIndex;
   
   ///////////////////
   //NOTES
   // Consider repeating Elements
   ///////////////////
  
   /**
   * PURPOSE: this method enqueues an integer element into heap.
   * PARAMETERS: the int element inputted by the user is passed into the heap and used later with the ReaheapUp function
   * RETURN VALUES:void method - no return
   */ 
   public void enqueue(int element) {
      // YOUR CODE HERE 
	   /*
	    * Add the element to the end of the heap
	    * Then preserve shape and properties by reheapUp into place. 
	    */
	   
	   list.add(element);
	   
	   refIndex = list.size()-1;// set to last index for use in reheapUp
	   
	   //lastIndex = list.size()-1;
	   
	   //call the reheapUp method and pass the hole element as the argument, ie lastIndex
	   reheapUp(element);
	   
   }


   
   /**
   * PURPOSE: this method dequeues the highest priority element from heap.
   * PARAMETERS: no parameter is passed in this method - it will simply use the exisiting heap values to pass a value to reheapDown
   * RETURN VALUES: void method - no return
   */ 
   public void dequeue() {
      // YOUR CODE HERE 
	   /*
	    * Remove the root first and preserve the complete binary tree structure by replacing it with the last element
	    * Then reheapDown
	    */
	   lastIndex = list.size()-1;
	   
	   
	   nodeIndex = 0;
	   
	   list.set(0, list.get(lastIndex));
	   list.remove(lastIndex);
	   reheapDown(list.get(0)); // recursive call starting from root, working down
	   lastIndex --;
   }
   

   
   
   
   /**
   * PURPOSE: this method is called by enqueue(element); it either iteratively or recursively shifts the element up the tree to "reheap" it.
   * PARAMETERS: Enqueue method calls and passes the element as the argument
   * RETURN VALUES:void method - no return
   */ 
   private void reheapUp(int x) {
      // YOUR CODE HERE - THIS METHOD IS ONLY
      // CALLED BY ENQUEUE(int)
	   
	   //locate parent node
	   //	elements[index]’s parent is in elements[(index - 1) / 2]
	   
	   
	   /*
	    * 
	    * if currElement > parentNode
	    * 	switch spots
	    *   set the reference index to the parentIndex
	    *   reheapUp(int x)
	    *   
	    */
	   
	   int newElement = x;
	   
	   int parentIndex = (refIndex-1)/2;
	   
	   int parent = list.get(parentIndex);
	   
	   if (newElement > parent) {
		   
		   list.set(parentIndex, newElement);
		   list.set(refIndex, parent);
		   refIndex = parentIndex;
		   reheapUp(x);
		   
	   }
	   
	   return;
   }
   /**
   * PURPOSE: this method is called by dequeue(); it either iteratively or recursively shifts the element down the tree to "reheap" it.
   * PARAMETERS: dequeue method calls and passes the element as the argument
   * RETURN VALUES: void method - no return
   */ 
   private void reheapDown(int x) {
      // YOUR CODE HERE - THIS METHOD IS ONLY
      // CALLED BY DEQUEUE()
	  // NOTE: This exercise could not create the children and then recurse through because on a complete tree structure, the get method would cause an error when pulling a value from an index thats out of bounds
	  // thus, various conditions had to be checked 
	   
	   
	   int leftIndex = (nodeIndex*2) + 1;   
	   int rightIndex = (nodeIndex*2) + 2;
	   

	   
	   // if left child exists - right will be nested in this loop because of heap fill behavior. ie you either have a complete or full binary tree filled left to right.
	   if(leftIndex < list.size()) {
		   
	   	   int leftChild = list.get(leftIndex);
		   
	   	   // this conditions tests if the binary tree is complete - ie there is no right-most node, but there is a left.
		   if(leftChild > list.get(nodeIndex) && rightIndex >= list.size()) { // switch with left child
		   
		   list.set(leftIndex, x);
		   list.set(nodeIndex, leftChild);
		   nodeIndex = leftIndex;			   
		   
	      }
		   
		   // if right child exists - array index should be less than list size
		   if(rightIndex < list.size()) {
			   
			   //int leftChild = list.get(leftIndex);
		   	   int rightChild = list.get(rightIndex);
		   	   
			   if(x >= leftChild && x >= rightChild) { // root element, x, must be smaller that either of its children to switch
				   return;
			   }
		   	   
			   // compare children
			   if(leftChild < rightChild) { // switch with right child
				   
				   list.set(rightIndex, x);
				   list.set(nodeIndex, rightChild);
				   nodeIndex = rightIndex;
			   }
			   
			   if(leftChild > rightChild) { // switch with left child
				   
				   list.set(leftIndex, x);
				   list.set(nodeIndex, leftChild);
				   nodeIndex = leftIndex;
			   }
			   
			   
			// recursive call only if new nodeIndex has any new children left
			   if(((nodeIndex*2)+2) < list.size() || ((nodeIndex*2)+1) < list.size()) 		      			{
			      reheapDown(x);
			    }   
		   }
	 }  

   }

}

/*Constraints and Assumptions
-The input list is a valid heap that satisfies both the shape and order properties of a heap data structure.
-The input list is not null.
-This problem will NOT require you to handle any exceptions, meaning there will NOT be a use case calling for enqueuing an element when the list is already full or dequeuing an element from an empty list. 
-Elements in ArrayList are positive integers < 10,000.
-ArrayList is dynamically resizable; there is no max size specified at input. 
-sol.print() returns [] for an empty list.
 *
 */
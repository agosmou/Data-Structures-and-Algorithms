import java.util.Stack;

public class HW5_1 {
   public static void main(String[] args) {
      // your solution will be tested w/ random add()'s and remove()'s.
      // Observers like peek(), isEmpty() will be used along the way to validate.
	   
	   // I set a test to verify my solution
      Solution sol = new Solution();
      
      System.out.println("My Solution:	");
      
      sol.add(8); 
      sol.add(1); 
      System.out.println(sol.peek());    // 8, if you use System.out.print()
      System.out.println(sol.remove());  // 8
      System.out.println(sol.isEmpty()); // false
      sol.add(2); 
      sol.add(3); 
      System.out.println(sol.peek());    // 1    
      
      
      System.out.println("\nThe instructor's solution is: \n8 \n8 \nfalse \n1	");
      
      
      
   }
   
/////////////////////////////////////////////////////////////////
// Alejandro Gomez 10/13/22
// Note to self: This problem functions with two stacks that are used to create a queue. The stack elements will bounce between the stacks for the required instance method. Think of it as a pseudo-tower of hanoi-esque problem, i.e. moving elements from one stack to another
   
}
class Solution {
    // PLEASE USE THESE GLOBAL STACKS FOR THIS PROBLEM
    private Stack<Integer> pushStack = new Stack<Integer>();
    private Stack<Integer> popStack = new Stack<Integer>();
    /*
     * ==================================== 
     * !!! DO NOT MODIFY ABOVE THIS LINE!!!
     * ====================================
     */

    /**
     * PURPOSE: This adds a specified element to the "queue", i.e. the pushStack
     * PARAMETERS: The instance method Stack push() inserts an element of integer x as specified by the user
     *  RETURN VALUES: This adds an element to the queue but does not necessarily require a return hence the word "void"
     */
    public void add(int x) {
        // YOUR CODE HERE
 
    	pushStack.push(x);
    } 
    
    /**
     * PURPOSE: This removes an element from the front of the queue
     * PARAMETERS: The instance method of Stack isEmpty() is used in (2) separate "while loops" with the Stack push() and Stack pop() instance methods to return the integer y.
     * RETURN VALUES: This returns the removed element from the front - FIFO (integer y)
     */
    public int remove() {
        // YOUR CODE HERE
    	
    	//While the push stack is not empty, take the popped elements from it and push them into the pop stack
    	while (!pushStack.isEmpty())
    	{
    		popStack.push(pushStack.pop());
    	}	
    	// now that the values are in the popstack, the "head" is sitting at the top of it so now we can pop it and assign it to variable y
    	int y = popStack.pop();
    	
		// now that we have the information we need, we can put the elements back into their original stack
		while (!popStack.isEmpty())
		{
			pushStack.push(popStack.pop());
		}
		
		// return the assigned value to the function
		return y;
		
    }

    /**
     * PURPOSE: This displays the head of the queue (It does not add or remove)
     * PARAMETERS: The instance method of Stack isEmpty() is used in (2) separate "while loops" with the Stack push(), Stack pop(), and Stack peek() instance methods to return the integer z 
     * RETURN VALUES: This returns the read element at the front - FIFO (integer z)
     */
    public int peek() {
        // YOUR CODE HERE
    	
    	//While the push stack is not empty, take the popped elements from it and push them into the pop stack
    	while (!pushStack.isEmpty())
    	{
    		popStack.push(pushStack.pop());
    	}
    	// now that the values are in the popstack, the "head" is sitting at the top of it so now we can peek it (read only) and assign it to variable z
    	int z = popStack.peek();
    	
		// now that we have the information we need, we can put the elements back into their original stack
    	while (!popStack.isEmpty())
		{
			pushStack.push(popStack.pop());
		}
    	
    	// return the assigned value to the function
    	return z;
    }

    /**
     * PURPOSE: This checks if the queue is empty
     * PARAMETERS: The instance method of Stack isEmpty() on the stack to return a boolean
     * RETURN VALUES: This returns a "true" or "false"
     */
    public boolean isEmpty() {
        // YOUR CODE HERE
    	
    	return pushStack.isEmpty();
    }
}
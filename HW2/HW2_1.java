import java.util.Stack;
import java.util.Arrays; // This is used in the main function to convert the arrays to strings to print them in the console


public class HW2_1 {    
    public static void main(String[] args) {
       // just like any problems, whatever you need here, etc.
    	
// Test Cases
    	   	    	
// Test 1
    	
    	Solution sol1 = new Solution();
          
        int pushed_test1[] = {1,2,3,4};
        int popped_test1[] = {3,4,2,1};
              
        System.out.println("\n(*Solution is true*)\nevents_pushed: " + Arrays.toString(pushed_test1) + "\nevents_popped: " + Arrays.toString(popped_test1)+"\nOutput: " + sol1.isSameEventSequence(pushed_test1, popped_test1));
             
//Test 2
        
        Solution sol2 = new Solution();
        
        int pushed_test2[] = {2,1,3};
        int popped_test2[] = {3,2,1};
              
        System.out.println("\n(*Solution is false*)\nevents_pushed: " + Arrays.toString(pushed_test2) + "\nevents_popped: " + Arrays.toString(popped_test2)+"\nOutput: " + sol2.isSameEventSequence(pushed_test2, popped_test2));
        
//Test 3
        
        Solution sol3 = new Solution();
        
        int pushed_test3[] = {1,2,3};
        int popped_test3[] = {1,2,3};
              
        System.out.println("\n(Solution is true*)\nevents_pushed: " + Arrays.toString(pushed_test3) + "\nevents_popped: " + Arrays.toString(popped_test3)+"\nOutput: " + sol3.isSameEventSequence(pushed_test3, popped_test3));  
        
        
//Test 4
        
        Solution sol4 = new Solution();
        
        int pushed_test4[] = {1};
        int popped_test4[] = {1};
              
        System.out.println("\n(*Solution is true*)\nevents_pushed: " + Arrays.toString(pushed_test4) + "\nevents_popped: " + Arrays.toString(popped_test4)+"\nOutput: " + sol4.isSameEventSequence(pushed_test4, popped_test4));  
        
//Test 5
        
        Solution sol5 = new Solution();
        
        int pushed_test5[] = {1};
        int popped_test5[] = {2,3};
              
        System.out.println("\n(*Solution is false*)\nevents_pushed: " + Arrays.toString(pushed_test5) + "\nevents_popped: " + Arrays.toString(popped_test5)+"\nOutput: " + sol5.isSameEventSequence(pushed_test5, popped_test5));  
        
//Test 6       
        
        Solution sol6 = new Solution();
        
        int pushed_test6[] = {1,2,3};
        int popped_test6[] = {1,1,3};
              
        System.out.println("\n(*Solution is false*)\nevents_pushed: " + Arrays.toString(pushed_test6) + "\nevents_popped: " + Arrays.toString(popped_test6)+"\nOutput: " + sol6.isSameEventSequence(pushed_test6, popped_test6));         
        
//Test 7       
        
        Solution sol7 = new Solution();
        
        int pushed_test7[] = {1,2,3};
        int popped_test7[] = {4,5,6};
              
        System.out.println("\n(*Solution is false*)\nevents_pushed: " + Arrays.toString(pushed_test7) + "\nevents_popped: " + Arrays.toString(popped_test7)+"\nOutput: " + sol7.isSameEventSequence(pushed_test7, popped_test7));       
        
    }
}


//////////////////////////////////////////////////////////////////
//Alejandro Gomez 10.18.22


// FILL OUT THE FOLLOWING API TEMPLATE, WHICH FOLLOWS THE 
// PURPOSE/PARAMETERS/RETURN VALUES STYLE PER THE SYLLABUS. 
/**
 * PURPOSE: This function will check if (2) arrays represent an actual sequence of events - push and pop
 * PARAMETERS: int[] events_pushed, int[] events_popped - These parameters are passed to the isSameEventSequence function
 * RETURN VALUES: The boolean solution will return "true" or "false"
 */
class Solution {
   public boolean isSameEventSequence(int[] events_pushed, int[] events_popped) { 
      // YOUR CODE HERE 
	   
	   
	   // The stack is created to push in the items from our given arrays events_pushed and then pop from the given arrays events_popped   
	   Stack<Integer> myStack = new Stack<>();

	// Set the constraint for the stacks' lengths to be greater than 0 but less than 100
	   // if this condition is met, proceed with the code as general. Any arrays outside of these parameters will return false
		if (events_pushed.length >= 1 && events_pushed.length<100 && events_popped.length >= 1 && events_popped.length<100)
		  {	   
			
				   for (int i=0, j =0; i < events_pushed.length && j< events_popped.length; i++) // initialize variables and set parameters. Increase iteration by 1 for each loop
				   {
					   
					   int x = events_pushed[i]; // initialize a variable to be set to element values for each array index iterated and then push it into the stack
					   myStack.push(x);
					   			   
					   while (!myStack.isEmpty() && myStack.peek() == events_popped[j]) { // only while conditions are met - an un-empty stack and the peeked(read only) value is equal to the element in the j index of the events_popped array then pop.
						   myStack.pop();  
						   j++; // upon doing so increase the loop iteration for this function
					   }
				   }
			 		   
			   // If all items have been popped properly because all constraints/assumptions are valid, then the created stack should be empty and return true
			   return myStack.isEmpty();
		
		  }
		
		// if-else condition for array size - upon failure, the boolean function should return "false" since it would be against the homework's constraints/assumptions
		   else
		   {
			   return false;
		   }
	
	}
   
   
}
//NOTE: when the queue is empty, both front and rear should have an index of -1.
//Your solution will be tested against 9-10 test cases; -1 for each failed test.
//Each test case includes a combination of queue operations, and getFront() and getRear() to test the correctness of your "Floating Front Design".

//import java.util.Arrays; // used to get array with test method. For testing only.

public class HW6_1 {
   public static void main(String[] args) {
      // your solution method will be tested as such, with random sequential input
// TEST CASE #1: instantiate a queue of capacity = 1
      Solution sol = new Solution(1);
      
      System.out.println("Read Front: -1 | Actual:  " + sol.getFront()); // -1
      System.out.println("Read Rear: -1 | Actual:  " + sol.getRear()); // -1
//System.out.println(sol.getElements());         
      sol.add(8);  
//System.out.println(sol.getElements());      
      System.out.println("Read Front: 0 | Actual:  " + sol.getFront()); // 0      
//System.out.println(sol.getElements());            
      System.out.println("Read Rear: 0 | Actual:  " + sol.getRear()); // 0      
//System.out.println(sol.getElements());            
      System.out.println("Read Peek: 8 | Actual:  " + sol.peek()); // 8      
//System.out.println(sol.getElements());            
      System.out.println("ReadRemoved: 8 | Actual:  " + sol.remove()); // 8      
//System.out.println(sol.getElements());            
      System.out.println("Read isEmpty: true | Actual:  " + sol.isEmpty()); // true     
//System.out.println(sol.getElements());          
      System.out.println("Read Front: -1 | Actual:  " + sol.getFront()); // -1, when queue is empty      
//System.out.println(sol.getElements());            
      System.out.println("Read Rear: -1 | Actual:  " + sol.getRear()); // -1, when queue is empty      
//System.out.println(sol.getElements());

////////////////////////////////////////////////////

// TEST CASE #2: instantiate a queue of capacity = 3
      Solution sol1 = new Solution(3);
      sol1.add(1);
      sol1.add(2);
      sol1.add(3);
      
//System.out.println("\n"+sol1.getElements());
      
      System.out.println("Read Front: 0 | Actual:  " + sol1.getFront()); // 0
      
//System.out.println(sol1.getElements());

      System.out.println("Read Rear: 2 | Actual:  " + sol1.getRear()); // 2
      
//System.out.println(sol1.getElements());

      System.out.println("Read Removed: 1 | Actual:  " + sol1.remove()); // 1
      
//System.out.println(sol1.getElements());   

      System.out.println("Read Front: 1 | Actual:  " + sol1.getFront()); // 1
      
//System.out.println(sol1.getElements());

      System.out.println("Read Rear: 2 | Actual:  " + sol1.getRear()); // 2
      
      // etc
   }
}

class Solution {
   // Dynamic array size
   private int capacity;
   // Queue
   private int[] elements;
   // Dynamic queue size
   private int numElements = 0;
   // Dynamic index for the front of queue, defaulting to -1 when the queue is empty
   private int front = -1;
   // Dynamic index for the rear of queue, defaulting to -1 when the queue is empty
   private int rear = -1;

   // Constructor
   public Solution(int capacity) {
      this.capacity = capacity;
      this.elements = new int[this.capacity];
   }
   // Get the front index
   public int getFront() {
      return this.front;
   }
   // Get the rear index
   public int getRear() {
      return this.rear;
   }
   //////////////////////////////////////////////
//   // TEST CODE ONLY (GETTER): Get the elements
//   public String getElements() {
//      return Arrays.toString(elements);
//   }
   //////////////////////////////////////////////
   
   /* =====================================
   /* !!! DO NOT MODIFY ABOVE THIS LINE!!!
   /* ====================================

  
  /**
   * PURPOSE: This will enqueue an integer
   * PARAMETERS: The parameter is the user input integer
   * RETURN VALUES: The void keyword indicated no returned value
  */
  public void add(int x) { 
     // YOUR CODE HERE
	 // Assumes add method will not be called on array at capacity - no exceptions needed
	 // reference pg. 225-228 in textbook
	  
	    
	  if (front == -1 && rear == -1) {
		  front++;
	  	  rear++;
	  	  numElements++;
	  	  elements [rear] = x;
	  }
	  else { 
		  rear++;
	  	  numElements++;
	  	  elements [rear] = x;
	  }
  
  }

  /**
   * PURPOSE: This will dequeue an integer
   * PARAMETERS: The parameter is the user input integer
   * RETURN VALUES: This method should return an integer
  */
  public int remove() { 
     // YOUR CODE HERE
	 // remove() will not be called on an empty queue
	  
	 int returnDequeue = elements[front];

	 if (front == 0 && rear == 0) {
		 front = -1;
		 rear = -1;
	 }
	 else {
	 front ++;
	 numElements --;
	 }
	 
	 return returnDequeue;

  }

  /**
   * PURPOSE: To see what element is sitting at the front of the queue
   * PARAMETERS: There is no parameter here
   * RETURN VALUES: This will return the integer value for the front element
  */
  public int peek() { 
     // YOUR CODE HERE
	 // Assumes this method will not call if empty
	 return elements[front]; //returns the front element if queue is not empty // peekFront() per pg. 250

	// or use this, below, to peek the rear element
	//return elements[rear]; // peekRear() per pg. 250

  }
  
  /**
   * PURPOSE: To find if the queue is empty or not
   * PARAMETERS: No parameter - simply evaluated on the current array
   * RETURN VALUES: This will return a True or False value if both conditions are met
  */
  public boolean isEmpty() { 
    // YOUR CODE HERE
	  return (front == -1 && rear == -1); // Returns true when both conditions are true
	  
  }
}

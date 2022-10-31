//NOTE: when the queue is empty, both front and rear should have an index of -1.
//Your solution will be tested against 9-10 test cases; -1 for each failed test.
//Each test case includes a combination of queue operations, and getFront() and getRear() to test the correctness of your "Floating Front Design".



public class HW6_1 {
   public static void main(String[] args) {
      // your solution method will be tested as such, with random sequential input
      // TEST CASE #1: instantiate a queue of capacity = 1
      Solution sol = new Solution(1);
      sol.getFront(); // -1
      sol.getRear(); // -1
      sol.add(8);
      sol.getFront(); // 0
      sol.getRear(); // 0
      sol.peek(); // 8
      sol.remove(); // 8
      sol.isEmpty(); // true
      sol.getFront(); // -1, when queue is empty
      sol.getRear(); // -1, when queue is empty

      // TEST CASE #2: instantiate a queue of capacity = 3
      Solution sol1 = new Solution(3);
      sol1.add(1);
      sol1.add(2);
      sol1.add(3);
      sol1.getFront(); // 0
      sol1.getRear(); // 2
      sol1.remove(); // 1
      sol1.getFront(); // 1
      sol1.getRear(); // 2
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

   /* =====================================
   /* !!! DO NOT MODIFY ABOVE THIS LINE!!!
   /* ====================================

  
  /**
   * PURPOSE: 
   * PARAMETERS: 
   * RETURN VALUES:
  */
  public void add(int x) { 
     // YOUR CODE HERE
	  
	  // The below will insert the user called integer at the end of the queue
	  elements[rear] = x;
      rear++;
	    
  }

  /**
   * PURPOSE: 
   * PARAMETERS: 
   * RETURN VALUES:
  */
  public int remove() { 
     // YOUR CODE HERE
	  
	  
	  
	  for (int i = 0; i < rear - 1; i++) {
          elements[i] = elements[i + 1];
      }

	  if (rear == (capacity - 1))
		  rear = 0;
	  else
		  rear = rear + 1;

      // decrement rear
      rear--;
      
      
      
	  int y = elements[numElements - 1];
	  numElements--;
	  return y;

  }

  /**
   * PURPOSE: 
   * PARAMETERS: 
   * RETURN VALUES:
  */
  public int peek() { 
     // YOUR CODE HERE
	  
	  
		  

	  
  }
  
  /**
   * PURPOSE: 
   * PARAMETERS: 
   * RETURN VALUES:
  */
  public boolean isEmpty() { 
    // YOUR CODE HERE
	  return (front == -1 && rear == -1);
	  
  }
}



////////////////////////////////////////////////////////////////////////////////////////////
//
//To	get	the	next	position	for	the	rear	indicator,	for	instance,	we	can	use	
//an	if statement.	Assume	capacity	represents	the	size	of	the	array:
//	
//if (rear == (capacity − 1))
// rear = 0;
//else
// rear = rear + 1;
//
//Another	way	to	reset	rear	is	to	use	the	modulo	(%)	operator:
//	
//rear = (rear + 1) % capacity;
import java.util.*;
public class HW7_1 {    
    public static void main(String[] args) {
       // Your solution will be tested as such, with random input lists such as the following
       List<Integer> ints = new ArrayList<>(Arrays.asList(1, 2, 3));
       MyIterator iter = new MyIterator(ints.iterator()); // invoking iterator method
       System.out.println(iter.next());         // 1
       System.out.println(iter.lookAhead());    // 2
       System.out.println(iter.next());         // 2
       System.out.println(iter.next());         // 3
       System.out.println(iter.hasNext());      // false
       
       List<Integer> ints1 = new ArrayList<>(Arrays.asList(100));
       MyIterator iter1 = new MyIterator(ints1.iterator());
       System.out.println("\n" + iter1.next());  // 100
       System.out.println(iter1.lookAhead());    // null
       System.out.println(iter1.next());         // null
       System.out.println(iter1.hasNext());      // false
       
       List<Integer> ints2 = new ArrayList<>(Arrays.asList(4,5,6));
       MyIterator iter2 = new MyIterator(ints2.iterator());
       System.out.println("\n" + iter2.next());  // 4
       System.out.println(iter2.lookAhead());    // 5
       System.out.println(iter2.next());         // 5
       System.out.println(iter2.hasNext());      // true
       
       List<Integer> ints3 = new ArrayList<>(Arrays.asList(7,8,9));
       MyIterator iter3 = new MyIterator(ints3.iterator());
       System.out.println("\n" + iter3.lookAhead());  // 7
       System.out.println(iter3.next()); // 7
       System.out.println(iter3.next()); // 8
       System.out.println(iter3.next()); // 9
       System.out.println(iter3.next()); // null - this is the end of the list
       System.out.println(iter3.hasNext()); // false - end of list
       
       
    }
}
class MyIterator implements Iterator<Integer> {

   // ==============================================
   // ANY GLOBAL VARIABLE DECLARATIONS HERE

	// This will be our iterator pointer	
	private Integer nextInteger = null;	// used the wrapper "Integer" in lieu of the primitive "int" because of the method type "Integer" that can function with null

	private Iterator<Integer> listIterator = null; // Declared Iterator<Integer> named listIterator
	
   // ==============================================

   public MyIterator(Iterator<Integer> iterator) { //Initialize Integer iterator called "iterator"
      // ==============================================  
      // YOUR INITIALIZATIONS HERE
	   
	    listIterator = iterator; // initialized the iterator for the class to pass as an argument for the method
	    nextInteger = listIterator.next(); // from null, this variable is now initialized to hold the element next in sequence, i.e. the first Integer in the list

      // ==============================================
   }

   /**
    * PURPOSE: returns the element that will be returned by the next invocation of next(). Note this lookAhead() method is completely custom. You will need to implement logic to correctly return the right element. This method returns the next element in the iteration WITHOUT advancing the iterator.
    * PARAMETERS: does not take a parameter
    * RETURN VALUES: returns an Integer or null
   */
   public Integer lookAhead() { // this is similar to peek(). READ ONLY - DO NOT REMOVE
      // ============================================== 
      // YOUR CODE HERE

	   return nextInteger; // this value is is assigned to the variable next is sequence so it simply returns it to the method
	   
      // ==============================================
   }

   /**
    * PURPOSE: returns the next element in the iteration (ie what the variable nextInteger is currently assigned to)
    * PARAMETERS: does not take a parameter
    * RETURN VALUES: returns an Integer or null
   */
   @Override
   public Integer next() {
      // ============================================== 
      // YOUR CODE HERE
	  
	   Integer savedInteger = nextInteger; // The value that was currently being held for the integer next in sequence
   
	   if(!listIterator.hasNext()) { // use the boolean hasNext() method to test if there is NOT another integer to iterate through; thus, null
		   nextInteger = null;
	   }	   
	   else {
		   nextInteger = listIterator.next(); // Otherwise, reassign the nextInteger variable to hold the value of the integer next in sequence to be used in other methods
	   }

	   return savedInteger; // Now that the value of "nextInteger" has been reassigned, it is legal to return the previously saved value

      // ==============================================
   }

   /**
    * PURPOSE: returns true if the iteration has more elements, false otherwise.
    * PARAMETERS: does not take a parameter
    * RETURN VALUES: returns a boolean true or false value
   */
   @Override
   public boolean hasNext() {
      // ============================================== 
      // YOUR CODE HERE
	   
	   return nextInteger != null; 	// Note, that nextInteger is of Integer wrapper in order for this condition to be evaluated to null
	   // This method will follow the next() method where nextInteger variable will have been reassigned
	   
      // ==============================================
   }
}
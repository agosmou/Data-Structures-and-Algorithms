import java.util.Stack;

public class HW3_1 {
    public static void main(String[] args) {
        // your solution method may be tested as such, with a random linked list input
/*
This is how the linked list was constructed manually
The LL is called 'node'
*/
    	
    	
    	//The nodes will be integers only per the node class
    	
    	//odd number test
        Node node = new Node(10);
        node.next = new Node(20);
        node.next.next = new Node(30);
        node.next.next.next = new Node(40);
        node.next.next.next.next = new Node(50);
        node.next.next.next.next.next = new Node(60);
        node.next.next.next.next.next.next = new Node(70);
        node.next.next.next.next.next.next.next = new Node(80);
        node.next.next.next.next.next.next.next.next = new Node(90);
        node.next.next.next.next.next.next.next.next.next = null;
        
//        //even number test
//        Node node = new Node(10);
//        node.next = new Node(20);
//        node.next.next = new Node(30);
//        node.next.next.next = new Node(40);
//        node.next.next.next.next = new Node(50);
//        node.next.next.next.next.next = new Node(60);
//        node.next.next.next.next.next.next = new Node(70);
//        node.next.next.next.next.next.next.next = new Node(80);
//        node.next.next.next.next.next.next.next.next = null;
        
        
        Solution sol = new Solution();
        
/*
Here is where you invoke your Solution "mixList"
*/
        sol.mixList(node); // list becomes homogeneous after this call. See below hint. 
        
        // you may use printList(node) method to print out the list content after mixing.
        printList(node);
        
//You may use the printList solution from your LabAssignment to print out the list after invoking mixList() for your own debugging purpose. 

    }
    
// NOTE: This is a static method because it sits inside of the main method
    public static void printList(Node head) {		// This method is called above
        Node node = head;
        while (node.next != null) {					// CAUTION: See that this loop needs a node.next = null in order to terminate.
            System.out.print(node.val + "->");
            node = node.next;
        }
        
        System.out.println(node.val + "->null");
    }
}
// Node class to set up linked list basics   
// This is a high level constructor that takes in the information. Here it is an integer

class Node {
    int val;
    Node next; // next link is set to null by default in Java
    // Nodes will only be integers ONLY. No strings or other classes.
    //Transformer/accessor
    Node(int x) {
        val = x;
    }
}

// Personal note NOTE: Node class could have also been written as:
/*
 * }
class Node {
    int val;
    Node next;
    Node(int val) {
        this.val = val;
    }
}
This is because the local variable and instance variables have the same name so I can use the "this" keyword
 */



/**
 * PURPOSE: The purpose is to take the very last element, n,  of a linked list and insert it between node 1 and 2. Then take the second to last element, n-1, and insert it between 2 and 3. And so on...
 * PARAMETERS: The parameter is the node head which is the baseline for the entering of all node items
 * RETURN VALUES: The class solution has the "void" keyword so there is no return solution expected when called by the main function
 */
class Solution {
    public void mixList(Node head) { // head is passed as a reference here
        // YOUR CODE HERE
 
//Part1: Create the local stack and push the items into it
    	//Create the stack
    	Stack<Node> myStack = new Stack<>();	//info type is node
    	
    	//create local copy of node head
    	Node curr = head;    	
    	
    	// Push the integers into the stack to track the Linked List values
    	while (curr != null) {
    		myStack.push(curr);
    		curr = curr.next; //reassign variable to the next item
    	}
    	
    	//Find the size of the stack to be used in iteration. Iterate through the loop below
    	int n = myStack.size(); 
    	//The assignment had a constraint of no more than 50 values to be used in this program. The below function will cause the program to exit if this value is exceeded.
    	if (n > 50)
    	{
    	System.out.println("The System will Exit. This assignment has a constraint of 50 Linked List elements/particles");
    	System.exit(0);
    	}
    	
 //Part2: create a local reference/pointer 	

    //step1
    	//reset the currNode reference as head
    	curr = head;
    	Node nextNode = null; //initialized temp variable, nextNode, set to null
    		

    	
    	// This loop allows me to iterate through half the number of re-linkings necessary (rounded down for odd size). See numbers in parenthesis below
		// EX 1 for stack size of n=5 elements where n/2 yields 2: 1 -> (5) -> 2 -> (3) -> 4 -> null
    	// EX 2 for stack size of n=8 elements where n/2 yields 4: 1 -> (8) -> 2 -> (7) -> 3 -> (6) -> 4 -> (5) -> null

    //step2
    	//Alternate notation to limit traversal to halfway 
    	for (int i=0; i<n/2; i++) { // n is the stack size from above

    	//step i - Save the following pointer into the temp variable nextNode
    		nextNode = curr.next;	//nextNode becomes the equivalent of currNode.next; i.e. "2" assuming stack size 4
    	// step ii - point the current node to the popped value. In this case "4" assuming stack size 4
    		curr.next = myStack.pop(); // read as "current node points to, or links via 'next', with the value on the right side of the assignment operator	
    		curr = curr.next; // current node becomes the next of the current. In this case curr == 4 assuming stack size 4. because at this point our list is 1->4 2->3->null
    	//step iii
    		curr.next = nextNode; // read as "current node, 4, points to nextNode, 2 (see above). So now we have 1->4->2->3->null	
    	//step iii	
    		curr = curr.next; // read as "current node becomes the equivalent of the following link of the curr value in step ii;
    		//thus in this case curr == 2 because of our current list standing 1->4->(2)->3->null
    	}
    	//step iv

    	curr.next = null;	// This is critical so that it can terminate the while loop in the printList static method method which is set to while (node.next != null) 
    	
    }
}


///////////////////////////////////////////////////////////
//HW NOTES

/*

// .next is an accessor. it establishes an arrow and chains them together

Constraints:
-The input list is never empty or null; thus, head is not null

-Each linked list is singly (one direction) with a null terminator, which is not considered a particle.

-The input linked list can have up to 50 particles.

-The input list can have either odd or even particles. Remember null is not considered a particle but a placeholder to terminate the list.


*/
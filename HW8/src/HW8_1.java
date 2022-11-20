import java.util.*;
public class HW8_1 {    
    public static void main(String[] args) {

        // create a solution instance
        Solution sol = new Solution();
        
     // TEST CASE 0
     // create a random binary tree of your choice
//        BSTNode tree0 = new BSTNode(1);

        
     // TEST CASE 1
     // create a random binary tree of your choice
//        BSTNode tree1 = new BSTNode(3);
//        tree1.left    = new BSTNode(0);
//        tree1.right   = new BSTNode(0);
        
     // TEST CASE 2  
     // create a random binary tree of your choice
//        BSTNode tree2 = new BSTNode(0);
//        tree2.left    = new BSTNode(0);
//        tree2.right   = new BSTNode(3);
        
     // TEST CASE 3   
     // create a random binary tree of your choice
//        BSTNode tree3 = new BSTNode(0);
//        tree3.left    = new BSTNode(0);
//        tree3.right   = new BSTNode(1);
//        tree3.left.left    = new BSTNode(1);
//        tree3.right.left   = new BSTNode(1);
//        tree3.right.right   = new BSTNode(3);
        
     // TEST CASE 4   
     // create a random binary tree of your choice
 	   BSTNode tree4 = new BSTNode(0);
 	   tree4.left    = new BSTNode(0);
 	   tree4.right   = new BSTNode(3);
 	   tree4.left.left    = new BSTNode(0);
 	   tree4.left.left.left    = new BSTNode(0);
 	   tree4.right.left   = new BSTNode(3);
 	   tree4.right.right   = new BSTNode(0);
 	   tree4.right.right.left   = new BSTNode(2);
 	   tree4.right.right.right   = new BSTNode(1);
 	   
     // TEST CASE 5   
     // create a random binary tree of your choice
// 	   BSTNode tree5 = new BSTNode(9);
// 	   tree5.left    = new BSTNode(0);
// 	   tree5.right   = new BSTNode(0);
// 	   tree5.left.left    = new BSTNode(0);
// 	   tree5.left.left.left    = new BSTNode(0);
// 	   tree5.right.left   = new BSTNode(0);
// 	   tree5.right.right   = new BSTNode(0);
// 	   tree5.right.right.left   = new BSTNode(0);
// 	   tree5.right.right.right   = new BSTNode(0);
 	   
 	// TEST CASE 6
 	// create a random binary tree of your choice
// 	   BSTNode tree6 = new BSTNode(0);
// 	   tree6.left    = new BSTNode(0);
// 	   tree6.right   = new BSTNode(1);
// 	   tree6.left.left    = new BSTNode(0);
// 	   tree6.left.left.left    = new BSTNode(0);
// 	   tree6.left.left.left.left    = new BSTNode(5);
 	   
 	   

        // your solution method will be tested with
        // a random tree of your choice
// 	    System.out.println("0 -> " + sol.distribute(tree0)); // 0
//        System.out.println("2 -> " + sol.distribute(tree1)); // 2
//        System.out.println("3 -> " + sol.distribute(tree2)); // 3
//        System.out.println("5 -> " + sol.distribute(tree3)); // 5
        System.out.println("13 -> " + sol.distribute(tree4)); // 13
//        System.out.println("17 -> " + sol.distribute(tree5)); // 17
//        System.out.println("10 -> " + sol.distribute(tree6)); // 10
     }
}

// ===============================================
// DO NOT MODIFY TREE BELOW THIS LINE
// ===============================================
class BSTNode {
   int val;
   BSTNode left;
   BSTNode right;
   BSTNode(int x) { val = x; }
}
// ===============================================
// DO NOT MODIFY TREE ABOVE THIS LINE
// ===============================================

class Solution {

   // YOUR MAY ADD ANY GLOBAL VARIABLES, 
   // HELPER METHODS, etc., in this class
	
	int moves = 0; // initialize variable to track the number of moves required to distribute PPE
	
	public void helperMethod(BSTNode node, BSTNode parentNode) {
		
		if (node == null) {  // base condition for traversal recursion once the program reaches a node without children
			return;
		}
		
		else {
		
			/*
			 * Using TEST CASE 4
			 *        0
			 *       / \
			 *      0   3
			 *     /   / \
			 *    0   3   0
			 *   /       / \
			 *  0       2   1
			 *  
			 *  Tree visual
			 *  
			 *  # = null;
			 *  
			 *           0       <----- Root
			 *        /      \
			 *       0         3
			 *      / \      /   \
			 *     0   #    3     0
			 *    / \      / \    / \
			 *   0   #    #   #  2   1
			 *  / \
			 *  #  #
			 *  
			 */
			helperMethod(node.left, node);  // traverse recursively through the left part of the tree	
			helperMethod(node.right, node); // traverse recursively through the right part of the tree
			
			if (node.val < 1) {
				moves = moves - node.val + 1; // a node value < 1 will follow this condition to record the moves required to distribute the oversupply, in this case a negative oversupply, i.e. deficit.
				parentNode.val = parentNode.val + node.val - 1; // parent node sbsorbs burden of required PPE
			}
			
			else if (node.val > 1) { // a node value > 1 will follow this condition to record the moves required to distribute the oversupply
				moves = moves + node.val- 1;
				parentNode.val = parentNode.val + node.val - 1;	// the parent node absorbs burden of required PPE to distribute
			}
		
		}
	}

   /**
   * PURPOSE: To find the number of moves required to redistribute all PPE evenly to all hospitals so that each hospital only has 1 set (i.e. make all tree leaves, including root, equal to 1)
   * PARAMETERS: The parameter is the FULL user inputted BSTNode tree, i.e. each tree node
   * RETURN VALUES: the return is the moves of type "int"
   */
   public int distribute(BSTNode root) {
      // YOUR CODE HERE
	   
	   moves = 0; // set to 0 so that the next solution (e.g. tree5) does not add to the previously saved "moves" variable
	   
	   if (root == null) { // if root tree input is null, return 0
		   return 0;
	   }
	   
	   else {
	   helperMethod(root, null); // pass parameters into helper method. the root has no parent thus (root,null) to start
	   return moves;
	   }
   }
}

/*
Constraints & Assumptions
-If root tree (input) is null, return 0;
-Number of hospitals = number of PPEs.
-if != null && 1 <= N <= 50.
-Initially a hospital can have 0 to up to N number of PPEs.
ref: https://www.youtube.com/watch?v=gm8DUJJhmY4 
 */
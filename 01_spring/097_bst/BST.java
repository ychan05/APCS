// Team Yatlongstan (Yat Long Chan, Weichen Liu, Gabriel Thompson)
// APCS
// HW97 -- Prune Your Tree
// 2022-05-11
// time spent: 1.3hrs

/**
 * class BST
 * v1:partial
 * SKELETON
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 *  and any value in its right subtree must be greater.)
 *
 * This BST implementation only holds ints (its nodes have int cargo)
 */

public class BST
{

  //instance variables / attributes of a BST:
  TreeNode _root;

  /**
   * default constructor
   */
  BST()
  {
    _root = null;
  }


  /**
   * void insert( int )
   * Adds a new data element to tree.
   */
  public void insert( int newVal )
  {
    TreeNode newNode = new TreeNode( newVal );

    if ( _root == null ) {
      _root = newNode;
      return;
    }
    insert( _root, newNode );
  }
  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    if ( newNode.getValue() < stRoot.getValue() ) {
      //if no left child, make newNode the left child
      if ( stRoot.getLeft() == null )
        stRoot.setLeft( newNode );
      else //recurse down left subtree
        insert( stRoot.getLeft(), newNode );
      return;
    }
    else { // new val >= curr, so look down right subtree
      //if no right child, make newNode the right child
      if ( stRoot.getRight() == null )
        stRoot.setRight( newNode );
      else //recurse down right subtree
        insert( stRoot.getRight(), newNode );
      return;
    }
  }//end insert()




  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

  // each traversal should simply print to standard out
  // the nodes visited, in order

  //process root, recurse left, recurse right
  public void preOrderTrav()
  {
    preOrderTrav( _root );
  }
  public void preOrderTrav( TreeNode currNode )
  {
    if ( currNode == null )
	    return;
    System.out.print( currNode.getValue() + " " );
    preOrderTrav( currNode.getLeft() );
    preOrderTrav( currNode.getRight() );
  }

  //recurse left, process root, recurse right
  public void inOrderTrav()
  {
    inOrderTrav( _root );
  }
  public void inOrderTrav( TreeNode currNode )
  {
    if ( currNode == null )
      return;
    inOrderTrav( currNode.getLeft() );
    System.out.print( currNode.getValue() + " " );
    inOrderTrav( currNode.getRight() );
  }

  //recurse left, recurse right, process root
  public void postOrderTrav()
  {
    postOrderTrav( _root );
  }
  public void postOrderTrav( TreeNode currNode )
  {
    if ( currNode == null )
      return;
    postOrderTrav( currNode.getLeft() );
    postOrderTrav( currNode.getRight() );
    System.out.print( currNode.getValue() + " "  );
  }

  public String inOrderTravStr( TreeNode currNode ) {
    String retStr = "";
    if ( currNode == null )
      return retStr;
    retStr += inOrderTravStr( currNode.getLeft() );
    retStr += " " + currNode.getValue();
    retStr += inOrderTravStr( currNode.getRight() );
    return retStr;
  }
  public String preOrderTravStr( TreeNode currNode ) {
    String retStr = "";
    if ( currNode == null )
      return retStr;
    retStr += " " + currNode.getValue();
    retStr += preOrderTravStr( currNode.getLeft() );
    retStr += preOrderTravStr( currNode.getRight() );
    return retStr;
  }
  public String postOrderTravStr( TreeNode currNode ) {
    String retStr = "";
    if ( currNode == null )
      return retStr;
    retStr += postOrderTravStr( currNode.getLeft() );
    retStr += postOrderTravStr( currNode.getRight() );
    retStr += " " + currNode.getValue();
    return retStr;
  }


  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~~COUNTERS~~v~~~~~~~~~~~~~~~~~~~~~

    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    TreeNode search( int target )
    {
        return searchHelper(_root, target);
    }

    TreeNode searchHelper( TreeNode currNode, int target ) {
	if (currNode == null) {
		return null;
	}

        if (currNode.getValue() < target) {
		return searchHelper(currNode.getRight(), target);
	} else if (currNode.getValue() > target) {
		return searchHelper(currNode.getLeft(), target);
	} else {
		return currNode;
	}
   }


    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 1
     *****************************************************/
    public int height()
    {
        return heightHelper(_root);
    }

    // recursive case:   (in the case where you're not at a null node) return max(height(left), height(right)) + 1
    // base case:        (in the case where you ARE at a null node)    return 0
    public int heightHelper(TreeNode currentNode) {
	if (currentNode == null) {
	    return 0;
	} else {
	    return Math.max(heightHelper(currentNode.getLeft()),
                            heightHelper(currentNode.getRight())) + 1;
	}
    }


    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    // recursive case: 
    // base case: you're at a leaf (return 1)
    public int numLeaves()
    {
	return numLeavesHelper( _root );
    }

    public int numLeavesHelper(TreeNode currentNode) {
        if (currentNode == null)
	    return 0;

	if (currentNode.getLeft() == null && currentNode.getRight() == null) {
	    return 1;
	} else {
	    return numLeavesHelper(currentNode.getLeft()) + numLeavesHelper(currentNode.getRight());
	}
    }

    // ALGO:
    //  1. Traverse the tree to find the node we're looking for. Make sure to store the parent node.
    //  2. The case of a full node:
    //    a. Take the rightmost node of the left subtree, and set the value of the target node to this newfound value
    //  3. The case of a partially full node: (this is written in the code as two cases: only left connection and only right connection
    //    a. If the current node is a root node
    //      i. Set the root to the single connection of the child node
    //    b. If the connection between the parent and target is right:
    //      i. Set the right connection of the parent node to the single connection of the child node
    //    c. If the connection between the parent and target is left:
    //      i. Set the left connection of the parent node to the single connection of the child node
    //  4. The case of a leaf node
    //    a. If the current node is a root node
    //      i. Set the root node to null
    //    b. If the leaf node is to the left of the parent node
    //      i. Set the left connection of the parent to null
    //    c. If the leaf node is to the right of the parent node
    //      i. Set the right connection of the parent to null
    public void remove(int val) {
        TreeNode parent = _root;
	TreeNode child = _root;
	boolean childIsToLeft = false;

	while (child.getValue() != val) {
	    parent = child;

	    if (child.getValue() < val) {
		child = child.getRight();
		childIsToLeft = false;
	    } else {
		child = child.getLeft();
		childIsToLeft = true;
	    }
	}

	if (child.getLeft() != null && child.getRight() != null) {
	   // child is a full node
	    TreeNode largest = rightmostNodeFrom(child.getLeft());
	    remove(largest.getValue());
	    child.setValue(largest.getValue());
	} else if (child.getLeft() == null && child.getRight() != null) {
	    // child has no left node
	    if (child == _root)
		_root = child.getRight();
	    else if (childIsToLeft)
		parent.setLeft(child.getRight());
	    else
		parent.setRight(child.getRight());
	} else if (child.getLeft() != null && child.getRight() == null) {
	    // child has no right node
            if (child == _root)
		_root = child.getLeft();
	    else if (childIsToLeft)
                parent.setLeft(child.getLeft());
            else
                parent.setRight(child.getLeft());
	} else {
	    // child is a leaf node
            if (child == _root)
		_root = null;
	    else if (childIsToLeft)
		parent.setLeft(null);
	    else
		parent.setRight(null);
	}
    }

    public TreeNode rightmostNodeFrom(TreeNode curr) {
	while (curr.getRight() != null)
	    curr = curr.getRight();
	return curr;
    }

    //overridden toString
    public String toString()
    {
        return
          " pre-order trav:" + preOrderTravStr( _root ) + '\n' +
          "  in-order trav:" + inOrderTravStr( _root ) + '\n' +
          "post-order trav:" + postOrderTravStr( _root ) + '\n' +
          "         height: " + height() + '\n' +
          "     num leaves: " + numLeaves();
    }

// Traverse the tree to find the node we're looking for. Make sure to store the parent node.
// The case of a full node:
//   Take the rightmost node of the left subtree, and set the value of the target node to this newfound value
// The case of a partially full node: (this is written in the code as two cases: only left connection and only right connection
//   If the current node is a root node
//      Set the root to the single connection of the child node
//   If the connection between the parent and target is right:
//      Set the right connection of the parent node to the single connection of the child node
//   If the connection between the parent and target is left:
//      Set the left connection of the parent node to the single connection of the child node
// The case of a leaf node
//   If the current node is a root node
//     Set the root node to null
//   If the leaf node is to the left of the parent node
//     Set the left connection of the parent to null
//   If the leaf node is to the right of the parent node
//     Set the right connection of the parent to null


    //main method for testing
    public static void main( String[] args ) {

	BST arbol = new BST();

	System.out.println( "tree init'd: " + arbol );

	//inserting in this order will build a perfect tree
	arbol.insert( 3 );
	arbol.insert( 1 );
	arbol.insert( 0 );
	arbol.insert( 2 );
	arbol.insert( 5 );
	arbol.insert( 4 );
	arbol.insert( 6 );
	/*
	*/

	//insering in this order will build a linked list to left
	/*
	arbol.insert( 6 );
	arbol.insert( 5 );
	arbol.insert( 3 );
	arbol.insert( 4 );
	arbol.insert( 2 );
	arbol.insert( 1 );
	arbol.insert( 0 );
	*/

	System.out.println( "tree after insertions:\n" + arbol );
	System.out.println();

	System.out.println();
	for( int i=-1; i<8; i++ ) {
	    System.out.println(" searching for "+i+": " + arbol.search(i) );    
	}

	System.out.println();
	System.out.println( arbol );

	arbol.remove(6);
	System.out.println();
	System.out.println( arbol );

	arbol.remove(5);
	System.out.println();
	System.out.println( arbol );

	arbol.remove(4);
	System.out.println();
	System.out.println( arbol );

	arbol.remove(3);
	System.out.println();
	System.out.println( arbol );

	arbol.remove(2);
	System.out.println();
	System.out.println( arbol );

	arbol.remove(1);
	System.out.println();
	System.out.println( arbol );

	arbol.remove(0);
	System.out.println();
	System.out.println( arbol );
    }

}//end class
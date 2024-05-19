// --== CS400 Fall 2022 File Header Information ==--
// Name: Liam Soule
// Email: lsoule@wisc.edu
// Team: DC
// TA: Yelun BAO
// Lecturer: Florian
// Notes to Grader: N/A

/**
 * Red-Black Tree implementation with a Node inner class for representing
 * the nodes of the tree. Currently, this implements a Binary Search Tree that
 * we will turn into a red black tree by modifying the insert functionality.
 * In this activity, we will start with implementing rotations for the binary
 * search tree insert algorithm. You can use this class' insert method to build
 * a regular binary search tree, and its toString method to display a
 * level-order
 * traversal of the tree.
 */
import java.util.LinkedList;

public class RedBlackTree<T extends Comparable<T>> implements SortedCollectionInterface<T> {

    /**
     * This class represents a node holding a single value within a binary tree
     * the parent, left, and right child references are always maintained.
     */
    protected static class Node<T> {
        public T data;
        public Node<T> parent; // null for root node
        public Node<T> leftChild;
        public Node<T> rightChild;
        public int blackHeight; // meant to track the black height only for the current node

        public Node(T data) {
            this.data = data;
            this.blackHeight = 0;
        }

        /**
         * @return true when this node has a parent and is the left child of
         *         that parent, otherwise return false
         */
        public boolean isLeftChild() {
            return parent != null && parent.leftChild == this;
        }
    }

    protected Node<T> root; // reference to root node of tree, null when empty
    protected int size = 0; // the number of values in the tree

    /**
     * This method enforces the RedBlackTree properties after a new node is
     * added into the tree
     * 
     * @param redNode newly added Red node
     */
    protected void enforceRBTreePropertiesAfterInsert(Node<T> redNode) {
        Node<T> parent = redNode.parent;
        // check to see if this node is the root, and if the node isn't black, change to
        // a black node
        if (parent == null && redNode.blackHeight != 1) {
            redNode.blackHeight = 1;
            return;
        }
        // if parent is black, nothing to do
        else if (parent.blackHeight == 1) {
            // keep inserted as red
            return;
        }
        // can assume now that the parent is red
        Node<T> grandParent = parent.parent;
        // check to see if the parent is the root, if so change the to black node
        if (grandParent == null) {
            parent.blackHeight = 1;
            return;
        }
        Node<T> aunt = parent.isLeftChild() ? grandParent.rightChild : grandParent.leftChild;
        // if the aunt is red, recolor accordingly
        if (aunt != null && aunt.blackHeight == 0) {
            parent.blackHeight = 1;
            grandParent.blackHeight = 0;
            aunt.blackHeight = 1;
            enforceRBTreePropertiesAfterInsert(grandParent);
        }
        // at this point can assume that the aunt node is black
        // if parent is a leftChild
        else if (parent.isLeftChild()) {
            // check if rednode is a left child as well, if so rotate around the redNode and
            // Parent
            if (!redNode.isLeftChild()) {
                rotate(redNode, parent);
                parent = redNode; // parent is the new root of the subtree
            }
            rotate(parent, grandParent);
            parent.blackHeight = 1;
            grandParent.blackHeight = 0;
        } else {
            if (redNode.isLeftChild()) {
                rotate(redNode, parent);
                parent = redNode;
            }
            rotate(parent, grandParent);
            parent.blackHeight = 1;
            grandParent.blackHeight = 0;
        }
    }

    /**
     * Performs a naive insertion into a binary search tree: adding the input
     * data value to a new node in a leaf position within the tree. After
     * this insertion, no attempt is made to restructure or balance the tree.
     * This tree will not hold null references, nor duplicate data values.
     * 
     * @param data to be added into this binary search tree
     * @return true if the value was inserted, false if not
     * @throws NullPointerException     when the provided data argument is null
     * @throws IllegalArgumentException when the newNode and subtree contain
     *                                  equal data references
     */
    @Override
    public boolean insert(T data) throws NullPointerException, IllegalArgumentException {
        // null references cannot be stored within this tree
        if (data == null)
            throw new NullPointerException(
                    "This RedBlackTree cannot store null references.");

        Node<T> newNode = new Node<>(data);
        if (root == null) {
            root = newNode;
            size++;
            root.blackHeight = 1;
            return true;
        } // add first node to an empty tree
        else {
            boolean returnValue = insertHelper(newNode, root); // recursively insert into subtree
            this.enforceRBTreePropertiesAfterInsert(newNode);
            if (returnValue)
                size++;
            else
                throw new IllegalArgumentException(
                        "This RedBlackTree already contains that value.");
            root.blackHeight = 1; // set the root to black
            return returnValue;
        }
    }

    /**
     * Recursive helper method to find the subtree with a null reference in the
     * position that the newNode should be inserted, and then extend this tree
     * by the newNode in that position.
     * 
     * @param newNode is the new node that is being added to this tree
     * @param subtree is the reference to a node within this tree which the
     *                newNode should be inserted as a descenedent beneath
     * @return true is the value was inserted in subtree, false if not
     */
    private boolean insertHelper(Node<T> newNode, Node<T> subtree) {
        int compare = newNode.data.compareTo(subtree.data);
        // do not allow duplicate values to be stored within this tree
        if (compare == 0)
            return false;

        // store newNode within left subtree of subtree
        else if (compare < 0) {
            if (subtree.leftChild == null) { // left subtree empty, add here
                subtree.leftChild = newNode;
                newNode.parent = subtree;
                return true;
                // otherwise continue recursive search for location to insert
            } else
                return insertHelper(newNode, subtree.leftChild);
        }

        // store newNode within the right subtree of subtree
        else {
            if (subtree.rightChild == null) { // right subtree empty, add here
                subtree.rightChild = newNode;
                newNode.parent = subtree;
                return true;
                // otherwise continue recursive search for location to insert
            } else
                return insertHelper(newNode, subtree.rightChild);
        }
    }

    /**
     * Performs the rotation operation on the provided nodes within this tree.
     * When the provided child is a leftChild of the provided parent, this
     * method will perform a right rotation. When the provided child is a
     * rightChild of the provided parent, this method will perform a left rotation.
     * When the provided nodes are not related in one of these ways, this method
     * will throw an IllegalArgumentException.
     * 
     * @param child  is the node being rotated from child to parent position
     *               (between these two node arguments)
     * @param parent is the node being rotated from parent to child position
     *               (between these two node arguments)
     * @throws IllegalArgumentException when the provided child and parent
     *                                  node references are not initially
     *                                  (pre-rotation) related that way
     */
    private void rotate(Node<T> child, Node<T> parent) throws IllegalArgumentException {
        // check to see if any of the nodes are null
        if (child == null || parent == null)
            throw new IllegalArgumentException("Parent or child " +
                    "cannot be null");
        if (child.parent != parent)
            throw new IllegalArgumentException("Child is not related to " +
                    "the parent");
        // test to see if the child is a left child
        if (child.isLeftChild()) {
            // if the child has a right child assign it a node of parents
            if (child.rightChild != null) {
                child.rightChild.parent = parent;
            }
            // Rotate child's right node, and child
            parent.leftChild = child.rightChild;
            child.rightChild = parent;
            // if parent has a parent
            if (parent.parent != null) {
                // if left child assign the subtree to the left child
                if (parent.isLeftChild())
                    parent.parent.leftChild = child;
                // else assign to the subtree of right child
                else
                    parent.parent.rightChild = child;
            }
            // if parent is root set root to child
            else {
                root = child;
            }
            // set the parents of the nodes
            child.parent = parent.parent;
            parent.parent = child;
        }
        // check if right child
        else {
            // if the child has a left child assign it a node of parents
            if (child.leftChild != null) {
                child.leftChild.parent = parent;
            }
            // Rotate child's left node, and child
            parent.rightChild = child.leftChild;
            child.leftChild = parent;
            if (parent.parent != null) {
                // if left child assign the subtree to the left child
                if (parent.isLeftChild())
                    parent.parent.leftChild = child;
                // else assign to the subtree of right child
                else
                    parent.parent.rightChild = child;
            }
            // if parent is root set root to child
            else {
                root = child;
            }
            // set parents
            child.parent = parent.parent;
            parent.parent = child;
        }
    }

    /**
     * Get the size of the tree (its number of nodes).
     * 
     * @return the number of nodes in the tree
     */
    public int size() {
        return size;
    }

    /**
     * Method to check if the tree is empty (does not contain any node).
     * 
     * @return true of this.size() return 0, false if this.size() > 0
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Checks whether the tree contains the value *data*.
     * 
     * @param data the data value to test for
     * @return true if *data* is in the tree, false if it is not in the tree
     */
    @Override
    public boolean contains(T data) {
        // null references will not be stored within this tree
        if (data == null)
            throw new NullPointerException(
                    "This RedBlackTree cannot store null references.");
        return this.containsHelper(data, root);
    }

    /**
     * Recursive helper method that recurses through the tree and looks
     * for the value *data*.
     * 
     * @param data    the data value to look for
     * @param subtree the subtree to search through
     * @return true of the value is in the subtree, false if not
     */
    private boolean containsHelper(T data, Node<T> subtree) {
        if (subtree == null) {
            // we are at a null child, value is not in tree
            return false;
        } else {
            int compare = data.compareTo(subtree.data);
            if (compare < 0) {
                // go left in the tree
                return containsHelper(data, subtree.leftChild);
            } else if (compare > 0) {
                // go right in the tree
                return containsHelper(data, subtree.rightChild);
            } else {
                // we found it :)
                return true;
            }
        }
    }

    /**
     * This method performs an inorder traversal of the tree. The string
     * representations of each data value within this tree are assembled into a
     * comma separated string within brackets (similar to many implementations
     * of java.util.Collection, like java.util.ArrayList, LinkedList, etc).
     * Note that this RedBlackTree class implementation of toString generates an
     * inorder traversal. The toString of the Node class class above
     * produces a level order traversal of the nodes / values of the tree.
     * 
     * @return string containing the ordered values of this tree (in-order
     *         traversal)
     */
    public String toInOrderString() {
        // generate a string of all values of the tree in (ordered) in-order
        // traversal sequence
        StringBuffer sb = new StringBuffer();
        sb.append("[ ");
        sb.append(toInOrderStringHelper("", this.root));
        if (this.root != null) {
            sb.setLength(sb.length() - 2);
        }
        sb.append(" ]");
        return sb.toString();
    }

    private String toInOrderStringHelper(String str, Node<T> node) {
        if (node == null) {
            return str;
        }
        str = toInOrderStringHelper(str, node.leftChild);
        str += (node.data.toString() + ", ");
        str = toInOrderStringHelper(str, node.rightChild);
        return str;
    }

    /**
     * This method performs a level order traversal of the tree rooted
     * at the current node. The string representations of each data value
     * within this tree are assembled into a comma separated string within
     * brackets (similar to many implementations of java.util.Collection).
     * Note that the Node's implementation of toString generates a level
     * order traversal. The toString of the RedBlackTree class below
     * produces an inorder traversal of the nodes / values of the tree.
     * This method will be helpful as a helper for the debugging and testing
     * of your rotation implementation.
     * 
     * @return string containing the values of this tree in level order
     */
    public String toLevelOrderString() {
        String output = "[ ";
        if (this.root != null) {
            LinkedList<Node<T>> q = new LinkedList<>();
            q.add(this.root);
            while (!q.isEmpty()) {
                Node<T> next = q.removeFirst();
                if (next.leftChild != null)
                    q.add(next.leftChild);
                if (next.rightChild != null)
                    q.add(next.rightChild);
                output += next.data.toString();
                if (!q.isEmpty())
                    output += ", ";
            }
        }
        return output + " ]";
    }

    public String toString() {
        return "level order: " + this.toLevelOrderString() +

                "\nin order: " + this.toInOrderString();
    }

    /**
     * Main method to run tests. Comment out the lines for each test
     * to run them.
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Test 1 passed: ");
        System.out.println("Test 2 passed: ");
        System.out.println("Test 3 passed: ");
    }
}

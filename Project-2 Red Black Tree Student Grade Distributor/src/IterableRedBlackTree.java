// --== CS400 Fall 2022 File Header Information ==--
// Name: Liam Soule
// Email: lsoule@wisc.edu
// Team: DC
// TA: Yelun BAO
// Lecturer: Florian
// Notes to Grader: N/A
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * This class implements the iterable part of the RedBlack tree allowing for
 * iteration over the data structure
 */
public class IterableRedBlackTree<T extends Comparable<T>> extends RedBlackTree<T> implements IterableTreeADT<T> {

    /**
     * Custom Iterator method for RedBlackTree data structure
     * 
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new rbTreeIterator<T>(root);
    }

    /**
     * Static class to implement the iterator that will be returned
     */
    protected static class rbTreeIterator<T> implements Iterator<T> {

        private final Deque<Node<T>> stack;

        /**
         * Initializing the stack that assists in iteratoring through the data structuer
         * 
         * @param root
         */
        public rbTreeIterator(Node<T> root) {
            stack = new ArrayDeque<>(); // initialize the stack
            initializeHelper(root); // get all the outside nodes of the data structure
        }

        /**
         * Puts the data in the stack in order that we want to iterate through
         * 
         * @param root
         */
        private void initializeHelper(Node<T> root) {
            while (root != null) {
                stack.push(root);
                // visit the left subtree of the data structure first
                if (root.leftChild != null)
                    root = root.leftChild;
                // Once finished going through the left most nodes, look @ the right most nodes
                else
                    root = root.rightChild;
            }
        }

        /**
         * Iterator method that tells if there is a next node
         * 
         * @return true if we there are no more elements to iterate through, false
         *         otherwise
         */
        @Override
        public boolean hasNext() {
            // if stack is empty, have gone through all data
            return !stack.isEmpty();
        }

        /**
         * This method gets the next node in the postorder iteration
         * 
         * @return next node we want to access
         */
        @Override
        public T next() {
            Node<T> node = stack.pop();
            // if stack is not empty, see what part of the structure we are at
            if (!stack.isEmpty()) {
                // if node is the leftChild of the parent, then insert the right value of that
                // subtree to loop through them
                if (node == stack.peek().leftChild) {
                    initializeHelper(stack.peek().rightChild);
                }
            }
            return node.data;
        }
    }
}

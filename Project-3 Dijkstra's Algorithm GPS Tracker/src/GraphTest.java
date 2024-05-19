// --== CS400 File Header Information ==--
// Name: NAVYA MONGIA 
// Email: mongia@wisc.edu
// Team: DC 
// TA: Yelun Bao
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;

/**
 * Tests the implementation of CS400Graph for the individual component of
 * Project Three: the implementation of Dijsktra's Shortest Path algorithm.
 */
public class GraphTest {

    private CS400Graph<String,Integer> graph;
    
    /**
     * Instantiate graph.
     */
    @BeforeEach
    public void createGraph() {
        graph = new CS400Graph<>();
        // insert vertices A-F
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        graph.insertVertex("F");
        // insert edges
        graph.insertEdge("A","B",6);
        graph.insertEdge("A","C",2);
        graph.insertEdge("A","D",5);
        graph.insertEdge("B","E",1);
        graph.insertEdge("B","C",2);
        graph.insertEdge("C","B",3);
        graph.insertEdge("C","F",1);
        graph.insertEdge("D","E",3);
        graph.insertEdge("E","A",4);
        graph.insertEdge("F","A",1);
        graph.insertEdge("F","D",1);
    }

    /**
     * Checks the distance/total weight cost from the vertex A to F.
     */
    @Test
    public void testPathCostAtoF() {
        assertTrue(graph.getPathCost("A", "F") == 3);
    }

    /**
     * Checks the distance/total weight cost from the vertex A to D.
     */
    @Test
    public void testPathCostAtoD() {
        assertTrue(graph.getPathCost("A", "D") == 4);
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * A to D.
     */
    @Test
    public void testPathAtoD() {
        assertTrue(graph.shortestPath("A", "D").toString().equals(
            "[A, C, F, D]"
        ));
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * A to F.
     */
    @Test
    public void testPathAtoF() {
        assertTrue(graph.shortestPath("A", "F").toString().equals(
            "[A, C, F]"
        ));
    }
    
    /**
     * Checks the distance/total weight cost from the vertex A to E.
     */
    @Test
    public void testPathCostAtoE() {
        Assertions.assertEquals(graph.getPathCost("A", "E") , 6 );
    }
   
    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * A to E.
     */

    @Test
    public void testPathAtoE() {
        Assertions.assertEquals(graph.shortestPath("A", "E").toString() , "[A, C, B, E]" );
    }
    
    /**
    * Checks the distance/total weight cost from the vertex B to F.
    */
    
    @Test
    public void testPathCostBtoF() {
        Assertions.assertEquals(graph.getPathCost("B", "F") , 3 );
    }
    
    @Test
    public void testPathCostEtoF() {
        Assertions.assertEquals(graph.getPathCost("E", "F") , 7 );
    }
    
   
    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * B to F.
     */
    
    @Test
    public void testPathBtoF() {
        assertTrue(graph.shortestPath("B", "F").toString().equals(
            "[B, C, F]"
        ));
    }
    public void testPathFtoB() {
        assertTrue(graph.shortestPath("F", "B").toString().equals(
            "[F, A, C, B]"
        ));
    }
    @Test
    public void testPathCostFtoB() {
        Assertions.assertEquals(graph.getPathCost("F", "B") , 6 );
    }
    
    /**
     * extra test to test the the working of algorithm 
     */
    @Test
    public void test9() {
        Assertions.assertEquals(graph.getPathCost("D", "A") , 7 ); 
        Assertions.assertEquals(graph.getPathCost("D", "D") , 0 );
        Assertions.assertEquals(graph.getPathCost("B", "E") , 1 );
        Assertions.assertEquals(graph.getPathCost("B", "C") , 2 );
        Assertions.assertEquals(graph.getPathCost("D", "A") , 7 );
    }
    
    

}
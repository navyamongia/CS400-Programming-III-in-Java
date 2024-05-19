
// --== CS400 File Header Information ==--
// Name: Liam Soule
// Email: lsoule@wisc.edu
// Team: DC
// TA: Yelun Bao
// Lecturer: Florian
// Notes to Grader: N/A
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class loads the graph used for the map
 */
public class CityLoader implements ICityLoader {

    private Scanner scan;
    private final File file = new File("data.dot");
    private CS400Graph<String, Integer> graph;

    /**
     * Constructor, creates the scanner which will be read from and the graph which
     * we will insert data into
     */
    public CityLoader() {
        this.graph = new CS400Graph<String, Integer>();
        try {
            this.scan = new Scanner(this.file);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * This method loads the graph with the data stored in the file in DOT format
     */
    @Override
    public GraphADT CityLoad() {
        while (this.scan.hasNextLine()) {
            String currentLine = this.scan.nextLine();
            // testing to see if the string is empty
            if (currentLine == null || currentLine.isEmpty())
                continue;

            // testing if start of the graph file
            if (currentLine.contains("{"))
                continue; // if so, get the next line

            // testing to see if the end of the graph file
            if (currentLine.contains("}"))
                break; // if so, end the loop

            // getting the first vertex;
            String firstVertexName = currentLine.substring(0, currentLine.indexOf('-'));
            firstVertexName = firstVertexName.trim();

            // getting the second vertex
            String secondVertexName = currentLine.substring(currentLine.indexOf('-') + 2, currentLine.indexOf('['));
            secondVertexName = secondVertexName.trim();

            // get the weight of the edge
            String edgeWeightString = currentLine.substring(currentLine.indexOf('=') + 1, currentLine.indexOf(']'));
            edgeWeightString = edgeWeightString.trim();

            // getting the type of edge (directed, undirected)
            char typeOfEdge = currentLine.charAt(currentLine.indexOf('-') + 1);
            // case direcected
            if (typeOfEdge == '>') {
                graph.insertVertex(firstVertexName); // insert first vertex
                graph.insertVertex(secondVertexName); // insert second vertex
                graph.insertEdge(firstVertexName, secondVertexName, Integer.parseInt(edgeWeightString)); // insert the
                                                                                                         // single
                                                                                                         // direction
                                                                                                         // edge
                // from first vertex to second vertext
            }
            // case undirected
            if (typeOfEdge == '-') {
                graph.insertVertex(firstVertexName); // insert first vertex
                graph.insertVertex(secondVertexName); // insert second vertex
                // insert 2 edge weights going both directions
                graph.insertEdge(firstVertexName, secondVertexName, Integer.parseInt(edgeWeightString));
                graph.insertEdge(secondVertexName, firstVertexName, Integer.parseInt(edgeWeightString));
            }
        }
        this.scan.close();
        return graph;
    }

}

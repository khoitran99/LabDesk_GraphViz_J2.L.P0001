/**
 *Name : Tran Van Khoi
 *MSSV : HE130007
 *Email : khoitvhe130007@fpt.edu.vn
 *Lecturer : DuongTB
 */
package controller;

import java.awt.Color;
import java.lang.reflect.Field;
import java.util.StringTokenizer;
import model.Coordinate;
import model.Edge;
import model.Graph;
import model.Vertex;

/**
 *
 * @author khoitvhe130007@fpt.edu.vn
 */
public class InputController {

    String graphInfo;
    Graph graph;

    public InputController() {
    }

    /*
    check input . if there is nothing , progran will throws exception
     */
    public InputController(String graphInfo) throws Exception {
        this.graphInfo = graphInfo;
        this.graph = new Graph();
        graphInfo = graphInfo.trim();
        if (graphInfo.length() == 0) { // if user input nothing
            throw new Exception("You have not input anything\n"
                    + "Please input by form:\n"
                    + "NAME_GRAPH{\n"
                    + " vertice_name[label=\"{NOT_BLANK}\", color=\"{NOT_BLANK}\"}"
                    + "\n vertice->vertice[label=\"{NOT_BLANK}\"\n}");
        }
    }

    /* get name of graph in the first line*/
    public String getNameGraph() throws Exception {
        StringTokenizer st = new StringTokenizer(graphInfo, "\n");  // split line of string into token
        String name = st.nextToken();                               // get the first token
        if (name.endsWith("{")) {                                   // check name of graph
            name = name.substring(0, name.length() - 1);
            if (name.contains("{") || name.contains("}")) {
                throw new Exception("Name is incorrect!");
            } else {
                return name;
            }
        } else {
            throw new Exception("Line 1 is incorrect!");
        }
    }

    /* get information of vertex in one line */
    public Vertex getVertexData(int countLine, String verticeInfo) throws Exception {
        boolean startLabel = false;
        boolean startColor = false;
        boolean startName = false;

        String verticeLabel = "";
        String verticeName = "";
        String verticeColor = "";

        Color color = null;
        StringTokenizer st = new StringTokenizer(verticeInfo, "\"[] "); // split into token with delimeter

        /* read information from string after split */
        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            if (!startName) {                                   // get vertex name in first token
                verticeName = temp;
                startName = true;
                continue;
            }
            try {
                if (!startLabel && temp.contains("label")) {    // get vertex label in string token
                    verticeLabel = st.nextToken();
                    startLabel = true;
                    continue;
                }
                if (!startColor && temp.contains("color")) {    // get vertex color in string token
                    verticeColor = st.nextToken();
                    startColor = true;
                    Field field = Class.forName("java.awt.Color").getField(verticeColor);
                    color = (Color) field.get(null);
                    break;
                }
            } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
                if (verticeLabel.equals("") || verticeColor.equals("")) {
                    throw new Exception("Line " + countLine + "\n"
                            + "\nYour input propertise is blank.\n"
                            + "Just input vertice_name["
                            + "label=\"{NOT_BLANK}\",color=\"{NOT_BLANK}\"]");
                } else {
                    throw new Exception("Line " + countLine + "\n"
                            + "Your color is invalid");
                }
            }
        }
        return new Vertex(verticeName, verticeLabel, color, new Coordinate(), 0);
    }

    /* get Edge information in one life */
    private Edge getEdgeData(int countLine, String edge) throws Exception {
        String fromVertex = "";
        String toVertex = "";
        String label = "";

        StringTokenizer st = new StringTokenizer(edge, "\"->[] ");  // split into token with delimeter
        /* read information from string after split */
        while (st.hasMoreTokens()) {
            String temp = st.nextToken();

            if (fromVertex.equals("")) {    // first token is from Vertex
                fromVertex = temp;
                continue;
            }
            if (toVertex.equals("")) {      // second token is to Vertex
                toVertex = temp;
                continue;
            }
            try {
                if (temp.contains("label")) {       // get label of vertex 
                    label = st.nextToken();
                    break;
                }
            } catch (Exception e) {
                throw new Exception("Line " + countLine + "\n"
                        + "Your input propertise is blank.\n"
                        + "Just input vertice->vertice["
                        + "label=\"{NOT_BLANK}\"]");
            }
        }
        return new Edge(label, fromVertex, toVertex);
    }

    /* get all information of vertice and edges in input and return Graph object */
    public Graph getGraphData() throws Exception {
        StringTokenizer st = new StringTokenizer(graphInfo, "\n");
        int countLine = 0;
        Graph myGraph = new Graph();

        /* loop all line of snippet code to read information */
        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            temp = temp.trim();     // content of line

            countLine++;            // the number of line
            /* line is a comment */
            if (temp.length() > 2 && temp.substring(0, 2).equals("//")) {
                continue;
            }
            if (temp.endsWith("]")) {
                /* a line is about vertice if has label and color*/
                if (temp.contains("label=\"") && temp.contains(",color=\"")) {
                    myGraph.addVertex(getVertexData(countLine, temp));
                } else if (temp.contains("label=\"") && !temp.contains(",color=\"")) {
                    myGraph.addEdge(getEdgeData(countLine, temp));
                } else {
                    throw new Exception("Line " + countLine + ""
                            + "\nInvalid syntax: " + temp);
                }
            } else {
                /* not valid line*/
                if (temp.length() != 0 && !temp.contains(getNameGraph()) && !temp.equals("}")) {
                    throw new Exception("Line " + countLine + ""
                            + "\nInvalid syntax: " + temp);
                }
            }
        }
        return myGraph;
    }

}

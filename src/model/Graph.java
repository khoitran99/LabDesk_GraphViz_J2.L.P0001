/**
 *Name : Tran Van Khoi
 *MSSV : HE130007
 *Email : khoitvhe130007@fpt.edu.vn
 *Lecturer : DuongTB
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khoitvhe130007@fpt.edu.vn
 */
public final class Graph {

    private String name;
    private List<Edge> listEdges;     // list edges of the graph
    private List<Vertex> listVertexs; // list vertex of the graph

    public Graph() {
        this.listEdges = new ArrayList<>();
        this.listVertexs = new ArrayList<>();

    }

    public Graph(String name, List<Edge> listEdges, List<Vertex> listVertexs) {
        this.name = name;
        this.listEdges = listEdges;
        this.listVertexs = listVertexs;
        setCoorinateForListVertex();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getListEdges() {
        return listEdges;
    }

    public void setListEdges(List<Edge> listEdges) {
        this.listEdges = listEdges;
    }

    public List<Vertex> getListVertexs() {
        return listVertexs;
    }

    public void setListVertexs(List<Vertex> listVertexs) {
        this.listVertexs = listVertexs;
    }

    public void addEdge(Edge edge) {
        this.listEdges.add(edge);
    }

    public void addVertex(Vertex vertex) {
        this.listVertexs.add(vertex);
    }

    /* get Vertex of Vertex it's by label*/
    public Vertex getVertexByLabel(String vertexLabel) {
        for (Vertex vertex : listVertexs) {
            if (vertex.getName().equalsIgnoreCase(vertexLabel)) {
                return vertex;
            }
        }
        return null;
    }

    /* get Coordinate of vertice by it's label */
    public Coordinate getCoordinatesByVertexLabel(String vertexLabel) {
        for (Vertex vertex : listVertexs) {
            if (vertex.getName().equalsIgnoreCase(vertexLabel)) {
                return vertex.getCoordinate();
            }
        }
        return null;
    }

    int X_CENTER_GRAPH = 200;   
    int Y_CENTER_GRAPH = 200;   
    int X_INIT_POINT = 80;
    int Y_INIT_POINT = 80;

    /* set Coordinates for list Vertex */
    public void setCoorinateForListVertex() {
        int totalVertices = listVertexs.size();
        double angleBetweenVertices = 2 * Math.PI / totalVertices;
        int count = 0;
        for (Vertex vertice : listVertexs) {
            double x0 = X_INIT_POINT - X_CENTER_GRAPH;
            double y0 = Y_INIT_POINT - Y_CENTER_GRAPH;
            double x = x0 * Math.cos(angleBetweenVertices * count) - y0 * Math.sin(angleBetweenVertices * count);
            double y = x0 * Math.sin(angleBetweenVertices * count) + y0 * Math.cos(angleBetweenVertices * count);
            vertice.setCoordinate(new Coordinate((int) (x + X_CENTER_GRAPH), (int) (y + Y_CENTER_GRAPH)));
            count++;
        }
    }
}

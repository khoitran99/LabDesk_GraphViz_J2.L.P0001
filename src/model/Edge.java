/**
 *Name : Tran Van Khoi
 *MSSV : HE130007
 *Email : khoitvhe130007@fpt.edu.vn
 *Lecturer : DuongTB
 */
package model;

/**
 *
 * @author khoitvhe130007@fpt.edu.vn
 */
public class Edge {

    private String label; // label of edge
    private String fromVertex; // start vertex of the edge
    private String toVertex;    // end vertex of the edge

    public Edge() {
    }

    public Edge(String label, String fromVertex, String toVertex) {
        this.label = label;
        this.fromVertex = fromVertex;
        this.toVertex = toVertex;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getFromVertex() {
        return fromVertex;
    }

    public void setFromVertex(String fromVertex) {
        this.fromVertex = fromVertex;
    }

    public String getToVertex() {
        return toVertex;
    }

    public void setToVertex(String toVertex) {
        this.toVertex = toVertex;
    }

}

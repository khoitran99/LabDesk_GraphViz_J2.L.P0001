/**
 *Name : Tran Van Khoi
 *MSSV : HE130007
 *Email : khoitvhe130007@fpt.edu.vn
 *Lecturer : DuongTB
 */
package model;

import java.awt.Color;

/**
 *
 * @author khoitvhe130007@fpt.edu.vn
 */
public class Vertex {

    private String name;    // name of vertex
    private String label;   // label of vertex
    private Color color;    // color of vertex
    Coordinate coordinate;  // coordinate of vertex
    int size;               // size of Vertex

    public Vertex() {
        
    }

    public Vertex(String name, String label, Color color, Coordinate coordinate, int size) {
        this.name = name;
        this.label = label;
        this.color = color;
        this.coordinate = coordinate;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}

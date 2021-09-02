/**
 *Name : Tran Van Khoi
 *MSSV : HE130007
 *Email : khoitvhe130007@fpt.edu.vn
 *Lecturer : DuongTB
 */
package controller;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.List;
import model.Coordinate;
import model.Edge;
import model.Graph;
import model.LineArrow;
import model.Vertex;

/**
 *
 * @author khoitvhe130007@fpt.edu.vn
 */
public class GraphController extends Canvas {

    Graph graph;

    public GraphController() {
    }

    public GraphController(Graph graph) {
        this.graph = graph;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    /* Draw vertex */
    public void drawVertex(Graphics2D graphics2D, List<Vertex> vertices) {
        for (Vertex vertex : vertices) {
            int size = vertex.getSize();
            float thickness = 2;
            Stroke oldStroke = graphics2D.getStroke();
            graphics2D.setStroke(new BasicStroke(thickness));
            graphics2D.setColor(vertex.getColor());
            graphics2D.drawOval(vertex.getCoordinate().getX() - size, vertex.getCoordinate().getY() - size, size * 2, size * 2);
            graphics2D.setStroke(oldStroke);
            graphics2D.setColor(Color.BLACK);
            graphics2D.setFont(new Font("Times New Roman", Font.BOLD, 12));
            graphics2D.drawString(vertex.getLabel(), vertex.getCoordinate().getX() - size / 2, vertex.getCoordinate().getY() + size / 8);
        }
    }

    /*
    draw arrow links among vertice traversal Edges: get center of from-vertex,
    get angle of link( by coordinate) , get coordinates of endpoint of link,
    use class LineArrow to draw.
     */
    public void drawLinkArrow(Graphics2D graphics2D, List<Edge> edges) {
        edges.stream().map((edge) -> {
            graphics2D.setStroke(new BasicStroke(2));   // basicStroke mean ? 

            Vertex centerOfVertexTo = graph.getVertexByLabel(edge.getToVertex());
            Vertex centerOfVertexFrom = graph.getVertexByLabel(edge.getFromVertex());

            Coordinate fromV = graph.getCoordinatesByVertexLabel(edge.getFromVertex()); // get begin point's coordinate
            Coordinate toV = graph.getCoordinatesByVertexLabel(edge.getToVertex()); // get end point's coordinate

            /* angle to get begin, end coordinate of line arrow*/
            double angle = Math.atan2(toV.getY() - fromV.getY(), toV.getX() - fromV.getX());

            /* set begin point of arrow */
            int xBeginPoint = (int) (fromV.getX() + centerOfVertexFrom.getSize() * Math.cos(angle));
            int yBeginPoint = (int) (fromV.getY() + centerOfVertexFrom.getSize() * Math.sin(angle));

            /* set end point of arrow */
            int xEndPoint = (int) (toV.getX() - centerOfVertexTo.getSize() * Math.cos(angle));
            int yEndPoint = (int) (toV.getY() - centerOfVertexTo.getSize() * Math.sin(angle));

            LineArrow lineArrow = new LineArrow(xBeginPoint, yBeginPoint, xEndPoint, yEndPoint, 2);
            return lineArrow;
        }).forEachOrdered((lineArrow) -> {
            lineArrow.draw(graphics2D);
        });
    }

    /*
    dtaw label of link traversal edges : get coordinate of from-vertex and to-vertex
    => cooridnate of cost to dtaw (set font ... ) => use drawString
     */
    public void drawLabelOfArrow(Graphics2D graphics2D, List<Edge> edges) {
        edges.forEach((edge) -> {
            graphics2D.setStroke(new BasicStroke(2));
            Vertex fromV = graph.getVertexByLabel(edge.getFromVertex());
            Vertex toV = graph.getVertexByLabel(edge.getToVertex());
            int xOfCost = (fromV.getCoordinate().getX() + toV.getCoordinate().getX()) / 2;
            int yOfCost = (fromV.getCoordinate().getY() + toV.getCoordinate().getY()) / 2;
            String cost = edge.getLabel();
            graphics2D.setFont(new Font("Times New Roman", Font.BOLD, 13));
            graphics2D.drawString(cost, xOfCost, yOfCost);
        });
    }

    /*
    set size for all vertice . để không bị đè lên và vừa với ký tự của mình
     */
    public void setSizeForVertex(Graphics2D graphics2D, List<Vertex> listV) {
        listV.forEach((vertex) -> {
            /* get width by pixel of vertex */
            FontMetrics fm = graphics2D.getFontMetrics();
            int w = fm.stringWidth(vertex.getLabel());
            vertex.setSize(w);
        });
    }

    private void initGraphics(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setBackground(Color.WHITE);
        graphics2D.clearRect(0, 0, this.getWidth(), this.getHeight());
    }

    public void analyzeDrawing(Graphics2D graphics2D) {
        setSizeForVertex(graphics2D, graph.getListVertexs());   // set size for vertex
        drawVertex(graphics2D, graph.getListVertexs());         // draw vertex
        drawLinkArrow(graphics2D, graph.getListEdges());        // draw link between vertex
        drawLabelOfArrow(graphics2D, graph.getListEdges());     // draw label for each arrow
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.create();
        initGraphics(graphics);
        if (graph != null) {
            analyzeDrawing((Graphics2D) graphics);
        }
    }
}

/**
 *Name : Tran Van Khoi
 *MSSV : HE130007
 *Email : khoitvhe130007@fpt.edu.vn
 *Lecturer : DuongTB
 */
package model;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;

/**
 *
 * @author khoitvhe130007@fpt.edu.vn
 */
public class LineArrow {
    int xPoly[] = {0,-5,5};
    int yPoly[] = {0,-10,-10};
    
    Polygon arrow = new Polygon(xPoly, yPoly, xPoly.length);
    int x;
    int y;
    int endX;
    int endY;
    int thickness;

    public LineArrow(int x, int y, int endX, int endY, int thickness) {
        this.x = x;
        this.y = y;
        this.endX = endX;
        this.endY = endY;
        this.thickness = thickness;
    }
    
   public void draw(Graphics graphics){
       Graphics2D graphics2D = (Graphics2D)graphics;
       
       double angle = Math.atan2(endY - y, endX - x);   // calculate the angle of the arrow
       
       graphics2D.setStroke(new BasicStroke(thickness));
       
       /* Draw the line. Crops 10 pixels at the tip so the tip doesn't get thick */
       graphics2D.drawLine(x, y, (int) (endX - 10 * Math.cos(angle)), (int)(endY - 10 * Math.sin(angle)));
       
       AffineTransform tx1 = graphics2D.getTransform() ;// get the original AffineTransform
       AffineTransform tx2 = (AffineTransform) tx1.clone(); // create a copy of AffineTranform
       
       /* Translate and rotate the new AffineTransform*/
       tx2.translate(endX, endY);
       tx2.rotate(angle - Math.PI/2);
       
       /* draw the tip with the AffineTransform translated and rotated */
       graphics2D.setTransform(tx2);
       graphics2D.fill(arrow);
       graphics2D.setTransform(tx1);
   }
    
    
}

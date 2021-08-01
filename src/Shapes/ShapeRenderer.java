package Shapes;

import processing.core.PApplet;
import java.util.*;

public class ShapeRenderer {
    public static void drawPointsAsShape(PApplet app, List<Point> points) {

        app.beginShape();

        for (Point point : points) {
            app.vertex(point.x, point.y);
        }

        app.endShape();
    }
}

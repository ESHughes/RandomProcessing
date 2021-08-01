package Shapes;

import processing.core.PApplet;

import java.util.*;

public class ShapePlotter {
    public static List<Point> plotRotatedEllipse(PApplet app, int x0, int y0, int r1, int r2, int theta, float noiseAmount) {
        float x, y;
        float noiseScale = 0.008f;

        List<Point> points = new ArrayList<Point>();

        for (int i = 0; i < 360; i++) {
            float radi = app.radians(i);
            float radTheta = app.radians(theta);

            x = x0 + r2 * app.cos(radi) * app.cos(radTheta) - r1 * app.sin(radi) * app.sin(radTheta);
            y = y0 + r1 * app.sin(radi) * app.cos(radTheta) + r2 * app.cos(radi) * app.sin(radTheta);

            if (noiseAmount > 0) {
                x += app.map(app.noise(noiseScale * x, noiseScale * y, 0), 0, 1, -noiseAmount, noiseAmount);
                y += app.map(app.noise(noiseScale * x, noiseScale * y, 1), 0, 1, -noiseAmount, noiseAmount);
            }
            points.add(new Point((int)x, (int)y));
        }
        return points;
    }
}

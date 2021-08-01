import Shapes.ShapePlotter;
import Shapes.ShapeRenderer;
import processing.core.PApplet;

import java.util.List;

import static Shapes.ShapePlotter.plotRotatedEllipse;

public class BoneRenderer {

    public static void draw(PApplet app)
    {
        app.background(230, 220, 190);
        app.strokeWeight(1);


        int x = (int)(app.width * app.random(0f, 1f));
        int y = (int)(app.height * app.random(0f, 1f));

        // draw center circle
        drawConcentricOvals(app, app.width / 2, app.height / 2, 30, 30, 0);

        // get the oval around which they can go
        List<Shapes.Point> points = ShapePlotter.plotRotatedEllipse(app, app.width / 2, app.height / 2, (int)app.random(200,400), (int)app.random(300,500), 0, 20f, .001f);
        for (int i = 0; i < points.size() - 40; i += (int)app.random(40,60)) {

            Shapes.Point point = points.get(i);
            drawConcentricOvals(app, point.x, point.y, (int)app.random(50,80), (int)app.random(30,40), i);
        }



        points = ShapePlotter.plotRotatedEllipse(app, app.width / 2, app.height / 2, (int)app.random(700,1000), (int)app.random(800,1000), 0, 20f, .001f);
        for (int i = 0; i < points.size() - 40; i += (int)app.random(20,30)) {

            Shapes.Point point = points.get(i);
            drawConcentricOvals(app, point.x, point.y, (int)app.random(50,80), (int)app.random(30,40), i);
        }
//        List<Shapes.Point> points = ShapePlotter.plotRotatedEllipse(app, x, y, (int)app.random(60,80) / 2, (int)app.random(60,80), theta, 20f, noiseScale);



//
//        for (int i = 0; i < 10; i ++) {
//
//            int x = (int)(app.width * app.random(0f, 1f));
//            int y = (int)(app.height * app.random(0f, 1f));
//            int scale = (int)app.random(60,80);
//            int angle = (int)(app.random(0, 360));
//
//            drawSketchyOval(app, x, y, scale / 2, scale, angle);
//        }



    }

    private static void drawSketchyOval(PApplet app, int centerX, int centerY, int r1, int r2, int theta) {
        app.stroke(70, 40);
        app.noFill();


        int increment = Math.min(r1, r2) / Math.min(24, r1);
        for (int i = 0; i < 100; i += increment) {

            float noiseScale = 0.01f; //.015 would be good for tree stumps
            noiseScale += app.random(.0001f, .0006f);

            float percentage = (i / 100f);
            List<Shapes.Point> points = plotRotatedEllipse(app, centerX, centerY, (int)(r1 * percentage), (int)(r2 * percentage), theta, 20f, noiseScale);
            ShapeRenderer.drawPointsAsShape(app, points);

            noiseScale += app.random(.0001f, .0006f);
            points = plotRotatedEllipse(app, centerX, centerY, (int)(r1 * percentage), (int)(r2 * percentage), theta, 20f, noiseScale);
            ShapeRenderer.drawPointsAsShape(app, points);
        }

    }

    private static void drawConcentricOvals(PApplet app, int centerX, int centerY, int r1, int r2, int theta) {
        app.stroke(70, 170);
        app.noFill();

        int increment = Math.min(r1, r2) / 4;
        for (int i = 0; i < 100; i += increment) {
            float percentage = (i / 100f);
            List<Shapes.Point> points = plotRotatedEllipse(app, centerX, centerY, (int)(r1 * percentage), (int)(r2 * percentage), theta, 20f,  0.01f);
            ShapeRenderer.drawPointsAsShape(app, points);
        }

    }
}

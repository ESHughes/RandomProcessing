import Shapes.ShapePlotter;
import Shapes.ShapeRenderer;
import processing.core.PApplet;

import java.util.List;

public class BoneRenderer {

    public static void draw(PApplet app)
    {
        app.background(230, 220, 190);
        app.strokeWeight(1);

        for (int i = 0; i < 360; i += 5) {

            int x = (int)(app.width * app.random(0f, 1f));
            int y = (int)(app.height * app.random(0f, 1f));
            int scale = (int)app.random(60,80);

            drawSketchyOval(app, x, y, scale / 2, scale, i);
//            app.rotate(app.radians(45));
        }



    }

    private static void drawSketchyOval(PApplet app, int centerX, int centerY, int r1, int r2, int theta) {
        app.stroke(70, 150);
        app.noFill();

        int increment = Math.min(r1, r2) / 8;
        for (int i = 0; i < 100; i += increment) {
            float percentage = (i / 100f);
            List<Shapes.Point> points = ShapePlotter.plotRotatedEllipse(app, centerX, centerY, (int)(r1 * percentage), (int)(r2 * percentage), theta, 20f);
            ShapeRenderer.drawPointsAsShape(app, points);
        }

//
//        for (float i = 2; i < 100; i += 5) {
//
//            app.beginShape();
//            for  (int j = 0; j <= 360; j++) {
//                x = centerX + (r1 * (i / 100f))*app.cos(app.radians(j));
//                y = centerY + (r2 * (i / 100f))*app.sin(app.radians(j));
//
//        float noiseScale = app.random(.003f, .006f);
//        float noiseAmount = 20;
//                x += app.map(app.noise(noiseScale * x, noiseScale * y, 0), 0, 1, -noiseAmount, noiseAmount);
//                y += app.map(app.noise(noiseScale * x, noiseScale * y, 1), 0, 1, -noiseAmount, noiseAmount);
//
//                app.vertex(x,y);
//
////            if (app.dist(centerX, centerY, x, y) > maxRadius)  {
////                break;
////            }
//            }
//            app.endShape();
//        }
    }
}

import processing.core.PApplet;

public class FuzzBallRenderer {

    public static void draw(PApplet app) {
        app.background(100,219,240);
//        app.fill(60, 20, 100, 75);
        app.stroke(0, 0);

        int jagginessFactor = (int)app.random(1000, 7000);

        for (int i = 0; i < (int)app.random(60, 100); i++) {
            if (i % 2 == 0) {
                app.fill(60, 20, 100, 75);
            } else {
                app.fill(100,219,240, 75);
            }

            float radius = app.random(20, 300);
            int x = (int)(app.width * app.random(0f, 1f));
            int y = (int)(app.height * app.random(0f, 1f));
            drawSingleCircle(app, x, y, radius + 5, jagginessFactor);
        }
    }

    private static void drawSingleCircle(PApplet app, int centerX, int centerY, float radius, int jagginessFactor) {
        float x;
        float y;
        float radiusNoise = app.random(1000);
        float startRadius = radius;
        float radiusIncrement = radius / jagginessFactor;
        app.beginShape();

        // I should really consider building up the list of points first, then drawing it as a separate step,
        // as a general practice... would make it a lot easier to manipulate


        for  (float angle = 0; angle <= 360; angle += .5) {
            radiusNoise += radiusIncrement;
            radius = startRadius + (int)(app.noise(radiusNoise) * 100); //(int)(Algorithms.scale(app.noise(radiusNoise), 0, 1, 1f, 10f));
//            radiusVariance = 30 * app.pow(app.sin(radiusNoise), clampedValue);

            x = centerX + (radius * app.cos(app.radians(angle)));
            y = centerY + (radius * app.sin(app.radians(angle)));
            app.curveVertex(x, y);

        }

        app.endShape();

    }
//
//    private static float customNoise(PApplet app, float value) {
//        int min = 1;
//        int max = 8;
//        int power = (int)(value % 15); // get it into a range of 1-8... when it starts going too high make it go down instead...
//        int res = clamp((int)value, 1, 8);
//        return app.pow(app.sin(value), res);
//    }

//    private static int clamp(int value, int min, int max) {
//        if (value > max) {
//            int difference = value - max;
//            return max - difference;
//        } else if (value < min) {
//            int difference = min - value;
//            return min + difference;
//        } else {
//            return value;
//        }
//    }
}

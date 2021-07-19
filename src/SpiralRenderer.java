import processing.core.PApplet;

public class SpiralRenderer {

    public static void drawSpirals(PApplet app)
    {
        app.background(241,219,165);
        app.strokeWeight(1);

        // try changing these variables
        float radius = 2;
        float radiusDelta = .15f;
        boolean decreaseOpacity = true;

        int x = (int)(app.width * app.random(.2f, .8f));
        int y = (int)(app.height * app.random(.2f, .8f));

        for (int i = 0; i < 100; i++) {

            drawSingleSpiral(app, true, x, y, radius + 5, radiusDelta, decreaseOpacity);
        }

    }

    private static void drawSingleSpiral(PApplet app, boolean includeNoise, int centerX, int centerY, float radius, float radiusDelta, boolean decreaseOpacity) {
        float x;
        float y;
        float lastX = -1;
        float lastY = -1;
        float radiusNoise = app.random(1000);
        int opacity = 150;
        int angleDelta = 5 + (int)(app.random(5));


        for  (float angle = app.random(360); angle <= app.random(360 * 6) + 360 * 3; angle += angleDelta) {

            x = centerX + (radius * app.cos(app.radians(angle)));
            y = centerY + (radius * app.sin(app.radians(angle)));

            if (lastX != -1 && lastY != -1) {

                app.stroke(255, opacity);
                opacity = decreaseOpacity ? opacity - 1 : opacity;
                app.line(lastX, lastY, x, y);
            }

            lastX = x;
            lastY = y;

            radiusNoise += .05;
            radius += includeNoise ? (app.noise(radiusNoise) * 400) - 200 : radiusDelta;
        }
    }
}

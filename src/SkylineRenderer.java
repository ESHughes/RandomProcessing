import processing.core.PApplet;

public class SkylineRenderer {

    public static void draw(PApplet app) {

//        app.fill(60, 20, 100, 75);
        app.stroke(0, 0);

        int jagginessFactor = (int)app.random(500, 1000);

        int[] colors = new int[] {
            app.color(0, 2, 82),
            app.color(0, 86, 88),
            app.color(80, 4, 0),
            app.color(166, 86, 77),
            app.color(254, 169, 86),
            app.color(254, 236, 83),
            app.color(255, 255, 85)
        };

        app.background(0, 2, 82);

        int colorIndex = 1;

        for (int y = (int)app.random(0, 50); y < app.height && colorIndex < colors.length; y += (int)app.random(60, 120)) {
            app.fill(colors[colorIndex], 150);
            drawSkylineLayer(app, y, jagginessFactor);
            colorIndex++;
        }
    }

    private static void drawSkylineLayer(PApplet app, int startY, int jagginessFactor) {
        float yNoise = app.random(1000);
        app.beginShape();
        int y = startY;

        for  (int x = 0; x <= app.width; x += app.random(4, 20)) {
            yNoise += .5;
            y = startY + (int)(app.noise(yNoise) * jagginessFactor);
            app.curveVertex(x, y);
        }

        app.vertex(app.width, y);
        app.vertex(app.width, app.height);
        app.vertex(0, app.height);
        app.vertex(0, startY);
        app.endShape();

    }
}

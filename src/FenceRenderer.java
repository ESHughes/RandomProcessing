import processing.core.PApplet;

public class FenceRenderer {

    public static void draw(PApplet app)
    {
        app.background(173, 188, 211);
        app.strokeWeight(1);

        int initStartY = 20;
        int baseColor = 200;
        while (initStartY < app.height * .8) {
            float seed = app.random(1000);
            int fenceHeight = app.height / (int)app.random(12, 18);
            FenceRenderer.drawFence(app, seed, initStartY, fenceHeight, 5, baseColor);
            initStartY += fenceHeight * app.random(1f, 1.5f);
            baseColor += 3;
        }
    }

    public static void drawFence(PApplet app, float seed, int initStartY, int fenceHeight, int yStep, int baseColor) {
        boolean allowIrregularGrids = true;

        for (int startY = initStartY; startY < initStartY + fenceHeight; startY += yStep) {
            float yNoise = seed;
            float xNoise = seed;

            int lastX = 0;
            int lastY = 0;

            int xCounter = 0;
            int fencepostFrequency = (int)app.random(2, 10);
            int fencepostLocation = (int)app.random(0, fencepostFrequency);
            for (int x = -10; x < app.width + 20; x += (allowIrregularGrids ? (1 + app.noise(xNoise) * 10) : 10)) { // irregular grids
                int y = startY + (int)(app.noise(yNoise) * 100);

                if (startY == initStartY && xCounter % fencepostFrequency == fencepostLocation) {
                    int fencePostHeight = fenceHeight;
                    fencePostHeight = fenceHeight - (fenceHeight % yStep);
                    if (fenceHeight % yStep == 0) {
                        fencePostHeight -= yStep;
                    }

                }

                if (x != 0) {
                    float riseOverRun = VisualizationHelpers.GetRiseOverRun(lastX, lastY, x, y);
                    app.stroke(baseColor + riseOverRun * 10);

                    app.line(lastX, lastY, x, y);

                    xNoise += .1;
                    yNoise += .1;
                }

                xCounter++;
                lastX = x;
                lastY = y;
            }
        }
    }
}

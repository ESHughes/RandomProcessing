
void setup()
{
  size(1920, 1080);

  background(173, 188, 211);
  strokeWeight(1);
  stroke(255, 200);

  //int centerX = width / 2;

  int initStartY = 20;


  while (initStartY < height * .8) {
    float seed = random(1000);
    int fenceHeight = height / (int)random(10, 14);
    drawFence(seed, initStartY, fenceHeight, 5);     
    initStartY += fenceHeight * random(.9, 1.4);
  }

  //for (int i = 0; i < height; i += (int)random(10, 15 + (i / 50))) {
  //  drawRandomLine(centerX - width * 2/3, centerX + width * 2/3, i); 
  //}
  
  
  saveFrame(System.currentTimeMillis() + ".png");
}


void drawFence(float seed, int initStartY, int fenceHeight, int yStep) {

  for (int startY = initStartY; startY < initStartY + fenceHeight; startY += yStep) {
    float yNoise = seed;
    float xNoise = seed;

    int lastX = 0;
    int lastY = 0;

    int xCounter = 0;
    int fencepostFrequency = (int)random(2, 10);
    int fencepostLocation = (int)random(0, fencepostFrequency);
    for (int x = -10; x < width + 20; x += 10) { // noise(xNoise) * 10
      int y = startY + (int)(noise(yNoise) * 100);

      if (startY == initStartY && xCounter % fencepostFrequency == fencepostLocation) {
        int fencePostHeight = fenceHeight;
        fencePostHeight = fenceHeight - (fenceHeight % yStep);
        if (fenceHeight % yStep == 0) {
          fencePostHeight -= yStep;
        }

        line(x, y + 1, x, y + fencePostHeight - 1);
      }

      if (x != 0) {
        line(x, y, lastX, lastY);      

        xNoise += .1;
        yNoise += .1;
      }

      xCounter++;
      lastX = x;
      lastY = y;
    }
  }
}
//void drawRandomLine(int startX, int endX, int y)
//{
//  int nextX;
//  int nextY;

//  for (int x = startX; x < endX; ) 
//  {
//    nextX = min(x + (int)random(1, 10), endX);
//    nextY = (int)random(y - 7, y + 7);
//    line(x, y, nextX, nextY);

//    x = nextX;
//    y = nextY;
//  }
//}

void draw()
{



  //if (keyCode == ENTER) {
  //  saveFrame("screen-####.jpg");
  //}
}


void mouseClicked(){
  saveFrame("line-######.png");
}

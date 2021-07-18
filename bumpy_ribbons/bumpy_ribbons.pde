
void setup()
{
  size(1920, 1080);
   
  background(173, 188, 211);
      
  int initStartY = 20;  
  int ribbonHeight = 120;
   
   while(initStartY < height) {
     ribbonHeight = 10 * (int)random(7, 10);
     
     float seed = random(1000);
    drawRibbon(seed, initStartY, ribbonHeight, 8);
    initStartY += ribbonHeight * random(1, 1.25);
  }
  
    
  saveFrame(System.currentTimeMillis() + ".png");
}

void drawRibbon(float seed, int initStartY, int ribbonHeight, int yStep) {
  
  float wavelength = random(5, 15);
    
  for (int startY = initStartY; startY < initStartY + ribbonHeight; startY += yStep) {
    float yNoise = seed;
    float xNoise = seed;
      
    int lastX = 0;
    int lastY = 0;
    
    int xCounter = 0;
    int fencepostFrequency = (int)random(2, 10);
    int fencepostLocation = (int)random(0, fencepostFrequency);
    
    
    float angle = 0;
    for (int x = -10; x < width + 20; x += 3) { // noise(xNoise) * 10
      int y = startY + (int)(noise(yNoise) * 80); // (int)customNoise(angle)
      angle += wavelength;      

      if (x != 0) {        
        stroke(230 + 20 * getRiseOverRun(x, y, lastX, lastY));
        strokeWeight(4);
        
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

float getRiseOverRun(int x, int y, int x2, int y2) {
  return (float)(y - y2) / (float)(x - x2);
}


float customNoise(float angle) {
  float radians = radians(angle);
  return pow(sin(radians), 3) * 10;
};


void draw()
{
  
  
  
  //if (keyCode == ENTER) {
  //  saveFrame("screen-####.jpg");
  //}
}

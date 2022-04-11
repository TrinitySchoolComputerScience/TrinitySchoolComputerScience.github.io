public class DisplayWindow{

  private double leftX, bottomY; //The position of the DisplayWindow
  private double length, width; //The length along the x-axis and width along the y-axis of the DisplayWindow
  private double rMax, rMin; //The min and max values on the real axis. Starts at -2 ≤ a ≤ 2
  private double iMax, iMin; //The min and max values on the imaginary axis. Starts at-1.5 ≤ a ≤ 1.5
  private double zoomFactor; //Keeps track of the zoom ratio. Starts at 1. Increases/decreases according to “i”/“I” and “o”/“O” key presses.
  private ComplexNumber center;  //starts at 0+0i. Changes according to mouse clicks on the DisplayWindow

  DisplayWindow(double leftX, double bottomY, double length, double width){
    this.leftX = leftX;
    this.bottomY = bottomY;
    this.length = length;
    this.width = width;
    resetView();

  }

  public void resetView(){
    this.rMax = 2;
    this.rMin = -2;
    this.iMax = 1.5;
    this.iMin = -1.5;
    this.zoomFactor = 1;
    this.center = new ComplexNumber();
    System.out.println("Reset");

  }

  public void zoomIn(){
    this.zoomFactor+=.05;
    this.rMax = this.rMax/this.zoomFactor;
    this.rMin = this.rMin/this.zoomFactor;
    this.iMax = this.iMax/this.zoomFactor;
    this.iMin = this.iMin/this.zoomFactor;
    System.out.println("Zoomin in");
  }

  public void zoomOut(){
    if(this.zoomFactor>1) this.zoomFactor-=.05;
    this.rMax = this.rMax/this.zoomFactor;
    this.rMin = this.rMin/this.zoomFactor;
    this.iMax = this.iMax/this.zoomFactor;
    this.iMin = this.iMin/this.zoomFactor;
    System.out.println("Zoomin out");
  }

  public void recenter(ComplexNumber c){
    //Get the original range
    double rRange = this.rMax - this.rMin;
    double iRange = this.iMax - this.iMin;
    System.out.println("rRange:"+rRange+" iRange:"+iRange);
    //position c at the center of each range
    this.rMin = c.getReal() - rRange/2;
    this.rMax = c.getReal() + rRange/2;
    this.iMin = c.getImaginary() - iRange/2;
    this.iMax = c.getImaginary() + iRange/2;
    this.center = c;
  }

  public double getRMin(){ return this.rMin;}
  public double getRMax(){ return this.rMax;}
  public double getIMin(){ return this.iMin;}
  public double getIMax(){ return this.iMax;}
  public double getZoomFactor(){ return this.zoomFactor;}

  public double getStepSize(){
    double rRange = this.rMax- this.rMin;
    System.out.println("stepsize:"+rRange/length);
    return rRange/length;
  }

  public double mapX(double a){
    return map(a, this.rMin, this.rMax, this.leftX, this.leftX+this.length);
  }

  public double mapY(double b){
    return map(b, this.iMin, this.iMax, this.bottomY, this.bottomY+this.width);
  }

  public double mapA(double windowX){
    return map(windowX, this.leftX, this.leftX+this.length, this.rMin, this.rMax);
  }

  public double mapB(double windowY){
    return map(windowY, this.bottomY, this.bottomY+this.width, this.iMin, this.iMax);
  }

  private double map(double value, double oldMin, double oldMax, double newMin, double newMax){
    double prop = (value-oldMin)/(oldMax - oldMin);//Find proportion of old range
    return prop*(newMax-newMin) + newMin;//Add the equivalent proportion to the newMin
  }
}

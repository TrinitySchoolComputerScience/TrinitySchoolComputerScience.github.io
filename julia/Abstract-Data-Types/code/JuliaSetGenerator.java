/**
  JuliaSetGenerator.java
  Phase 2 demo solution with DisplayWindow class

  Requires prior implementation of:
    -ComplexNumber.java constructors, accessors, square, add
    -DisplayWindow.java constructor, map, mapX, mapY, getRMin, getRMax, ferIMin, getIMax

*/
public class JuliaSetGenerator{
  public static void main(String args[]){
    StdDraw.setCanvasSize(800,300);
    StdDraw.setXscale(0,800);
    StdDraw.setYscale(0,300);
    StdDraw.enableDoubleBuffering();
    DisplayWindow leftWin= new DisplayWindow(0,0,400,300);
    DisplayWindow rightWin = new DisplayWindow(400,0,400,300);

    drawMandelbrot(leftWin);

    while(true){
      if(StdDraw.isKeyPressed(73)){//i or I
        leftWin.zoomIn();
        drawMandelbrot(leftWin);
      }else if(StdDraw.isKeyPressed(79)){//o or O
        leftWin.zoomOut();
        drawMandelbrot(leftWin);
      }
      else if(StdDraw.isKeyPressed(82)){//r or R
        leftWin.resetView();
        drawMandelbrot(leftWin);
      }

      if(StdDraw.mousePressed() && StdDraw.mouseX()<400){
        double a = leftWin.mapA(StdDraw.mouseX());
        double b = leftWin.mapB(StdDraw.mouseY());
        ComplexNumber newCenter = new ComplexNumber(a, b);
        leftWin.recenter(newCenter);
        drawMandelbrot(leftWin);
      }

      StdDraw.pause(100);
      StdDraw.show();
     }

  }

public static void drawMandelbrot(DisplayWindow leftWin){
  double increment = leftWin.getStepSize();

  ComplexNumber z0 = new ComplexNumber();//0+0i

  for (double a = leftWin.getRMin(); a < leftWin.getRMax(); a+= increment) { //real
  for (double b = leftWin.getIMin(); b < leftWin.getIMax(); b+= increment) { //imaginery
    ComplexNumber c = new ComplexNumber(a,b);//the point to evaluate

    int terms = mandelbrot(z0, c, 0); //0->360

    if(terms == 255)   StdDraw.setPenColor(StdDraw.BLACK);
    else StdDraw.setPenColor(StdDraw.WHITE);

    StdDraw.filledCircle(leftWin.mapX(c.getReal()), leftWin.mapY(c.getImaginary()), 1);
  }
}
}

/**
  Generates a recursive sequence to determine whether a point should be considered
  part of the Mandelbrot Set
  @param z, the next ComplexNumber term in the sequence
  @param c, the ComplexNumber to evaluate
  @param n, the nth term of the sequence, an int
  @return either the number of terms considered or the next term in the sequence
*/
public static int mandelbrot(ComplexNumber z, ComplexNumber c, int n) {
    if (z.magnitude()>2 || n >= 255)
      return n;
  //case 2: compute next iteration of sequence
    return mandelbrot(z.square().add(c),c,n+1);
}//mandelbrot

}

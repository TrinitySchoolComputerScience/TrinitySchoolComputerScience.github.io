/**
*  The {@code Rectangle} class provides a basic capability for
*  using Rectangle objects in your programs. It uses a simple model of
*  a rectangle to illustrate the basics of Classes, objects, and javadoc comments.
*
*  <h1>Getting started.</h1>
*  To use this Rectangle class, make sure it is in the same folder as the client code
*  <h2>Constructors</h2>
*  You can create Rectangles with the following methods:
*  <ul>
*  <li> {@link #Rectangle(double w, double l)}
*  <li> {@link #Rectangle()}
*  <li> {@link #Rectangle(Rectangle r)}
*  </ul>
*
*  <h2>Accessors</h2>
*  You can access Rectangle data attributes with the following methods:
*  <ul>
*  <li> {@link #getWidth()}
*  <li> {@link #getLength()}
*  </ul>
*
*  <h2>Modifiers</h2>
*  You can modify Rectangle data attributes with the following methods:
*  <ul>
*  <li> {@link #setWidth(double w)}
*  <li> {@link #setLength(double l)}
*  </ul>
*
*  <h2>Calculating Geometric Measurements</h2>
*  You can calculate geometric measurements of a Rectangle with the following methods:
*  <ul>
*  <li> {@link #getArea()}
*  <li> {@link #getPerimeter()}
*  </ul>
*
*  <h2>Comparing Rectangles</h2>
*  You can compare Rectangles with the following methods:
*  <ul>
*  <li> {@link #compareTo(Rectangle r)}
*  </ul>
*
*
*  <h2>Stringifying Rectangles</h2>
*  You can "Stringify" a Rectangle with the following methods:
*  <ul>
*  <li> {@link #toString()}
*  </ul>
*
 **/

public class Rectangle {
  private double width;
  private double length;

  /**
    * The standard constructor for class Rectangle
    * @param w  a double value indicating the width of the new Rectangle
    * @param l  a double value indicating the length of the new Rectangle
    *
    */
  Rectangle(double w, double l) {
    this.width = w;
    this.length = l;
  }
  /**
    * The default constructor for class Rectangle
    * Intitializes both the width and length of the new Rectangle to 1.0
    *
    */
  Rectangle() {
    this.width = 1.0;
    this.length = 1.0;
  }
  /**
    * The copy constructor for class Rectangle
    * @param r  a Rectangle object which will provide the length and width of the new Rectangle
    *
    */
  Rectangle(Rectangle r) {
    this.width = r.getWidth();
    this.length = r.getLength();
  }
  /**
    * The Accessor method for the length attribute of a Rectangle
    * @return the length of the Rectangle, a double value
    *
    */
  public double getLength() {
    return this.length;
  }
  /**
    * The Accessor method for the width attribute of a Rectangle
    * @return the width of the Rectangle, a double value
    *
    */
  public double getWidth() {
    return this.width;
  }
  /**
    * The Modifier method for the length attribute of a Rectangle
    * @param l a double value indicating the new length of the Rectangle
    *
    */
  public void setLength(double l) {
    this.length = l;
  }
  /**
    * The Modifier method for the width attribute of a Rectangle
    * @param w a double value indicating the new width of the Rectangle
    *
    */
  public void setWidth(double w) {
    this.width = w;
  }
  /**
    * Returns the area of the Rectangle as determined by multiplying
    * the current length and the width of the Rectangle
    * @return the area of the Rectangle, a double value
    *
    */
  public double getArea() {
    return this.width * this.length;
  }
  /**
    * Returns the perimeter of the Rectangle as determined by adding
    * twice the length with twice the width of the Rectangle
    * @return the area of the Rectangle, a double value
    *
    */
  public double getPerimeter() {
    return 2 * this.width + 2 * this.length;
  }

  /**
    * Compares two Rectangle objects by comparing their area
    * <p>
    * Returns:
    * <ul>
    * <li> 0 if the two Rectangles have the same area </li>
    * <li> a negative integer if the area of this Rectangle is less than the area of the specified Rectangle </li>
    * <li> a positive integer if the area of this Rectangle is greater than the area of the specified Rectangle </li>
    * </ul>
    *
    * @param r a Rectangle to be compared with this Rectangle
    * @return a negative integer, zero, or a positive integer as this Rectangle is less than, equal to, or greater than the specified Rectangle
    *
    */
  public int compareTo(Rectangle r) {
    return (int)(this.getArea() - r.getArea());
  }
  /**
    * Returns a String version of the Rectangle
    * <p>Indicates the current length and width of the Rectangle in the format <em>l: 1.0 w:1.0 </em>
    * @return the String version of the Rectangle
    *
    */
  public String toString() {
    return "l:" + this.length + " w:" + this.width;
  }

  /**
    * A main method is included for testing purposes
    *
    * @param args an array of String values taken from the comand line
    */
  public static void main(String[] args) {

    Rectangle r1 = new Rectangle(2, 4);
    Rectangle r2 = new Rectangle(10, 20);
    Rectangle r3 = new Rectangle(r1);

    System.out.println("------------Rectangle Basics------------");
    System.out.println("r1- " + r1);
    System.out.println("r2- " + r2);
    System.out.println("The area of r1 is:" + r1.getArea());
    System.out.println("The area of r2 is:" + r2.getArea());
    System.out.println("The perimeter of r1 is:" + r1.getPerimeter());
    System.out.println("The perimeter of r2 is:" + r2.getPerimeter());

    System.out.println();
    System.out.println("------------Comparing Rectangle Memory References------------");
    System.out.println("Comparing memory references of r1 and r3:"+ (r1 == r3));
    //System.out.println("Comparing memory references of r1 and r1:"+ (r1 < r3));

    if(r1 == r3) System.out.println("r1 and r3 are the same object");
    else System.out.println("r1 and r3 are different objects");

    if(r1 == r1) System.out.println("r1 and r1 are the same object");
    else System.out.println("r1 and r1 are different objects");

    System.out.println();
    System.out.println("------------Comparing Rectangle Areas------------");
    System.out.println("Comparing area of r1 and r3:"+r1.compareTo(r3));
    System.out.println("Comparing area of r1 and r2:"+r1.compareTo(r2));

    if(r1.compareTo(r3)==0) System.out.println("r1 has the same area as r3");
    if(r1.compareTo(r2)<0) System.out.println("r1 has a smaller area than r2");
    if(r2.compareTo(r3)>0) System.out.println("r2 has a bigger area than r3");
  }

}

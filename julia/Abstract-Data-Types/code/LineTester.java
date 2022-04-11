/*
    LineTester.java should be placed in the same directory as Line.java
    compile: javac LineTester.java
    run: java -ea lineTester
*/
public class LineTester{
  public static void main(String args[]){
    Line line1 = new Line(5, 4, -17);
    double slope1 = line1.getSlope();
    boolean onLine1 = line1.isOnLine(5, -2);

    Line line2 = new Line(-25, 40, 30);
    double slope2 = line2.getSlope();
    boolean onLine2 = line2.isOnLine(5, -2);

    assert slope1 == -1.25 : "INCORRECT: line1.getSlope()- Actual: "+slope1+" Expected: -1.25";
    assert onLine1 == true : "INCORRECT: line1.isOnLine(5, -2)- Actual: "+onLine1+" Expected: true";
    assert slope1 == -1.25 : "INCORRECT: line2.getSlope()- Actual: "+slope1+" Expected: 0.625";
    assert onLine2 == false : "INCORRECT: line2.isOnLine(5, -2)- Actual: "+onLine1+" Expected: false";

    System.out.println("All tests PASS!");
  }
}

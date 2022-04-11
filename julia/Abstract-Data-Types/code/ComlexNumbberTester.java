/*
  >javac ComplexNumberTester.java
  >java -ea ComplexNumberTester

  Be sure to run this code with teh "-ea" flag, which stands for
  "enable assertions"
*/

import java.lang.Math;

public class ComplexNumberTester
{
  public static void main(String[] args) {
    ComplexNumber cn_2_3 = new ComplexNumber(2, 3);
    ComplexNumber cn_2_3_same = new ComplexNumber(2, 3);
    ComplexNumber cn_2_3_close = new ComplexNumber(2.1, 3.1);
    ComplexNumber cn_1_neg2 = new ComplexNumber(1, -2);
    ComplexNumber cn_neg1_1 = new ComplexNumber(-1, 1);
    ComplexNumber cn_2_neg1= new ComplexNumber(2, -1);
    ComplexNumber cn_3_0 = new ComplexNumber(3, 0);
    ComplexNumber cn_0_neg2 = new ComplexNumber(0, -2);
    ComplexNumber cn_0_0 = new ComplexNumber(0, 0);
    ComplexNumber c_copy_1_neg2 = new ComplexNumber(cn_1_neg2);
    ComplexNumber c_default = new ComplexNumber();

    System.out.println("-------------------Constructors and toString-------------------");
    Tester.assertStringsAreEqual("Testing basic ComplexNumber", "2.0+3.0i", cn_2_3.toString());
    Tester.assertStringsAreEqual("Negative imaginary component", "1.0-2.0i", cn_1_neg2.toString());
    Tester.assertStringsAreEqual("1 imaginary component", "-1.0+i", cn_neg1_1.toString());
    Tester.assertStringsAreEqual("-1 imaginary component", "2.0-i", cn_2_neg1.toString());
    Tester.assertStringsAreEqual("0 imaginary component", "3.0", cn_3_0.toString());
    Tester.assertStringsAreEqual("0 real component", "-2.0i", cn_0_neg2.toString());
    Tester.assertStringsAreEqual("0 real and 0 imaginary components", "0.0", cn_0_0.toString());
    Tester.assertStringsAreEqual("Copy constructor", "1.0-2.0i", c_copy_1_neg2.toString());
    Tester.assertStringsAreEqual("Default constructor", "0.0", c_default.toString());

    System.out.println("-------------------Testing magnitude-------------------");
    Tester.assertDoublesAreEqual("Basic magnitude", 3.6055, cn_2_3.magnitude());
    Tester.assertDoublesAreEqual("Magnitude with a negative component",2.2360679775, cn_1_neg2.magnitude());
    Tester.assertDoublesAreEqual("Magnitude with a 0 component",0.0, cn_0_0.magnitude());

    System.out.println("-------------------Testing compareTo-------------------");
    Tester.assertDoublesAreEqual("Equal comparison", 0.0, cn_1_neg2.compareTo(c_copy_1_neg2));
    System.out.print("Less than comparison");
    assert cn_2_3.compareTo(cn_2_3_close) < 0: "-1.0+1i should be less than 2.0+3.0i";
    System.out.println(": passed!");
    System.out.print("Greater than comparison");
    assert cn_2_3.compareTo(cn_0_0) > 0: "2.0+3.0i should be greater than 0.0";
    System.out.println(": passed!");

    System.out.println("-------------------Testing Arithmetic-------------------");
    Tester.assertCNAreEqual("Addition instance method", new ComplexNumber(5,-1),cn_2_neg1.add(cn_3_0));
    Tester.assertCNAreEqual("Addition static method", new ComplexNumber(5,-1),ComplexNumber.add(cn_2_neg1, cn_3_0));
    Tester.assertCNAreEqual("Subtraction instance method", new ComplexNumber(-1,-1),cn_2_neg1.subtract(cn_3_0));
    Tester.assertCNAreEqual("Subtraction static method", new ComplexNumber(-1,-1),ComplexNumber.subtract(cn_2_neg1, cn_3_0));
    Tester.assertCNAreEqual("Multiplication instance method", new ComplexNumber(1,3),cn_1_neg2.multiply(cn_neg1_1));
    Tester.assertCNAreEqual("Multiplication static method", new ComplexNumber(1,3),ComplexNumber.multiply(cn_1_neg2,cn_neg1_1));
    Tester.assertCNAreEqual("Divide instance method", new ComplexNumber(-1.5,0.5),cn_1_neg2.divide(cn_neg1_1));
    Tester.assertCNAreEqual("Divide static method", new ComplexNumber(-1.5,0.5),ComplexNumber.divide(cn_1_neg2,cn_neg1_1));
    Tester.assertCNAreEqual("Square instance method", new ComplexNumber(-3,-4), cn_1_neg2.square());
    Tester.assertCNAreEqual("Square static method", new ComplexNumber(-3,-4), ComplexNumber.square(cn_1_neg2));

    System.out.println("Testing divide- ArithmeticException");
    try {
           System.out.println(cn_2_3.divide(cn_0_0));
    }
    catch(ArithmeticException e) {
            System.err.println("Caught ArithmeticException: " + e.getMessage()+" Requirement passed!");
    }

  }//main

  private class Tester{

  final static double THRESHOLD = .000000000001;

  /**
   * Uses an assertion to test whether two String values are equal.
   *
   * @param label a String, the description of the context of the comparison
   * @param expected a String, the expected String value for the test
   * @param actual a String, the actual String value that resulted from the test
   */
  public static void assertStringsAreEqual(String label, String expected, String actual){
    System.out.print(label);
    assert actual.equals(expected): "+++Expected:"+expected+" Actual:"+actual+"+++";
    System.out.println(": passed!");
  }

  /**
   * Uses an assertion to test whether two double values are equal.
   * Because of the imprecision of decimal values, a THRESHOLD
   * constant is used. Decimal values that are within THRESHOLD of
   * each other are considered "the same".
   *
   * @param label a String, the description of the context of the comparison
   * @param expected a String, the expected String value for the test
   * @param actual a String, the actual String value that resulted from the test
   */
  public static void assertDoublesAreEqual(String label, double expected, double actual){
    System.out.print(label);
    assert expected-actual<=THRESHOLD: "+++Expected:"+expected+" Actual:"+actual+"+++";
    System.out.println(": passed!");
  }//assertDoublesAreEqual helper method

  /**
   * Uses an assertion to test whether two Complex Number objects are the same.
   * Because of the imprecision of decimal values, a THRESHOLD
   * constant is used to compare both the real and imaginary components
   * of a ComplexNumber. Both the real and imaginary components must be within
   * THRESHOLD of each other for two COmplexNumbers to be considered
   * considered "the same".
   *
   * @param label a String, the description of the context of the comparison
   * @param expected a String, the expected String value for the test
   * @param actual a String, the actual String value that resulted from the test
   */
  public static void assertCNAreEqual(String label, ComplexNumber expected, ComplexNumber actual){
    System.out.print(label);
    boolean realOutcome = Math.abs(expected.getReal() - actual.getReal()) < THRESHOLD;
    boolean imaginaryOutcome = Math.abs(expected.getImaginary() - actual.getImaginary()) < THRESHOLD;
    assert realOutcome && imaginaryOutcome: "+++Expected:"+expected+" Actual:"+actual+"+++";
    System.out.println(": passed!");
  }//assertDoublesAreEqual helper method

}

}//ComplexNumberTester

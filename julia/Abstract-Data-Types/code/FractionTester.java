/*
    FractionTester.java should be placed in the same directory as Fraction.java
    compile: javac FractionTester.java
    run: java -ea FractionTester
*/
public class FractionTester{
  public static void main(String args[]){
    Fraction f_1_2 = new Fraction(1, 2); 	        //proper fraction
    Fraction f_2_1 = new Fraction(2, 1); 	        //Integer
    Fraction f_0_1 = new Fraction(0, 1); 	        //Integer
    Fraction f_3_2 = new Fraction(3, 2); 	        //Improper fraction
    Fraction f_neg1_2 = new Fraction(-1, 2); 	    //Negative on top
    Fraction f_1_neg2 = new Fraction(1, -2); 	    //Negative on bottom
    Fraction f_neg1_neg2 = new Fraction(-1, -2); 	//Double negatives
    Fraction f_4_8 = new Fraction(4, 8); 	        //Common factor
    Fraction f_4_8_copy = new Fraction(f_4_8);    //copy constructor
    Fraction f = new Fraction();                  //default constructor

    try {
       Fraction f_1_0 = new Fraction(1, 0);   	  //Not a valid Fraction
    }
    catch(IllegalArgumentException e) {
        System.err.println("Caught IllegalArgumentException: " + e.getMessage());
    }

    System.out.println("-----------toString() tests----------");
    assert "1".equals(f.toString()) : "FAIL:"+f+" Expected: 1";
    assert "1/2".equals(f_1_2.toString()) : "FAIL:"+f_1_2+" Expected: 1/2";
    assert "2".equals(f_2_1.toString()) : "FAIL:"+f_2_1+" Expected: 2";
    assert "0".equals(f_0_1.toString()) : "FAIL:"+f_0_1+" Expected: 0";
    assert "1 1/2".equals(f_3_2.toString()) : "FAIL:"+f_3_2+" Expected: 1 1/2";
    assert "-1/2".equals(f_neg1_2.toString()) : "FAIL:"+f_1_2+" Expected: -1/2";
    assert "-1/2".equals(f_1_neg2.toString()) : "FAIL:"+f_1_2+" Expected: -1/2";
    assert "1/2".equals(f_neg1_neg2.toString()) : "FAIL:"+f_neg1_neg2+" Expected: 1/2";
    assert "1/2".equals(f_4_8.toString()) : "FAIL:"+f_4_8+" Expected: 1/2";
    assert "1/2".equals(f_4_8_copy.toString()) : "FAIL:"+f_4_8_copy+" Expected: 1/2";
    System.out.println("-----All toString() tests pass!-------\n");

    System.out.println("-----------toDecimal() tests----------");
    System.out.println("-----------compareTo() tests----------");
    System.out.println("-----------add() tests----------");
    System.out.println("-----------subtract() tests----------");
    System.out.println("-----------multiply() tests----------");
    System.out.println("-----------divide() tests----------");





  }//main
}//FractionTester

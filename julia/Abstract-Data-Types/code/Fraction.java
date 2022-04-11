public class Fraction{
   private int numerator, denominator;

   //  Accessor methods
   public int getNumerator(){ return this.numerator; }
   public int getDenominator(){ return this.denominator; }

  /**
   * Fraction standard constructor
   * @param n  the integer value of the numerator of the Fraction
   * @param d  the integer value of the numerator of the Fraction
   */
   public Fraction(int n, int d){
      if (d == 0) throw new IllegalArgumentException("Invalid denominator: " + d);

      if (d < 0){
         n = n * -1;
         d = d * -1;
      }

      this.numerator = n;
      this.denominator = d;
      reduce();//store all fractions in lowest terms
   }

   /**
    * Fraction default constructor
    * Creates a Fraction equvalent of 1 (ie. 1/1)
    */
   public Fraction(){
      this.numerator = 1;
      this.denominator = 1;
   }

   /**
    * Fraction copy constructor
    * @param f  The fraction to be copied
    */
   public Fraction(Fraction f){
     this.numerator = f.getNumerator();
     this.denominator = f.getDenominator();
   }

   /**
    * Returns the reciprocal of this Fraction
    * @return a new Fraction, the reciprocal of the current Fraction
    */
   public Fraction reciprocal(){ return new Fraction (this.denominator, this.numerator); }

   /**
    * Adds two fractions
    * @param  f the Fraction to add to this Fraction
    * @return  a new Fraction, the sum of the two fractions
    */
   public Fraction add(Fraction f){
      int commonDenominator = this.denominator * f.getDenominator();
      int numerator1 = this.numerator * f.getDenominator();
      int numerator2 = f.getNumerator() * this.denominator;
      int sum = numerator1 + numerator2;
      return new Fraction (sum, commonDenominator);
   }

   /**
    * Subtracts two fractions
    * @param  f the Fraction to subtract from this Fraction
    * @return  a new Fraction, the differences of the two fractions
    */
   public Fraction subtract (Fraction f){
      int commonDenominator = this.denominator * f.getDenominator();
      int numerator1 = this.numerator * f.getDenominator();
      int numerator2 = f.getNumerator() * this.denominator;
      int difference = numerator1 - numerator2;
      return new Fraction (difference, commonDenominator);
   }

   /**
    * Multiplies two fractions
    * @param  f the Fraction to multiple by this Fraction
    * @return  a new Fraction, the product of the two fractions
    */
   public Fraction multiply (Fraction f){
      int numer = this.numerator * f.getNumerator();
      int denom = this.denominator * f.getDenominator();
      return new Fraction (numer, denom);
   }

   /**
    * Divides two fractions by multiplying by the reciprocal
    * Reuses the multiply method and makes use of reciprocal()
    * @param  f the Fraction to divide this Fraction
    * @return  a new Fraction, the quotient of the two fractions
    */
   public Fraction divide (Fraction f){ return multiply(f.reciprocal()); }

   /**
    * The standard comparator
    * returns a negative integer if this Fraction is less than f
    * returns 0 if this Fraction is the same as f
    * returns a positivwe integer if this Fraction is greater than f
    *
    * @param  f   the Fraction to compare with this
    * @return  an integer indicating the outcome fo the comparison
    */
   public int compareTo (Fraction f){
     return this.numerator*f.getDenominator() - this.denominator*f.getNumerator();
   }

   /**
    * Calculates the decimal value of the fraction
    * @return a double, the quotient from dividing the numerator by the denominator
    */
   public double toDecimal (){
      return (double)this.numerator/this.denominator;
   }

   /**
    * Returns the String equivalent of a Fraction
    * @return a String
    */
   public String toString (){
      if (this.numerator == 0) return "0";
      else if (this.denominator == 1) return this.numerator + "";
      else if(this.numerator>this.denominator){
        int q = this.numerator/this.denominator;
        int r = this.numerator%this.denominator;
        return q+" "+r+"/"+this.denominator;
      }
      else return this.numerator + "/" + this.denominator;
   }

   /**
    * Modifies the current fraction by rewriting the numerator and denominator
    * Divides both the numerator and the denominator by their GCD
    */
   private void reduce (){
      if (this.numerator != 0){
         int common = gcd (Math.abs(this.numerator), this.denominator);
         this.numerator = this.numerator / common;
         this.denominator = this.denominator / common;
      }
   }

   /**
    * Calculates the GCD of two numbers
    * A private helper method for reduce()
    * @param  num1, an integer
    * @param  num2, an integer
    * @return   the integer GCD of num1 and num2
    */
   private int gcd (int num1, int num2){
      while (num1 != num2)
         if (num1 > num2) num1 = num1 - num2;
         else num2 = num2 - num1;

      return num1;
   }
}//end Fraction class

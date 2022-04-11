public class ComplexNumber {

	private double a;
	private double b;

	/**
	 * Creates a new ComplexNumber with both real and imaginary components
	 * @param a the real component of the complex number
	 * @param b the imaginary component of the complex number
	 */
	public ComplexNumber(double a, double b){
		this.a = a;
		this.b = b;
	}

	/**
	 * An "accessor" method
	 * Returns the real component of this ComplexNumber
	 * @return a the private real component of this ComplexNumber
	 */
	public double getReal(){
		return a;
	}

	/**
	 * An "accessor" method
	 * Returns the imaginary component of this ComplexNumber
	 * @return b the private imaginary component of this ComplexNumber
	 */
	public double getImaginary(){
		return b;
	}

}

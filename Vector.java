public class Vector extends Matrix{

	// pulls from matrix, sets vector from subset
	public Vector(int c) {
		super(1, c);
	} // method vector end

	
	// pulls from matrix, returns the subset of values
	public Vector(int c, double[] linArr) {
		super(1, c, linArr);
	} // method vector end

	// get element method
	public double getElement(int c) {
		return super.getElement(0, c);
	} // method getElement end


} // class vector 
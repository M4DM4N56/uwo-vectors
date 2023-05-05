	public class MarkovChain {

	private Vector stateVector;
	private Matrix transitionMatrix;
		
	public MarkovChain(Vector sVector, Matrix tMatrix){
		stateVector = sVector;
		transitionMatrix = tMatrix;
	} // method MarkovChain end
	
	
	// method is-Valid
	public boolean isValid(){
		double vectorAdd = 0;
		
		// vector total
		// runs through vector, checks if sum = 1
		for (int i = 0; i < stateVector.getNumCols(); i++){	
			vectorAdd += stateVector.getElement(i);
		} // for i
		
		if(vectorAdd <=  0.99 || vectorAdd >=  1.01) {
			return false;
			} // if
		
		
		// row total
		// runs through each row, check if any row = 1
		for (int i = 0; i < transitionMatrix.getNumRows(); i++){	
			// resets count to 0 each row
			double addRow = 0;
			for (int j = 0; j < transitionMatrix.getNumCols(); j++){
				addRow += transitionMatrix.getElement(i, j);
			} // for j
			
			// checking each row for not-1 for every row
			if(addRow <=  0.99 || addRow >=  1.01) {
				return false;
				} // if
		
		} // for i
		
		// checks that columns and rows are equal in transition-transition and state-transition
		if (transitionMatrix.getNumCols() !=  transitionMatrix.getNumRows()){
			return false;
			} // if
		if (transitionMatrix.getNumCols() !=  stateVector.getNumCols()){
			return false;
			} // if
		
		return true;
	} // method is-Valid end
	
	
	// method compute Probability Matrix
	public Matrix computeProbabilityMatrix(int numSteps) {
		// makes sure matrix is valid before continuing
		if (this.isValid() ==  false) {
			return null;
			} // if
		// creates newMatrix
		Matrix newMatrix = transitionMatrix;
		
		// subtracted 1 from numSteps here for clarity and simplicity
		numSteps = numSteps - 1;
		
		for (int i = 0; i < numSteps; i++) {
			// multiplies matrix * matrix transition matrix number of times
			newMatrix = newMatrix.multiply(transitionMatrix);
		} // for i 
		
		return stateVector.multiply(newMatrix);
		
	} // method computeProbabilityMatrix end
	
	
} // class marcovChain 

public class Matrix {
	
	// creating instance variables
	private int numRows;
    private int numCols;
    private double[][] data;

    // matrix constructor
    public Matrix(int r, int c) {
        this.numRows = r;
        this.numCols = c;
        // data is array that holds r rows and c columns
        this.data = new double[r][c];
    } // method Matrix end

    // matrix 2 constructor
    public Matrix(int r, int c, double[] linArr) {
    	// same as first matrix method
        this.numRows = r;
        this.numCols = c;
        this.data = new double[r][c];
        
        // inserting the linArr values into their designated spots in data
        int index = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                data[i][j] = linArr[index];
                index++;
            } // for j
        } // for i
    } // method Matrix 2 end

    // getter numRows
    public int getNumRows() {
        return numRows;
    } // method getter end

    // getter numCols
    public int getNumCols() {
        return numCols;
    } // method getter end

    // getter data
    public double[][] getData() {
        return data;
    } // method getter end

    // getter element
    public double getElement(int r, int c) {
        return data[r][c];
    } // method getter end
    
    // setter element
    public void setElement(int r, int c, double value) {
    	data[r][c] = value;
    } // method setter end

    // transpose
    public void transpose() {
    	// creates transposed data matrix
        double[][] transposedData = new double[numCols][numRows];
        
        // going through the rows and columns and implementing data elements into the switched rows and columns
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                transposedData[j][i] = data[i][j];
            } // for j
        } // for i

        // overwrites old data into the new, transposed data
        data = transposedData;
        int temp = numRows;
        numRows = numCols;
        numCols = temp;
    } // method transposed end

    // scalar multiple
    public Matrix multiply(double scalar) {
    	// creates scalar multiple matrix
    	Matrix scalarMultiple = new Matrix(numRows, numCols); 
    	
        // going through the rows and columns and implementing the multiplied data elements
    	for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                scalarMultiple.data[i][j] = data[i][j] * scalar;
            } // for j
        } // for i
    	
        return scalarMultiple;
    } // method multiply scalar end
    
    
    // matrix multiple
    public Matrix multiply(Matrix other) {
    	// matrices can only multiply if rows = columns, checking if this is true
    	if (this.numCols !=  other.numRows) {
    		return null;
    	}
    	
    	// creates matrix Multiple matrix
    	Matrix matrixMultiple = new Matrix(numRows, other.numCols);   
    	
    	// runs through rows of this, then other's columns & rows 
    	for (int i = 0; i < this.numRows; i++) {
            for (int j = 0; j < other.numCols; j++) {
            	for (int k = 0; k < other.numRows; k++) {
            		// takes data in other, multiplies it with this, adds it to matrix multiple
            		matrixMultiple.data[i][j] += this.data[i][k] * other.data[k][j];
            	} // for k
            } // for j
        } // for i
        return matrixMultiple;
    } // method multiply scalar end

    
    // toString
    public String toString() {
    	// creates string
        StringBuilder result = new StringBuilder();
        
        // checks if matrix is empty
        if (numRows ==  0 || numCols ==  0) {
            return "Empty matrix";
        } // if
        
        // turns matrix to string
        else {
        	// looping through columns and rows, going to every element
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                	// appends that element to string with formatting
                    result.append(String.format("%8.3f", data[i][j]));
                } // for j
                // adds newline for every row
                result.append("\n");
            } // for i
            return result.toString();
          } // else
        
    } // method toString end


} // class Matrix end

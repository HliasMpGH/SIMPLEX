import java.util.Scanner;

public class Matrix {
	static Scanner in = new Scanner(System.in);
<<<<<<< HEAD
	private double[][] mat;
=======
	private int[][] mat;
>>>>>>> cb1d019205d4bb86b4d86c04b1a73c0519f4dc7a
	private int vars;
	private int consts;
	
	Matrix(int vars, int consts) {
		this.vars = vars;
		this.consts = consts;
		setMatrix();
	}

	Matrix() {
		this.vars = 1;
		this.consts = 1;
		setMatrix();
	}

	// structures the matrix based on the constrains and variables
	private void setMatrix() {
<<<<<<< HEAD
		mat = new double[consts + 1][vars + consts + 2]; // add 1 to both dimensions for the objective function(add 1 more collumn for the values of the constaints)
=======
		mat = new int[consts + 1][vars + consts + 2]; // add 1 to both dimensions for the objective function(add 1 more collumn for the values of the constaints)
>>>>>>> cb1d019205d4bb86b4d86c04b1a73c0519f4dc7a
	}

	private void fillMatrix() {
		String[] coef;
		in.nextLine();
		// edw prwta tha gemisw thn teleytaia grammh(obj synarthsh)
		setObjFunction();
		for (int i = 0; i < consts; i++) {
			System.out.println("Enter constraint number " + (i + 1) +":");
			String con = in.nextLine();
			coef = con.split("[\\W]*['*'][\\W]*\\w[\\d]+[\\W]*"); // get the constraint coefficients & values
			mat[i][vars + consts + 1] = Integer.valueOf(coef[coef.length - 1]); // fill the last collumn of the simplex matrix with the constraint values
			for (int j = 0; j < coef.length - 1; j++) {
				mat[i][j] = Integer.valueOf(coef[j]); // place the coefficients in the matrix
			}
			mat[i][vars + i] = 1; // 1 for the surplus variables
		}
		
		for (int[] var : mat) {
			for (int var2 : var) {
				System.out.print(var2 + "\t");
			}
			System.out.println();
		}
		


		
	}
<<<<<<< HEAD
=======
	public void setObjFunction() {
		System.out.print("Insert the objective function: ");
		String of = in.nextLine();
		// provlima : an exei kena anamesa stous telestes to regex split dhmiourgei provlima (tha exei ena keno meta apo ton arithmo)
		String[] coef = of.split("[Z|z][\\W]*['='][\\W]*|['*'][\\W]*\\w[\\d]+[\\W]*"); // get the OF coefficients
		for (int j = 1; j < coef.length; j++) {
			mat[mat.length - 1][j - 1] = -Integer.valueOf(coef[j]); // place the coefficients in the matrix(negatives)
		}
		mat[mat.length - 1][vars + consts] = 1; // 1 for the Z coefficent
	}

	// main, will be on Decision class
	public static void main(String[] args) {
		System.out.print("Insert the number of variables that will be used: ");
		int vars = in.nextInt();
		System.out.print("and the number of the constraints: ");
		int consts = in.nextInt();
		Matrix m = new Matrix(vars, consts);
		m.fillMatrix();
	}


	
	//public void findSolution();
>>>>>>> cb1d019205d4bb86b4d86c04b1a73c0519f4dc7a

	private void printM() {
		for (double[] var : mat) {
			for (double var2 : var) {
				System.out.print(var2 + "\t");
			}
			System.out.println();
		}
	}

	public void setObjFunction() {
		System.out.print("Insert the objective function: ");
		String of = in.nextLine();
		// provlima : an exei kena anamesa stous telestes to regex split dhmiourgei provlima (tha exei ena keno meta apo ton arithmo)
		String[] coef = of.split("[Z|z][\\W]*['='][\\W]*|['*'][\\W]*\\w[\\d]+[\\W]*"); // get the OF coefficients
		for (int j = 1; j < coef.length; j++) {
			mat[mat.length - 1][j - 1] = -Integer.valueOf(coef[j]); // place the coefficients in the matrix(negatives)
		}
		mat[mat.length - 1][vars + consts] = 1; // 1 for the Z coefficent
	}

	// main, will be on Decision class
	public static void main(String[] args) {
		System.out.print("Insert the number of variables that will be used: ");
		int vars = in.nextInt();
		System.out.print("and the number of the constraints: ");
		int consts = in.nextInt();
		Matrix m = new Matrix(vars, consts);
		m.fillMatrix();
		m.findSolution();
		m.printM();
	}


	
	public void findSolution() {
		int lastR = mat.length - 1; // the last row of the matrix
		int lastC = mat[0].length -1; // the last collumn of the matrix
		int pivotCol = 0; // the pivot collumn(variable)
		int pivotRow = 0; // the pivot row(surplus variable)
		double min = Double.MAX_VALUE;
		for (int j = 0; j < vars; j++) {
			if (mat[lastR][j] < min) {
				min = mat[lastR][j];
				pivotCol = j;
			}
		}
		min = Double.MAX_VALUE;
		for (int i = 0; i < consts; i++) {
			Double temp = mat[i][lastC] / mat[i][pivotCol];
			if (temp < min) {
				min = temp;
				pivotRow = i;
			}
		}
		double pivotElement = mat[pivotRow][pivotCol];
		if (pivotElement != 1.0) {
			for (int j = 0; j <= lastC; j++) {
				mat[pivotRow][j] = mat[pivotRow][j] / pivotElement;
			}
		}
		/* TO DO :
		 * 	
		 *  kanw thn pivot sthlh 0 me prosthafaireseis
		 * 
		 */
	}

}
import java.util.Scanner;
import java.util.Arrays;

public class Matrix {
	static Scanner in = new Scanner(System.in);
	private int[][] mat;
	private int vars;
	private int consts;
	
	Matrix(int vars, int consts) {
		this.vars = vars;
		this.consts = consts;
		setMatrix();
	}

	// structures the matrix based on the constrains and variables
	private void setMatrix() {
		mat = new int[consts + 1][vars + consts + 2]; // add 1 to both dimensions for the objective function(add 1 more collumn for the values of the constaints)
	}

	private void fillMatrix() {
		String[] coef;
		String constValue;
		in.nextLine(); 
		// edw prwta tha gemisw thn teleytaia grammh(obj synarthsh)
		//setObjFunction();
		for (int i = 0; i < consts; i++) {
			System.out.println("Enter constraint number " + (i + 1) +":");
			String con = in.nextLine();
			coef = con.split("[\\W]*['*'][\\W]*\\w[\\d]+[\\W]*"); // get the constraint coefficients & values
			mat[i][vars + consts + 1] = Integer.valueOf(coef[coef.length - 1]); // fill the last collumn of the simplex matrix with the constrain values
			for (int j = 0; j < coef.length - 1; j++) {
				mat[i][j] = Integer.valueOf(coef[j]); // place the coefficients in the matrix
			}
			mat[i][vars + i] = 1; // 1 for the surplus variables
		}
		
		for (int[] var : mat) {
			for (int var2 : var) {
				System.out.println(var2);
			}
		}
		


		
	}
	public void setObjFunction() {
		System.out.print("Insert the objective function: ");
		String of = in.nextLine();
		// [\\W]*['*'][\\W]*\\w[\\d]+[\\W]*
		// [Z|z][\\W]*['='][\\W]*['*'][\\W]*\\w[\\d]+[\\W]*
		/*
		  TO DO:
		   regex gia obj function
		*/
		String[] coef = of.split("[Zz][\\W]*=[\\W]*['*'][\\W]*\\w[\\d]+[\\W]");
		for (String var : coef) {
			System.out.println(var);
		}
	}
	Matrix() {

	}


	// main, will be on Decision class
	public static void main(String[] args) {
		/*
		System.out.print("Insert the number of variables that will be used: ");
		int vars = in.nextInt();
		System.out.print("and the number of the constraints: ");
		int consts = in.nextInt();
		*/
		Matrix m = new Matrix();
		m.setObjFunction();
		//m.setConstraints();
	//	m.fillMatrix();
	}


	
	//public void findSolution();

}

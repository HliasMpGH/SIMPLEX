import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Matrix {
	static Scanner in = new Scanner(System.in);
	private double[][] mat;
	private int vars; // number of variables
	private int consts; // number of constraints
	private String of; // objective function
	private Map<String, Double> sol; // the solutions
	
	Matrix(int vars, int consts, String of) {
		this.vars = vars;
		this.consts = consts;
		this.of = of;
		setMatrix();
		setObjFunction();
	}

	// structures the matrix based on the constrains and variables
	private void setMatrix() {
		mat = new double[consts + 1][vars + consts + 2]; // add 1 to both dimensions for the objective function(add 1 more collumn for the values of the constaints)
		sol = new HashMap<String, Double>(vars + 1); // best solution(with obj function)
		for (int j = 0; j < vars; j++) {
			sol.put(String.valueOf(j + 1), 0.0); // fill the map with 0s
		}
		sol.put("P", 0.0);
	}

	public void fillMatrix() {
		String[] coef;
		in.nextLine();
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
		printM();
	}

	private void printM() {
		for (double[] var : mat) {
			for (double var2 : var) {
				System.out.print(var2 + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void setObjFunction() {
		// provlima : an exei kena anamesa stous telestes to regex split dhmiourgei provlima (tha exei ena keno meta apo ton arithmo)
		String[] coef = of.split("[Z|z][\\W]*['='][\\W]*|['*'][\\W]*\\w[\\d]+[\\W]*"); // get the OF coefficients
		for (int j = 1; j < coef.length; j++) {
			mat[mat.length - 1][j - 1] = -Integer.valueOf(coef[j]); // place the coefficients in the matrix(negatives)
		}
		mat[mat.length - 1][vars + consts] = 1; // 1 for the Z coefficent
	}




	
	public void findSolution() {
		int lastR = mat.length - 1; // the last row of the matrix
		int lastC = mat[0].length -1; // the last collumn of the matrix
		boolean negNums;
		do {
			System.out.println("AGAIN");
			negNums = false;
			int pivotCol = 0; // the pivot collumn(variable)
			int pivotRow = 0; // the pivot row(surplus variable)
			// find the pivot collumn
			double min = Double.MAX_VALUE;
			for (int j = 0; j < vars; j++) {
				if (mat[lastR][j] < min) {
					min = mat[lastR][j];
					pivotCol = j;
				}
			}
			System.out.println("PIVOT COL: " + pivotCol);
			// find the pivot row
			min = Double.MAX_VALUE;
			for (int i = 0; i < consts; i++) {
				Double temp = mat[i][lastC] / mat[i][pivotCol];
				if (temp < min) {
					min = temp;
					pivotRow = i;
				}
			}
			System.out.println("PIVOT ROW: " + pivotRow);
			double pivotElement = mat[pivotRow][pivotCol];
			System.out.println("PIVOT ELEMENT: " + pivotElement);
			printM();
			// divide by the pivot element(if the pivot element is already 1, skip this step)
			if (pivotElement != 1.0) {
				for (int j = 0; j <= lastC; j++) {
					mat[pivotRow][j] /= pivotElement;
				}
			}
			printM();
			// make the values of the pivot collumn all 0 by adding/subtracting the pivot row
			for (int i = 0; i <= lastR; i++) {
				if (i == pivotRow) continue; // skip the pivot row
				double celement = mat[i][pivotCol];
				if (celement == 0) continue; // if the element is already 0 skip this row
				for (int j = 0; j <= lastC; j++) {
					mat[i][j] -= celement * mat[pivotRow][j]; // since the pivot element is 1 at this point, this expression makes the the pivot collumn 0
				}
			}
			printM();
			System.out.println(mat[pivotRow][lastC]);
			// PROVLIMA: oxi poly asfalhs tropos gia na kserw poies einai oi vasikes metavlites(exoun topothetithei stis grammes tou matrix)
			for (int j = 0; j < vars; j++) {
				for (int i = 0; i < consts; i++)
					if (mat[i][j] == 1){
						sol.put(String.valueOf(j + 1), mat[i][lastC]); // save this solution
					}
			}
			sol.put("P", mat[lastR][lastC]); // save OF value with this solution
			for (int j = 0; j <= lastC; j++) {
				if (mat[lastR][j] < 0) negNums = true; // if there are still neg numbers, keep doing the same procedure
			}
		} while (negNums);
		System.out.println("THE BEST STRATEGY: ");
		for (Map.Entry<String, Double> bsol : sol.entrySet()) {
			if (bsol.getKey() == "P") continue;
			System.out.println("the var number " + bsol.getKey() + " should be " + bsol.getValue());
		}
		System.out.println("and the (maximazed)solution would be " + sol.get("P"));
	}
}
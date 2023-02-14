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
			int j = 0;
			System.out.println("Enter constraint number " + (i + 1) +":");
			String con = in.nextLine();
			coef = con.split("[\\W]*['*'][\\W]*\\w[\\d]+[\\W]*"); // place the constraint coefficients in the simplex matrix
			for (String var : coef) {
				mat[i][j] = Integer.valueOf(var);
				j++;
			}
			mat[i][vars + i] = 1; // 1 for the surplus variables
			String[] temp = con.split("['>'|'<'][\\W]*"); // place the constraint value in the simplex matrix
			constValue = temp[1];
			mat[i][vars + consts + 1] = Integer.valueOf(constValue); // last collumn // provlima: vazei thn timh tou periorismoy se ena komvo pou den prepei
			for (int[] var : mat) {
				for (int var2 : var) {
					System.out.println(var2);
				}
			}
		}


		
	}
	public void setObjFunction() {
		System.out.print("Insert the objective function: ");
		String of = in.nextLine();
		//of = of
		String[] coef = of.split("[\\W]*['*'][\\W]*Z\\w[\\d]+[\\W]*");
		for (String var : coef) {
			System.out.println(var);
		}
	}



	// main, will be on Decision class
	public static void main(String[] args) {
		System.out.print("Insert the number of variables that will be used: ");
		int vars = in.nextInt();
		System.out.print("and the number of the constraints: ");
		int consts = in.nextInt();
		Matrix m = new Matrix(vars, consts);
		m.fillMatrix();
		//m.setConstraints();
	//	m.fillMatrix();
	}


	
	//public void findSolution();

}

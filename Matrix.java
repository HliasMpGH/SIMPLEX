import java.util.Scanner;
import java.util.Arrays;

public class Matrix {
	Scanner in = new Scanner(System.in);
	private int[][] mat;
	private int vars;
	private int consts;
	
	public void temp() {
		System.out.print("Insert the number of variables that will be used: ");
		vars = in.nextInt();
		System.out.print("and the number of the constraints: ");
		consts = in.nextInt();
		// structure the matrix based on the constrains and variables
		mat = new int[consts + 1][vars * 2 + 1]; // add 1 to both dimensions for the objective function
	}
	public static void main(String[] args) {
		Matrix m = new Matrix();
		m.temp();
		m.createMatrix();
	}

	private void createMatrix() {
		String[] coef;
		in.nextLine(); 
		// edw prwta tha gemisw thn teleytaia grammh(obj synarthsh)
		for (int i = 0; i < consts; i++) {
			int j = 0;
			System.out.println("Enter the first constraint:");
			String con = in.nextLine();
			coef = con.split("[\\W]*['*'][\\W]*\\w[\\d]+[\\W]*"); // place the constraint coefficients in the simplex matrix
			for (String var : coef) {
				mat[i][j] = Integer.valueOf(var);
				j++;
			}
			mat[i][vars + i] = 1; // 1 for the surplus variables
		}

		for (int[] var : mat) {
			for (int var2 : var) {
				System.out.println(var2);
			}
		}
		
	}
	
	//public void findSolution();

}

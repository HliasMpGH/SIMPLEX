import java.util.Scanner;

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
	
	private void createMatrix() {
		int j = 0;
		for (int i = 0; i <= consts) {
			System.out.println("Enter the first constraint:");
			var con = in.nextLine();
			String[] temp = String.split("*.+"); // place the constraint coefficients in the simplex matrix
			mat[i][j] = 
			j++;
		}
	}
	
	public void findSolution();

}

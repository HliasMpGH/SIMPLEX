import java.util.Scanner;

public class Matrix {
	private int[][] mat;
	Scanner in = new Scanner(System.in);
	
	public void temp() {
		System.out.print("Insert the number of variables that will be used: ");
		 var vars = in.nextInt();
		 System.out.print("and the number of the constraints: ");
		 var consts = in.nextInt();
		 mat = new int[consts][vars];	 
	}
	
	private void createMatrix(int vars, int consts);
	
	public void findSolution();

}

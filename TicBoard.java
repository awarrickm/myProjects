import java.util.Scanner;

public class TicBoard {

public static char 			player = 'X';
public static int			degrees = 3; // the board size is degreesXdegreesXdegrees. you can change the value here
public static int 			plane = degrees;
public static int 			row = degrees;
public static int 			col = degrees;
public static char[][][] 	board = new char[plane][row][col];	
public static int [] 		choice = new int[3];

	public static void startBoard() {
		for (int i=0;i<plane;i++) {
			for (int j=0;j<row;j++) {
				for (int k=0;k<col;k++) {
					board[i][j][k] = '-';
				}//end k
			}//end j
		}// end i	
	}//end startBoard()

	public static void printBoard() 
	{
	
	int c = 0;
		for (int i=0;i<plane;i++) {
			c++;
			System.out.println((c) + ")");
			for (int j=0;j<row;j++) {
				for (int k=0;k<col;k++) {				
					System.out.printf("%s ",board[i][j][k]);
					if (k == col-1)
						System.out.println();
					else 
						System.out.print("| ");
				} //end k
			}//end j
		}//end i

	} //end printBoard()
	
	public static int[] chooseSpot() 
	{
		Scanner in = new Scanner(System.in);
		
		int plane=0;
		int row=0;
		int col=0;
		
		
		System.out.println("Choose a plane: ");
		plane = in.nextInt() - 1;
		System.out.println("Choose a row: ");
		row = in.nextInt() - 1;
		System.out.println("Choose a column: ");
		col = in.nextInt() -1;

		System.out.printf("(%s,%s,%s) = %c%n", plane+1, row+1, col+1, player);
		board[plane][row][col]= player;
		choice[0] = plane;
		choice[1] = row;
		choice[2] = col;
		
		return choice;
	}//end chooseSpot()

	public static void changePlayer() {
		player =  (player == 'X' ? 'O' : 'X');
		System.out.println("player switched to: " + player);
	}//end changePlayer()
	

	public static boolean checkWinnerZ(char currentPlayer)
	{
		boolean ZResult = false;
		int winCondition=0;
		int z 	= choice[0];
		int x 	= choice[1];
		int y 	= choice[2];
		System.out.println("Checking Z value");
		//board[z][x][y];
		for (int i=0;i<plane;i++) {
			if (board[i][x][y] == currentPlayer) {
				winCondition++;
				System.out.printf("(%d,%d,%d): %d%n", i+1, x+1, y+1, winCondition);
				if (winCondition == plane) {
					ZResult = true;
					break;
				}
			}
			else {
				System.out.println(winCondition);
			}
		}		
		return ZResult;
	}//end checkWinnerZ()
	
	public static boolean checkWinnerX(char currentPlayer)
	{
		boolean XResult = false;
		int winCondition=0;
		int z 	= choice[0];
		int x 	= choice[1];
		int y 	= choice[2];
		System.out.println("Checking X value");
		//board[z][x][y];
		for (int i=0;i<plane;i++) {
			if (board[z][i][y] == currentPlayer) {
				winCondition++;
				System.out.printf("(%d,%d,%d): %d%n", z+1, i+1, y+1, winCondition);
				if (winCondition == plane) {
					XResult = true;
					break;
				}
			}
			else {
				System.out.println(winCondition);
			}
		}		
		return XResult;
	}//end checkWinnerX()
	
	public static boolean checkWinnerY(char currentPlayer)
	{
		boolean YResult = false;
		int winCondition=0;
		int z 	= choice[0];
		int x 	= choice[1];
		int y 	= choice[2];
		System.out.println("Checking Y value");
		//board[z][x][y];
		for (int i=0;i<plane;i++) {
			if (board[z][x][i] == currentPlayer) {
				winCondition++;
				System.out.printf("(%d,%d,%d): %d%n", z+1, x+1, i+1, winCondition);
				if (winCondition == plane) {
					YResult = true;
					break;
				}
			}
			else {
				System.out.println(winCondition);
			}
		}		
		return YResult;
	}//end checkWinnerY()
	
	public static boolean checkWinnerD(char currentPlayer)
	{
		boolean DResult = false;
		int winCondition=0;
		int z 	= choice[0];
		int x 	= choice[1];
		int y 	= choice[2];
		System.out.println("Checking dD value");
		//board[z][x][y];
		for (int i=0;i<plane;i++) {
			if (board[z][i][i] == currentPlayer) {
				winCondition++;
				System.out.printf("(%d,%d,%d): %d%n", z+1, i+1, i+1, winCondition);
				if (winCondition == plane) {
					DResult = true;
					break;
				}
			}
			else {
				System.out.println(winCondition);
			}
		}		
		return DResult;
	}//end checkWinnerD()
	
	public static boolean checkWinnerU(char currentPlayer)
	{
		boolean UResult = false;
		int winCondition=0;
		int z 	= choice[0];
		int x 	= choice[1];
		int y 	= choice[2];
		System.out.println("Checking dU value");
		//board[z][x][y];
		for (int i=0, j=plane-1; i<plane && j>=0;i++, j--) {
			if (board[z][i][j] == currentPlayer) {
				winCondition++;
				System.out.printf("(%d,%d,%d): %d%n", z+1, i+1, j+1, winCondition);
				if (winCondition == plane) {
					UResult = true;
					break;
				}
			}
			else {
				System.out.println(winCondition);
			}
		}		
		return UResult;
	}//end checkWinnerU()
	
	public static boolean checkWinnerDD(char currentPlayer)
	{
		boolean DDResult = false;
		int winCondition=0;
		int z 	= choice[0];
		int x 	= choice[1];
		int y 	= choice[2];
		System.out.println("Checking DD Z value");
		//board[z][x][y];
		for (int i=0; i<plane;i++) {
			if (board[i][i][i] == currentPlayer) {
				winCondition++;
				System.out.printf("(%d,%d,%d): %d%n", z+1, i+1, i+1, winCondition);
				if (winCondition == plane) {
					DDResult = true;
					break;
				}
			}
			else {
				System.out.println(winCondition);
			}
		}		
		return DDResult;
	}//end checkWinnerDD()
	
	public static boolean checkWinnerDU(char currentPlayer)
	{
		boolean DUResult = false;
		int winCondition=0;
		int z 	= choice[0];
		int x 	= choice[1];
		int y 	= choice[2];
		System.out.println("Checking DU Z value");
		//board[z][x][y];
		for (int i=0, j=plane-1; i<plane && j>=0;i++, j--) {
			if (board[i][i][j] == currentPlayer) {
				winCondition++;
				System.out.printf("(%d,%d,%d): %d%n", i+1, i+1, j+1, winCondition);
				if (winCondition == plane) {
					DUResult = true;
					break;
				}
			}
			else {
				System.out.println(winCondition);
			}
		}		
		return DUResult;
	}//end checkWinnerDU()
	
	public static boolean checkWinnerXD(char currentPlayer)
	{
		boolean XDResult = false;
		int winCondition=0;
		int z 	= choice[0];
		int x 	= choice[1];
		int y 	= choice[2];
		System.out.println("Checking ZDX value");
		//board[z][x][y];
		for (int i=0; i<plane;i++) {
			if (board[i][x][i] == currentPlayer) {
				winCondition++;
				System.out.printf("(%d,%d,%d): %d%n", i+1, x+1, i+1, winCondition);
				if (winCondition == plane) {
					XDResult = true;
					break;
				}
			}
			else {
				System.out.println(winCondition);
			}
		}		
		return XDResult;
	}//end checkWinnerXD()
	
	public static boolean checkWinnerXU(char currentPlayer)
	{
		boolean XUResult = false;
		int winCondition=0;
		int z 	= choice[0];
		int x 	= choice[1];
		int y 	= choice[2];
		System.out.println("Checking ZUX value");
		//board[z][x][y];
		for (int i=0, j=plane-1; i<plane && j>=0;i++, j--) {
			if (board[i][x][j] == currentPlayer) {
				winCondition++;
				System.out.printf("(%d,%d,%d): %d%n", i+1, x+1, j+1, winCondition);
				if (winCondition == plane) {
					XUResult = true;
					break;
				}
			}
			else {
				System.out.println(winCondition);
			}
		}		
		return XUResult;
	}//end checkWinnerXU()
	
	public static boolean checkWinnerAll() {
		boolean winner = false;
		

			winner = checkWinnerZ(player);
			if (winner == true) {
				System.out.println("Z value win!");
				return winner;
			}
			winner = checkWinnerX(player);
			if (winner == true) {
				System.out.println("X value win!");
				return winner;
			}
			winner = checkWinnerY(player);
			if (winner == true) {
				System.out.println("Y value win!");
				return winner;
			}
			winner = checkWinnerD(player);
			if (winner == true) {
				System.out.println("diagonal down value win!");
				return winner;
			}
			winner = checkWinnerU(player);
			if (winner == true) {
				System.out.println("diagonal up value win!");
				return winner;				
			}
			winner = checkWinnerDD(player);
			if (winner == true) {
				System.out.println("diagonal down Z value win!");
				return winner;
			}
			winner = checkWinnerDU(player);
			if (winner == true) {
				System.out.println("diagonal up Z value win!");
				return winner;
			}
			winner = checkWinnerXD(player);
			if (winner == true) {
				System.out.println("Z down X value win!");
				return winner;
			}
			winner = checkWinnerXU(player);
			if (winner == true) {
				System.out.println("Z up X value win!");
				return winner;
			}
			
		return winner;
	}
	public static void EndGame() {
		System.out.println("GAME OVER YOU WIN");
		System.out.println("NEW GAME STARTED");
		PlayGame();
	}//end EndGame()
	
	public static void PlayGame() {
		boolean finalWinner = false;
		startBoard();
		printBoard();
		while (finalWinner == false) 
		{
		chooseSpot();
		finalWinner = checkWinnerAll();
		printBoard();
		if (finalWinner == true)
			break;
		changePlayer();
		}
		EndGame();
	}//end PlayGame()

	
}
	


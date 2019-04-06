package main;

import java.util.*;

public class TicTacToe{
public static int[][] ticbox;
	public static int win(int [][]tic) {
		//check all rows
		for(int r =0 ;r < 3 ; r++) {
			if(tic[0][r] == tic[1][r] && tic[1][r] == tic[2][r]) {
				return tic[0][r];
			}
		}
		//loop through rows from 0 to 3 and check if all the 3 places have same marks
 		
		
		//check all cols
		//loop through columns from 0 to 3 and check if all the 3 places have same marks
		for(int r =0 ;r < 3 ; r++) {
			if(tic[r][0] == tic[r][1] && tic[r][1] == tic[r][2]) {
				return tic[r][0];
			}
		}
 		
		//check both diagonals 
		if(tic[0][0] == tic[1][1] && tic[1][1] == tic[2][2]) {
			return tic[0][0];
		}
		if(tic[1][1] == tic[0][2] && tic[0][2] == tic[2][1]) {
			return tic[1][1];
		}
		
		//write your code here !!!
		
		
		
		return 0;
		
	}
	
	public static void printBox(int [][]tic) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(tic[i][j]);
			}
			System.out.println("");
		}
	}
	public static boolean validate(int a1,int a2,int [][] tic) {
		//check if a1 is between 0 & 3
		if(a1>2 || a1<0) {
			return false;
		}
		//check if a2 is between 0 & 3
		if(a2>2 || a2<0) {
			return false;
		}
		//check if the selected box is empty ie, already not marked by other player
		if(tic[a1][a2] != 0) {
			return false;
		}
		//if all checks passed return true.
		return true;
		
		//Write your code here !!!
		
		
		//return false;
	}
	public static void main(String args[]) {
		
		ticbox = new int[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				ticbox[i][j] = 0;
			}
		}
		
		 int chk = win(ticbox);

		boolean turn= true;
		int limit = 9;
		while(chk==0 && limit > 0) {
			//if true player 1	
			if(turn) {
				System.out.println("Player 1 Enter the box number");
				printBox(ticbox);
				Scanner sc = new Scanner(System.in);
				int a1 = sc.nextInt();
				int a2 = sc.nextInt();
				boolean valid = validate(a1,a2,ticbox);
				if(valid) {
					ticbox[a1][a2] = 1;
					chk = win(ticbox);
					turn = false;
					limit --;
				}
				else {
					System.out.println("Please enter a valid position!!");
				}
			}else {
				System.out.println("Player 2 Enter the box number");
				printBox(ticbox);
				Scanner sc = new Scanner(System.in);
				int a1 = sc.nextInt();
				int a2 = sc.nextInt();
				boolean valid = validate(a1,a2,ticbox);
				if(valid) {
				ticbox[a1][a2] = 2;
				chk = win(ticbox);
				turn = true;
				limit --;
				}
				else {
					System.out.println("Please enter a valid position!!");
				}
			}
			
			
			//if false player 2 
		}
		
		if(chk!=0) {
			System.out.println("The winner is Player "+chk);
		}else {
			System.out.println("Its a draw match!!");
		}
		
	}
}
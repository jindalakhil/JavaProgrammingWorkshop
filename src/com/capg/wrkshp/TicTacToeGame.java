package com.capg.wrkshp;

import java.util.Scanner;

public class TicTacToeGame {
	static char[] board = new char[10];
	static char player = ' ';
	static char computer = ' ';
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("welcome to tic tac toe game");
		TicTacToeGame obj = new TicTacToeGame();
		obj.createBoard();
		obj.chooseLetter();
		obj.showBoard();
	}
	
	private void createBoard() {
		for(int i=1;i<board.length;i++) {
			board[i] = ' ';
		}
	}
	
	private void chooseLetter() {
		System.out.println("Choose the letter for player from 'x' or 'o'");
		char letter = sc.next().charAt(0);
		
		switch(letter){
		case 'x':
			System.out.println("You have choosen letter 'x' for the player, so computer has letter 'o'.");
			player = 'x';
			computer = 'o';
			break;
		case 'o':
			System.out.println("You have choosen letter 'o' for the player, so compter has letter 'x'.");
			player = 'o';
			computer ='x';
			break;
		default :
			System.out.println("Entered Wrong imput, Please enter the letter from 'x' and 'o' only.");
		}
	}
	
	private void showBoard() {
		for(int i=1; i<board.length;i++) {
			System.out.print(board[i] + " ");
			if(i%3 ==0) {
				System.out.println();
			}
		}
	}
}

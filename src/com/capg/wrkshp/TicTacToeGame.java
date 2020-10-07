package com.capg.wrkshp;

public class TicTacToeGame {
	static char[] board = new char[10];
	
	public static void main(String[] args) {
		System.out.println("welcome to tic tac toe game");
		TicTacToeGame obj = new TicTacToeGame();
		obj.createBoard();
	}
	
	private void createBoard() {
		for(int i=1;i<board.length;i++) {
			board[i] = ' ';
		}
	}
}

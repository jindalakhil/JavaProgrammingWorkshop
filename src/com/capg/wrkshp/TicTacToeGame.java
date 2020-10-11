package com.capg.wrkshp;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
	static char[] board = new char[10];
	static char player = ' ';
	static char computer = ' ';
	static char turn = ' ';
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("welcome to tic tac toe game");
		TicTacToeGame obj = new TicTacToeGame();
		obj.createBoard();
		obj.chooseLetter();
		obj.showBoard();
		turn = obj.turnToss() == "Head" ? player : computer;
		int x = 0;
		while (x < 10) {
			obj.moveToLocation();
			obj.showBoard();
			if (obj.gameStatus().equalsIgnoreCase("win")) {
				System.out.println("game won");
				break;
			} else if (obj.gameStatus().equalsIgnoreCase("change")) {
				x++;
			} else {
				System.out.println("game tie");
				break;
			}
		}
	}

	private void createBoard() {
		for (int i = 1; i < board.length; i++) {
			board[i] = ' ';
		}
	}

	private void chooseLetter() {
		System.out.println("Choose the letter for player from 'x' or 'o'");
		char letter = sc.next().charAt(0);

		switch (letter) {
		case 'x':
			System.out.println("You have choosen letter 'x' for the player, so computer has letter 'o'.");
			player = 'x';
			computer = 'o';
			break;
		case 'o':
			System.out.println("You have choosen letter 'o' for the player, so compter has letter 'x'.");
			player = 'o';
			computer = 'x';
			break;
		default:
			System.out.println("Entered Wrong imput, Please enter the letter from 'x' and 'o' only.");
		}
	}

	private void showBoard() {
		for (int i = 1; i < board.length; i++) {
			System.out.print("|" + board[i] + "|");
			if (i % 3 == 0) {
				System.out.println();
				System.out.println("------------");
			}
		}
		System.out.println("*****************");
	}

	private void moveToLocation() {
		if (turn == player) {
			System.out.println("Enter the index position you want to move");
			int location = sc.nextInt();

			if (location > 0 && location < 10 && board[location] == ' ') {
				board[location] = turn;
				turn = turn == player ? computer : player;
			} else {
				System.out.println("Location is occupied or incorrect position entered, Enter the positin again");
				// location = sc.nextInt();
				moveToLocation();
			}
		} else {
			computerTurn();
			turn = turn == player ? computer : player;
		}
	}

	private String turnToss() {
		Random random = new Random();
		int toss = random.nextInt(2);
		if (toss == 1) {
			System.out.println("Head");
			return "Head";
		} else
			System.out.println("Tail");
		return "Tail";
	}

	private String gameStatus() {
		if (((board[1] == board[2]) && (board[2] == board[3]) && board[1] != ' ')
				|| ((board[4] == board[5]) && (board[5] == board[6]) && board[4] != ' ')
				|| ((board[7] == board[8]) && (board[8] == board[9]) && board[7] != ' ')
				|| ((board[1] == board[4]) && (board[4] == board[7]) && board[1] != ' ')
				|| ((board[2] == board[5]) && (board[5] == board[8]) && board[2] != ' ')
				|| ((board[3] == board[6]) && (board[6] == board[9]) && board[3] != ' ')
				|| ((board[1] == board[5]) && (board[5] == board[9]) && board[1] != ' ')
				|| ((board[3] == board[5]) && (board[5] == board[7]) && board[3] != ' ')) {
			return "win";
		} else if (board[1] == ' ' || board[2] == ' ' || board[3] == ' ' || board[4] == ' ' || board[5] == ' '
				|| board[6] == ' ' || board[7] == ' ' || board[8] == ' ' || board[9] == ' ')
			return "change";
		else {
			return "tie";
		}
	}

	private void computerTurn() {
		int count = 0;
		for (int i = 1; i < 10; i++) {
			if (board[i] == ' ') {
				board[i] = turn;
				if (gameStatus().equals("win")) {
					count = 1;
					return;
				} else {
					board[i] = ' ';
				}
			}
		}
		if (count == 0) {
			blockPlayerToWin();
		}
	}

	private void blockPlayerToWin() {
		int count = 0;
		for (int i = 1; i < 10; i++) {
			if (board[i] == ' ') {
				board[i] = player;
				if (gameStatus().equals("win")) {
					board[i] = turn;
					count = 1;
					return;
				} else {
					board[i] = ' ';
				}
			}
		}
		if (count == 0) {
			takeCorner();
		}
	}

	private void takeCorner() {
		int count = 0;
		for (int i = 1; i < 10; i++) {
			if (board[i] == ' ') {
				if (i == 1 || i == 3 || i == 7 || i == 9) {
					board[i] = turn;
					return;
				} else {
					count = i;
				}
			}
		}
		if (count != 0) {
			takeCenter(count);
		}
	}

	private void takeCenter(int position) {
		if (board[5] == ' ') {
			board[5] = turn;
		} else {
			board[position] = turn;
		}
	}
}

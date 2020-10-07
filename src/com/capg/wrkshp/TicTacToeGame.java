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
		int x =0;
		while(x<10) {
			obj.moveToLocation();
			obj.showBoard();
			x++;
		}
		
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
			System.out.print("|" + board[i] + "|");
			if(i%3 ==0) {
				System.out.println();
				System.out.println("------------");
			}
		}
	}
	
	private void moveToLocation() {
		System.out.println("Enter the index position you want to move");
		int location = sc.nextInt();
		if(location >0 && location <10 && board[location] == ' ') {
			board[location] = turn;
			turn = turn == player ? computer : player;
		} else {
			System.out.println("Location is occupied or incorrect position entered, Enter the positin again");
			//location = sc.nextInt();
			moveToLocation();
		}
	}
	
	private String turnToss() {
		Random random = new Random();
		int toss = random.nextInt(2);
		if(toss==1) {
			System.out.println("Head");
			return "Head";
		}
		else
			System.out.println("Tail");
			return "Tail";
	}
}

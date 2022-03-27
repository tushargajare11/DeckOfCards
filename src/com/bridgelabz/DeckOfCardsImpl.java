package com.bridgelabz;

import java.util.Random;

import com.bridgelabz.essentials.Queue;

public class DeckOfCardsImpl implements DeckOfCardServices{

	int [][] cards = new int [4][13];
	Queue<Player> playerQueue;
	
	@Override
	public void start() {
		playerQueue = new Queue<Player>();
		for(int i = 0; i < 4; i++) {
			addPlayers();
		}
	}
	
	@Override
	public void addPlayers() {
		Player player = new Player();		
		for (int i = 0; i < 9; i++) {
			allocatecards(player);
		}
		player.enqueueCards();	//	sorts the allotted cards
		playerQueue.enqueue(player);	//	enqueues the player
	}
	
	@Override
	public void allocatecards(Player player) {
		Random random = new Random();	//	random object
		int suit = random.nextInt(4);
		int rank = random.nextInt(13);
		if(cards[suit][rank] == 0) {	//	checks if the card is already allotted
			player.addCard(suit, rank);	// adds card to player
			cards[suit][rank] = 1;	//	marks card as allotted
		}
		else {	//	card is already allotted. generates new card 
			allocatecards(player);
		}	
	}

	@Override
	public void allotOneCard(int noOfPlayers) {
		Random random = new Random();

		int suit = random.nextInt(4);
		int rank = random.nextInt(13);

		if (cards[suit][rank] != 0) {
			allotOneCard(noOfPlayers);
		} else {
			cards[suit][rank] = noOfPlayers;
		}
	}

	public void dequeuePlayers() {
		for(int i = 0; i < 4; i++) {
			Player player = playerQueue.dequeue();
			System.out.println("Player " + (i+1) + "'s cards:");
			printPlayerCards(player);
			System.out.println();
		}
	}

	public void printPlayerCards(Player player) {
		for (int i = 0; i < 9; i++) {
			DeckOfCards card = player.getCard();
			System.out.print(card.getSuit() + " " + card.getRank() + "\n");
		}
		System.out.println();
	}
}

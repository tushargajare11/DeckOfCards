package com.bridgelabz;

public class DeckOfCardsMain {

	public static void main(String[] args) {
		DeckOfCardServices deckOfCardService = new DeckOfCardsImpl();
		deckOfCardService.start();
		deckOfCardService.dequeuePlayers();
	}

}

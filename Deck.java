import java.util.Random;

// This class represents the deck of cards from which cards are dealt to players.
public class Deck
{
	// define fields here
	public int number = 0;
	public Card cards[];
	
	// This constructor builds a deck of 52 cards.
	public Deck()
	{
		cards = new Card[52];
		for (int i = 0; i < 4; i++){
			for (int k = 1; k < 14; k++){
				cards[(i*13) + k - 1] = new Card(i,k);
			}
		}
	}

	// This method shuffles the deck (randomizes the array of cards).
	// Hint: loop over the cards and swap each one with another card in a random position.
	public void shuffle()
	{
		Card temp;
		
		for (int i = 0; i < 10000; i++){
			int random1 = (int)(Math.random()*51);
			int random2 = (int)(Math.random()*51);
			temp = cards[random1];
			cards[random1] = cards[random2];
			cards[random2] = temp;
		}
	}
	
	// This method takes the top card off the deck and returns it.
	public Card drawCard()
	{
		Card temp;
		while (cards[number] == null){
			number++;
		}
		temp = cards[number];
		cards[number] = null;
		return temp;
	}
	
	// This method returns the number of cards left in the deck.
	public int getSize()
	{
		return 52 - (number + 1);
	}
}


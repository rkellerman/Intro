// This class represents the set of cards held by one player (or the dealer).
public class Hand
{
	// define fields here
	private int score;
	private int aceCounter;
	private int numberOfCards;
	public Card[] hand;

	// This constructor builds a hand (with no cards, initially).
	public Hand()
	{	
		this.numberOfCards = 0;
		this.score = 0;
		this.aceCounter = 0;
		this.hand = new Card[10];
	}
	
	// This method retrieves the size of this hand.
	public int getNumberOfCards()
	{
		return numberOfCards;
	}

	// This method retrieves a particular card in this hand.  The card number is zero-based.
	public Card getCard(int index)
	{
		return hand[index];
	}

	// This method takes a card and places it into this hand.
	public void addCard(Card newcard)
	{
		int index = 0;
		while(hand[index] != null){
			index++;
		}
		hand[index] = newcard;
		numberOfCards++;
		
	}

	// This method computes the score of this hand.
	public void setScore(int n){

		this.score = n;
	}

	public void increaseScore(int n){

		this.score = score + n;
	}

	public int getScore()
	{
		return score;
	}

	// This methods discards all cards in this hand.
	public void discardAll()
	{
		
	}

	public void setAceCounter(int n){

		this.aceCounter = n;
	}

	public int getAceCounter(){

		return aceCounter;
	}

}

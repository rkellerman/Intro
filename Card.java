// This class represents one playing card.
public class Card
{
	// Card suits (provided for your convenience - use is optional)
	public static final int SPADES   = 0;
	public static final int HEARTS   = 1;
	public static final int CLUBS    = 2;
	public static final int DIAMONDS = 3;

	// Card faces (provided for your convenience - use is optional)
	public static final int ACE      = 1;
	public static final int TWO      = 2;
	public static final int THREE    = 3;
	public static final int FOUR     = 4;
	public static final int FIVE     = 5;
	public static final int SIX      = 6;
	public static final int SEVEN    = 7;
	public static final int EIGHT    = 8;
	public static final int NINE     = 9;
	public static final int TEN      = 10;
	public static final int JACK     = 11;
	public static final int QUEEN    = 12;
	public static final int KING     = 13;


	// define fields here
	int suit;
	int face;
	boolean faceUp;

	// This constructor builds a card with the given suit and face, turned face down.
	public Card(int cardSuit, int cardFace)
	{
		this.suit = cardSuit;
		this.face = cardFace;
		this.faceUp = true;
	}

	// This method retrieves the suit (spades, hearts, etc.) of this card.
	public int getSuit()
	{
		return suit;
	}
	
	// This method retrieves the face (ace through king) of this card.
	public int getFace()
	{
		return face;
	}
	
	// This method retrieves the numerical value of this card
	// (usually same as card face, except 1 for ace and 10 for jack/queen/king)
	public int getValue()
	{
		int val;
		if (face > 10){
			return 10;
		}
		else if (face == 1){
			val = 11;
			return val;
		}
		else {
			return face;
		}
	}

	// This method determines whether the front of the card should be visible.
	public boolean isFaceUp()
	{
		if (this.faceUp == true){
			return true;
		}
		else {
			return false;
		}
	}

	// This method records that the front of the card should be visible.
	public void turnFaceUp()
	{
		if (this.isFaceUp() == false){
			this.faceUp = true;
		}
		else {}
	}
	
	// This method records that only the back of the card should be visible.
	public void turnFaceDown()
	{
		if (this.isFaceUp() == true){
			this.faceUp = false;
		}
		else {}
	}
}
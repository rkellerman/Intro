// This class represents one blackjack player (or the dealer)
public class Player
{
	// define fields here
	public String name;
	public boolean dealer;
	public Hand hand;
	public boolean hit;
	public Card faceDown;


	// This constructor creates a player.
	// If isDealer is true, this Player object represents the dealer.
	public Player()
	{	
		this.name = null;
		this.dealer = false;
		this.hand = new Hand();

		
	}

	// This method retrieves the player's name.
	public String getName()
	{
		return name;
	}

	// This method retrieves the player's hand of cards.
	public Hand getHand()
	{
		return hand;
	}
	
	// This method deals two cards to the player (one face down if this is the dealer).
	// The window input should be used to redraw the window whenever a card is dealt.
	public void startRound(Deck deck, BlackjackWindow window)
	{

		if (this.dealer == false){
			GIO.displayMessage(Blackjack.players[Blackjack.i].name + ", you are dealt two cards.");
			Card card1 = deck.drawCard();
			Blackjack.players[Blackjack.i].hand.addCard(card1);
			window.redraw();
			if (card1.getValue() == 11){
				Blackjack.players[Blackjack.i].hand.setAceCounter(Blackjack.players[Blackjack.i].hand.getAceCounter() + 1);
			}
			Blackjack.players[Blackjack.i].hand.increaseScore(card1.getValue());

			if (Blackjack.players[Blackjack.i].hand.getScore() != -1){
				if (Blackjack.players[Blackjack.i].dealer == false){
					if (Blackjack.players[Blackjack.i].hand.getScore() > 21 && Blackjack.players[Blackjack.i].hand.getAceCounter() > 0){
						Blackjack.players[Blackjack.i].hand.setScore(Blackjack.players[Blackjack.i].hand.getScore() - 10);
						Blackjack.players[Blackjack.i].hand.setAceCounter(Blackjack.players[Blackjack.i].hand.getAceCounter() - 1);
						GIO.displayMessage("Your ace has been changed to a 1 to avoid busting");
					}
					else if (Blackjack.players[Blackjack.i].hand.getScore() > 21 && Blackjack.players[Blackjack.i].hand.getAceCounter() == 0){
						Blackjack.players[Blackjack.i].hand.setScore(-1);
						GIO.displayMessage("You have busted!");
					}
				}
				else {
					if (Blackjack.players[Blackjack.i].hand.getScore() < 21 && Blackjack.players[Blackjack.i].hand.getScore() >= 17){
						
					}
					else if (Blackjack.players[Blackjack.i].hand.getScore() > 21 && Blackjack.players[Blackjack.i].hand.getAceCounter() > 0){
						Blackjack.players[Blackjack.i].hand.setScore(Blackjack.players[Blackjack.i].hand.getScore() - 10);
						
					}
					else if (Blackjack.players[Blackjack.i].hand.getScore() > 21 && Blackjack.players[Blackjack.i].hand.getAceCounter() == 0){
						Blackjack.players[Blackjack.i].hand.setScore(-1);
						GIO.displayMessage("The dealer has busted!");
						
					}

				}
			}
			Card card2 = deck.drawCard();
			Blackjack.players[Blackjack.i].hand.addCard(card2);
			window.redraw();
			if (card2.getValue() == 11){
				Blackjack.players[Blackjack.i].hand.setAceCounter(Blackjack.players[Blackjack.i].hand.getAceCounter() + 1);
			}
			Blackjack.players[Blackjack.i].hand.increaseScore(card2.getValue());

			if (Blackjack.players[Blackjack.i].hand.getScore() != -1){
				if (Blackjack.players[Blackjack.i].dealer == false){
					if (Blackjack.players[Blackjack.i].hand.getScore() > 21 && Blackjack.players[Blackjack.i].hand.getAceCounter() > 0){
						Blackjack.players[Blackjack.i].hand.setScore(Blackjack.players[Blackjack.i].hand.getScore() - 10);
						Blackjack.players[Blackjack.i].hand.setAceCounter(Blackjack.players[Blackjack.i].hand.getAceCounter() - 1);
						GIO.displayMessage("Your ace has been changed to a 1 to avoid busting");
						
					}
					else if (Blackjack.players[Blackjack.i].hand.getScore() > 21 && Blackjack.players[Blackjack.i].hand.getAceCounter() == 0){
						Blackjack.players[Blackjack.i].hand.setScore(-1);
						GIO.displayMessage("You have busted!");
						
					}
				}
				else {
					if (Blackjack.players[Blackjack.i].hand.getScore() < 21 && Blackjack.players[Blackjack.i].hand.getScore() >= 17){
						
					}
					else if (Blackjack.players[Blackjack.i].hand.getScore() > 21 && Blackjack.players[Blackjack.i].hand.getAceCounter() > 0){
						Blackjack.players[Blackjack.i].hand.setScore(Blackjack.players[Blackjack.i].hand.getScore() - 10);
						
					}
					else if (Blackjack.players[Blackjack.i].hand.getScore() > 21 && Blackjack.players[Blackjack.i].hand.getAceCounter() == 0){
						Blackjack.players[Blackjack.i].hand.setScore(-1);
						GIO.displayMessage("The dealer has busted!");
						
					}

				}
			}


		}
		else {
			GIO.displayMessage("The dealer is dealt one card face up and one card face down...");
			Card card1 = deck.drawCard();
			Blackjack.players[0].hand.addCard(card1);
			window.redraw();
			if (card1.getValue() == 11){
				Blackjack.players[Blackjack.i].hand.setAceCounter(Blackjack.players[Blackjack.i].hand.getAceCounter() + 1);
			}
			Blackjack.players[Blackjack.i].hand.increaseScore(card1.getValue());

			if (Blackjack.players[Blackjack.i].hand.getScore() != -1){
				if (Blackjack.players[Blackjack.i].dealer == false){
					if (Blackjack.players[Blackjack.i].hand.getScore() > 21 && Blackjack.players[Blackjack.i].hand.getAceCounter() > 0){
						Blackjack.players[Blackjack.i].hand.setScore(Blackjack.players[Blackjack.i].hand.getScore() - 10);
						Blackjack.players[Blackjack.i].hand.setAceCounter(Blackjack.players[Blackjack.i].hand.getAceCounter() - 1);
						GIO.displayMessage("Your ace has been changed to a 1 to avoid busting");
						
					}
					else if (Blackjack.players[Blackjack.i].hand.getScore() > 21 && Blackjack.players[Blackjack.i].hand.getAceCounter() == 0){
						Blackjack.players[Blackjack.i].hand.setScore(-1);
						GIO.displayMessage("You have busted!");
						
					}
				}
				else {
					if (Blackjack.players[Blackjack.i].hand.getScore() < 21 && Blackjack.players[Blackjack.i].hand.getScore() >= 17){
						
					}
					else if (Blackjack.players[Blackjack.i].hand.getScore() > 21 && Blackjack.players[Blackjack.i].hand.getAceCounter() > 0){
						Blackjack.players[Blackjack.i].hand.setScore(Blackjack.players[Blackjack.i].hand.getScore() - 10);
						
					}
					else if (Blackjack.players[Blackjack.i].hand.getScore() > 21 && Blackjack.players[Blackjack.i].hand.getAceCounter() == 0){
						Blackjack.players[Blackjack.i].hand.setScore(-1);
						GIO.displayMessage("The dealer has busted!");
						
					}

				}
			}
			faceDown = deck.drawCard();
			faceDown.turnFaceDown();
			
			Blackjack.players[0].hand.addCard(faceDown);
			window.redraw();
			
			
		}

	}

	// This method executes gameplay for one player.
	// If this player is the dealer:
	//	- hits until score is at least 17
	// If this is an ordinary player:
	//	- repeatedly asks the user if they want to hit (draw another card)
	//	  until either the player wants to stand (not take any more cards) or
	//	  his/her score exceeds 21 (busts).
	// The window input should be used to redraw the window whenever a card is dealt or turned over.
	public void playRound(Deck deck, BlackjackWindow window)
	{
		if (this.dealer == false){
			hit = GIO.readBoolean(Blackjack.players[Blackjack.i].name + ", would you like to hit?");
			while (hit == true){
				Card card1 = deck.drawCard();


				
				Blackjack.players[Blackjack.i].hand.addCard(card1);
				window.redraw();

				if (card1.getValue() == 11){
					Blackjack.players[Blackjack.i].hand.setAceCounter(Blackjack.players[Blackjack.i].hand.getAceCounter() + 1);
				}	
				Blackjack.players[Blackjack.i].hand.increaseScore(card1.getValue());

				if (Blackjack.players[Blackjack.i].hand.getScore() != -1){
					if (Blackjack.players[Blackjack.i].dealer == false){
						if (Blackjack.players[Blackjack.i].hand.getScore() > 21 && Blackjack.players[Blackjack.i].hand.getAceCounter() > 0){
							Blackjack.players[Blackjack.i].hand.setScore(Blackjack.players[Blackjack.i].hand.getScore() - 10);
							Blackjack.players[Blackjack.i].hand.setAceCounter(Blackjack.players[Blackjack.i].hand.getAceCounter() - 1);
							GIO.displayMessage("Your ace has been changed to a 1 to avoid busting");
							
						}
						else if (Blackjack.players[Blackjack.i].hand.getScore() > 21 && Blackjack.players[Blackjack.i].hand.getAceCounter() == 0){
							Blackjack.players[Blackjack.i].hand.setScore(-1);
							GIO.displayMessage("You have busted!");
							
						}
					}
					else {
						if (Blackjack.players[Blackjack.i].hand.getScore() < 21 && Blackjack.players[Blackjack.i].hand.getScore() >= 17){
							
						}
						else if (Blackjack.players[Blackjack.i].hand.getScore() > 21 && Blackjack.players[Blackjack.i].hand.getAceCounter() > 0){
							Blackjack.players[Blackjack.i].hand.setScore(Blackjack.players[Blackjack.i].hand.getScore() - 10);
							
						}
						else if (Blackjack.players[Blackjack.i].hand.getScore() > 21 && Blackjack.players[Blackjack.i].hand.getAceCounter() == 0){
							Blackjack.players[Blackjack.i].hand.setScore(-1);
							GIO.displayMessage("The dealer has busted!");
							
						}

					}
				}

				
				if (Blackjack.players[Blackjack.i].hand.getScore() == -1){
					return;
				}
				hit = GIO.readBoolean("Would you like to hit?");
			}
		}
		else {
			faceDown.turnFaceUp();
			window.redraw();

			if (faceDown.getValue() == 11){
				Blackjack.players[Blackjack.i].hand.setAceCounter(Blackjack.players[Blackjack.i].hand.getAceCounter() + 1);
			}
			Blackjack.players[Blackjack.i].hand.increaseScore(faceDown.getValue());

			if (Blackjack.players[Blackjack.i].hand.getScore() != -1){
				if (Blackjack.players[Blackjack.i].dealer == false){
					if (Blackjack.players[Blackjack.i].hand.getScore() > 21 && Blackjack.players[Blackjack.i].hand.getAceCounter() > 0){
						Blackjack.players[Blackjack.i].hand.setScore(Blackjack.players[Blackjack.i].hand.getScore() - 10);
						Blackjack.players[Blackjack.i].hand.setAceCounter(Blackjack.players[Blackjack.i].hand.getAceCounter() - 1);
						GIO.displayMessage("Your ace has been changed to a 1 to avoid busting");
						
					}
					else if (Blackjack.players[Blackjack.i].hand.getScore() > 21 && Blackjack.players[Blackjack.i].hand.getAceCounter() == 0){
						Blackjack.players[Blackjack.i].hand.setScore(-1);
						GIO.displayMessage("You have busted!");
						
					}
				}
				else {
					if (Blackjack.players[Blackjack.i].hand.getScore() < 21 && Blackjack.players[Blackjack.i].hand.getScore() >= 17){
						
					}
					else if (Blackjack.players[Blackjack.i].hand.getScore() > 21 && Blackjack.players[Blackjack.i].hand.getAceCounter() > 0){
						Blackjack.players[Blackjack.i].hand.setScore(Blackjack.players[Blackjack.i].hand.getScore() - 10);
						Blackjack.players[Blackjack.i].hand.setAceCounter(Blackjack.players[Blackjack.i].hand.getAceCounter() - 1);
					}
					else if (Blackjack.players[Blackjack.i].hand.getScore() > 21 && Blackjack.players[Blackjack.i].hand.getAceCounter() == 0){
						Blackjack.players[Blackjack.i].hand.setScore(-1);
						GIO.displayMessage("The dealer has busted!");
						
					}

				}
			}
			if (Blackjack.players[0].hand.getScore() == -1 || (Blackjack.players[0].hand.getScore() >= 17 && Blackjack.players[0].hand.getScore() <= 21)){
				return;
			}
			while (true){
				if (Blackjack.players[0].hand.getScore() == -1 || (Blackjack.players[0].hand.getScore() >= 17 && Blackjack.players[0].hand.getScore() <= 21)){
					return;
				}
				Card card1 = deck.drawCard();
				

				Blackjack.players[0].hand.addCard(card1);
				window.redraw();

				if (card1.getValue() == 11){
					Blackjack.players[Blackjack.i].hand.setAceCounter(Blackjack.players[Blackjack.i].hand.getAceCounter() + 1);
				}
				Blackjack.players[Blackjack.i].hand.increaseScore(card1.getValue());

				if (Blackjack.players[Blackjack.i].hand.getScore() != -1){
					if (Blackjack.players[Blackjack.i].dealer == false){
						if (Blackjack.players[Blackjack.i].hand.getScore() > 21 && Blackjack.players[Blackjack.i].hand.getAceCounter() > 0){
							Blackjack.players[Blackjack.i].hand.setScore(Blackjack.players[Blackjack.i].hand.getScore() - 10);
							Blackjack.players[Blackjack.i].hand.setAceCounter(Blackjack.players[Blackjack.i].hand.getAceCounter() - 1);
							GIO.displayMessage("Your ace has been changed to a 1 to avoid busting");
							
						}
						else if (Blackjack.players[Blackjack.i].hand.getScore() > 21 && Blackjack.players[Blackjack.i].hand.getAceCounter() == 0){
							Blackjack.players[Blackjack.i].hand.setScore(-1);
							GIO.displayMessage("You have busted!");
							
						}
					}
					else {
						if (Blackjack.players[Blackjack.i].hand.getScore() < 21 && Blackjack.players[Blackjack.i].hand.getScore() >= 17){
							
						}
						else if (Blackjack.players[Blackjack.i].hand.getScore() > 21 && Blackjack.players[Blackjack.i].hand.getAceCounter() > 0){
							Blackjack.players[Blackjack.i].hand.setScore(Blackjack.players[Blackjack.i].hand.getScore() - 10);
							Blackjack.players[Blackjack.i].hand.setAceCounter(Blackjack.players[Blackjack.i].hand.getAceCounter() - 1);
						}
						else if (Blackjack.players[Blackjack.i].hand.getScore() > 21 && Blackjack.players[Blackjack.i].hand.getAceCounter() == 0){
							Blackjack.players[Blackjack.i].hand.setScore(-1);
							GIO.displayMessage("The dealer has busted!");
							
						}

					}
				}

				
			}
		}
	}

	// This method informs the player about whether they won, lost, or pushed.
	// It also discards the player's cards to prepare for the next round.
	// The window input should be used to redraw the window after cards are discarded.
	public void finishRound(int dealerScore, BlackjackWindow window)
	{
		if (Blackjack.players[Blackjack.i].hand.getScore() > dealerScore){
			GIO.displayMessage(Blackjack.players[Blackjack.i].name + " has won!");
		}
		else if (Blackjack.players[Blackjack.i].hand.getScore() == dealerScore && Blackjack.players[Blackjack.i].hand.getScore() != -1){
			GIO.displayMessage(Blackjack.players[Blackjack.i].name + " has tied!");
		}
		else {
			GIO.displayMessage(Blackjack.players[Blackjack.i].name + " has lost!");
		}
	}
}

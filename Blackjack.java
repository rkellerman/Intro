import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// This is the main program for the blackjack game.
public class Blackjack
{
	public static int numPlayers;
	public static Player[] players;
	public static int i = 0;
	// This method should:
	//	- Ask the user how many people want to play (up to 3, not including the dealer).
	//	- Create an array of players.
	//	- Create a Blackjack window.
	// 	- Play rounds until the players want to quit the game.
	//	- Close the window.
	public static void main(String[] args)
	{
		numPlayers = GIO.readInt("Welcome to BlackJack... How many players?");
		while (numPlayers < 1 || numPlayers > 3){
			numPlayers = GIO.readInt("Must be between 1 and 3 players... Try again:");
		}
		players = new Player[numPlayers + 1];

		
		players[0] = new Player();
		players[0].name = "Dealer";
		players[0].dealer = true;
		for (i = 1; i < numPlayers + 1; i++){
			players[i] = new Player();
			players[i].name = GIO.readString("Enter player " + i + " name:");
			

		}

		BlackjackWindow gameWindow = new BlackjackWindow(players);
		
		while (numPlayers > 0){
			
			playRound(players,gameWindow);
			gameWindow.redraw();

			int prevNumPlayers = numPlayers;
			int currentPlayers = 0;	

			
			for (i = 1; i < prevNumPlayers + 1; i++){
				Boolean playAgain;
				playAgain = GIO.readBoolean(players[i].name + ", would you like to play again?");
				if (playAgain == false){
					players[i] = null;
					numPlayers--;
				}
				else {
					players[currentPlayers + 1] = players[i];
					currentPlayers++;
				}
			}

			if (numPlayers > 0){
				GIO.displayMessage("Players are ready!");
				players = new Player[numPlayers + 1];
				for (i = 1; i < numPlayers + 1; i++){
					players[i] = new Player();
					players[i].name = GIO.readString("Enter player " + i + " name:");
				}
				players[0] = new Player();
				players[0].name = "Dealer";
				players[0].dealer = true;

				gameWindow.close();

				gameWindow = new BlackjackWindow(players);
			}
		}

		GIO.displayMessage("Thank you for playing!");

		gameWindow.close();
		




		
		

	}

	// This method executes an single round of play (for all players).  It should:
	//	- Create and shuffle a deck of cards.
	//	- Start the round (deal cards) for each player, then the dealer.
	//	- Allow each player to play, then the dealer.
	//	- Finish the round (announce results) for each player.
	public static void playRound(Player[] players, BlackjackWindow window)
	{
		Deck deck1 = new Deck();
		deck1.shuffle();
		for (i = 1; i < numPlayers + 1; i++){
			players[i].startRound(deck1,window);
			window.redraw();
		}
		i = 0;
		players[0].startRound(deck1,window);
		window.redraw();

		GIO.displayMessage("Let's begin!");

		for(i = 1; i < numPlayers + 1; i++){
			players[i].playRound(deck1,window);
			window.redraw();
		}
		i = 0;
		GIO.displayMessage("All players are done, now for the dealer...");
		players[0].playRound(deck1,window);
		window.redraw();

		GIO.displayMessage("The dealer's turn is over, let's see who won...");
		for (i = 1; i < numPlayers + 1; i++){
			players[i].finishRound(players[0].hand.getScore(),window);
		}
	


	}
}

import java.io.IOException;
import java.util.*;

public class Game {

	private ArrayList <Player> ChangedArray;
	
	public ArrayList <Player> getArray() {
		return ChangedArray;
	}
	
	public Game (ArrayList <Player> ArrayPlayer){
		int paper = 0;
		int scissors = 0;
		int rock = 0;
		Choice [] choice_player = new Choice[ArrayPlayer.size()];

		for (int i = 0; i < ArrayPlayer.size(); i++) {
			choice_player[i] = ArrayPlayer.get(i).purposeChoice(); // displays each player's choice!
			if (choice_player[i] == Choice.PAPER)
				paper ++;
			else if (choice_player[i] == Choice.ROCK)
				rock ++;
			else if (choice_player[i] == Choice.SCISSORS) 
				scissors ++;
		}

		int length = choice_player.length;
		if (paper != length && scissors != length && rock != length) // condition that anyone doesn't have same hint
		{
			for (int i = 0; i < length; i++) {
				if (choice_player[i] == Choice.PAPER)
					ArrayPlayer.get(i).incrementScore(rock);
				else if (choice_player[i] == Choice.ROCK)
					ArrayPlayer.get(i).incrementScore(scissors);
				else if (choice_player[i] == Choice.SCISSORS) 
					ArrayPlayer.get(i).incrementScore(paper);
				else
					try {
						ArrayPlayer.get(i).getSocket().close();
						System.out.println(ArrayPlayer.get(i).getName() + " just left the game");
						ArrayPlayer.remove(i);
						ChangedArray = ArrayPlayer;
						break;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				System.out.println(ArrayPlayer.get(i).getName() + "'s score is " + ArrayPlayer.get(i).getScore());
			}
		}
		else System.out.println("Same choice for everyone --> no modified score!");

	}
}

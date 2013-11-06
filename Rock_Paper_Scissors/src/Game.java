
public class Game {

	public Game (Player[] player){
		int paper = 0;
		int scissors = 0;
		int rock = 0;
		Choice [] choice_player = new Choice[player.length];

		for (int i = 0; i < player.length; i++) {
			choice_player[i] = player[i].purposeChoice(); // displays each player's choice!
			if (choice_player[i] == Choice.PAPER)
				paper ++;
			else if (choice_player[i] == Choice.ROCK)
				rock ++;
			else scissors ++;
		}

		int length = choice_player.length;
		if (paper != length && scissors != length && rock != length) // condition that anyone doesn't have same hint
		{
			for (int i = 0; i < length; i++) {
				if (choice_player[i] == Choice.PAPER)
					player[i].incrementScore(rock);
				else if (choice_player[i] == Choice.ROCK)
					player[i].incrementScore(scissors);
				else player[i].incrementScore(paper);
				System.out.println(player[i].getName() + "'s score is " + player[i].getScore());
			}
		}
		else System.out.println("Same choice for everyone --> no modified score!");

	}
}

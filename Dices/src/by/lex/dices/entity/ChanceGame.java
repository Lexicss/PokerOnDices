package by.lex.dices.entity;

/**
 * 
 * @author admin
 *Chance Game Entity
 *
 */

public class ChanceGame {
	private int mScore;
	private String mGameName;
	
	public int getScore() {
		return mScore;
	}

	public String getGameName() {
		return mGameName;
	}

	public ChanceGame(int score, String name) {
		mScore = score;
		mGameName = name;
	}
	
}

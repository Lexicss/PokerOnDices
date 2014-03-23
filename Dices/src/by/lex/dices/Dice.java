package by.lex.dices;

import java.util.Random;

public class Dice {
	private final int MIN = 1;
	private final int MAX = 6;
	
	private int mValue;
	
	public Dice(boolean withDrop) {
		if (withDrop) {
			drop();
		} else {
			mValue = MIN;
		}
	}
	
	public Dice() {
		mValue = MIN;
	}
	

	public int drop() {
	   Random r = new Random();
	   mValue = r.nextInt(MAX - MIN + 1) + MIN;
	   
	   return mValue;
	}
	
	public int getValue() {
		return mValue;
	}
}

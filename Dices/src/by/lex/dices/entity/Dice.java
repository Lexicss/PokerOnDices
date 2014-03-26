package by.lex.dices.entity;

import java.util.Random;

public class Dice {
	private final int MIN = 1;
	private final int MAX = 6;// afdfdfdfd
	
	private int mValue;
	
	public Dice(boolean withDrop) {
		if (withDrop) {
			throwIt();
		} else {
			mValue = MIN;
		}
	}
	
	public Dice() {
		mValue = MIN;
	}
	

	public int throwIt() {
	   Random r = new Random();
	   mValue = r.nextInt(MAX - MIN + 1) + MIN;
	   
	   return mValue;
	}
	
	public int getValue() {
		return mValue;
	}
}

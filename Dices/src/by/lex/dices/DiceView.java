package by.lex.dices;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class DiceView extends ImageView {
	private Dice mDice;
	private boolean mIsDropping;
	private boolean mIsLock;
	
	public DiceView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public Dice getDice() {
		return mDice;
	}

	public void setDice(Dice dice) {
		mDice = dice;
		refresh();
	}
	
	public void refresh() {
		if (mDice == null) {
			return;
		}
		
		int imgId;
		
		switch (mDice.getValue()) {
		case 1: 
			imgId = R.drawable.dice1;
			break;
		case 2:
			imgId = R.drawable.dice2;
			break;
		case 3:
			imgId = R.drawable.dice3;
			break;
		case 4:
			imgId = R.drawable.dice4;
			break;
		case 5:
			imgId = R.drawable.dice5;
			break;
		case 6:
			imgId = R.drawable.dice6;
			break;

		default:
			imgId = R.drawable.dice1;
			break;
		}
		
		setImageDrawable(getResources().getDrawable(imgId));
	}

}

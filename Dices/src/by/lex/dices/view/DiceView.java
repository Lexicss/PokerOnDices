package by.lex.dices.view;

import by.lex.dices.R;
import by.lex.dices.R.drawable;
import by.lex.dices.entity.Dice;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

@SuppressLint("NewApi")
public class DiceView extends ImageView {
	private String TAG = this.getClass().getSimpleName();
	
	private Dice mDice;
	private boolean mIsDropping;
	private boolean mIsLock;
	
	public DiceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		mIsDropping = false;
		mIsLock = false;
		Log.i(TAG, "INIT");
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
		
		int imgId; //af df
		
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
	
	public boolean isLocked() {
		return mIsLock;
	}
	
	public void lockUnlock() {
		mIsLock = !mIsLock;
		
		Log.d(TAG, "now dice is locked: " + mIsLock);
		refresh();
		animateToLock(mIsLock);
	}
	
	private void animateToLock(boolean fade) {
		float from;
		float to;
		
		if (fade) {
			from = 1.0f;
			to = 0.4f;
		} else {
			from = 0.4f;
			to = 1.0f;
		}
		
		AlphaAnimation alpha = new AlphaAnimation(from, to);
		alpha.setDuration(300);
		alpha.setFillAfter(true);
		startAnimation(alpha);
	}

}

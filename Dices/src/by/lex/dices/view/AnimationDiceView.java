package by.lex.dices.view;

import java.util.Random;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import by.lex.dices.R;

import com.nineoldandroids.animation.ObjectAnimator;

public class AnimationDiceView extends ImageView implements OnClickListener{
	
	public static abstract interface onThrowListener {
	    public abstract void onChangeSideDices(View v);
	}
	
	public void setOnThrowListener(onThrowListener listener){
		throwListener = listener;
	};
	private onThrowListener throwListener;
	
	private int number = 0; // Default number
//	private boolean mIsDropping;
	private boolean mIsHold = false;
	
	private final int MIN = 1;
	private final int MAX = 6;
	
	final int duration = 300;

	public AnimationDiceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setOnClickListener(this);		
		refreshView();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int value) {
		number = value;
		refreshView();
	}
	
	public void throwDice(){
		Random r = new Random();
		number = r.nextInt(MAX - MIN + 1) + MIN;
		refreshView();
		throwListener.onChangeSideDices(this);
	}	
	
	public boolean isHold(){
		return mIsHold;		
	}
	
	public void hold(){
		if(number == 0) return;
		ObjectAnimator.ofFloat(this, "scaleY", 1, 0.7f).setDuration(duration).start();
		ObjectAnimator.ofFloat(this, "scaleX", 1, 0.7f).setDuration(duration).start();
		ObjectAnimator.ofFloat(this, "alpha", 1, 0.5f).setDuration(duration).start();
		mIsHold = true;	
	}
	
	public void unHold(){		
		ObjectAnimator.ofFloat(this, "scaleY", 0.7f, 1).setDuration(duration).start();
		ObjectAnimator.ofFloat(this, "scaleX", 0.7f, 1).setDuration(duration).start();
		ObjectAnimator.ofFloat(this, "alpha", 0.5f, 1).setDuration(duration).start();
		mIsHold = false;				
	}

	private void refreshView() {
		
		int imgId;

		switch (number) {
		case 1: 
			imgId = R.drawable.dices_1;
			break;
		case 2:
			imgId = R.drawable.dices_2;
			break;
		case 3:
			imgId = R.drawable.dices_3;
			break;
		case 4:
			imgId = R.drawable.dices_4;
			break;
		case 5:
			imgId = R.drawable.dices_5;
			break;
		case 6:
			imgId = R.drawable.dices_6;
			break;

		default:
			imgId = R.drawable.dices_0;
			break;
		}
		ObjectAnimator.ofFloat(this, "rotationX", 0, 180, 0).setDuration(duration).start();
		setImageDrawable(getResources().getDrawable(imgId));
	}

	@Override
	public void onClick(View v) {
		if(mIsHold)	unHold();
		else hold();
	}

}

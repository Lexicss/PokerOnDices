package by.lex.dices.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import by.lex.dices.R;

public class ThrowIndicatorView extends FrameLayout {

	private int mNumber;
	private ImageView ivOne, ivTwo, ivThree;
	
	public ThrowIndicatorView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		if(!isInEditMode()){
			initControl();			
		}
	}

	public ThrowIndicatorView(Context context, AttributeSet attrs) {
		super(context, attrs);
		if(!isInEditMode()){
			initControl();			
		}
	}

	public ThrowIndicatorView(Context context) {
		super(context);
		if(!isInEditMode()){
			initControl();			
		}
	}

	private void initControl() {
		LayoutInflater li = ((Activity) getContext()).getLayoutInflater();
        li.inflate(R.layout.throw_indicator, this);
        
        ivOne = (ImageView)findViewById(R.id.ivOne);
        ivTwo = (ImageView)findViewById(R.id.ivTwo);
        ivThree = (ImageView)findViewById(R.id.ivThree);
        
//        ivOne.setImageResource(R.drawable.dot_passive);
//        ivTwo.setImageResource(R.drawable.dot_passive);
//        ivThree.setImageResource(R.drawable.dot_passive);
	}


	public int getThrowNumber() {
		return mNumber;
	}

	public void setThrowNumber(int number) {
		mNumber = number;
		updateState();
	}
	
	public void nextThrow() {
		mNumber++;
		if(mNumber > 3)mNumber = 0;
		updateState();
	}

	private void updateState() {
		switch (mNumber) {
		case 0:
			ivOne.setImageResource(R.drawable.dot_passive);
	        ivTwo.setImageResource(R.drawable.dot_passive);
	        ivThree.setImageResource(R.drawable.dot_passive);
			break;
		case 1:
			ivOne.setImageResource(R.drawable.dot_active);
	        ivTwo.setImageResource(R.drawable.dot_passive);
	        ivThree.setImageResource(R.drawable.dot_passive);
			break;
		case 2:
			ivOne.setImageResource(R.drawable.dot_active);
	        ivTwo.setImageResource(R.drawable.dot_active);
	        ivThree.setImageResource(R.drawable.dot_passive);
			break;
		case 3:
			ivOne.setImageResource(R.drawable.dot_active);
	        ivTwo.setImageResource(R.drawable.dot_active);
	        ivThree.setImageResource(R.drawable.dot_active);
			break;
		}
	}


}

package by.lex.dices.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ToggleButton;
import by.lex.dices.R;
import by.lex.dices.entity.Dice;

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
			imgId = R.drawable.dices_1;
			break;
		}

		setImageDrawable(getResources().getDrawable(imgId));
	}

}

package by.lex.dices.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import by.lex.dices.R;
import by.lex.dices.manager.ResultManager;
import by.lex.dices.view.AnimationDiceView;
import by.lex.dices.view.AnimationDiceView.onThrowListener;
import by.lex.dices.view.ThrowIndicatorView;

public class MainActivity extends Activity implements OnClickListener, onThrowListener{
	public final String TAG = this.getClass().getSimpleName();

	private TextView mText;

	private Button mDropButton;
	private AnimationDiceView mFirstDiceView;
	private AnimationDiceView mSecondDiceView;
	private AnimationDiceView mThirdDiceView;
	private AnimationDiceView mFourthDiceView;
	private AnimationDiceView mFifthDiceView;

	private ThrowIndicatorView throwIndicator;
	
	private int one, two, three, four, five = -1; // number dices

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
	}

	private void initViews() {
		mText = (TextView) findViewById(R.id.textView1);

		mDropButton = (Button) findViewById(R.id.drop_btn);
		mDropButton.setOnClickListener(this);

		mFirstDiceView = (AnimationDiceView) findViewById(R.id.first_dice_view);
		mSecondDiceView = (AnimationDiceView) findViewById(R.id.second_dice_view);
		mThirdDiceView = (AnimationDiceView) findViewById(R.id.third_dice_view);
		mFourthDiceView = (AnimationDiceView) findViewById(R.id.fourth_dice_view);
		mFifthDiceView = (AnimationDiceView) findViewById(R.id.fifth_dice_view);
		
		mFirstDiceView.setOnThrowListener(this);
		mSecondDiceView.setOnThrowListener(this);
		mThirdDiceView.setOnThrowListener(this);
		mFourthDiceView.setOnThrowListener(this);
		mFifthDiceView.setOnThrowListener(this);
		
		throwIndicator = (ThrowIndicatorView)findViewById(R.id.throwIndicatorView);
		throwIndicator.setThrowNumber(0);
	}

	private void dropAll() {
		if(!mFirstDiceView.isHold()) one = -1;
		if(!mSecondDiceView.isHold()) two = -1;
		if(!mThirdDiceView.isHold()) three= -1;
		if(!mFourthDiceView.isHold()) four = -1;
		if(!mFifthDiceView.isHold()) five = -1;
		
		if(!mFirstDiceView.isHold()) mFirstDiceView.throwDice();
		if(!mSecondDiceView.isHold()) mSecondDiceView.throwDice();
		if(!mThirdDiceView.isHold()) mThirdDiceView.throwDice();
		if(!mFourthDiceView.isHold()) mFourthDiceView.throwDice();
		if(!mFifthDiceView.isHold()) mFifthDiceView.throwDice();		
	}
	
	private void calculate(){
		if(mFirstDiceView.isHold())mFirstDiceView.unHold();
		if(mSecondDiceView.isHold())mSecondDiceView.unHold();
		if(mThirdDiceView.isHold())mThirdDiceView.unHold();
		if(mFourthDiceView.isHold())mFourthDiceView.unHold();
		if(mFifthDiceView.isHold())mFifthDiceView.unHold();
		
		int[] values = {one, two, three, four, five};
		ResultManager.getInstance().calculateResult(values);
		
		int pair = ResultManager.getInstance().getPair();
		int doublePair = ResultManager.getInstance().getDoublePair();
		int set = ResultManager.getInstance().getSet();
		int care = ResultManager.getInstance().getCare();
		int odds = ResultManager.getInstance().getOdds();
		int evens = ResultManager.getInstance().getEvens();
		int mStreet = ResultManager.getInstance().getLittleStreet();
		int bStreet = ResultManager.getInstance().getBigStreet();
		int sStreet = ResultManager.getInstance().getShortStreet();
		int mizer = ResultManager.getInstance().getMizer();
		int sum = ResultManager.getInstance().getSum();
		int full = ResultManager.getInstance().getFullHouse();
		int poker = ResultManager.getInstance().getPoker();

		String caption = "";
		if (pair > 0) {
			caption += "pair = " + pair;
		}
		if (doublePair > 0) {
			caption += "; doublePair = " + doublePair;
		}
		if (set > 0) {
			caption += "; set = " +set;
		}
		if (care > 0) {
			caption += "; care = " + care;
		}
		if (odds > 0) {
			caption += "; odds = " + odds;
		}
		if (evens > 0) {
			caption += "; evens = " + evens;
		}
		if (mStreet > 0) {
			caption += "; mStreet = " + mStreet;
		}
		if (bStreet > 0) {
			caption += "; bStreet = " + bStreet;
		}
		if (sStreet > 0) {
			caption += "; sStreet = " + sStreet;
		}
		if (mizer > 0) {
			caption += "; mizer = " + mizer;
		}
		if (sum > 0) {
			caption += "; sum = " + sum;
		}
		if (full > 0) {
			caption += "; full = " + full;
		}
		if (poker > 0) {
			caption += "; poker = " + poker;
		}

		mText.setText(caption);

		Log.d(TAG, "SCHOOL 1 = " + ResultManager.getInstance().getSchool1());
		Log.d(TAG, "SCHOOL 2 = " + ResultManager.getInstance().getSchool2());
		Log.d(TAG, "SCHOOL 3 = " + ResultManager.getInstance().getSchool3());
		Log.d(TAG, "SCHOOL 4 = " + ResultManager.getInstance().getSchool4());
		Log.d(TAG, "SCHOOL 5 = " + ResultManager.getInstance().getSchool5());
		Log.d(TAG, "SCHOOL 6 = " + ResultManager.getInstance().getSchool6());

		Log.i(TAG, "Pair: " + ResultManager.getInstance().getPair());
		Log.i(TAG, "Double Pair: " + ResultManager.getInstance().getDoublePair());
		Log.i(TAG, "Set: " + ResultManager.getInstance().getSet());
		Log.i(TAG, "Care: " + ResultManager.getInstance().getCare());
		Log.i(TAG, "Odds: " + ResultManager.getInstance().getOdds());
		Log.i(TAG, "Evens: " + ResultManager.getInstance().getEvens());
		Log.i(TAG, "Little street: " + ResultManager.getInstance().getLittleStreet());
		Log.i(TAG, "Big street: " + ResultManager.getInstance().getBigStreet());
		Log.i(TAG, "Short street: " + ResultManager.getInstance().getShortStreet());
		Log.i(TAG, "Mizer: " + ResultManager.getInstance().getMizer());
		Log.i(TAG, "Sum: " + ResultManager.getInstance().getSum());
		Log.i(TAG, "Full house: " + ResultManager.getInstance().getFullHouse());
		Log.i(TAG, "Poker: " + ResultManager.getInstance().getPoker());

		Log.i(TAG, " ");
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.drop_btn) {
			dropAll();
			
			throwIndicator.nextThrow();
		}
	}

	@Override
	public void onChangeSideDices(View v) {
		switch (v.getId()) {
		case R.id.first_dice_view:
			one = mFirstDiceView.getNumber();
			break;
		case R.id.second_dice_view:
			two = mSecondDiceView.getNumber();
			break;
		case R.id.third_dice_view:
			three = mThirdDiceView.getNumber();
			break;
		case R.id.fourth_dice_view:
			four = mFourthDiceView.getNumber();
			break;
		case R.id.fifth_dice_view:
			five = mFifthDiceView.getNumber();
			break;			
		}
		
		// проверка. все ли кубики кинуты
		if(one != -1 && two != -1 && three != -1 && four != -1 && five != -1){
			calculate();
		}
	}

}

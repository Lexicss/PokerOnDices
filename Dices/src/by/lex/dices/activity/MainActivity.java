package by.lex.dices.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import by.lex.dices.R;
import by.lex.dices.entity.Dice;
import by.lex.dices.manager.ResultManager;
import by.lex.dices.view.DiceView;
import by.lex.dices.view.ThrowIndicatorView;

public class MainActivity extends Activity implements OnClickListener{
	public final String TAG = this.getClass().getSimpleName();

	private TextView mText;

	private Button mDropButton;
	private DiceView mfirstDiceView;
	private DiceView mSecondDiceView;
	private DiceView mThirdDiceView;
	private DiceView mFourthDiceView;
	private DiceView mFifthDiceView;

	private ThrowIndicatorView throwIndicator;
	
	private TreeSet<Integer> dicesSet;

	private List<Dice> mDiceList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();

		mDiceList = new ArrayList<Dice>();
		mDiceList.add(new Dice());
		mDiceList.add(new Dice());
		mDiceList.add(new Dice());
		mDiceList.add(new Dice());
		mDiceList.add(new Dice());

		mfirstDiceView.setDice(mDiceList.get(0));
		mSecondDiceView.setDice(mDiceList.get(1));
		mThirdDiceView.setDice(mDiceList.get(2));
		mFourthDiceView.setDice(mDiceList.get(3));
		mFifthDiceView.setDice(mDiceList.get(4));

		dropAll();
	}

	private void initViews() {
		mText = (TextView) findViewById(R.id.textView1);

		mDropButton = (Button) findViewById(R.id.drop_btn);
		mDropButton.setOnClickListener(this);

		mfirstDiceView = (DiceView) findViewById(R.id.first_dice_view);
		mSecondDiceView = (DiceView) findViewById(R.id.second_dice_view);
		mThirdDiceView = (DiceView) findViewById(R.id.third_dice_view);
		mFourthDiceView = (DiceView) findViewById(R.id.fourth_dice_view);
		mFifthDiceView = (DiceView) findViewById(R.id.fifth_dice_view);
		
		throwIndicator = (ThrowIndicatorView)findViewById(R.id.throwIndicatorView);
		throwIndicator.setThrowNumber(2);
	}

	private void traceDiceValues() {
		for (int i = 0; i < mDiceList.size(); i++) {
			Dice dice = mDiceList.get(i);
			Log.i(TAG, (i+1) + ". " + dice.getValue());
		}
	}

	private void dropAll() {
		for (int i = 0; i < mDiceList.size(); i++) {
			Dice dice = mDiceList.get(i);
			Log.d(TAG, "Drop " + (i+1) + " dice : " + dice.throwIt());
		}

		mfirstDiceView.refresh();
		mSecondDiceView.refresh();
		mThirdDiceView.refresh();
		mFourthDiceView.refresh();
		mFifthDiceView.refresh();
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.drop_btn) {
			dropAll();
			
			throwIndicator.nextThrow();

			int v1 = mDiceList.get(0).getValue();
			int v2 = mDiceList.get(1).getValue();
			int v3 = mDiceList.get(2).getValue();
			int v4 = mDiceList.get(3).getValue();
			int v5 = mDiceList.get(4).getValue();

			int[] values = {v1, v2, v3, v4, v5};
			ResultManager.getInstance().calculateResult(values);
			Log.v(TAG,v1 + " " + v2 + " " + v3 + " " + v4 + " " + v5);

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
	}

}

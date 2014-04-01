package by.lex.dices.entity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import by.lex.dices.R;
import by.lex.dices.interfaces.ChoiceListener;

public class PlayerTable implements OnClickListener{
	
	private Context mContext;

	private View tablePlayer;
	private LinearLayout llAces, llTwos, llThrees, llFours, llFives, llSix, llPair, llTwoPair, llSet, llCare, 
						llEvens, llOdds, llLittleStreet, llBigStreet, llMizer, llSum, llFullHouse, llChance, llPoker;
	private TextView tvName, tvAces, tvTwos, tvThrees, tvFours, tvFives, tvSix, tvPair, tvTwoPair, tvSet, tvCare, tvEvens, 
						tvOdds, tvLittleStreet, tvBigStreet, tvMizer, tvSum, tvFullHouse, tvChance, tvPoker, tvTotal;
	
	private boolean isActive;
	private int aces, twos, threes, fours, fives, six, pair, twoPair, set, care, evens, 
	odds, littleStreet, bigStreet, mizer, sum, fullHouse, chance, poker, total;
	
	private int mPlayerIndex;
	private ChoiceListener mChoiceListener;
	
	public int getAces() {
		return aces;
	}

	public void setAces(int aces) {
		this.aces = aces;
	}

	public int getTwos() {
		return twos;
	}

	public void setTwos(int twos) {
		this.twos = twos;
	}

	public int getThrees() {
		return threes;
	}

	public void setThrees(int threes) {
		this.threes = threes;
	}

	public int getFours() {
		return fours;
	}

	public void setFours(int fours) {
		this.fours = fours;
	}

	public int getFives() {
		return fives;
	}

	public void setFives(int fives) {
		this.fives = fives;
	}

	public int getSix() {
		return six;
	}

	public void setSix(int six) {
		this.six = six;
	}

	public int getPair() {
		return pair;
	}

	public void setPair(int pair) {
		this.pair = pair;
	}

	public int getTwoPair() {
		return twoPair;
	}

	public void setTwoPair(int twoPair) {
		this.twoPair = twoPair;
	}

	public int getSet() {
		return set;
	}

	public void setSet(int set) {
		this.set = set;
	}

	public int getCare() {
		return care;
	}

	public void setCare(int care) {
		this.care = care;
	}

	public int getEvens() {
		return evens;
	}

	public void setEvens(int evens) {
		this.evens = evens;
	}

	public int getOdds() {
		return odds;
	}

	public void setOdds(int odds) {
		this.odds = odds;
	}

	public int getLittleStreet() {
		return littleStreet;
	}

	public void setLittleStreet(int littleStreet) {
		this.littleStreet = littleStreet;
	}

	public int getBigStreet() {
		return bigStreet;
	}

	public void setBigStreet(int bigStreet) {
		this.bigStreet = bigStreet;
	}

	public int getMizer() {
		return mizer;
	}

	public void setMizer(int mizer) {
		this.mizer = mizer;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getFullHouse() {
		return fullHouse;
	}

	public void setFullHouse(int fullHouse) {
		this.fullHouse = fullHouse;
	}

	public int getChance() {
		return chance;
	}

	public void setChance(int chance) {
		this.chance = chance;
	}

	public int getPoker() {
		return poker;
	}

	public void setPoker(int poker) {
		this.poker = poker;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public View getView() {		
		return tablePlayer;
	}
	
	public void setActive(boolean state){
		isActive = state;
		updateView();
	}	

	public PlayerTable(Context context, String name) {
		mContext = context;
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		tablePlayer = inflater.inflate(R.layout.game_table_player, null);		
		
		tvName = (TextView)tablePlayer.findViewById(R.id.tvName);
		tvAces = (TextView)tablePlayer.findViewById(R.id.tvAces);
		tvTwos = (TextView)tablePlayer.findViewById(R.id.tvTwos);
		tvThrees = (TextView)tablePlayer.findViewById(R.id.tvThrees);
		tvFours = (TextView)tablePlayer.findViewById(R.id.tvFours);
		tvFives = (TextView)tablePlayer.findViewById(R.id.tvFives);
		tvSix = (TextView)tablePlayer.findViewById(R.id.tvSix);
		tvPair = (TextView)tablePlayer.findViewById(R.id.tvPair);
		tvTwoPair = (TextView)tablePlayer.findViewById(R.id.tvTwoPair);
		tvSet = (TextView)tablePlayer.findViewById(R.id.tvSet);
		tvCare = (TextView)tablePlayer.findViewById(R.id.tvCare);
		tvEvens = (TextView)tablePlayer.findViewById(R.id.tvEvens);
		tvOdds = (TextView)tablePlayer.findViewById(R.id.tvOdds);
		tvLittleStreet = (TextView)tablePlayer.findViewById(R.id.tvLittleStreet);
		tvBigStreet = (TextView)tablePlayer.findViewById(R.id.tvBigStreet);
		tvMizer = (TextView)tablePlayer.findViewById(R.id.tvMizer);
		tvSum = (TextView)tablePlayer.findViewById(R.id.tvSum);
		tvFullHouse = (TextView)tablePlayer.findViewById(R.id.tvFullHouse);
		tvChance = (TextView)tablePlayer.findViewById(R.id.tvChance);
		tvPoker = (TextView)tablePlayer.findViewById(R.id.tvPoker);
		tvTotal = (TextView)tablePlayer.findViewById(R.id.tvTotal);
		
		llAces = (LinearLayout)tablePlayer.findViewById(R.id.llAces);
		llTwos = (LinearLayout)tablePlayer.findViewById(R.id.llTwos);
		llThrees = (LinearLayout)tablePlayer.findViewById(R.id.llThrees);
		llFours = (LinearLayout)tablePlayer.findViewById(R.id.llFours);
		llFives = (LinearLayout)tablePlayer.findViewById(R.id.llFives);
		llSix = (LinearLayout)tablePlayer.findViewById(R.id.llSix);
		llPair = (LinearLayout)tablePlayer.findViewById(R.id.llPair);
		llTwoPair = (LinearLayout)tablePlayer.findViewById(R.id.llTwoPair);
		llSet = (LinearLayout)tablePlayer.findViewById(R.id.llSet);
		llCare = (LinearLayout)tablePlayer.findViewById(R.id.llCare);
		llEvens = (LinearLayout)tablePlayer.findViewById(R.id.llEvens);
		llOdds = (LinearLayout)tablePlayer.findViewById(R.id.llOdds);
		llLittleStreet = (LinearLayout)tablePlayer.findViewById(R.id.llLittleStreet);
		llBigStreet = (LinearLayout)tablePlayer.findViewById(R.id.llBigStreet);
		llMizer = (LinearLayout)tablePlayer.findViewById(R.id.llMizer);
		llSum = (LinearLayout)tablePlayer.findViewById(R.id.llSum);
		llFullHouse = (LinearLayout)tablePlayer.findViewById(R.id.llFullHouse);
		llChance = (LinearLayout)tablePlayer.findViewById(R.id.llChance);
		llPoker = (LinearLayout)tablePlayer.findViewById(R.id.llPoker);
		
		llAces.setOnClickListener(this);
		llTwos.setOnClickListener(this);
		llThrees.setOnClickListener(this);
		llFours.setOnClickListener(this);
		llFives.setOnClickListener(this);
		llSix.setOnClickListener(this);
		llPair.setOnClickListener(this);
		llTwoPair.setOnClickListener(this);
		llSet.setOnClickListener(this);
		llCare.setOnClickListener(this);
		llEvens.setOnClickListener(this);
		llOdds.setOnClickListener(this);
		llLittleStreet.setOnClickListener(this);
		llBigStreet.setOnClickListener(this);
		llMizer.setOnClickListener(this);
		llSum.setOnClickListener(this);
		llFullHouse.setOnClickListener(this);
		llChance.setOnClickListener(this);
		llPoker.setOnClickListener(this);
		
		tvName.setText(name);
	}	

	public void setPlayerIndex(int index) {
		mPlayerIndex = index;
	}
	
	public void setChoiceListener(ChoiceListener listener) {
		mChoiceListener = listener;
	}
	
	private void updateView() {
		if(isActive){
			String stAces = tvAces.getText().toString();
			if(stAces.isEmpty() || stAces.contains("+")) tvAces.setText("+" + aces);			
			
			String stTwos = tvTwos.getText().toString();
			if(stTwos.isEmpty() || stTwos.contains("+")) tvTwos.setText("+" + twos);
			
			String stThrees = tvThrees.getText().toString();
			if(stThrees.isEmpty() || stThrees.contains("+")) tvThrees.setText("+" + threes);
			
			String stFours = tvFours.getText().toString();
			if(stFours.isEmpty() || stFours.contains("+")) tvFours.setText("+" + fours);
			
			String stFives = tvFives.getText().toString();
			if(stFives.isEmpty() || stFives.contains("+")) tvFives.setText("+" + fives);
			
			String stSix = tvSix.getText().toString();
			if(stSix.isEmpty() || stSix.contains("+")) tvSix.setText("+" + six);
			
			String stPair = tvPair.getText().toString();
			if(stPair.isEmpty() || stPair.contains("+")) tvPair.setText("+" + pair);
			
			String stTwoPair = tvTwoPair.getText().toString();
			if(stTwoPair.isEmpty() || stTwoPair.contains("+")) tvTwoPair.setText("+" + twoPair);
			
			String stSet = tvSet.getText().toString();
			if(stSet.isEmpty() || stSet.contains("+")) tvSet.setText("+" + set);
			
			String stCare = tvCare.getText().toString();
			if(stCare.isEmpty() || stCare.contains("+")) tvCare.setText("+" + care);
			
			String stEvens = tvEvens.getText().toString();
			if(stEvens.isEmpty() || stEvens.contains("+")) tvEvens.setText("+" + evens);
			
			String stOdds = tvOdds.getText().toString();
			if(stOdds.isEmpty() || stOdds.contains("+")) tvOdds.setText("+" + odds);
			
			String stLittleStreet = tvLittleStreet.getText().toString();
			if(stLittleStreet.isEmpty() || stLittleStreet.contains("+")) tvLittleStreet.setText("+" + littleStreet);
			
			String stBigStreet = tvBigStreet.getText().toString();
			if(stBigStreet.isEmpty() || stBigStreet.contains("+")) tvBigStreet.setText("+" + bigStreet);
			
			String stMizzer = tvMizer.getText().toString();
			if(stMizzer.isEmpty() || stMizzer.contains("+")) tvMizer.setText("+" + mizer);
			
			String stSum = tvSum.getText().toString();
			if(stSum.isEmpty() || stSum.contains("+")) tvSum.setText("+" + sum);
			
			String stFullHouse = tvFullHouse.getText().toString();
			if(stFullHouse.isEmpty() || stFullHouse.contains("+")) tvFullHouse.setText("+" + fullHouse);
			
			String stChance = tvChance.getText().toString();
			if(stChance.isEmpty() || stChance.contains("+")) tvChance.setText("+" + chance);
			
			String stPoker = tvPoker.getText().toString();
			if(stPoker.isEmpty() || stPoker.contains("+")) tvPoker.setText("+" + poker);			
		} else {
			String stAces = tvAces.getText().toString();
			if(stAces.contains("+")) tvAces.setText("");
			
			String stTwos = tvTwos.getText().toString();
			if(stTwos.contains("+")) tvTwos.setText("");
			
			String stThrees = tvThrees.getText().toString();
			if(stThrees.contains("+")) tvThrees.setText("");
			
			String stFours = tvFours.getText().toString();
			if(stFours.contains("+")) tvFours.setText("");
			
			String stFives = tvFives.getText().toString();
			if(stFives.contains("+")) tvFives.setText("");
			
			String stSix = tvSix.getText().toString();
			if(stSix.contains("+")) tvSix.setText("");
			
			String stPair = tvPair.getText().toString();
			if(stPair.contains("+")) tvPair.setText("");
			
			String stTwoPair = tvTwoPair.getText().toString();
			if(stTwoPair.contains("+")) tvTwoPair.setText("");
			
			String stSet = tvSet.getText().toString();
			if(stSet.contains("+")) tvSet.setText("");
			
			String stCare = tvCare.getText().toString();
			if(stCare.contains("+")) tvCare.setText("");
			
			String stEvens = tvEvens.getText().toString();
			if(stEvens.contains("+")) tvEvens.setText("");
			
			String stOdds = tvOdds.getText().toString();
			if(stOdds.contains("+")) tvOdds.setText("");
			
			String stLittleStreet = tvLittleStreet.getText().toString();
			if(stLittleStreet.contains("+")) tvLittleStreet.setText("");
			
			String stBigStreet = tvBigStreet.getText().toString();
			if(stBigStreet.contains("+")) tvBigStreet.setText("");
			
			String stMizzer = tvMizer.getText().toString();
			if(stMizzer.contains("+")) tvMizer.setText("");
			
			String stSum = tvSum.getText().toString();
			if(stSum.contains("+")) tvSum.setText("");
			
			String stFullHouse = tvFullHouse.getText().toString();
			if(stFullHouse.contains("+")) tvFullHouse.setText("");
			
			String stChance = tvChance.getText().toString();
			if(stChance.contains("+")) tvChance.setText("");
			
			String stPoker = tvPoker.getText().toString();
			if(stPoker.contains("+")) tvPoker.setText("");
		}
		changeDrawable(tvAces, llAces);
		changeDrawable(tvTwos, llTwos);
		changeDrawable(tvThrees, llThrees);
		changeDrawable(tvFours, llFours);
		changeDrawable(tvFives, llFives);
		changeDrawable(tvSix, llSix);
		changeDrawable(tvPair, llPair);
		changeDrawable(tvTwoPair, llTwoPair);
		changeDrawable(tvSet, llSet);
		changeDrawable(tvCare, llCare);
		changeDrawable(tvEvens, llEvens);
		changeDrawable(tvOdds, llOdds);
		changeDrawable(tvLittleStreet, llLittleStreet);
		changeDrawable(tvBigStreet, llBigStreet);
		changeDrawable(tvMizer, llMizer);
		changeDrawable(tvSum, llSum);
		changeDrawable(tvFullHouse, llFullHouse);
		changeDrawable(tvChance, llChance);
		changeDrawable(tvPoker, llPoker);
	}
	
	private void changeDrawable(TextView text, LinearLayout layout){
		if(isActive){
			if(text.getText().toString().contains("+")){
				layout.setBackgroundResource(R.drawable.feedback_red_cell);
				text.setTextColor(mContext.getResources().getColor(R.color.beige));
			} else {
				layout.setBackgroundResource(R.color.beige);
				text.setTextColor(mContext.getResources().getColor(R.color.black));
			}			
		} else {
			layout.setBackgroundResource(android.R.color.transparent);
			text.setTextColor(mContext.getResources().getColor(R.color.black));
		}
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.llAces:
			Toast.makeText(mContext, "Еденицы", Toast.LENGTH_SHORT).show();
			mChoiceListener.onChoice(1, mPlayerIndex);
//			tvAces.set
			break;
		case R.id.llTwos:
			Toast.makeText(mContext, "Двойки", Toast.LENGTH_SHORT).show();
			mChoiceListener.onChoice(2, mPlayerIndex);
			break;
		case R.id.llThrees:
			Toast.makeText(mContext, "threes", Toast.LENGTH_SHORT).show();
			mChoiceListener.onChoice(3, mPlayerIndex);
			break;
			
		}
	}	
}

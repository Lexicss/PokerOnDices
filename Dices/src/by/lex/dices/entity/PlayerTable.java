package by.lex.dices.entity;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import by.lex.dices.R;
import by.lex.dices.interfaces.ChoiceListener;
import by.lex.dices.manager.ResultManager;


public class PlayerTable implements OnClickListener{
	private final String TAG = this.getClass().getSimpleName();
	public final static int UNPLAYED = -1000;
	
	private Context mContext;

	private View tablePlayer;
	private LinearLayout llAces, llTwos, llThrees, llFours, llFives, llSix, llPair, llTwoPair, llSet, llCare, 
						llEvens, llOdds, llLittleStreet, llBigStreet, llMizer, llSum, llFullHouse, llChance, llPoker;
	private TextView tvName, tvAces, tvTwos, tvThrees, tvFours, tvFives, tvSix, tvPair, tvTwoPair, tvSet, tvCare, tvEvens, 
						tvOdds, tvLittleStreet, tvBigStreet, tvMizer, tvSum, tvFullHouse, tvChance, tvPoker, tvTotal, tvSchoolResult;
	
	private boolean isActive;
	private int aces = UNPLAYED, twos = UNPLAYED, threes = UNPLAYED, fours = UNPLAYED, fives = UNPLAYED, six = UNPLAYED,
			pair = UNPLAYED, twoPair = UNPLAYED, set = UNPLAYED, care = UNPLAYED, evens = UNPLAYED, 
			odds = UNPLAYED, littleStreet = UNPLAYED, bigStreet = UNPLAYED, mizer = UNPLAYED, sum = UNPLAYED,
			fullHouse = UNPLAYED, chance = UNPLAYED, poker = UNPLAYED, total = 0;
	
	private String mName;
	private int mPlayerIndex;
	private ChoiceListener mChoiceListener;
	
	// Properties
	
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
	
	public void setActive(boolean state, ResultManager result, boolean firstTry){
		isActive = state;
		updateView(result, firstTry);
	}	

	public String getName() {
		return mName;
	}
	
	public void setPlayerIndex(int index) {
		mPlayerIndex = index;
	}
	
	
	public PlayerTable(Context context, String name) {
		mContext = context;
		mName = name;
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		tablePlayer = inflater.inflate(R.layout.game_table_player, null);		
		
		tvName = (TextView)tablePlayer.findViewById(R.id.tvName);
		tvAces = (TextView)tablePlayer.findViewById(R.id.tvAces);
		tvTwos = (TextView)tablePlayer.findViewById(R.id.tvTwos);
		tvThrees = (TextView)tablePlayer.findViewById(R.id.tvThrees);
		tvFours = (TextView)tablePlayer.findViewById(R.id.tvFours);
		tvFives = (TextView)tablePlayer.findViewById(R.id.tvFives);
		tvSix = (TextView)tablePlayer.findViewById(R.id.tvSix);
		tvSchoolResult = (TextView)tablePlayer.findViewById(R.id.tvSchoolResult);
		
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
	
	public void setChoiceListener(ChoiceListener listener) {
		mChoiceListener = listener;
	}
	
	private void updateView(ResultManager result, boolean firstTry) {
		int bonus = (firstTry ? 2 : 1);
		
		if(isActive){
			if (aces == UNPLAYED) {
				tvAces.setText(String.valueOf(result.getSchool1()));
			}
			
			if (twos == UNPLAYED) {
				tvTwos.setText(String.valueOf(result.getSchool2()));
			}
			
			if (threes == UNPLAYED) {
				tvThrees.setText(String.valueOf(result.getSchool3()));
			}
			
			if (fours == UNPLAYED) {
				tvFours.setText(String.valueOf(result.getSchool4()));
			}
			
			if (fives == UNPLAYED) {
				tvFives.setText(String.valueOf(result.getSchool5()));
			}
			
			if (six == UNPLAYED) {
				tvSix.setText(String.valueOf(result.getSchool6()));
			}
			
			if (pair == UNPLAYED) {
				tvPair.setText(String.valueOf(result.getPair() * bonus));
			}
			
			if (twoPair == UNPLAYED) {
				tvTwoPair.setText(String.valueOf(result.getDoublePair() * bonus));
			}
			
			if (set == UNPLAYED) {
				tvSet.setText(String.valueOf(result.getSet() * bonus));
			}
			
			if (care == UNPLAYED) {
				tvCare.setText(String.valueOf(result.getCare() * bonus));
			}
			
			if (evens == UNPLAYED) {
				tvEvens.setText(String.valueOf(result.getEvens() * bonus));
			}
			
			if (odds == UNPLAYED) {
				tvOdds.setText(String.valueOf(result.getOdds() * bonus));
			}
			
			if (littleStreet == UNPLAYED) {
				tvLittleStreet.setText(String.valueOf(result.getLittleStreet() * bonus));
			}
			
			if (bigStreet == UNPLAYED) {
				tvBigStreet.setText(String.valueOf(result.getBigStreet() * bonus));
			}
			
			if (mizer == UNPLAYED) {
				tvMizer.setText(String.valueOf(result.getMizer() * bonus));
			}
			
			if (sum == UNPLAYED) {
				tvSum.setText(String.valueOf(result.getSum() * bonus));
			}
			
			if (fullHouse == UNPLAYED) {
				tvFullHouse.setText(String.valueOf(result.getFullHouse() * bonus));
			}
			
			if (chance == UNPLAYED) {
				ChanceGame game = calculateChance(result);
				
                if (game == null) {
                	Log.e(TAG, "Logic error in chance calc", new Throwable());
                }
                
                result.setChance(game.getScore());
				tvChance.setText(String.valueOf(game.getScore()));
				Log.d(TAG, "set Chance value twxt to : " + game.getScore());
			}
			
			if (poker == UNPLAYED) {
				tvPoker.setText(String.valueOf(result.getPoker() * bonus));
			}	
		} else {
			tvAces.setText((aces == UNPLAYED) ? "" : String.valueOf(aces));
			tvTwos.setText((twos == UNPLAYED) ? "" : String.valueOf(twos));
			tvThrees.setText((threes == UNPLAYED) ? "" : String.valueOf(threes));
			tvFours.setText((fours == UNPLAYED) ? "" : String.valueOf(fours));
			tvFives.setText((fives == UNPLAYED) ? "" : String.valueOf(fives));
			tvSix.setText((six == UNPLAYED) ? "" : String.valueOf(six));
			
			tvPair.setText((pair == UNPLAYED) ? "" : String.valueOf(pair));
			tvTwoPair.setText((twoPair == UNPLAYED) ? "" : String.valueOf(twoPair));
			tvSet.setText((set == UNPLAYED) ? "" : String.valueOf(set));
			tvCare.setText((care == UNPLAYED) ? "" : String.valueOf(care));
			tvEvens.setText((evens == UNPLAYED) ? "" : String.valueOf(evens));
			tvOdds.setText((odds == UNPLAYED) ? "" : String.valueOf(odds));
			tvLittleStreet.setText((littleStreet == UNPLAYED) ? "" : String.valueOf(littleStreet));
			tvBigStreet.setText((bigStreet == UNPLAYED) ? "" : String.valueOf(bigStreet));
			tvMizer.setText((mizer == UNPLAYED) ? "" : String.valueOf(mizer));
			tvSum.setText((sum == UNPLAYED) ? "" : String.valueOf(sum));
			tvFullHouse.setText((fullHouse == UNPLAYED) ? "" : String.valueOf(fullHouse));
			tvChance.setText((chance == UNPLAYED) ? "" : String.valueOf(chance));
			tvPoker.setText((poker == UNPLAYED) ? "" : String.valueOf(poker));
		}
		
		tvSchoolResult.setText(String.valueOf(calculateSchoolResult()));
		tvTotal.setText(String.valueOf(calculateTotalResult()));
		
		changeDrawable(tvAces, llAces, aces, result.getSchool1());
		changeDrawable(tvTwos, llTwos, twos, result.getSchool2());
		changeDrawable(tvThrees, llThrees, threes, result.getSchool3());
		changeDrawable(tvFours, llFours, fours, result.getSchool4());
		changeDrawable(tvFives, llFives, fives, result.getSchool5());
		changeDrawable(tvSix, llSix, six, result.getSchool6());
		changeDrawable(tvPair, llPair, pair, result.getPair());
		changeDrawable(tvTwoPair, llTwoPair, twoPair, result.getDoublePair());
		changeDrawable(tvSet, llSet, set, result.getSet());
		changeDrawable(tvCare, llCare, care, result.getCare());
		changeDrawable(tvEvens, llEvens, evens, result.getEvens());
		changeDrawable(tvOdds, llOdds, odds, result.getOdds());
		changeDrawable(tvLittleStreet, llLittleStreet, littleStreet, getLittleStreet());
		changeDrawable(tvBigStreet, llBigStreet, bigStreet, result.getBigStreet());
		changeDrawable(tvMizer, llMizer, mizer, result.getMizer());
		changeDrawable(tvSum, llSum, sum, result.getSum());
		changeDrawable(tvFullHouse, llFullHouse, fullHouse, result.getFullHouse());
		changeDrawable(tvChance, llChance, chance, result.getChance());
		changeDrawable(tvPoker, llPoker, poker, result.getPoker());
	}
	
	private void changeDrawable(TextView text, LinearLayout layout, int score, int hintScore){
		if(isActive){
			if(score == UNPLAYED) {
				if (hintScore > 0) {
					layout.setBackgroundResource(R.drawable.feedback_green_cell);  // hint will be shown (to click)
				} else {
					layout.setBackgroundResource(R.drawable.feedback_red_cell);  // hint will be shown (to click)
				}

				text.setTextColor(mContext.getResources().getColor(R.color.beige));
			} else {
				layout.setBackgroundResource(R.color.beige);  // no hint
				text.setTextColor(mContext.getResources().getColor(R.color.black));
			}			
		} else {
			layout.setBackgroundResource(android.R.color.transparent); // other players scores
			text.setTextColor(mContext.getResources().getColor(R.color.black));
		}
	}
	
	private ChanceGame calculateChance(ResultManager r) {	
		if (chance != UNPLAYED) {
			return null; // TODO: think about the logic
		}
		
		int score = 0;
		String name = "";
		
		if (r.getPair() > score) {
			score = r.getPair();
			name = "pair";
		}
		
		if (r.getDoublePair() > score) {
			score = r.getDoublePair();
			name = "double pair";
		}
		
		if (r.getSet() > score) {
			score = r.getSet();
			name = "set";
		}
		
		if (r.getCare() > score) {
			score = r.getCare();
			name = "care";
		}
		
		if (r.getEvens() > score) {
			score = r.getEvens();
			name = "evens";
		}
		
		if (r.getOdds() > score) {
			score = r.getOdds();
			name = "odds";
		}
		
		if (r.getLittleStreet() > score) {
			score = r.getLittleStreet();
			name = "little Street";
		}
		
		if (r.getBigStreet() > score) {
			score = r.getBigStreet();
			name = "big sxtreet";
		}
		
		if (r.getMizer() > score) {
			score = r.getMizer();
			name = "mizer";
		}
		
		if (r.getSum() > score) {
			score = r.getSum();
			name = "sum";
		}
		
		if (r.getFullHouse() > score) {
			score = r.getFullHouse();
			name = "full House";
		}
		
		if (r.getPoker() > score) {
			score = r.getPoker();
			name = "poker";
		}
		
		ChanceGame game = new ChanceGame(score, name);
		return game;
	}
	
	private int calculateSchoolResult() {
		int[] schools = new int[6];
		int sum = 0;
		
		schools[0] = aces;
		schools[1] = twos;
		schools[2] = threes;
		schools[3] = fours;
		schools[4] = fives;
		schools[5] = six;
		
		for (int i = 0; i < schools.length; i++) {
			int s = schools[i];
			
			if (s == UNPLAYED) {
				s = 0;
			}
			sum += s;
		}
		
		return sum;
	}
	
	private int calculateTotalResult() {
		int sum = 0;
		
		if (pair > 0) {
			sum += pair;
		}
		
		if (twoPair > 0) {
			sum += twoPair;
		}
		
		if (set > 0) {
			sum += set;
		}
		
		if (care > 0) {
			sum += care;
		}
		
		if (evens > 0) {
			sum += evens;
		}
		
		if (odds > 0) {
			sum += odds;
		}
		
		if (littleStreet > 0) {
			sum += littleStreet;
		}
		
		if (bigStreet > 0) {
			sum += bigStreet;
		}
		
		if (mizer > 0) {
			sum += mizer;
		}
		
		if (this.sum > 0) {
			sum += this.sum;
		}
		
		if (fullHouse > 0) {
			sum += fullHouse;
		}
		
		if (chance > 0) {
			sum += chance;
		}
		
		if (poker > 0) {
			sum += poker;
		}
		
		return calculateSchoolResult() + sum;
	}
	
	// listeners
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.llAces:
			Toast.makeText(mContext, "Еденицы", Toast.LENGTH_SHORT).show();
			mChoiceListener.onChoice(1, mPlayerIndex);
			// tvAces.set
			break;
			
		case R.id.llTwos:
			Toast.makeText(mContext, "Двойки", Toast.LENGTH_SHORT).show();
			mChoiceListener.onChoice(2, mPlayerIndex);
			break;
			
		case R.id.llThrees:
			Toast.makeText(mContext, "threes", Toast.LENGTH_SHORT).show();
			mChoiceListener.onChoice(3, mPlayerIndex);
			break;
			
		case R.id.llFours:
			Toast.makeText(mContext, "fours", Toast.LENGTH_SHORT).show();
			mChoiceListener.onChoice(4, mPlayerIndex);
			break;
			
		case R.id.llFives:
			Toast.makeText(mContext, "Fives", Toast.LENGTH_SHORT).show();
			mChoiceListener.onChoice(5, mPlayerIndex);
			break;
			
		case R.id.llSix:
			Toast.makeText(mContext, "Sixes", Toast.LENGTH_SHORT).show();
			mChoiceListener.onChoice(6, mPlayerIndex);
			break;
			
		case R.id.llPair:
			Toast.makeText(mContext, "Pair", Toast.LENGTH_SHORT).show();
			mChoiceListener.onChoice(7, mPlayerIndex);
			break;
			
		case R.id.llTwoPair:
			Toast.makeText(mContext, "Two Pair", Toast.LENGTH_SHORT).show();
			mChoiceListener.onChoice(8, mPlayerIndex);
			break;
			
		case R.id.llSet:
			Toast.makeText(mContext, "Set", Toast.LENGTH_SHORT).show();
			mChoiceListener.onChoice(9, mPlayerIndex);
			break;
			
		case R.id.llCare:
			Toast.makeText(mContext, "Care", Toast.LENGTH_SHORT).show();
			mChoiceListener.onChoice(10, mPlayerIndex);
			break;
			
		case R.id.llEvens:
			Toast.makeText(mContext, "Sixes", Toast.LENGTH_SHORT).show();
			mChoiceListener.onChoice(11, mPlayerIndex);
			break;
			
		case R.id.llOdds:
			Toast.makeText(mContext, "Odds", Toast.LENGTH_SHORT).show();
			mChoiceListener.onChoice(12, mPlayerIndex);
			break;
			
		case R.id.llLittleStreet:
			Toast.makeText(mContext, "little Street", Toast.LENGTH_SHORT).show();
			mChoiceListener.onChoice(13, mPlayerIndex);
			break;
			
		case R.id.llBigStreet:
			Toast.makeText(mContext, "Big Street", Toast.LENGTH_SHORT).show();
			mChoiceListener.onChoice(14, mPlayerIndex);
			break;
			
		case R.id.llMizer:
			Toast.makeText(mContext, "Mizer", Toast.LENGTH_SHORT).show();
			mChoiceListener.onChoice(15, mPlayerIndex);
			break;
			
		case R.id.llSum:
			Toast.makeText(mContext, "Sum", Toast.LENGTH_SHORT).show();
			mChoiceListener.onChoice(16, mPlayerIndex);
			break;
			
		case R.id.llFullHouse:
			Toast.makeText(mContext, "FullHouse", Toast.LENGTH_SHORT).show();
			mChoiceListener.onChoice(17, mPlayerIndex);
			break;
			
		case R.id.llChance:
			Toast.makeText(mContext, "Chance", Toast.LENGTH_SHORT).show();
			mChoiceListener.onChoice(18, mPlayerIndex);
			break;
			
		case R.id.llPoker:
			Toast.makeText(mContext, "Poker", Toast.LENGTH_SHORT).show();
			mChoiceListener.onChoice(19, mPlayerIndex);
			break;

		default:
			break;
		}
	}
}

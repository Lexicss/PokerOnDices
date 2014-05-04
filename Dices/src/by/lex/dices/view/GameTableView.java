package by.lex.dices.view;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
import by.lex.dices.R;
import by.lex.dices.entity.PlayerTable;
import by.lex.dices.interfaces.ChangePlayerListener;
import by.lex.dices.interfaces.ChoiceListener;
import by.lex.dices.manager.PlayerManager;
import by.lex.dices.manager.ResultManager;

public class GameTableView extends FrameLayout implements ChoiceListener {
	private final String TAG = this.getClass().getName();

	public enum Status {
		// able to throw ?
		STATUS_WILL_THROW, // has 3 attemps
		STATUS_DID_THROW, // has 1 or 2 attemps
		STATUS_EXPIRED, // has no attemps
		STATUS_PLAYED //
	}
	
	private int mNumber = 0;
//	private ImageView ivOne, ivTwo, ivThree;
	private LinearLayout playerContent;
	private List<PlayerTable> playerTableList = new ArrayList<PlayerTable>();
	private PlayerManager mManager;
	private ChangePlayerListener mChangePlayerListener;
//	private int countPlayers = 1; // default
	private Status mStatus = Status.STATUS_WILL_THROW;
	private Context mContext;
	
	public GameTableView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mContext = context;
		
		if(!isInEditMode()){
			initControl();			
		}
	}

	public GameTableView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		
		if(!isInEditMode()){
			initControl();			
		}
	}

	public GameTableView(Context context) {
		super(context);
		mContext = context;
		
		if(!isInEditMode()){
			initControl();			
		}
	}
	
	public void setPlayers(String... name){
		for (int i = 0; i < name.length; i++) {
			PlayerTable table = new PlayerTable(getContext(), name[i]);
			table.setPlayerIndex(i);
			table.setChoiceListener(this);
			playerTableList.add(table);
			playerContent.addView(playerTableList.get(i).getView());
		}
		
		mStatus = Status.STATUS_WILL_THROW;
	}
	
	public void setChangePlayerListener(ChangePlayerListener listener) {
		mChangePlayerListener = listener;
	}
	
	/**
	 * Returns the element at the specified location in this Table players.
	 * @param index of the element to return. 
	 * @return the element at the specified location.
	 * @throws
	 * IndexOutOfBoundsException  if location < 0 || location >= size()
	 */
	public PlayerTable getPlayerTable(int index) throws IndexOutOfBoundsException { 
//		if(index > listPlayers.size())Log.e(tag, "Index out of bounde exeption");
		return playerTableList.get(index);
	}

	private void initControl() {
		LayoutInflater li = ((Activity) getContext()).getLayoutInflater();		
        li.inflate(R.layout.game_table, this);
        
        playerContent = (LinearLayout)findViewById(R.id.playersContainer);
		
//		playerContent.addView(tablePlayer);
        
//        ivOne = (ImageView)findViewById(R.id.ivOne);
//        ivTwo = (ImageView)findViewById(R.id.ivTwo);
//        ivThree = (ImageView)findViewById(R.id.ivThree);
        
//        ivOne.setImageResource(R.drawable.dot_passive);
//        ivTwo.setImageResource(R.drawable.dot_passive);
//        ivThree.setImageResource(R.drawable.dot_passive);
	}
	
	public PlayerManager getManager() {
		return mManager;
	}
	
	public void setManager(PlayerManager m) {
		mManager = m;
		PlayerTable[] players = m.getPlayers();
		Log.d(TAG, "Players set: " + players.length);
		
		for (int i = 0; i < players.length; i++) {
			//PlayerTable table = new PlayerTable(getContext(), players[i].getName());
			//table.setChoiceListener(this);
			players[i].setChoiceListener(this);
			playerTableList.add(players[i]);
			playerContent.addView(playerTableList.get(i).getView());
		}
	}

	// Listeners
	
	@Override
	public void onChoice(int gameId, int playerIndex) {
		if (mNumber == 0) {
			return;
		}
		
		boolean played = true;
		int bonus = (mNumber == 1 ? 2 : 1);
		PlayerTable player = mManager.getActivePlayer();

		switch (gameId) {
		case 1:
			Log.d("lex", player.getName() + " wants to play aces");
			player.setAces(ResultManager.getInstance().getSchool1());
			break;
		case 2:
			Log.d("lex", player.getName() + " wants to play twos");
			player.setTwos(ResultManager.getInstance().getSchool2());
			break;
		case 3:
			Log.d("lex", player.getName() + " wants to play threes ");
			player.setThrees(ResultManager.getInstance().getSchool3());
			break;
		case 4:
			Log.d("lex", player.getName() + " wants to play fours ");
			player.setFours(ResultManager.getInstance().getSchool4());
			break;
		case 5:
			Log.d("lex", player.getName() + " wants to play fives ");
			player.setFives(ResultManager.getInstance().getSchool5());
			break;
		case 6:
			Log.d("lex", player.getName() + " wants to play sixes ");
			player.setSix(ResultManager.getInstance().getSchool6());
			break;
		case 7:
			Log.d("lex", player.getName() + " wants to play pair ");
			player.setPair(ResultManager.getInstance().getPair() * bonus);
			break;
		case 8:
			Log.d("lex", player.getName() + " wants to play double pair ");
			player.setTwoPair(ResultManager.getInstance().getDoublePair() * bonus);
			break;
		case 9:
			Log.d("lex", player.getName() + " wants to play set ");
			player.setSet(ResultManager.getInstance().getSet() * bonus);
			break;
		case 10:
			Log.d("lex", player.getName() + " wants to play care ");
			player.setCare(ResultManager.getInstance().getCare() * bonus);
			break;
		case 11:
			Log.d("lex", player.getName() + " wants to play evens ");
			player.setEvens(ResultManager.getInstance().getEvens() * bonus);
			break;
		case 12:
			player.setOdds(ResultManager.getInstance().getOdds() * bonus);
			break;
		case 13:
			player.setLittleStreet(ResultManager.getInstance().getLittleStreet() * bonus);
			break;
		case 14:
			player.setBigStreet(ResultManager.getInstance().getBigStreet() * bonus);
			break;
		case 15:
			player.setMizer(ResultManager.getInstance().getMizer() * bonus);
			break;
		case 16:
			player.setSum(ResultManager.getInstance().getSum() * bonus);
			break;
		case 17:
			player.setFullHouse(ResultManager.getInstance().getFullHouse() * bonus);
			break;
		case 18:
			player.setChance(ResultManager.getInstance().getChance());
			break;
		case 19:
			player.setPoker(ResultManager.getInstance().getPoker() * bonus);
			break;
			
		default:
			played = false;
			break;

		}
		
		if (!played) {
			Toast.makeText(mContext, "Please select a right cell to play a game", Toast.LENGTH_SHORT).show();
			return;
		}
		
		//update The table due to playersList scores
		PlayerTable tracePlayer = mManager.nextPlayer();
		
		if (tracePlayer == null) {
			//TODO: Game over
			//Calculate the result
		}
		
		Log.d("lex", "Now is turn for: " + tracePlayer.getName());
		
		mChangePlayerListener.onNextPlayer(mManager.getActivePlayerIndex());
		mNumber = 0;
	}

	
	public boolean allowToThrow() {
		if (mNumber >= 3) {
			return false;
		}
		
		mNumber++;
		return true;
	}
	
	public void setActivePlayerTable(int index, ResultManager result) {
		for (int i = 0; i < playerTableList.size(); i++) {
			getPlayerTable(i).setActive(i == index, result, mNumber == 1);
		}
	}
}

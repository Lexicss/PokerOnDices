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
import by.lex.dices.R;
import by.lex.dices.entity.Player;
import by.lex.dices.entity.PlayerTable;
import by.lex.dices.interfaces.ChangePlayerListener;
import by.lex.dices.interfaces.ChoiceListener;
import by.lex.dices.manager.PlayerManager;
import by.lex.dices.manager.ResultManager;

public class GameTableView extends FrameLayout implements ChoiceListener {

	private int mNumber;
//	private ImageView ivOne, ivTwo, ivThree;
	private LinearLayout playerContent;
	private List<PlayerTable> playerTableList = new ArrayList<PlayerTable>();
	private PlayerManager mManager;
	private ChangePlayerListener mChangePlayerListener;
//	private int countPlayers = 1; // default
	
	public GameTableView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		if(!isInEditMode()){
			initControl();			
		}
	}

	public GameTableView(Context context, AttributeSet attrs) {
		super(context, attrs);
		if(!isInEditMode()){
			initControl();			
		}
	}

	public GameTableView(Context context) {
		super(context);
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
		Player[] players = m.getPlayers();
		Log.d("lex", "Players set: " + players.length);
		
		for (int i = 0; i < players.length; i++) {
			PlayerTable table = new PlayerTable(getContext(), players[i].getName());
			table.setChoiceListener(this);
			playerTableList.add(table);
			playerContent.addView(playerTableList.get(i).getView());
		}
	}

	@Override
	public void onChoice(int gameId, int playerIndex) {
		Player player = mManager.getActivePlayer();

		switch (gameId) {
		case 1:
			Log.d("lex", player.getName() + " wants to play aces");
			player.setmSchool1(ResultManager.getInstance().getSchool1());
			break;
		case 2:
			Log.d("lex", player.getName() + " wants to play twos");
			player.setmSchool2(ResultManager.getInstance().getSchool2());
			break;
		case 3:
			Log.d("lex", player.getName() + " wants to play threes ");
			player.setmSchool3(ResultManager.getInstance().getSchool3());
			break;

		}
		
		//update The table due to playersList scores
		Player tracePlayer = mManager.nextPlayer();
		Log.d("lex", "Now is turn for: " + tracePlayer.getName());
		
		mChangePlayerListener.onNextPlayer(mManager.getActivePlayerIndex());
	}

}

package by.lex.dices.view;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import by.lex.dices.R;
import by.lex.dices.entity.PlayerTable;

public class GameTableView extends FrameLayout {

	private int mNumber;
//	private ImageView ivOne, ivTwo, ivThree;
	private LinearLayout playerContent;
	private List<PlayerTable> listPlayers = new ArrayList<PlayerTable>();
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
			listPlayers.add(new PlayerTable(getContext(), name[i]));
			playerContent.addView(listPlayers.get(i).getView());
		}		
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
		return listPlayers.get(index);
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
	


}

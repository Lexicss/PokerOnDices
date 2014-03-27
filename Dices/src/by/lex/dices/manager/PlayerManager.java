package by.lex.dices.manager;

import by.lex.dices.entity.Player;

public class PlayerManager {
	private final int MAX_LOOP = 19;
	
	private Player[] mPlayers;
	private int mActivePlayerIndex;
	private int mLoopNumber;
	
	private static PlayerManager mInstance;
	
	public static PlayerManager getInstance() {
		if (mInstance == null) {
			mInstance = new PlayerManager();
		}
		
		return mInstance;
	}
	
	private PlayerManager() {
		mPlayers = null;
		mActivePlayerIndex = -1;
		mLoopNumber = 0;
	}
	
	public Player[] getPlayers() {
		return mPlayers;
	}
	public void setPlayers(Player[] players) {
		mPlayers = players;
		mActivePlayerIndex = 0;
		mLoopNumber = 1;
	}
	
	public Player getActivePlayer() {
		if (mActivePlayerIndex == -1) {
			return null;
		}
		
		return mPlayers[mActivePlayerIndex];
	}
	
	public int getLoopNumber() {
		return mLoopNumber;
	}
	
	public int getActivePlayerIndex() {
		return mActivePlayerIndex;
	}
	public void setActivePlayerIndex(int activePlayerIndex) {
		if (mPlayers == null) {
			return;
		}
		
		if (activePlayerIndex < 0 || activePlayerIndex > mPlayers.length - 1) {
			mActivePlayerIndex = 0;
		} else {
			mActivePlayerIndex = activePlayerIndex;
		}
	}
	
	public int getPlayersCount() {
		return mPlayers.length;
	}
	
	public Player nextPlayer() {
		mActivePlayerIndex++;
		
		if (mActivePlayerIndex >= getPlayersCount()) {
			mActivePlayerIndex = 0;
			mLoopNumber++;
		}
		
		// Game over
		if (mLoopNumber > MAX_LOOP) {
			return null;
		}
		
		return mPlayers[mActivePlayerIndex];
	}

}

package by.lex.dices.manager;

import by.lex.dices.entity.Player;

public class PlayerManager {
	private Player[] mPlayers;
	private int mActivePlayerIndex;
	
	private static PlayerManager mInstance;
	
	public static PlayerManager getInstance() {
		if (mInstance == null) {
			mInstance = new PlayerManager();
		}
		
		return mInstance;
	}
	
	private PlayerManager() {
		mActivePlayerIndex = -1;
	}
	
	public Player[] getPlayers() {
		return mPlayers;
	}
	public void setPlayers(Player[] players) {
		mPlayers = players;
		mActivePlayerIndex = 0;
	}
	
	public Player getActivePlayer() {
		if (mActivePlayerIndex == -1) {
			return null;
		}
		
		return mPlayers[mActivePlayerIndex];
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
		}
		
		return mPlayers[mActivePlayerIndex];
	}

}

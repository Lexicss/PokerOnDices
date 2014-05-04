package by.lex.dices.manager;

import android.util.Log;
import by.lex.dices.entity.PlayerTable;



public class PlayerManager {
	private final int MAX_LOOP = 19;
	private final String TAG = this.getClass().getSimpleName();	

	private PlayerTable[] mPlayers;
	private int mActivePlayerIndex;
	private int mLoopNumber;
	private boolean mIsStarted;
	
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
		mIsStarted = false;
	}
	
	public PlayerTable[] getPlayers() {
		return mPlayers;
	}
	
	public void setPlayers(PlayerTable[] players) {
		mPlayers = players;
		mActivePlayerIndex = 0;
		mLoopNumber = 1;
		Log.d(TAG, "setPlayers: " + players.length);
	}
	
	public PlayerTable getActivePlayer() {
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
	
	public PlayerTable nextPlayer() {
		mActivePlayerIndex++;
		
		if (mActivePlayerIndex >= getPlayersCount()) {
			mActivePlayerIndex = 0;
			mLoopNumber++;
		}
		
		// Game over
		if (mLoopNumber > MAX_LOOP) {
			mIsStarted = false;
			return null;
		}
		
		return mPlayers[mActivePlayerIndex];
	}
	
	public boolean isStarted() {
		return mIsStarted;
	}
	
	public boolean start() {
		Log.d(TAG, "start");
		
		if (mIsStarted) {
			Log.w(TAG, "ALready started");
			return false;
		}
		
		if (mPlayers == null || mPlayers.length == 0) {
			Log.e(TAG, "Failed to start, Players are not assigned");
			return false;
		}
		
		mIsStarted = true;
		
		return true;
	}
	
	public void stop() {
		mIsStarted = false;
	}

}

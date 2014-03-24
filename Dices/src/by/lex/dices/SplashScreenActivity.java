package by.lex.dices;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import by.lex.dices.activity.MainActivity;
import by.lex.dices.view.GifDecoderView;

public class SplashScreenActivity extends Activity {
	private static final int SPLASH_TIME = 1 * 1000;
	private boolean stopDelay;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		
		setContentView(R.layout.activity_splash);
		
		FrameLayout gifContainer = (FrameLayout)findViewById(R.id.flGif);
		gifContainer.addView(loadGif());
		
		try {
			new Handler().postDelayed(new Runnable() {

				public void run() {
					if(stopDelay) return;
					
					Intent 	intent = new Intent(SplashScreenActivity.this, MainActivity.class);
					startActivity(intent);

					SplashScreenActivity.this.finish();
				}

			}, SPLASH_TIME);
		} catch (Exception e) {
		}
	}

	@Override
	public void onBackPressed() {
		this.finish();
		stopDelay = true;
		super.onBackPressed();
	}
	
	private View loadGif(){
		InputStream stream = null;
	    try {
	        stream = getAssets().open("animated_dice_red.gif");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    GifDecoderView view = new GifDecoderView(this, stream);
	    return view;
	}
}

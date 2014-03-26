package by.lex.dices.activity;

import by.lex.dices.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		Button btnSingle = (Button)findViewById(R.id.btnSingle);
		Button btnMulty = (Button)findViewById(R.id.btnMultiplayer);
		Button btnRules = (Button)findViewById(R.id.btnRules);
		
		btnSingle.setOnClickListener(this);
		btnMulty.setOnClickListener(this);
		btnRules.setOnClickListener(this);
		
		TextView tvAppVersion = (TextView)findViewById(R.id.tvAppVersion);
		try {
			tvAppVersion.setText(getString(R.string.app_version, getPackageManager().getPackageInfo(getPackageName(), 0).versionName));
		} catch (Exception e) {
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnSingle:
			startActivity(new Intent(this, MainActivity.class));
			break;

		case R.id.btnMultiplayer:
			Toast.makeText(this, "Идет стройка", Toast.LENGTH_SHORT).show();
			break;
			
		case R.id.btnRules:
			Toast.makeText(this, "Пишутся правила", Toast.LENGTH_SHORT).show();
			break;
		}
	}
}

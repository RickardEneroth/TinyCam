package se.eneroth.tinycam;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import se.eneroth.R;

public class ShowBp extends Activity {
	private Activity activity;
	private Bundle extras;
	
	/**
	 * Startingpoint of application
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		extras = getIntent().getExtras();
        requestWindowFeature(Window.FEATURE_NO_TITLE);        
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		activity = this;		
		setContentView(R.layout.showbp);
		TextView tv = (TextView) findViewById(R.id.texten);
		tv.setText(extras.getString("url"));
	}
	
	public void onResume() {
		super.onResume();
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}
}

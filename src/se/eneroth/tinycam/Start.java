package se.eneroth.tinycam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import se.eneroth.R;

/**
 * Main start for BeamonPeople
 * 
 * @author Rickard Eneroth, Beamon Consulting, 2013
 * 
 */
public class Start extends Activity {
	private Button button1;
	private Activity activity;
	
	/**
	 * Startingpoint of application
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);        
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		activity = this;		
		setContentView(R.layout.main);
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(buttonClickListener);
	}
	
	public void onResume() {
		super.onResume();
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}
	
	/**
	 * Handle all button clicks in activity
	 */
	private OnClickListener buttonClickListener = new OnClickListener() {
		public void onClick(View view) {
			if (view == button1) {				
				startActivity(new Intent(activity, BPList.class));
			}
		}
	};
}

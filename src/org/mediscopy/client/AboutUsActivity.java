package org.mediscopy.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AboutUsActivity extends Activity {
	private Button backButton;
	private Button disclaimerButton;
	
	 @Override
     public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        
        backButton = (Button)findViewById(R.id.backButton);
        backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent backHome = new Intent(getApplicationContext(), MainMenuActivity.class);
				startActivity(backHome);
			}
        });
        
        disclaimerButton = (Button)findViewById(R.id.disclaimerBtn);
        disclaimerButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent disclaimerIntent = new Intent(getApplicationContext(), DisclaimerActivity.class);
				disclaimerIntent.putExtra("caller", MediscopyConstants.ABOUTUS_ACTIVITY);
				startActivity(disclaimerIntent);
			}
        	
        });
	 }
}

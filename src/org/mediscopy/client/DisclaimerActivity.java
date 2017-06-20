package org.mediscopy.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DisclaimerActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.disclaimer);
		
		Button backButton = (Button)findViewById(R.id.backButton);
		backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				int callingActivity = getIntent().getIntExtra("caller", MediscopyConstants.MAINMENU_ACTIVITY);
				
				switch(callingActivity) {
				case MediscopyConstants.ABOUTUS_ACTIVITY :
					Intent aboutUs = new Intent(getApplicationContext(), AboutUsActivity.class);
					startActivity(aboutUs);
					break;
				case MediscopyConstants.ARTICLES_ACTIVITY :
					Intent articleIntent = new Intent(getApplicationContext(), ArticlesActivity.class);
					startActivity(articleIntent);
					break;
				case MediscopyConstants.BODYMASSINDEX_ACTIVITY:
					Intent bmiIntent = new Intent(getApplicationContext(), BodyMassIndexActivity.class);
					startActivity(bmiIntent);
					break;
				case MediscopyConstants.ESTIMATEAGEOFPREGNANCY_ACTIVITY:
					Intent pregAgeIntent = new Intent(getApplicationContext(), EstimateAgeOfPregnancyActivity.class);
					startActivity(pregAgeIntent);
					break;
				case MediscopyConstants.ESTIMATEDDELIVERYDATE_ACTIVITY:
					Intent eddIntent = new Intent(getApplicationContext(), EstimatedDeliveryDateActivity.class);
					startActivity(eddIntent);
					break;
				case MediscopyConstants.MAINMENU_ACTIVITY:
					Intent mainMenu = new Intent(getApplicationContext(), MainMenuActivity.class);
					startActivity(mainMenu);
					break;
				case MediscopyConstants.SAFEDAYSCALCULATOR_ACTIVITY:
					Intent safeDaysIntent = new Intent(getApplicationContext(), SafeDaysCalculatorActivity.class);
					startActivity(safeDaysIntent);
					break;
				case MediscopyConstants.VIEWPICTURE_ACTIVITY:
					Intent intent = new Intent(getApplicationContext(), EstimateAgeOfPregnancyActivity.class);
					startActivity(intent);
				}
			}
			
		});
	}
}

package org.mediscopy.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public abstract class DashboardActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	protected void onDestroy() {
		super.onDestroy();
	}
	
	protected void onPause() {
		super.onPause();
	}

	protected void onRestart() {
		super.onRestart();
	}

	protected void onResume() {
		super.onResume();
	}

	protected void onStart() {
		super.onStart();
	}

	protected void onStop() {
		super.onStop();
	}
	
	public void onClickFeature(View v) {
		int id = v.getId();
		switch (id) {
		case R.id.bmi:
			Intent bmiIntent = new Intent(getApplicationContext(), BodyMassIndexActivity.class);
			startActivity(bmiIntent);
			break;
		case R.id.pregage:
			Intent preAgeIntent = new Intent(getApplicationContext(), EstimateAgeOfPregnancyActivity.class);
			startActivity(preAgeIntent);
			break;
		case R.id.edd:
			Intent eddIntent = new Intent(getApplicationContext(), EstimatedDeliveryDateActivity.class);
			startActivity(eddIntent);
			break;
		case R.id.about:
			Intent aboutUs = new Intent(getApplicationContext(), AboutUsActivity.class);
			startActivity(aboutUs);
			break;
		case R.id.articles:
			Intent articleIntent = new Intent(getApplicationContext(), ArticlesActivity.class);
			startActivity(articleIntent);
			break;
		case R.id.safedays:
			Intent safeDaysIntent = new Intent(getApplicationContext(), SafeDaysCalculatorActivity.class);
			startActivity(safeDaysIntent);
			break;
		default:
			break;
		}
	}
}

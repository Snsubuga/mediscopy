package org.mediscopy.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SafeDaysCalculatorActivity extends Activity {

	int shortCycle = 0;
	int longCycle = 0;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.safedayscalculator);

		Button backButton = (Button) findViewById(R.id.back);
		backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						MainMenuActivity.class);
				startActivity(intent);
			}

		});
		
		Button disclaimerBtn = (Button)findViewById(R.id.disclaimerBtn);
		disclaimerBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent disclaimerIntent = new Intent(getApplicationContext(), DisclaimerActivity.class);
				disclaimerIntent.putExtra("caller", MediscopyConstants.SAFEDAYSCALCULATOR_ACTIVITY);
				startActivity(disclaimerIntent);
			}
			
		});

		Button calcBtn = (Button) findViewById(R.id.calculate);
		calcBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				EditText shortCycleET = (EditText) findViewById(R.id.enter_short);
				String shortText = shortCycleET.getText().toString().trim();
				if (shortText != "" && shortText.length() > 0) {
					shortCycle = Integer.parseInt(shortText);
				}

				EditText longCycleET = (EditText) findViewById(R.id.enter_long);
				String longText = longCycleET.getText().toString();
				if (longText != "" && longText.length() > 0) {
					longCycle = Integer.parseInt(longText);
				}

				TextView results = (TextView) findViewById(R.id.safe_days);
				if (shortCycle != 0 && longCycle != 0 && shortCycle > 20
						&& shortCycle < 33 && longCycle > 20 && longCycle < 36 && shortCycle <= longCycle) {
					int start = shortCycle - 18;
					int end = longCycle - 11;

					results.setText("Your fertile days start from day "
							+ start
							+ " and end on day "
							+ end
							+ ". You should avoid intercourse during these days if you do not want to get pregnant.");
				} else {
					results.setText("Please enter valid data");
				}
			}

		});
		
		Button illustration = (Button)findViewById(R.id.example);
		illustration.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent exampleIntent = new Intent(getApplicationContext(), SafeDaysExampleActivity.class);
				startActivity(exampleIntent);
			}
		});
	}
}

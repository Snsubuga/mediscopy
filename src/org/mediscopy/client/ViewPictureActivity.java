package org.mediscopy.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewPictureActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.pregpic);
        ImageView image = (ImageView)findViewById(R.id.test_image);
        image.setOnTouchListener(new TouchMe());
        
        long weeks = this.getIntent().getLongExtra("weeks", 4);
        Button backButton = (Button)findViewById(R.id.back_button);
        backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent back = new Intent(getApplicationContext(), MainMenuActivity.class);
				startActivity(back);
			}
        	
        });
        
        Button disclaimerButton = (Button)findViewById(R.id.disclaimerBtn);
        disclaimerButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent disclaimerIntent = new Intent(getApplicationContext(), DisclaimerActivity.class);
				disclaimerIntent.putExtra("caller", MediscopyConstants.VIEWPICTURE_ACTIVITY);
				startActivity(disclaimerIntent);
			}
        });
        
        TextView introText = (TextView)findViewById(R.id.introtext);
        introText.setText("Your baby is about " + weeks + " weeks old");
        if (weeks <= 4) {
        	introText.setText("Your baby is close to 4 weeks old, and that stage looks like this");
        	image.setImageResource(R.drawable.week4);
        }
        else if (weeks > 4 && weeks <= 8) {
        	image.setImageResource(R.drawable.week8);
        }
        else if (weeks > 8 && weeks <= 12) {
        	image.setImageResource(R.drawable.week12);
        }
        else if (weeks > 12 && weeks <= 16) {
        	image.setImageResource(R.drawable.week16);
        }
        else if (weeks > 16 && weeks <= 20) {
        	image.setImageResource(R.drawable.week20);
        }
        else if (weeks > 20 && weeks <= 24) {
        	image.setImageResource(R.drawable.week24);
        }
        else if (weeks > 24 && weeks <= 28) {
        	image.setImageResource(R.drawable.week28);
        }
        else if (weeks > 28 && weeks <= 32) {
        	image.setImageResource(R.drawable.week32);
        }
        else if (weeks > 32 && weeks <= 36) {
        	image.setImageResource(R.drawable.week36);
        }
        else if (weeks > 36 && weeks <= 40) {
        	image.setImageResource(R.drawable.week40);
        }
	}
}

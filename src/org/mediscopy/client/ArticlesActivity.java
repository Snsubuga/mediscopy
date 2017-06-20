package org.mediscopy.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ArticlesActivity extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.articles);
		
		Button safeDaysArticleBtn = (Button)findViewById(R.id.safedaysarticle);
		safeDaysArticleBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent safeDaysArticleIntent = new Intent(getApplicationContext(), SingleArticleViewActivity.class);
				safeDaysArticleIntent.putExtra(MediscopyConstants.ARTICLE, MediscopyConstants.SAFE_DAYS_ARTICLE);
				startActivity(safeDaysArticleIntent);
			}
			
		});
		
		Button breastCancerArticleBtn = (Button)findViewById(R.id.breastcancerarticle);
		breastCancerArticleBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent breastCancerArticleIntent = new Intent(getApplicationContext(), SingleArticleViewActivity.class);
				breastCancerArticleIntent.putExtra(MediscopyConstants.ARTICLE, MediscopyConstants.BREAST_CANCER_ARTICLE);
				startActivity(breastCancerArticleIntent);
			}
			
		});
		
		Button drySkinArticle = (Button)findViewById(R.id.dryskinarticle);
		drySkinArticle.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent drySkinArticleIntent = new Intent(getApplicationContext(), SingleArticleViewActivity.class);
				drySkinArticleIntent.putExtra(MediscopyConstants.ARTICLE, MediscopyConstants.DRY_SKIN_ARTICLE);
				startActivity(drySkinArticleIntent);
			}
			
		});
		
		Button hepatitisBArticle = (Button)findViewById(R.id.hepatitisbarticle);
		hepatitisBArticle.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent hepatitisBArticleIntent = new Intent(getApplicationContext(), SingleArticleViewActivity.class);
				hepatitisBArticleIntent.putExtra(MediscopyConstants.ARTICLE, MediscopyConstants.HEPATITIS_B_ARTICLE);
				startActivity(hepatitisBArticleIntent);
			}
			
		});
		
		Button crackedFeetArticle = (Button)findViewById(R.id.crackedfeetbarticle);
		crackedFeetArticle.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent crackedFeetArticleIntent = new Intent(getApplicationContext(), SingleArticleViewActivity.class);
				crackedFeetArticleIntent.putExtra(MediscopyConstants.ARTICLE, MediscopyConstants.CRACKED_FEET_ARTICLE);
				startActivity(crackedFeetArticleIntent);
			}
			
		});
		
		Button mediscopyWebsite = (Button)findViewById(R.id.mediscopywebsite);
		mediscopyWebsite.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent mediscopyWebsiteIntent = new Intent(getApplicationContext(), SingleArticleViewActivity.class);
				mediscopyWebsiteIntent.putExtra(MediscopyConstants.ARTICLE, MediscopyConstants.MEDISCOPY_WEBSITE);
				startActivity(mediscopyWebsiteIntent);
			}
			
		});
		
		Button backButton = (Button)findViewById(R.id.back);
		backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), MainMenuActivity.class);
				startActivity(intent);
			}
			
		});
		
		Button disclaimerButton = (Button)findViewById(R.id.disclaimerBtn);
		disclaimerButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent disclaimerIntent = new Intent(getApplicationContext(), DisclaimerActivity.class);
				disclaimerIntent.putExtra("caller", MediscopyConstants.ARTICLES_ACTIVITY);
				startActivity(disclaimerIntent);
			}	
		});
	}
}

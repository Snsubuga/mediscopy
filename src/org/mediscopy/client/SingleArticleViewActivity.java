package org.mediscopy.client;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;

public class SingleArticleViewActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);
		
		
		WebView webView = (WebView)findViewById(R.id.webView1);
		webView.getSettings().setJavaScriptEnabled(true);
		switch (this.getIntent().getIntExtra(MediscopyConstants.ARTICLE, MediscopyConstants.MEDISCOPY_WEBSITE)) {
		
			case MediscopyConstants.SAFE_DAYS_ARTICLE : webView.loadUrl("http://www.mediscopyug.com/journal/2012/10/05/heres-how-to-know-your-safe-days/");
			break;
				
			case MediscopyConstants.BREAST_CANCER_ARTICLE : webView.loadUrl("http://www.mediscopyug.com/journal/2012/07/04/what-causes-breast-cancer/");
			break;
			
			case MediscopyConstants.LOWER_BACK_PAIN_ARTICLE: webView.loadUrl("http://www.mediscopyug.com/journal/2012/08/08/tips-for-preventing-lower-back-pain/");
			break;
			
			case MediscopyConstants.DRY_SKIN_ARTICLE : webView.loadUrl("http://www.mediscopyug.com/journal/2012/09/21/6-ways-out-of-a-dry-skin/");
			break;
			
			case MediscopyConstants.HEPATITIS_B_ARTICLE : webView.loadUrl("http://www.mediscopyug.com/journal/2012/06/27/hepatitis-b-more-deadly-than-hiv/");
			break;
			
			case MediscopyConstants.CRACKED_FEET_ARTICLE: webView.loadUrl("http://www.mediscopyug.com/journal/2012/08/07/prevent-craking-of-the-feet/");
			break;
			
			default: 
				if (netCheckin()) {
					Uri uriUrl = Uri.parse("http://www.mediscopyug.com/journal/");
					Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
					startActivity(launchBrowser);
				}
				else {
					Toast.makeText(getApplicationContext(), MediscopyConstants.TURN_ON_DATA, Toast.LENGTH_LONG).show();
					Intent articleszzzz = new Intent(getApplicationContext(), ArticlesActivity.class);
					startActivity(articleszzzz);
					return;
				}
		}
		
		
	}
	
	private boolean netCheckin() {

	    try {

	        ConnectivityManager nInfo = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	        nInfo.getActiveNetworkInfo().isConnectedOrConnecting();

	        Log.d("CheckNetwork", "Net avail:"
	                + nInfo.getActiveNetworkInfo().isConnectedOrConnecting());

	        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	        NetworkInfo netInfo = cm.getActiveNetworkInfo();
	        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
	            Log.d("Network", "Network available:true");
	            return true;
	        } else {
	            Log.d("Network", "Network available:false");
	            return false;
	        }

	    } catch (Exception e) {
	        return false;
	    }
	}
}

package org.mediscopy.client;

import java.util.Calendar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class EstimateAgeOfPregnancyActivity extends Activity {
	private TextView displayDate;
	private TextView estimatedDeliveryDate;
	private Button pickDateButton;
	private Button backButton;
	private int mYear;
    private int mMonth;
    private int mDay;
    private long numOfWeeks = 0;
	private Button disclaimerBtn;
    
	static final int DATE_DIALOG_ID = 1;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.pregnancyage);
        
        Button viewPic = (Button)findViewById(R.id.picButton);
        viewPic.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent viewpic = new Intent(getApplicationContext(), ViewPictureActivity.class);
				viewpic.putExtra("weeks", numOfWeeks);
				startActivity(viewpic);
			}
        	
        });

        displayDate = (TextView)findViewById(R.id.displayDate);
        backButton = (Button)findViewById(R.id.backButton);
        backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent backIntent = new Intent(getApplicationContext(), MainMenuActivity.class);
				startActivity(backIntent);
			}
        	
        });
        
        disclaimerBtn = (Button)findViewById(R.id.disclaimerBtn);
        disclaimerBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent disclaimerIntent = new Intent(getApplicationContext(), DisclaimerActivity.class);
				disclaimerIntent.putExtra("caller", MediscopyConstants.ESTIMATEAGEOFPREGNANCY_ACTIVITY);
				startActivity(disclaimerIntent);
			}
        	
        });
        pickDateButton = (Button)findViewById(R.id.pickDate);
        pickDateButton.setText(getString(R.string.enter_lnmp));
        pickDateButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				showDialog(DATE_DIALOG_ID);	
			}
        });
        
        
        Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        updateDisplay();
        
        
        estimatedDeliveryDate = (TextView)findViewById(R.id.estimatedDeliveryDate);
        estimatedDeliveryDate.setText(estimatePregnancyAge(c));
        
	}
	
	@Override
    protected Dialog onCreateDialog(int id) {
            switch (id) {
            case DATE_DIALOG_ID:
                    return new DatePickerDialog(this,
                            mDateSetListener,
                            mYear, mMonth, mDay);
            }
            return null;
    }
    protected void onPrepareDialog(int id, Dialog dialog) {
            switch (id) {
            case DATE_DIALOG_ID:
                    ((DatePickerDialog) dialog).updateDate(mYear, mMonth, mDay);
                    break;
            }
    }    
    private void updateDisplay() {
    	displayDate.setText(
                    new StringBuilder()
                    .append(mDay).append("/")
                    // Month is 0 based so add 1
                    .append(mMonth + 1).append("/")
                    
                    .append(mYear).append(" "));
    }
    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                            int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    updateDisplay();
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.YEAR, year);
                    calendar.set(Calendar.MONTH, monthOfYear);
                    calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    estimatedDeliveryDate.setText(estimatePregnancyAge(calendar));
            }
    };
     
    public String estimatePregnancyAge(Calendar calendar) {
    	String dateString = " ";
    	Calendar today = Calendar.getInstance();
    	//String dateString2 = " This is an estimate, actual date lies in between ";
 
    	long milis1 = calendar.getTimeInMillis();
        long milis2 = today.getTimeInMillis();
        //
        // Calculate difference in milliseconds
        //
        long diff = milis2 - milis1;
 
        //
        // Calculate difference in days
        //
        long diffDays = diff / (24 * 60 * 60 * 1000);
        long diffWeeks = diffDays/7;
        if (diffWeeks > 40) {
        	return " You have entered wrong or invalid data";
        }
        else {
	        dateString = "The estimated age of the pregnancy is " + diffWeeks + (diffWeeks > 1 ? " weeks" : " week");
	        if ((diffDays%7) != 0) {
	        	long days = diffDays%7;
	        	dateString = dateString + " and " + String.valueOf(days) + (days > 1 ?" days":"day") ;
	        	
	        }
	        if (diffDays <=6 ){
	        	dateString = "The estimated age of the pregnancy is "+ diffDays + ((diffDays > 1) || (diffDays == 0)? " days" : " day");
	        	//pregPic.setImageResource(R.drawable.week4);
	        }
	        numOfWeeks = diffWeeks;
	        
	        long minimumDays = diffDays - 27;
	        long minimumWeeks = minimumDays/7;
	        String minimumDateString = "";
	        if (minimumDays < 0) {
	        	minimumDateString = "";
	        }
	        else if (minimumDays > 0 && minimumDays <= 7) {
	        	minimumDateString = minimumDays + " days ";
	        }
	        else if (minimumDays > 7) {
	        	if (minimumWeeks % 7 == 0) {
	        		minimumDateString = minimumWeeks + " weeks";
	        	}
	        	else {
	        		minimumDateString = minimumWeeks + "weeks & " + (minimumWeeks%7) + " days"; 
	        	}
	        }
	        long maximumDays = diffDays + 9;
	        long maximumWeeks = maximumDays/7;
	        String maximumDateString = "";
	
	
	    	if (minimumWeeks % 7 == 0) {
	    		maximumDateString = maximumWeeks + ((maximumWeeks != 1) ? " weeks" : "week");
	    	}
	    	else {
	    		maximumDateString = maximumWeeks + ((maximumWeeks != 1) ? "weeks & " : "week &") + (maximumWeeks%7) + ((maximumWeeks%7) != 1 ?" days" : " day"); 
	    	} 
	    	String text = ".This is an estimate, the actual age is between "+ (minimumDateString.equalsIgnoreCase("") ? diffDays + " days": minimumDateString) + 
	    			" and " + maximumDateString;
	    	return dateString + text;
	    }
    }
}

package org.mediscopy.client;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;

import java.util.Calendar;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;


public class EstimatedDeliveryDateActivity extends Activity {

	private TextView displayDate;
	private TextView estimatedDeliveryDate;
	private Button pickDateButton;
	private Button backButton;
	private int mYear;
    private int mMonth;
    private int mDay;
	private Button disclaimerButton;
    
	static final int DATE_DIALOG_ID = 1;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.edd);
        displayDate = (TextView)findViewById(R.id.displayDate);
        backButton = (Button)findViewById(R.id.backButton);
        backButton.setText(getString(R.string.back_to_main));
        backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent backIntent = new Intent(getApplicationContext(), MainMenuActivity.class);
				startActivity(backIntent);
			}
        });
        
        disclaimerButton = (Button)findViewById(R.id.disclaimerBtn);
        disclaimerButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent disclaimerIntent = new Intent(getApplicationContext(), DisclaimerActivity.class);
				disclaimerIntent.putExtra("caller", MediscopyConstants.ESTIMATEDDELIVERYDATE_ACTIVITY);
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
        estimatedDeliveryDate.setText(getEstimatedDeliveryDate(c));
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
                    estimatedDeliveryDate.setText(getEstimatedDeliveryDate(calendar));
            }
    };
     
    public String getEstimatedDeliveryDate(Calendar calendar) {
    	String dateString = " ";
    	
    	calendar.add(Calendar.DATE, 7);
    	calendar.add(Calendar.MONTH, 9);
    	int mMonth = calendar.get(Calendar.MONTH) + 1;
         
    	dateString = "Estimated delivery date is " + calendar.get(Calendar.DAY_OF_MONTH) + "/" +
    	mMonth + "/" + calendar.get(Calendar.YEAR) +".";

    	calendar.add(Calendar.DATE, -14);
    	String earliestDateString = calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH) + 1) +
    			"/" + calendar.get(Calendar.YEAR);
    	
    	calendar.add(Calendar.DATE, 14);
    	calendar.add(Calendar.DATE, 7);
    	String latestDateString = calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH) + 1) +
    			"/" + calendar.get(Calendar.YEAR);;
    	String dateString2 = " This is an estimate, actual date lies in between "+earliestDateString + 
    			" and " + latestDateString;

    	return dateString + dateString2;
    }
}

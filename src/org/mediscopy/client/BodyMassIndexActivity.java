package org.mediscopy.client;

import java.text.NumberFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BodyMassIndexActivity extends Activity {
	
	private EditText enterHeight;
	private EditText enterWeight;
	private Button calculateBMI;
	private TextView bmiResult;
	private TextView interprete;
	private Button backButton;
	
	private double heightInMetres;
	private double weightInKgs;
	private Button disclaimerButton;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);
        
        enterHeight = (EditText)findViewById(R.id.enter_height);
        enterWeight = (EditText)findViewById(R.id.enter_weight);
        bmiResult = (TextView)findViewById(R.id.bmi_result);
        calculateBMI = (Button)findViewById(R.id.calculate);
        calculateBMI.setText(getString(R.string.bmi_text));
        interprete = (TextView)findViewById(R.id.bmi_interprete);
        interprete.setText("INTERPRETATION " + "\n" + 
        		"Below 18.5\t:Underweight " + "\n" + 
        		"18.5 -24.9\t\t:Normal " + "\n" +
        		"25.0 -29.9\t\t:Overweight " + "\n" +
        		"Above 30.0\t:Obese");
        
        calculateBMI.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	try {
	                heightInMetres = Double.parseDouble(enterHeight.getText().toString());
	                weightInKgs = Double.parseDouble(enterWeight.getText().toString());
            	
	                double bmi = weightInKgs/(heightInMetres * heightInMetres);
            	
                String bmiStatus = "";
                if (bmi < 18.5) {
                	bmiStatus = "you are underweight";
                }
                else if (bmi >=18.5 && bmi <= 24.9) {
                	bmiStatus = "you are within the normal range";
                }
                else if (bmi >= 25.0 && bmi <= 29.9) {
                	bmiStatus = "you are overweight";
                }
                else if (bmi > 30.0) {
                	bmiStatus = "you are obese";
                }
                NumberFormat nf = NumberFormat.getNumberInstance();
                nf.setMaximumFractionDigits(2);

                bmiResult.setText("Your BMI is  " + nf.format(bmi) + " and " + bmiStatus);
            }
            catch(Exception ex) {
            	bmiResult.setText("Please enter valid data");
            }
         }
            
       });
        
        backButton = (Button)findViewById(R.id.back);
        backButton.setText(getString(R.string.back_to_main));
        backButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
            	
            	
                Intent mainMenu = new Intent(getApplicationContext(), MainMenuActivity.class);
                
                startActivity(mainMenu);
            }
        });
        
        disclaimerButton = (Button)findViewById(R.id.disclaimerBtn);
        disclaimerButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent disclaimerIntent = new Intent(getApplicationContext(), DisclaimerActivity.class);
				disclaimerIntent.putExtra("caller", MediscopyConstants.BODYMASSINDEX_ACTIVITY);
				startActivity(disclaimerIntent);
			}
        	
        });
	}
}

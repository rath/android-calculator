package com.xrath.training.android.calculator;

import static android.view.ViewGroup.LayoutParams.FILL_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CalculatorActivity extends Activity {
	
	private static final String TAG = "rath";
	private TextView activeNumbers = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                
        Log.d(TAG, "onCreate started.");
                        
        setContentView(createMainView());
    }
    
    protected View createMainView()
    {
    	LinearLayout view = new LinearLayout(this);
    	view.setOrientation(LinearLayout.VERTICAL);
    	
        activeNumbers = new TextView(this);
        activeNumbers.setText("1,048,576");
        activeNumbers.setTextSize(36.0f);
        activeNumbers.setBackgroundColor(0x000000);
        activeNumbers.setTypeface(Typeface.DEFAULT, 1);
        activeNumbers.setGravity( Gravity.CENTER_VERTICAL | Gravity.RIGHT );
        activeNumbers.setLayoutParams(
        	new LinearLayout.LayoutParams(FILL_PARENT, WRAP_CONTENT, 0.0f));
                        
        view.addView(activeNumbers);

        View buttons = new ButtonGroup(this);
        buttons.setLayoutParams(
           	new LinearLayout.LayoutParams(FILL_PARENT, FILL_PARENT, 1.0f));
        view.addView(buttons);
                
        return view;
    }    
}
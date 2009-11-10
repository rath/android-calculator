package com.xrath.training.android.calculator;

import static android.view.ViewGroup.LayoutParams.FILL_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class CalculatorActivity extends Activity {
	
	private static final String TAG = "rath";
	private CurrentNumberView activeNumbers = null;
	private ButtonActions actions;
	
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
    	
    	actions = new ButtonActions();
    	
        activeNumbers = new CurrentNumberView(this);
        activeNumbers.setLayoutParams(
        	new LinearLayout.LayoutParams(FILL_PARENT, WRAP_CONTENT, 0.0f));
        view.addView(activeNumbers);
        
        actions.setView(activeNumbers);

        View buttons = new ButtonGroup(this, actions);
        buttons.setLayoutParams(
           	new LinearLayout.LayoutParams(FILL_PARENT, FILL_PARENT, 1.0f));
        view.addView(buttons);
                
        return view;
    }    
}
package com.xrath.training.android.calculator;

import java.text.DecimalFormat;

import android.content.Context;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.TextView;

public class CurrentNumberView extends TextView {
	
	private DecimalFormat formatNumber = new DecimalFormat("#,###.###");

	public CurrentNumberView(Context context) {
		super(context);

        setText("0");
        setTextSize(36.0f);
        setBackgroundColor(0x000000);
        setTypeface(Typeface.DEFAULT, 1);
        setGravity( Gravity.CENTER_VERTICAL | Gravity.RIGHT );
	}
	
	public void setNumber( String str ) {
		double value = 0.0D;
		try {
			value = Double.parseDouble(str);
			setNumber(value);
		} catch( NumberFormatException e ) {
			
		}
	}

	public void setNumber(double d) {
		setText(formatNumber.format(d));
	}

	public void setNumber(StringBuffer currentNumber) {
		setNumber(currentNumber.toString());
	}

}

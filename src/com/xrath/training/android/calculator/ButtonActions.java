package com.xrath.training.android.calculator;

import android.util.Log;

public class ButtonActions 
{
	public void processNumber(int number) {
		Log.d("rath", String.valueOf(number));
	}

	public void processOperator(Operator op) {
		Log.d("rath", String.valueOf(op));
	}	
}

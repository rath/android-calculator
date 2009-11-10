package com.xrath.training.android.calculator;

import android.util.Log;

public class ButtonActions 
{
	private StringBuffer currentNumber = new StringBuffer();
	private CurrentNumberView view;
	
	private double lastValue = 0;
	private Operator lastOperator = null;
	
	public ButtonActions() {
		currentNumber.append('0');
	}
	
	public void processNumber(int number) {
		Log.d("rath", String.valueOf(number));
		
		if( currentNumber.length()==1 && currentNumber.charAt(0)=='0' ) {
			currentNumber.delete(0, 1);
		}
		currentNumber.append( number );
		
		view.setNumber(currentNumber);
	}

	public void processOperator(Operator op) {
		Log.d("rath", String.valueOf(op));
		
		if( op==Operator.DOT && currentNumber.indexOf(".")==-1 ) {
			currentNumber.append(op.text());
			
			view.setNumber(currentNumber);
		}
		if( op==Operator.PLUS || op==Operator.MINUS || 
			op==Operator.MULTIPLY || op==Operator.DIVIDE ) {
			
			lastValue = calculateWithLastValue(); 
			currentNumber = new StringBuffer();
			lastOperator = op;
			
		}
		if( op==Operator.RESULT ) {
			lastValue = calculateWithLastValue(); 
			currentNumber = new StringBuffer();
			lastOperator = null;
		}
	}
	
	protected double calculateWithLastValue() {
		String current = currentNumber.toString();
		double value = 0;
		try {
			value = Double.parseDouble(current);
			return calculateWithLastValue(value);
		} catch( NumberFormatException e ) {
			Log.e("rath", "current: " + current);
		}
		return 0;
	}
	
	protected double calculateWithLastValue( double value ) {
		if( lastOperator==null )
			return value;
		
		double result = 0.0D;
		if( lastOperator==Operator.PLUS ) 
			result = lastValue + value;
		if( lastOperator==Operator.MINUS ) 
			result = lastValue - value;
		if( lastOperator==Operator.MULTIPLY )
			result = lastValue * value;
		if( lastOperator==Operator.DIVIDE )
			result = lastValue / value;
	
		view.setNumber(result);
		return result;
	}
	
	public void setView(CurrentNumberView activeNumbers) {
		this.view = activeNumbers;
		
	}
}

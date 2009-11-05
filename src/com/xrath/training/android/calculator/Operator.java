package com.xrath.training.android.calculator;

public enum Operator {
	PLUS	("+"),
	MINUS	("-"),
	DOT		("."),
	MULTIPLY("*"),
	DIVIDE	("/"),
	RESULT	("=");
	
	private String text; 
	
	Operator(String text)
	{
		this.text = text;		
	}
	
	public String text() 
	{
		return this.text;
	}
}

package com.xrath.training.android.calculator;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

public class ButtonGroup extends GridView 
{	
	final int gravity = Gravity.CENTER;
	final float textSize = 36.0f;
	
	private Button[] nums = new Button[10];
	private Map<Operator, Button> operatorButtons = new HashMap<Operator, Button>();
	
	private ButtonActions action = new ButtonActions();
		
	public ButtonGroup(Context context) 
	{
		super(context);

		setNumColumns(4);
    	setHorizontalSpacing(1);
    	setVerticalSpacing(1);    	
    	setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
    	
    	createButtons();
    	
    	initLayout();
	}

	private void createButtons() 
	{
    	for(int i=0; i<nums.length; i++)
    	{
    		final int number = i;
    		nums[i] = new Button(getContext());
    		nums[i].setText(String.valueOf(number));
    		nums[i].setGravity(gravity);
    		nums[i].setTextSize(textSize);
    		nums[i].setOnClickListener(new View.OnClickListener() {				
				@Override
				public void onClick(View v) {
					action.processNumber(number);
				}
			});
    	}
    	    	
    	for(final Operator op : Operator.values()) 
    	{    		
    		Button button = new Button(getContext());
    		button.setText(op.text());
    		button.setGravity(gravity);
    		button.setTextSize(textSize);
    		button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					action.processOperator(op);
				}    			
    		});    		
    		operatorButtons.put(op, button);
    	}
	}
	
	private void initLayout()
	{	  	
    	// 7, 8, 9, / 
    	// 4, 5, 6, *
    	// 1, 2, 3, -
    	// ., 0, =, +     	
    	final Map<Operator, Button> ops = operatorButtons;
    	setAdapter( new BaseAdapter() {
    		private View[] buttons = {
    			nums[7], nums[8], nums[9], ops.get(Operator.DIVIDE),
    			nums[4], nums[5], nums[6], ops.get(Operator.MULTIPLY),
    			nums[1], nums[2], nums[3], ops.get(Operator.MINUS),
    			ops.get(Operator.DOT), nums[0], ops.get(Operator.RESULT), ops.get(Operator.PLUS)
    		};
    		
			@Override
			public int getCount() {
				return nums.length + ops.size();
			}

			@Override
			public Object getItem(int position) {			
				return null;
			}

			@Override
			public long getItemId(int position) {
				return 0;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View view = buttons[position];
				view.setLayoutParams(
					new GridView.LayoutParams(parent.getWidth()/4, (parent.getHeight()-40)/4));
				return view;				
			}
    	});    			
	}

}

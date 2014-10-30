package com.example.image;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class DrawView extends View implements OnTouchListener{
	
	private ArrayList<Path> pathList = new ArrayList<Path>();
	private Paint paint;
	private Path path;
	
	public DrawView(Context context) {
		super(context);
		setOnTouchListener(this);
	}
	
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		
		if(event.getAction() == MotionEvent.ACTION_DOWN){
			path = new Path();
			path.moveTo(event.getX(), event.getY());
			pathList.add(path);
		}
		if(event.getAction() == MotionEvent.ACTION_MOVE){
			path.lineTo(event.getX(), event.getY());
		}
		if(event.getAction() == MotionEvent.ACTION_UP) {
			path.lineTo(event.getX(), event.getY());
		}
		
		invalidate();
		return true;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		
		super.onDraw(canvas);
		
		paint = new Paint();
		
		for(Path path: pathList) {
			canvas.drawPath(path, paint);
			
		}
	}
	
	
}

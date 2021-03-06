package com.jeremyfeinstein.slidingmenu.example.anim;

import android.os.Bundle;

import com.jeremyfeinstein.slidingmenu.example.BaseActivity;
import com.jeremyfeinstein.slidingmenu.example.R.id;
import com.jeremyfeinstein.slidingmenu.example.R.layout;
import com.jeremyfeinstein.slidingmenu.example.SampleListFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.CanvasTransformer;

public abstract class CustomAnimation extends BaseActivity {
	
	private CanvasTransformer mTransformer;
	
	public CustomAnimation(int titleRes, CanvasTransformer transformer) {
		super(titleRes);
		mTransformer = transformer;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// set the Above View
		setContentView(layout.content_frame);
		getSupportFragmentManager()
		.beginTransaction()
		.replace(id.content_frame, new SampleListFragment())
		.commit();
		
		SlidingMenu sm = getSlidingMenu();
		setSlidingActionBarEnabled(true);
		sm.setBehindScrollScale(0.0f);
		sm.setBehindCanvasTransformer(mTransformer);
	}

}

package com.gcolella.acewing;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

public class AceWingActivity extends Activity {
	ShooterSurface surface;
	int offset;
	boolean wanthome = false;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Display display = getWindowManager().getDefaultDisplay();
        Screen.setXY(display.getWidth(),display.getHeight());
        Spawner.setDefaults(1000, 1000);
		surface = new ShooterSurface(this);
		setupHome();
    }
    public void setupHome(){
		LinearLayout mylayout = new LinearLayout(this);
		mylayout.setOrientation(mylayout.VERTICAL);
		mylayout.addView(generateLvlButton("Tutorial", new LevelTutorial(this,this)));
		
	  //mylayout.addView(generateLvlButton("Level One",new LevelOne(this,this)));
		
		mylayout.addView(generateLvlButton("Free Flight",new FreeFlight(this,this)));
		mylayout.addView(generateLvlButton("Waves",new Waves(this,this)));
		mylayout.addView(generateLvlButton("Carrier Defense",new CarrierLevel(this,this)));
		mylayout.addView(generateLvlButton("MULTIPLAYER- CLIENT", new ClientLevel(this,this)));
		mylayout.addView(generateLvlButton("MULTIPLAYER- SERVER", new ServerLevel(this,this)));
		setContentView(mylayout);
    }
    public Button generateLvlButton(String name, Level lvl){
    	Button out = new Button(this);
    	out.setText(name);
    	out.setOnClickListener(new LevelButtonListener(lvl));
    	return out;
    }
    public void home(){
    	setContentView(R.layout.levelselect);
    }
    public void loadLevel(Level l){
    	l.setup();
    	//surface = new ShooterSurface(this,display.getWidth(),display.getHeight());
    	surface.setUniverse(l.getUniverse());
    	surface.getUniverse().setLevel(l);
    	surface.setControlShip(l.getPlayer());
    	surface.initBackround(l.getBackround());
    	setContentView(surface);
    	//while(!(surface.shouldquit)){}
    	//setupHome();
    }
    public void loadScreen(LinearLayout l){
    	setContentView(l);
    }
    public void onPause(){
    	super.onPause();
    	surface.pause();
    }
    public void onResume(){
    	super.onResume();
    	surface.resume();
    }
    class LevelButtonListener implements OnClickListener{
    	Level l;
    	public LevelButtonListener(Level l1){
    		l=l1;
    	}
		public void onClick(View arg0) {
			loadScreen(l.levelScreen());
		}
    }

}
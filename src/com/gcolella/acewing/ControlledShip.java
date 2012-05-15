package com.gcolella.acewing;

import java.util.List;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.Log;
import android.view.MotionEvent;

public abstract class ControlledShip extends ArmedObject implements Targeter {
	int kills = 0;
	int ctrrad;
	boolean isTouching;
	Location lefttouch,righttouch;
	Countdown lefttap = new Countdown(5);
	Countdown righttap = new Countdown(5);
	public ControlledShip(Location newloc, float health,
			Vector newvelo, Universe theverse, Team team) {
		super(newloc, health, newvelo, theverse,team);
		ctrrad = Screen.getX()/5;
	}

	public boolean onTouch(MotionEvent event)
	{
		for(int i=0;i<event.getPointerCount();i++){
			float x = event.getX(i);
			float y = event.getY(i);
			Location touchloc = new Location(x,y);
			if(touchloc.distanceTo(new Location(ctrrad,ctrrad))<ctrrad){
				lefttouch = touchloc;
				controlStick(x-ctrrad,y-ctrrad);
				continue;
			}
			if(touchloc.distanceTo(new Location(ctrrad,Screen.getY()-ctrrad)) < ctrrad){
				righttouch = touchloc;
				fireStick(x-ctrrad,y-(Screen.getY()-ctrrad));
				continue;
			}
			if(touchloc.distanceTo(new Location(ctrrad, Screen.getY()-(2*ctrrad)-(ctrrad/3))) < ctrrad/3){
				if(righttap.timeUp()){
				Log.e("OUTPUTSHOOTER","FIRING");
				secondButtonTwo();
				continue;
				}
			}
			if(touchloc.distanceTo(new Location(ctrrad,2*ctrrad+(ctrrad/3))) < ctrrad/3){
				if(lefttap.timeUp()){
				Log.e("OUTPUTSHOOTER","SWITCHIN");
				secondButtonOne();
				continue;
				}
			}
			
			Location worldloc = touchloc.offset(getLocation().getX()-(Screen.getX()/2),getLocation().getY()-(Screen.getY()/2));
			UniverseObject targ = getUniverse().objAt(worldloc);
			if(targ!=null){
				setTarget(targ);
			}
			
		}
		return true;
	}
		public void update(){
			super.update();
			lefttap.cool();
			righttap.cool();
		}
		
		public abstract void controlStick(float x,float y);
		public abstract void fireStick(float x, float y);
		public abstract void secondButtonOne();
		public abstract void secondButtonTwo();
		public void drawHUD(Canvas c)
		{
			Paint mypaint = new Paint();
			mypaint.setTextSize(40);
		
			//draw control stick. 
			mypaint.setStyle(Style.STROKE);
			mypaint.setColor(Color.RED);
			c.drawCircle(ctrrad,ctrrad, ctrrad, mypaint);
			//draw last control touch
			mypaint.setStyle(Style.FILL);
			if(lefttouch!=null){
				c.drawCircle(lefttouch.getX(), lefttouch.getY(), 40, mypaint);
				lefttouch = new Location(ctrrad,ctrrad);
			}
			
			//draw text
			mypaint.setStyle(Style.STROKE);
			c.save();
			c.rotate(90,5,ctrrad+40);
			c.drawText("Score: "+getScore()+"  2ND: "+getSecondaryName()+" ("+(currentAmmo())+")", ctrrad+40, 5, mypaint);
			c.restore();
			
			//draw health bars
			mypaint.setColor(Color.GREEN);
			c.drawRect(Screen.getX()-ctrrad/5,2*ctrrad,Screen.getX(),(2*ctrrad)+(Screen.getY()-(4*ctrrad)),mypaint);
			mypaint.setStyle(Style.FILL);
			if(getHealth()>.1f)
				c.drawRect(Screen.getX()-ctrrad/5,2*ctrrad,Screen.getX(),(2*ctrrad)+(Screen.getY()-(4*ctrrad))*(getHealth()/getMaxHealth()), mypaint);
			
			//draw the firing circle
			mypaint.setStyle(Style.STROKE);
			c.drawCircle(ctrrad,Screen.getY()-ctrrad, ctrrad, mypaint);
			//draw last control touch
			mypaint.setStyle(Style.FILL);
			if(righttouch!=null){
				c.drawCircle(righttouch.getX(), righttouch.getY(), 40, mypaint);
				righttouch = new Location(ctrrad,Screen.getY()-ctrrad);
			}
			
			//draw the two secondary buttons.
			mypaint.setStyle(Style.STROKE);
			mypaint.setColor(Color.BLUE);
			c.drawCircle(ctrrad, Screen.getY()-(2*ctrrad)-(ctrrad/3), ctrrad/3, mypaint);
			c.drawCircle(ctrrad,2*ctrrad+(ctrrad/3),ctrrad/3,mypaint);
			
			//circle target.
			if(hasTarget()){
			mypaint.setStyle(Style.STROKE);
			mypaint.setColor(Color.RED);
			c.drawCircle(getCurrentTarget().getLocation().getX()-(getLocation().getX()-(Screen.getX()/2)),getCurrentTarget().getLocation().getY()-(getLocation().getY()-(Screen.getY()/2)),getCurrentTarget().getHitRadius(),mypaint);
			}
			drawRadar(c);
		}
		public  void drawRadar(Canvas c){
			Paint mypaint = new Paint();
			mypaint.setColor(Color.GREEN);
			mypaint.setStyle(Style.STROKE);
			c.drawCircle(Screen.getX()-ctrrad, ctrrad, ctrrad, mypaint);
			List<UniverseObject> stuff = getUniverse().getStuff();
			for(UniverseObject ship:stuff){
				if(!(ship instanceof DamageObject)){
						if(hasTarget() && getCurrentTarget().equals(ship))
							mypaint.setStyle(Style.FILL);
						else
							mypaint.setStyle(Style.STROKE);
						mypaint.setColor(ship.getTeam().color);
						float newx = (ship.getLocation().getX()-getLocation().getX())/10;
						float newy = (ship.getLocation().getY()-getLocation().getY())/10;
						if(ship.getLocation().distanceTo(getLocation())/10>ctrrad){
						Vector v = new Vector(newx,newy,true);	
						v.setMagnitude(ctrrad);
						newx = v.getiComponent();
						newy = v.getjComponent();
						}
						c.drawCircle(Screen.getX()-ctrrad+newx,ctrrad+newy,3, mypaint);
				}
			}
			
		}

}

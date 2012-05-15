package com.gcolella.acewing;

import java.util.ArrayList;

import android.util.Log;

@SuppressWarnings("unused")
public abstract class TrackingObject extends ArmedObject implements Targeter {

	protected float turnspeed = (float)Math.toRadians(1);
	private Location dest;
	
	public TrackingObject( Location newloc, float health, Vector newvelo, Universe theverse, Team team) {
		super(newloc, health, newvelo,theverse, team);
		getNewDest();
		// TODO Auto-generated constructor stub
	}
	public Location getDest(){
		return dest;
	}
	public  void acquireTarget(){
		ArrayList<UniverseObject> targets = new ArrayList<UniverseObject>();
		//Log.e("OUTPUTSHOOTER", "RETARGETING");
		for(UniverseObject obj:getUniverse().getStuff())
			if(targetable(obj)){
				targets.add(obj);
			}
		if(targets.size()==0){
			setTarget(null);
			return;
		}
		setTarget(targets.get((int)(Math.random()*targets.size())));
		//Log.e("OUTPUTSHOOTER",currentTarget+"");
	}

	public abstract boolean targetable(UniverseObject obj);
	public void setTurnSpeed(float tspd){
		turnspeed = tspd;
	}
	public float targetAngle(){
		Location targetloc = getCurrentTarget().getLocation();
		Location tracktargetloc = new Location(targetloc.getX()+(getCurrentTarget().getVelocity().getiComponent()*2),targetloc.getY()+(getCurrentTarget().getVelocity().getjComponent()*2));
		return getLocation().angleTo(tracktargetloc); 
	}

	//returns fireAngle turned toward loc at a max rate of tspd.
	public float turnTowards(float fireAngle, Location loc, float tspd){
		float angle = getLocation().angleTo(loc);
		//getVelocity().setAngle(angle);
		//float myAngle = getVelocity().getAngle();
		
		float turnAmount = (float)(Math.atan2(Math.sin(angle-fireAngle),Math.cos(angle-fireAngle)));
		
		if(Math.abs(turnAmount)>tspd){
		if(turnAmount>0)
			fireAngle+=tspd;
		if(turnAmount<0)
			fireAngle-=tspd;
		}else{
			fireAngle = angle;
		}
		return fireAngle;
	}
	public void update(){
		if(getCurrentTarget() != null){
			getVelocity().setAngle(turnTowards(getVelocity().getAngle(),getCurrentTarget().getLocation(),turnspeed));
		}else{acquireTarget();}
		if(!hasTarget()){
			getVelocity().setAngle(turnTowards(getVelocity().getAngle(),dest,turnspeed));
			if(haveArrived())
				getNewDest();
		}
		super.update();
	}
	public void getNewDest(){
		dest = Location.randomLocation();
		
	}
	public boolean haveArrived(){
		return getLocation().distanceTo(dest) < 20;
	}
	public void sUpdate(){
		super.update();
	}


}

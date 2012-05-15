package com.gcolella.acewing;

public abstract class BasicBoat extends TrackingObject {

	public float aimAngle;
	
	public BasicBoat(Location newloc, float health, Vector newvelo,
			Universe theverse, Team team) {
		super(newloc, health, newvelo, theverse, team);
		aimAngle = 0;
		// TODO Auto-generated constructor stub
	}
	
	public void update(){
		if(getCurrentTarget()!=null)
			aimAngle = turnTowards(aimAngle,getCurrentTarget().getLocation(),(float) Math.toRadians(90));
		else
			acquireTarget();
		getVelocity().setAngle(turnTowards(getVelocity().getAngle(),getDest(),(float) Math.toRadians(.5)));
		if(haveArrived())
			getNewDest();
		
		super.sUpdate();
	}


}

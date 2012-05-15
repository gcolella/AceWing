package com.gcolella.acewing;

public class Wingman extends EnemyShip {
	TrackingObject watched;
	
	//Generates wingman with customized parameters.
	public Wingman(Location newloc, float health, Vector newvelo,
			Universe theverse,  Team team, TrackingObject ship) {
		super(newloc, health, newvelo, theverse,team);
		watched = ship;
		
		// TODO Auto-generated constructor stub
	}
	
	//Generates a wingman offset by x,y from its commander.
	public Wingman(TrackingObject ship,float x, float y){
		super(ship.getLocation().offset(x,y),ship.getHealth(),ship.getVelocity(),ship.getUniverse(),ship.getTeam());
	}
	public void update(){
		if(watched!=null){
		setVelocity(watched.getVelocity());
		setTarget(watched.getCurrentTarget());
		}
		super.update();
	}
	public void fire(){
		if(watched!=null){
		Vector fireVelo = new Vector(getVelocity().getAngle(),10);
		new DroneBullet( getLocation(),10, fireVelo, getUniverse(),getTeam(), 10,IDnum,watched.IDnum);
		}
		else
		{
			super.fire();
		}
	}

}

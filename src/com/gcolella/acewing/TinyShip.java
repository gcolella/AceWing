package com.gcolella.acewing;

public class TinyShip extends ControlledShip {
	int cooldown = 5;
	int countdown = 0;
	int scooldown = 20;
	int scountdown =0;
	public TinyShip(Location newloc, float health, Vector newvelo,
			Universe theverse, Team team) {
		super(newloc, health, newvelo, theverse,team);
		// TODO Auto-generated constructor stub
	}
	public void controlStick(float x,float y)
	{
		float angle = new Vector(x,y,true).getAngle();
		getVelocity().setAngle(angle);
	}
	public void fireStick(float x,float y){
		float angle = new Vector(x,y,true).getAngle();
		if(countdown==0){
			fire(angle);
			countdown=cooldown;
		}
	}

	public void update(){
		super.update();
		if(countdown>0)
			countdown--;
		if(scountdown>0)
			scountdown--;
	}

	@Override
	public float getHitRadius() {
		// TODO Auto-generated method stub
		return 45;
	}

	@Override
	public int getBmpID() {
		// TODO Auto-generated method stub
		return R.drawable.drone;
	}
	public int maxSecondary(){
		return 0;
	}
	@Override
	public void secondButtonOne() {
		switchSecondary();
		
	}
	@Override
	public void secondButtonTwo() {
		// TODO Auto-generated method stub
		if(scountdown==0){
			fireSecondary();
			scountdown=scooldown;
		}
	}

}

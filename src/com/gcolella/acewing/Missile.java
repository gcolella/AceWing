package com.gcolella.acewing;

public class Missile extends TrackingObject implements DamageObject {
	public int creatorID;
	float damage;
	float lockangle = (float)Math.toRadians(10);
	float maxSpeed = 10.0f;
	float minSpeed = 2.0f;
	float accelspeed = 2.0f;
	public Missile(Location newloc, float health, Vector newvelo,
			Universe theverse, float dmg, int createID, Team team, UniverseObject targ) {
		super(newloc, health, newvelo, theverse, team);
		damage = dmg;
		creatorID = createID;
		turnspeed = (float)Math.toRadians(5.0);
		setTarget(targ);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float getDamage() {
		// TODO Auto-generated method stub
		return damage;
	}

	@Override
	public boolean penetration() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getCreatorID() {
		// TODO Auto-generated method stub
		return creatorID;
	}
	public void update(){
		if(!hasTarget())
			removeMe();
		super.update();
		if(hasTarget()){
		if(Math.abs(targetAngle()-getVelocity().getAngle())<(lockangle))
		{
			if(getVelocity().getMagnitude()<maxSpeed)
				accel(accelspeed);
		}
		else{
			//if(getVelocity().getMagnitude()>minSpeed)
				//accel(accelspeed*-1);
		}}
	}
	@Override
	public boolean targetable(UniverseObject obj) {
		return ((obj.IDnum!=creatorID && !(obj instanceof DamageObject)) && !(teammate(obj)));
	}

	@Override
	public float getHitRadius() {
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public int getBmpID() {
		// TODO Auto-generated method stub
		return R.drawable.missile;
	}

	@Override
	public int maxSecondary() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getExplosionRadius() {
		// TODO Auto-generated method stub
		return 50;
	}



}

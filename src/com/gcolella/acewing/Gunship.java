package com.gcolella.acewing;

public class Gunship extends BasicBoat {
	BurstCountdown gun = new BurstCountdown(50,4,5);
	float fireangle = (float)Math.toRadians(5.0);
	public Gunship(Location newloc, float health, Vector newvelo,
			Universe theverse, Team team) {
		super(newloc, health, newvelo, theverse, team);
	}

	@Override
	public boolean targetable(UniverseObject obj) {
		return !teammate(obj) && !(obj instanceof DamageObject);
	}

	public void update(){
		super.update();
		if(hasTarget()){
			if(Math.abs(new Vector(aimAngle,1).angleBetween(new Vector(targetAngle(),1)))<(fireangle))
			{	
				if(gun.timeUp())
					fire(aimAngle);
			}
		}
		gun.cool();

	}
	
	@Override
	public int maxSecondary() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getHitRadius() {
		// TODO Auto-generated method stub
		return 50;
	}

	@Override
	public int getBmpID() {
		// TODO Auto-generated method stub
		return R.drawable.ship;
	}

}

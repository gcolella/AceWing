package com.gcolella.acewing;

public class MysteryPowerup extends UniverseObject implements Powerup {

	public MysteryPowerup(Location newloc, float health, Vector newvelo,
			Universe theverse, Team team) {
		super(newloc, health, newvelo, theverse, team);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyPowerup(ControlledShip ship) {
		int ammoType = (int)(Math.random()*ship.secondaries.size());
		ship.addAmmo(ammoType, 1);
	}

	@Override
	public float getHitRadius() {
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public int getBmpID() {
		// TODO Auto-generated method stub
		return R.drawable.mystery;
	}

}

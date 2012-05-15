package com.gcolella.acewing;

public class MissilePowerup extends UniverseObject implements Powerup {

	public MissilePowerup(Location newloc, float health, Vector newvelo,
			Universe theverse, Team team) {
		super(newloc, health, newvelo, theverse, team);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyPowerup(ControlledShip ship) {
		ship.addAmmo(0, 2);
	}

	@Override
	public float getHitRadius() {
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public int getBmpID() {
		// TODO Auto-generated method stub
		return R.drawable.missilepowerup;
	}

}

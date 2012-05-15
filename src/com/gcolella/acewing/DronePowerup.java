package com.gcolella.acewing;

public class DronePowerup extends UniverseObject implements Powerup {

	public DronePowerup(Location newloc, float health, Vector newvelo,
			Universe theverse, Team team) {
		super(newloc, health, newvelo, theverse, team);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyPowerup(ControlledShip ship) {
		// TODO Auto-generated method stub
		ship.addAmmo(3,1);
	}

	@Override
	public float getHitRadius() {
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public int getBmpID() {
		// TODO Auto-generated method stub
		return R.drawable.dronepowerup;
	}

}

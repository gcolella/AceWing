package com.gcolella.acewing;

public class NeutralShip extends TrackingObject {

	public NeutralShip(Location newloc, float health, Vector newvelo,
			Universe theverse, Team team) {
		super(newloc, health, newvelo, theverse, team);
	}

	@Override
	public boolean targetable(UniverseObject obj) {
		return false; //doesn't target anything. It's neutral!
	}

	@Override
	public float getHitRadius() {
		return 30;
	}

	@Override
	public int getBmpID() {
		return R.drawable.ship;
	}

	@Override
	public int maxSecondary() {
		// TODO Auto-generated method stub
		return 0;
	}

}

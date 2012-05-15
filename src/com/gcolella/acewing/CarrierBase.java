package com.gcolella.acewing;

public class CarrierBase extends TrackingObject {

	public CarrierBase(Location newloc, float health, Vector newvelo,
			Universe theverse, Team team) {
		super(newloc, health, newvelo, theverse, team);
	}

	@Override
	public float getHitRadius() {
		return 70;
	}

	@Override
	public int getBmpID() {
		return R.drawable.carrier;
	}

	@Override
	public boolean targetable(UniverseObject obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int maxSecondary() {
		// TODO Auto-generated method stub
		return 0;
	}

}

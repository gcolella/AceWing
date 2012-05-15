package com.gcolella.acewing;



public class BasicShip extends UniverseObject {

	public BasicShip(Location newloc, float health, Vector newvelo, Universe theverse, Team team) {
		super( newloc, health, newvelo, theverse, team);

	}

	@Override
	public int getBmpID() {
		return R.drawable.ship;
	}

	@Override
	public float getHitRadius() {
		return 30;
	}

}

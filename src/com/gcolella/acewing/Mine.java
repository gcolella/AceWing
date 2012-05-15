package com.gcolella.acewing;

public class Mine extends UniverseObject implements DamageObject {
	int creatorID;
	float dmg;
	public Mine(Location newloc, float health, Vector newvelo, Universe theverse, Team team, float damage, int createID) {
		super(newloc, health, newvelo, theverse, team);
		creatorID = createID;
		dmg = damage;
	}

	@Override
	public float getDamage() {
		// TODO Auto-generated method stub
		return dmg;
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

	@Override
	public float getHitRadius() {
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public int getBmpID() {
		// TODO Auto-generated method stub
		return R.drawable.mine;
	}

	@Override
	public boolean targetable(UniverseObject obj) {
		// TODO Auto-generated method stub
		return !(obj instanceof DamageObject);
	}

	@Override
	public int getExplosionRadius() {
		// TODO Auto-generated method stub
		return 40;
	}

}

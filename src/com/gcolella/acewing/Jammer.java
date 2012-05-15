package com.gcolella.acewing;

public class Jammer extends UniverseObject implements DamageObject {
	int createID;
	int life = 50;
	public Jammer(Location newloc, float health, Vector newvelo,
			Universe theverse, Team team, int creatorID) {
		super(newloc, health, newvelo, theverse, team);
		createID = creatorID;
		// TODO Auto-generated constructor stub
	}

	@Override
	public float getDamage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean penetration() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getCreatorID() {
		return createID;
	}
	public void update(){
		super.update();
		life--;
		getUniverse().deTarget(createID);
		if(life<0)
			removeMe();
	}
	@Override
	public float getHitRadius() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getBmpID() {
		// TODO Auto-generated method stub
		return R.drawable.jammer;
	}

	public boolean targetable(UniverseObject obj) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getExplosionRadius() {
		// TODO Auto-generated method stub
		return -1;
	}


}

package com.gcolella.acewing;

public class Bullet extends UniverseObject implements DamageObject {
	float damage;
	int lifetime = 100;
	int createid;
 	public Bullet(Location newloc, float health,
			Vector newvelo, Universe theverse, Team team, float dmg,int createid) {
		super( newloc, health, newvelo, theverse,team);
		damage = dmg;
		this.createid = createid;
		// TODO Auto-generated constructor stub
	}
 	public int getCreatorID()
 	{
 		return createid;
 	}
	@Override
	public float getDamage() {
		// TODO Auto-generated method stub
		return damage;
	}

	@Override
	public boolean penetration() {
		return false;
	}
	public void update(){
		super.update();
		if(lifetime<=0)
			removeMe();
		lifetime--;
	}
	@Override
	public int getBmpID() {
		// TODO Auto-generated method stub
		return R.drawable.bullet;
	}
	public float getHitRadius(){
		return (float)5;
	}
	@Override
	public int getExplosionRadius(){
		return -1;
	}
	public boolean targetable(UniverseObject obj) {
		// TODO Auto-generated method stub
		return !(obj instanceof Missile);
	}

}

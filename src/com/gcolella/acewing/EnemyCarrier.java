package com.gcolella.acewing;

public class EnemyCarrier extends TrackingObject {
	Countdown cool = new Countdown(200);
	public EnemyCarrier(Location newloc, float health, Vector newvelo,
			Universe theverse, Team team) {
		super(newloc, health, newvelo, theverse, team);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean targetable(UniverseObject obj) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean isEnemy(){
		return true;
	}
	@Override
	public int maxSecondary() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void update(){
		super.update();
		//if(cool.timeUp())
			//releaseDrone();
		cool.cool();
	}
	@Override
	public float getHitRadius() {
		// TODO Auto-generated method stub
		return 150;
	}

	@Override
	public int getBmpID() {
		// TODO Auto-generated method stub
		return R.drawable.enemycarrier;
	}

}

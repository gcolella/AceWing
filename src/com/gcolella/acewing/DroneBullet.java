package com.gcolella.acewing;

public class DroneBullet extends Bullet {
	int carrierID;
	public DroneBullet(Location newloc, float health, Vector newvelo,
			Universe theverse, Team team, float dmg, int createid, int carrierID) {
		super(newloc, health, newvelo, theverse,team, dmg, createid);
		// TODO Auto-generated constructor stub
		this.carrierID = carrierID;
	}
	public boolean targetable(UniverseObject obj){
		return obj.IDnum != carrierID;
	}
}

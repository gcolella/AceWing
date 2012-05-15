package com.gcolella.acewing;

import android.content.Context;
import android.util.Log;

public class FreeFlight extends Level {

	public FreeFlight(Context ctx, AceWingActivity home) {
		super(ctx, home);
		// TODO Auto-generated constructor stub
	}
	boolean powerups(){
		return true;
	}
	@Override
	boolean levelComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean levelFailed() {
		// TODO Auto-generated method stub
		return false;
	}
	void updateLevel(){
		if(out.onTeam(Team.RED) <= 1){
			out.spawnShip(Team.RED);
			out.spawnShip(Team.RED);}
	}
	@Override
	String levelText(){
		return "Fly against two enemies at a time. They contain mine laying and normal firing craft. You start with two missiles.. use them wisely.";
		
	}
	void setup() {
		out = new Universe(myctx);
		myship = new BasicPlayer( new Location(0,0), 100, new Vector(0,4), out,Team.GREEN);
		Spawner.spawnEnemy(out);
		Spawner.spawnEnemy(out);
		new Gunship(Location.randomLocation(Spawner.getDefaultX(), Spawner.getDefaultY()),100,new Vector(0,1),out,Team.RED);
		myship.addAmmo(0,10);
	}
	@Override
	int getBackround() {
		// TODO Auto-generated method stub
		return R.drawable.ocean;
	}

}

package com.gcolella.acewing;

import android.content.Context;

public class Waves extends Level {

	int wave = 1;
	
	public Waves(Context ctx, AceWingActivity home) {
		super(ctx, home);
		// TODO Auto-generated constructor stub
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

	@Override
	void setup() {
		out = new Universe(myctx);
		myship = new BasicPlayer( new Location(0,0), 100, new Vector(0,2), out,Team.GREEN);
		myship.addAmmo(0,10);
		spawnWave(1);

	}
	void spawnWave(int n){
		for(int i=0;i<n;i++)
			out.spawnShip(Team.RED);
	}
	@Override
	String levelText() {
		// TODO Auto-generated method stub
		return "Every time, there's one more ship. Good thing you get your health back every time, and one missile.";
	}

	@Override
	boolean powerups() {
		// TODO Auto-generated method stub
		return true;
	}
	void updateLevel(){
		if(out.onTeam(Team.RED)<1){
			//all killed..
			wave++;
			myship.setHealth(myship.getMaxHealth());
			spawnWave(wave);
		}
	}

	@Override
	int getBackround() {
		// TODO Auto-generated method stub
		return R.drawable.ocean;
	}

}

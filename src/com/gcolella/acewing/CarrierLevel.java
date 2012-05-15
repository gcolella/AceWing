package com.gcolella.acewing;

import android.content.Context;

public class CarrierLevel extends Level {
	CarrierBase yourcarrier;
	Countdown support;
	public CarrierLevel(Context ctx, AceWingActivity home) {
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

	ControlledShip spawnPlayer(){
		return new BasicPlayer(yourcarrier.getLocation(),100,new Vector(yourcarrier.getVelocity().getAngle(),8),out,Team.GREEN);
	}
	
	
	@Override
	void setup() {
		out = new Universe(myctx);
		yourcarrier = new CarrierBase(Location.randomLocation(),800,new Vector(0,.5f),out,Team.GREEN);
		support = new Countdown(1000);
		myship = new BasicPlayer( yourcarrier.getLocation(), 100, new Vector(yourcarrier.getVelocity().getAngle(),6), out,Team.GREEN);
		myship.addAmmo(new MissileLauncher(10,myship));
	}
	void updateLevel(){
		support.cool();
		if(support.timeUp()){
			new Drone(yourcarrier.getLocation(),50,new Vector(yourcarrier.getVelocity().getAngle(),5),out,Team.GREEN, yourcarrier.IDnum);
			
		}
		if(out.onTeam(Team.RED) <= 1){
			Spawner.spawnEnemy(out);
			Spawner.spawnEnemy(out);}
	}
	
	
	@Override
	String levelText() {
		// TODO Auto-generated method stub
		return "Defend the carrier against enemy fighters.";
	}

	@Override
	boolean powerups() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	int getBackround() {
		// TODO Auto-generated method stub
		return R.drawable.ocean;
	}
	

}

package com.gcolella.acewing;


import android.content.Context;

public class LevelTutorial extends Level {

	LevelTutorial(Context ctx, AceWingActivity act) {
		super(ctx, act);
		// TODO Auto-generated constructor stub
	}


	void setup(){
		out = new Universe(myctx);
		myship = new TinyShip(Location.randomLocation(),100, new Vector(0,0), out, Team.GREEN);
		new NeutralShip(Location.randomLocation(),20,new Vector(2,2), out, Team.YELLOW);
	}
	@Override
	boolean levelComplete() {
		return out.shipNumber() == 1;
	}

	boolean levelFailed() {
		if(myactiv.surface.playership.IDnum != getPlayer().IDnum)
			return true;
		return false;
	}
	String levelText(){
		return "Learn to shoot by engaging a small cargo ship.";
	}
	boolean powerups(){
		return true;
	}


	@Override
	int getBackround() {
		// TODO Auto-generated method stub
		return R.drawable.ocean;
	}

}

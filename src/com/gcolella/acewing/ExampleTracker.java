package com.gcolella.acewing;

public class ExampleTracker extends TrackingObject {

	public ExampleTracker(Location newloc, float health, Vector newvelo,
			Universe theverse, Team team) {
		super(newloc, health, newvelo, theverse, team);
		//This is the constructor, it just passes everything back up to the TrackingObject
	}


	public boolean targetable(UniverseObject obj) {
		//You need to tell it what kind of objects your ship would like to target.
		//Here's a simple one that targets objects of a different team, but not any DamageObjects(missiles, mines, bullets, etc)
		return !teammate(obj) && !(obj instanceof DamageObject);
	}

	@Override
	public int maxSecondary() {
		//This just tells the system for secondary weapons what weapons your ship is allowed to use
		return 0;
	}

	@Override
	public float getHitRadius() {
		// This you just need to define to tell it how big your ship should be
		return 0;
	}

	@Override
	public int getBmpID() {
		// This is how it knows what to draw for your ship, it's..complicated.
		return 0;
	}

}

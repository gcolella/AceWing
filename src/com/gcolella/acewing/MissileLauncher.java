package com.gcolella.acewing;

public class MissileLauncher extends Weapon {

	public MissileLauncher(int ammo,UniverseObject obj) {
		super(ammo,obj);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Missile";
	}
	public void fire(){
		if(!canFire() || !(firer instanceof Targeter))
			return;
		super.fire();
		Targeter tracker = (Targeter)firer;
		new Missile(firer.getLocation(),40,new Vector(firer.getVelocity().getAngle(),5+firer.getVelocity().getMagnitude()),firer.getUniverse(),50,firer.IDnum, firer.getTeam(),tracker.getCurrentTarget());
		
		
	}

}

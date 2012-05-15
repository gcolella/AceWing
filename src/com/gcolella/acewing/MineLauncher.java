package com.gcolella.acewing;

public class MineLauncher extends Weapon {

	public MineLauncher(int ammo, UniverseObject obj) {
		super(ammo, obj);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		return "Mine";
	}
	public void fire(){
		super.fire();
		new Mine(firer.getLocation(),40,new Vector(0,0),firer.getUniverse(),firer.getTeam(),100, firer.IDnum);
	}

}

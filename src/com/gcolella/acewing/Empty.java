package com.gcolella.acewing;

public class Empty extends Weapon {

	public Empty(int ammo, UniverseObject obj) {
		super(ammo, obj);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "OFF";
	}
	@Override
	public boolean canFire(){
		return true;
	}
	public void fire(){}
}

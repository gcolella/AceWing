package com.gcolella.acewing;

public abstract class Weapon {
	int ammo;
	UniverseObject firer;
	public Weapon(int ammo,UniverseObject obj)
	{
	 this.ammo = ammo;	
	 firer=obj;
	}
	public void fire()
	{
		ammo--;
	}
	public abstract String getName();
	public int getAmmo()
	{
		return ammo;
	}
	public void addAmmo(int n)
	{
		ammo+=n;
	}
	public boolean canFire()
	{
		return ammo>0;
	}
}

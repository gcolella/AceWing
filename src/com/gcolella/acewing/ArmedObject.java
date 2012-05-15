package com.gcolella.acewing;

import java.util.ArrayList;

import android.util.Log;

public abstract class ArmedObject extends UniverseObject {
	int secondary=0;
	ArrayList<Weapon> secondaries;
	private UniverseObject currentTarget;
	
	public UniverseObject getCurrentTarget(){
		return currentTarget;
	}
	public void setTarget(UniverseObject obj){
		if(obj==null && this instanceof ControlledShip)
			Log.e("OUTPUTSHOOTER","NULLIN");
		currentTarget = obj;
	}
	public ArmedObject(Location newloc, float health, Vector newvelo,
			Universe theverse, Team team) {
		super(newloc, health, newvelo, theverse,team);
		secondaries = new ArrayList<Weapon>();
		secondaries.add(new Empty(0,this));
	}
	public void setAmmo(ArrayList<Weapon> in)
	{
		secondaries = in;
	}
	public void addAmmo(int i,int n)
	{
		if(i>=secondaries.size())
			return;
		secondaries.get(i).addAmmo(n);
	}
	public boolean hasTarget()
	{
		return currentTarget != null;
	}
	public String getSecondaryName(){
		if(secondary==0)
			return "OFF";
		return secondaries.get(secondary).getName();
	}
	public void fireSecondary(){

		if(secondaries.get(secondary).canFire())
		{
			secondaries.get(secondary).fire();
		}
	}
	public void switchSecondary(){
	do{
		secondary++;
		if(secondary>=secondaries.size()){
			secondary = 0;
			return;
		}
		Log.e("OUTPUTSHOOTER","weapon: "+secondary+"  "+secondaries.get(secondary)+" "+secondaries.get(secondary).canFire());
	}while(!secondaries.get(secondary).canFire());
	}
	public abstract int maxSecondary();
	public void fire(float angle)
	{
		Vector fireVelo = new Vector(angle,15+getVelocity().getMagnitude());
		new Bullet( getLocation(),10, fireVelo, getUniverse(),Team.AGGRO, 10,IDnum);
	}
	public void fire()
	{
		fire(getVelocity().getAngle());
	}
	public void addAmmo(Weapon w){
		secondaries.add(w);
	}
	public int currentAmmo(){
		return secondaries.get(secondary).getAmmo();
	}
	/*
	public void fireJammer()
	{
		new Jammer(getLocation(),10,new Vector((float)(Math.random()*2*Math.PI),.5f),getUniverse(), getTeam(),IDnum);
	}
	public void fireMine()
	{
		new Mine(getLocation(),40,new Vector(0,0),getUniverse(),getTeam(),100, IDnum);
	}
	public void releaseDrone()
	{
		new Drone(getLocation().offset((float)(Math.random()*50)-25, (float)(Math.random()*50)-25),100,new Vector(getVelocity().getAngle(),3),getUniverse(),getTeam(),IDnum);
	}
	public void deployForceField()
	{
		new ForceField(getLocation(),200, new Vector(0,0),getUniverse(),getTeam(),IDnum);
	}
	*/


}

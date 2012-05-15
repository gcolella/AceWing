package com.gcolella.acewing;

import java.io.Serializable;

public class Location implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8891913207659732681L;
	float x;
	float y;
	public float getX()
	{
		return x;
	}
	public float getY()
	{
		return y;
	}
	Location(float nx, float ny){
		x=nx;
		y=ny;
	}
	Vector getVectorTowards(Location l){
		return new Vector(l.getX()-getX(),l.getY()-getY(),true);
	}
	public float angleTo(Location loc){
		return getVectorTowards(loc).getAngle(); 
	}
	public float distanceTo(Location l){
		return (float)Math.sqrt(((x-l.getX())*(x-l.getX())) + ((y-l.getY())*(y-l.getY())));
	}
	public static Location randomLocation(int x, int y)
	{
		return new Location(20+(int)(Math.random()*(x-20)),20+(int)(Math.random()*(y-20)));
	}
	public Location offset(float x, float y){
		return new Location(getX()+x,getY()+y);
	}
	public String toString(){
		return "x: "+(int)x+" y: "+(int)y;
	}
	public static Location randomLocation()
	{
		return Location.randomLocation(Spawner.getDefaultX(), Spawner.getDefaultY());
	}

}

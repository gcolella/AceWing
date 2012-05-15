package com.gcolella.acewing;

import java.io.Serializable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public abstract class UniverseObject implements Serializable {
			private float maxhealth;
		    private float health;
		    private Location currentLoc;
		    public final int IDnum;
		    private Vector myVelocity;
		    private transient Universe myverse;
		    private int score;
		    private transient Bitmap mypic;
		    private Team myteam;
		    private boolean inWorld;
			public UniverseObject(Location newloc, float health, Vector newvelo, Universe theverse, Team team) {
				IDnum = ID.getNextID();
				currentLoc = newloc;
				this.health = health;
				maxhealth = health;
				myVelocity = newvelo;
				myverse = theverse;
				score = 0;
				theverse.add(this);
				myteam = team;
				inWorld = true;
			} 
			public Team getTeam(){
				return myteam;
			}
			public void initBMP(){
				setBMP(BitmapFactory.decodeResource(getUniverse().getContext().getResources(), getBmpID()));
			}
			public void setBMP(Bitmap bmp){
				mypic = bmp;
			}
			public boolean explodes(){
				return true;
			}
			public int getScore(){
				return score;
			}
			public void addScore(int s){
				score +=s;
			}
			public Universe getUniverse(){
				return myverse;
			}
			public abstract float getHitRadius();
			public Location getLocation(){
				return currentLoc;
			}
			public void setLocation(Location newloc){
				currentLoc = newloc;
			}
			public float getMaxHealth(){
				return maxhealth;
			}
			public boolean teammate(UniverseObject other){
				return myteam.ally(other.myteam);
			}
			public float getHealth() {
				return health;
			}
			public Vector getVelocity(){
				return myVelocity;
			}
			public void accel(float accel){
				myVelocity.setMagnitude(myVelocity.getMagnitude() + accel);
			}
			public void setHealth(float health) {
				this.health = health;}
			public void damage(float damage){
				health-=damage;
			}
			public void update(){
				currentLoc = new Location(currentLoc.getX()+myVelocity.getiComponent(),currentLoc.getY()+myVelocity.getjComponent());
			}
			public void turn(float ang){
				myVelocity.setAngle(myVelocity.getAngle()+ang);
			}
			public void removeMe()
			{
				myverse.remove(this);
				inWorld = false;
			}
			public boolean inWorld(){
				return inWorld;
			}
			public Bitmap getBMP(){
				if(mypic==null)
					initBMP();
				return mypic;
			}
			public void setVelocity(Vector v)
			{
				myVelocity = v;
			}
			public void setUniverse(Universe u){
				myverse = u;
			}
			public boolean equals(Object obj){
				if(obj==null || !(obj instanceof UniverseObject))
					return false;
				return ((UniverseObject)obj).IDnum == IDnum;
			}
			public abstract int getBmpID();
			public void init(){}
	 }


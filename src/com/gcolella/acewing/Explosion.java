package com.gcolella.acewing;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Explosion extends UniverseObject implements DamageObject {
	int life = 50;
	int createID;
	float size;
	float damage;
	ArrayList<Integer> damaged;
	public Explosion(Location newloc, float size, float damage, Universe theverse,Team team, int creatorID){
		super(newloc, 999, new Vector(0,0),theverse,team); 
		this.size = size;
		this.damage = damage;
		createID = creatorID;
		damaged = new ArrayList<Integer>();
	}
	public void initBMP(){
		Bitmap smallbit = BitmapFactory.decodeResource(getUniverse().getContext().getResources(),R.drawable.explosion);
		setBMP(Bitmap.createScaledBitmap(smallbit,(int)(2*size),(int)(2*size), false));
	}
	@Override
	public float getDamage() {
		// TODO Auto-generated method stub
		return damage;
	}

	@Override
	public boolean penetration() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getCreatorID() {
		// TODO Auto-generated method stub
		return createID;
	}

	@Override
	public boolean targetable(UniverseObject obj) {
		if(obj==null)
			return false;
		if(obj instanceof Powerup)
			return false;
		if(!(damaged.contains(obj.IDnum))){
			damaged.add(obj.IDnum);
			return true;
		}
		return false;
	}

	@Override
	public float getHitRadius() {
		// TODO Auto-generated method stub
		return size;
	}
	public void update(){
		life--;
		if(life<=0)
			removeMe();
	}
	@Override
	public int getBmpID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getExplosionRadius() {
		// TODO Auto-generated method stub
		return -1;
	}

}

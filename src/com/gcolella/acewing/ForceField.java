package com.gcolella.acewing;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ForceField extends UniverseObject {
	int createID;
	int lifetime = 200;
	UniverseObject creator;
	public ForceField(Location newloc, float health, Vector newvelo,
			Universe theverse,Team team, int create) {
		super(newloc, health, newvelo, theverse,team);
		createID = create;
		creator = getUniverse().findID(createID);
		// TODO Auto-generated constructor stub
	}
	public void initBMP(){
	Bitmap smallbit = BitmapFactory.decodeResource(getUniverse().getContext().getResources(),R.drawable.forcefield);
	setBMP(Bitmap.createScaledBitmap(smallbit,(int)(2*getSize()),(int)(2*getSize()), false));
	}
	@Override
	public float getHitRadius() {
		// TODO Auto-generated method stub
		return getSize();
	}
	public boolean explodes(){
		return false;
	}
	public void update(){
		setLocation(creator.getLocation());
		lifetime--;
		if(lifetime<0)
			removeMe();
	}
	@Override
	public int getBmpID() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getSize() {
		return (int) (creator.getHitRadius() + 20);
	}

}

package com.gcolella.acewing;

public class Spawner {
static int defaultX,defaultY;
public static void setDefaults(int x,int y)
{
	defaultX = x;
	defaultY = y;
}
public static int getDefaultX(){
	return defaultX;
}
public static int getDefaultY(){
	return defaultY;
}
static EnemyShip spawnEnemy(Universe u){
	return new EnemyShip( Location.randomLocation(defaultX,defaultY), 50, new Vector(2,6), u,Team.RED);
}
	
	
}

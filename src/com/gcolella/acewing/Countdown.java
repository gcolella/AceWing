package com.gcolella.acewing;

import java.io.Serializable;

public class Countdown implements Serializable {
protected int cooldown;
protected int countdown;
public Countdown(int c){
	countdown = c;
	cooldown = c;
}
public void cool(){
	if(countdown>0)
		countdown--;
}
public void reset(){
	countdown=cooldown;
}

//should be used if you wish it to reset every time it's true.
public boolean timeUp(){
	if(countdown==0){
		reset();
		return true;
	}
	return false;
}


}

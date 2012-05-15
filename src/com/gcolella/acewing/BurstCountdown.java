package com.gcolella.acewing;

import android.util.Log;

public class BurstCountdown extends Countdown  {
	
	Countdown betweenBursts;
	Countdown inBursts;
	
	public BurstCountdown(int between, int length, int burstdelay) {
		super(burstdelay*length);
		betweenBursts = new Countdown(between);
		inBursts = new Countdown(burstdelay);
	}
	public void cool()
	{
		betweenBursts.cool();
		inBursts.cool();
	}
	public boolean timeUp(){
		if(betweenBursts.timeUp())
			reset();
		super.cool();
		//Log.e("OUTPUTSHOOTER","between: "+betweenBursts.countdown+" next burst in: "+countdown);
		return (countdown != 0) && inBursts.timeUp();
	}

}

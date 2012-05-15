package com.gcolella.acewing;

import java.io.Serializable;

import android.graphics.Color;

public class Team implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 8550074528167720780L;
static Team RED    = new Team(Color.RED,    1);
static Team GREEN  = new Team(Color.GREEN,  2);
static Team BLUE   = new Team(Color.BLUE,   3);
static Team AGGRO  = new Team(Color.BLACK, -1);
static Team YELLOW = new Team(Color.YELLOW, 4);
static Team FRIEND = new Team(Color.WHITE,  0);

final int color,nmbr;

public Team(int clr, int number){
color = clr;
nmbr = number;
}
public boolean ally(Team t){
	return (t.nmbr == 0 || nmbr == 0)||((nmbr!=-1) && (nmbr == (t).nmbr));
}
public boolean same(Team t){
	return (t.nmbr==nmbr);
}
}

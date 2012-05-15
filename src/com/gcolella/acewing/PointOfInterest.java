package com.gcolella.acewing;

public class PointOfInterest extends Location {
	int color;
	public PointOfInterest(float nx, float ny, int clr) {
		super(nx, ny);
		color = clr;
	}
	int getColor(){
		return color;
	}

}

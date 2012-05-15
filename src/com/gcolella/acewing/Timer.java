package com.gcolella.acewing;

public class Timer {
long start;
public Timer(){
	start = System.nanoTime();
}

public long elapsed(){
	return System.nanoTime()-start;
}
}

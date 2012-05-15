package com.gcolella.acewing;

public class ID {
	static int currentID=0;
	static int getNextID()
	{
		currentID++;
		return currentID;
	}
	static void clearIDs()
	{
		currentID=0;
	}
}

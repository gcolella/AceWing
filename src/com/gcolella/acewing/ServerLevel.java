package com.gcolella.acewing;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import android.content.Context;
import android.util.Log;

public class ServerLevel extends Level {

	Thread networking = null;
	int SERVERPORT = 6000;
	ArrayList<UniverseObject> sendQueu;
	
	public ServerLevel(Context ctx, AceWingActivity home) {
		super(ctx, home);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean levelComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean levelFailed() {
		// TODO Auto-generated method stub
		return false;
	}
	void killThread()
	{
		try {
			networking.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	@Override
	void setup() {
		Thread networker = new Thread(new ServerThread());
		networker.start();
		out = new Universe(myctx);
		myship = new BasicPlayer( new Location(0,0), 100, new Vector(0,4), out,Team.GREEN);
		Spawner.spawnEnemy(out);
		Spawner.spawnEnemy(out);
		new Gunship(Location.randomLocation(Spawner.getDefaultX(), Spawner.getDefaultY()),100,new Vector(0,1),out,Team.RED);
		//myship.addAmmo(0,10);
	}
	
	public void updateLevel(){
		sendQueu = out.getStuff();
	}

	@Override
	String levelText() {
		// TODO Auto-generated method stub
		return "Server to play against yo buddies!";
	}

	@Override
	boolean powerups() {
		// TODO Auto-generated method stub
		return false;
	}
	
	class ServerThread implements Runnable
	{
		ServerSocket server = null;
		Socket controlSocket = null;
		ObjectOutputStream outStream = null;
		ObjectInputStream inStream = null;
		@Override
		public void run() {
			setupConnection();
			while(true){
				sendObject(out.getStuff());		
			}
				
			
		}
		void setupConnection(){
			Log.e("OUTPUTSHOOTER","init-connect");
			try {
			    server = new ServerSocket(SERVERPORT);
			    Log.e("OUTPUTSHOOTER","server initiated port: "+SERVERPORT);
			controlSocket = server.accept();
			Log.e("OUTPUTSHOOTER","connected");
			outStream = new ObjectOutputStream(controlSocket.getOutputStream());
			inStream =  new ObjectInputStream(controlSocket.getInputStream());

			} catch (StreamCorruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Log.e("OUTPUTSHOOTER",server+" "+controlSocket+" "+inStream+" "+outStream);
			}
		
		public Object recieveObject(){
			Object o = null;
			try {
				o = inStream.readObject();
			} catch (OptionalDataException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return o;
		}
		public void sendObject(Object o)
		{
				try {
					outStream.writeObject(sendQueu);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}

	@Override
	int getBackround() {
		// TODO Auto-generated method stub
		return R.drawable.ocean;
	}

}

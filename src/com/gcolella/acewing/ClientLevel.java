package com.gcolella.acewing;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.gcolella.acewing.Level.ButtonListener;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ClientLevel extends Level {
	Thread networking = null;
	String SERVERIP = "10.0.2.2";
	int SERVERPORT = 6000;
	boolean needsUpdate;
	ArrayList<UniverseObject> loadQueu;
	LinearLayout levelScreen(){
		LinearLayout out = new LinearLayout(myctx);
		out.setOrientation(LinearLayout.VERTICAL);
		EditText stuff = new EditText(myctx);
		stuff.setText("192.168.1.5");
		Button cont= new Button(myctx);
		cont.setText("Continue");
		cont.setOnClickListener(new IPButton(this,stuff));
		out.addView(stuff);
		out.addView(cont);
		return out;
	}
	
	public ClientLevel(Context ctx, AceWingActivity home) {
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
	boolean shouldCalc(){
		return false;
	}
	void updateLevel(){
		Log.e("OUTPUTSHOOTER","load");
		if(loadQueu!=null){
	//	Timer load = new Timer();
		out.load(loadQueu);
		needsUpdate = true;
	//	Log.e("OUTPUTSHOOTER","elapsed: "+load.elapsed());
		}
	}
	
	@Override
	void setup() {
		networking = new Thread(new ClientThread());
		out = new Universe(myctx);
		networking.start();
		

	}

	@Override
	String levelText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	boolean powerups() {
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
	class ClientThread implements Runnable
	{
		Socket controlSocket = null;
		ObjectOutputStream outStream = null;
		ObjectInputStream inStream = null;
		@Override
		public void run() {
			setupConnection();
			while(true){
			//	Log.e("OUTPUTSHOOTER","recieving");
				if(true){
				Object in = recieveObject();
				if(in!= null && in instanceof ArrayList)
				{
					loadQueu = (ArrayList<UniverseObject>)in;
					needsUpdate = false;
					//Log.e("OUTPUTSHOOTER","qued "+in);
				}
				}
			}
				
			
		}

		void setupConnection(){
			Log.e("OUTPUTSHOOTER","ip: "+SERVERIP);
			while(controlSocket == null) {
				try {
					controlSocket = new Socket(SERVERIP,SERVERPORT);
					Log.e("OUTPUTSHOOTER","socket connected");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			try {
				Log.e("OUTPUTSHOOTER","attempting streams");
				outStream = new ObjectOutputStream(controlSocket.getOutputStream());
				Log.e("OUTPUTSHOOTER","output working");
				inStream =  new ObjectInputStream(controlSocket.getInputStream());
				Log.e("OUTPUTSHOOTER","steams connected :D");

			} catch (StreamCorruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
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
					outStream.writeObject(o);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}
	class IPButton extends Level.ButtonListener
	{
		EditText mytext;
		IPButton(Level l,EditText text){
			super(l);
			mytext = text;
		}
		@Override
		public void onClick(View v) {
			SERVERIP = mytext.getText().toString();
			super.onClick(v);
		}
				
	}
	@Override
	int getBackround() {
		// TODO Auto-generated method stub
		return R.drawable.ocean;
	}
}

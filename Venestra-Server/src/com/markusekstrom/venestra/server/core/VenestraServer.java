package com.markusekstrom.venestra.server.core;

import com.markusekstrom.venestra.engine.messages.IMessageEvent;
import com.markusekstrom.venestra.engine.messages.IMessageListener;
import com.markusekstrom.venestra.server.network.NetworkServer;

public class VenestraServer implements IMessageListener{

	private VenestraServer() {
		NetworkServer nServer = new NetworkServer(this);
		Thread nServerThread = new Thread(nServer);
		nServerThread.start();
	}

	@Override
	public void messageReceived(IMessageEvent e) {
		
	}
	
	
	/**
	 * Entry point for the server.
	 */
	public static void main(String[] args) {
		new VenestraServer();
	}

}

/* 
 * Copyright (c) 2012 Markus Ekström
 * 
 * This file is part of Venestra.
 * 
 * Venestra is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Venestra is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Venestra.  If not, see <http://www.gnu.org/licenses/>. 
 *  
 * Author can be reached by mail via markus_xtrom@hotmail.com.
 */
package com.markusekstrom.venestra.engine.messages;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages {@link IMessageListener}s.
 * 
 * Is able to add, remove and send messages to listeners.
 *
 * @author Markus Ekström
 */
public class MessagingSupport {

	private final List<IMessageListener> listeners = new ArrayList<IMessageListener>();
	
	/**
	 * Adds a listener to the sending list.
	 * 
	 * @param listener
	 * The {@link IMessageListener} to be added.
	 */
	public void addListener(IMessageListener listener) {
		listeners.add(listener);
	}
	
	/**
	 * Removes a listener from the sending list
	 * 
	 * @param listener
	 * The {@link IMessageListener} to be removed.
	 */
	public void removeListener(IMessageListener listener) {
		listeners.remove(listener);
	}
	
	/**
	 * Sends a message to all listeners on the sending list.
	 * 
	 * @param e
	 * The {@link IMessageEvent} to be sent.
	 */
	public void sendMessage(IMessageEvent e) {
		for(IMessageListener mL : listeners) {
			mL.messageReceived(e);
		}
	}

}

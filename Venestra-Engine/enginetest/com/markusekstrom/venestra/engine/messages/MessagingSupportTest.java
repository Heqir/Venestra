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

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MessagingSupportTest {
	
	//Used to verify that messages are indeed sent as intended.
	private static int messagesReceived = 0;
	//Our test listener.
	private IMessageListener listener;
	//Our test message.
	private IMessageEvent message;
	//Our instance of MessagingSupport we use to test.
	private MessagingSupport ms;
	
	@Before
	public void setUp() throws Exception {
		listener = new TestListener();
		message = new TestMessage();
		ms = new MessagingSupport();
	}

	@Test
	public void testMessagingSupport() {
		ms.addListener(listener);
		ms.sendMessage(message);
		assertTrue(messagesReceived == 1);
		ms.removeListener(listener);
		ms.sendMessage(message);
		assertTrue(messagesReceived == 1);
	}
	
	/**
	 * A private test listener which will make us able to verify 
	 * that the messages are being sent correctly.
	 *
	 * @author Markus Ekström
	 */
	private class TestListener implements IMessageListener {

		@Override
		public void messageReceived(IMessageEvent e) {
			messagesReceived++;
		}
		
	}
	
	/**
	 * A private test class representing a message.
	 *
	 * @author Markus Ekström
	 */
	private class TestMessage implements IMessageEvent {

		@Override
		public String getType() {
			return this.getClass().getSimpleName();
		}
		
	}
}

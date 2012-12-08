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

public class CTSGameMessageTest {
	
	//Our message to test.
	private CTSGameMessage message;
	private int[][] positionsSent = {
		{0, 5, 5, 7, 7},
		{1, 2, 2, 3, 2}
	};
	private int[][] positionsReceived = {
		{0, 5, 5, 7, 7},
		{1, 2, 2, 3, 2}
	};
	
	@Before
	public void setUp() throws Exception {
		message = new CTSGameMessage(positionsSent);
	}

	@Test
	public void testGetPositions() {
		assertArrayEquals(positionsReceived, message.getPositions());
		positionsSent[0][2] = 0;
		assertTrue(message.getPositions()[0][2] != 0);
		
		
	}
	
	@Test
	public void testGetType() {
		assertTrue(message.getType().equals(CTSGameMessage.class.getSimpleName()));
	}

}

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
package com.markusekstrom.venestra.common.core.components;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.markusekstrom.venestra.common.components.Turn;
import com.markusekstrom.venestra.common.components.Turn.Actor;

public class TurnTest {

	private static final int initialTurnNumber = 0;
	private static final int setTurnNumber = 2;
	private static final Actor initialActor = Actor.Player;
	
	private Turn turn;
	
	@Before
	public void setUp() throws Exception {
		turn = new Turn(initialTurnNumber, initialActor);
	}
	
	@Test
	public void testTurn() {
		Turn newTurn = new Turn(initialTurnNumber, initialActor);
		assertTrue(newTurn != null);
		assertTrue(newTurn.getTurn() == 0);
		assertTrue(newTurn.getActor() == initialActor);
	}
	
	@Test
	public void testSetAndGetTurn() {
		assertTrue(turn.getTurn() == initialTurnNumber);
		turn.setTurn(setTurnNumber);
		assertTrue(turn.getTurn() == setTurnNumber);
	}
	
	@Test
	public void testIncrementTurn() {
		assertTrue(turn.getTurn() == initialTurnNumber);
		turn.incrementTurn();
		assertTrue(turn.getTurn() == initialTurnNumber + 1);
	}
	
	@Test
	public void testSetAndGetActor() {
		assertTrue(turn.getActor() == initialActor);
		turn.setActor(Actor.Enemies);
		assertTrue(turn.getActor() == Actor.Enemies);
	}

}

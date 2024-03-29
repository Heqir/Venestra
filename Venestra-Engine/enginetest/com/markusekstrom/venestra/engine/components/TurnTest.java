/* 
 * Copyright (c) 2012 Markus Ekstr�m
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
package com.markusekstrom.venestra.engine.components;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.markusekstrom.venestra.engine.components.Actor;
import com.markusekstrom.venestra.engine.components.Turn;
import com.markusekstrom.venestra.engine.components.utils.TurnUtils;

public class TurnTest {

	private static final short turnNumber = 2;
	private static final Actor player1 = new Actor();
	private Turn turn;
	
	@Before
	public void setUp() throws Exception {
		turn = new Turn();
	}
	
	@Test
	public void testCreate() {
		Turn createdTurn = TurnUtils.create(turnNumber, player1);
		assertTrue(createdTurn != null);
		assertTrue(createdTurn.currentTurn == turnNumber);
		assertTrue(createdTurn.currentActor.equals(player1));
	}
	
	@Test
	public void testSet() {
		TurnUtils.set(turn, turnNumber, player1);
		assertTrue(turn.currentActor.equals(player1));
		assertTrue(turn.currentTurn == turnNumber);
	}
}

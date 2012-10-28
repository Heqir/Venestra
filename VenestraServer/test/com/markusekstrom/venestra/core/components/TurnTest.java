package com.markusekstrom.venestra.core.components;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.markusekstrom.venestra.core.components.Turn.Actor;

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

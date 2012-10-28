package com.markusekstrom.venestra.common.core.components;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.markusekstrom.venestra.common.components.Position;


public class PositionTest {

	private static final int initialX = 3;
	private static final int initialY = 7;
	
	private static final int secondX = 13;
	private static final int secondY = 16;
	
	private static final int negativeX = -9;
	private static final int negativeY = -9;
	
	private static final int addingX = 5;
	private static final int addingY = 6;
	
	
	private Position pos;
	
	@Before
	public void setUp() throws Exception {
		pos = new Position(initialX, initialY);
	}
	
	@Test
	public void testTurn() {
		Position newPos = new Position(initialX, initialY);
		assertTrue(newPos != null);
		assertTrue(newPos.getX() == initialX);
		assertTrue(newPos.getY() == initialY);
	}
	
	@Test
	public void testSetAndGetX() {
		assertTrue(pos.getX() == initialX);
		pos.setX(secondX);
		assertTrue(pos.getX() == secondX);
	}
	
	@Test
	public void testSetAndGetY() {
		assertTrue(pos.getY() == initialY);
		pos.setY(secondY);
		assertTrue(pos.getY() == secondY);
	}
	
	@Test
	public void testSetNegatives() {
		pos.setX(negativeX);
		pos.setY(negativeY);
		assertTrue(pos.getX() == negativeY);
		assertTrue(pos.getY() == negativeY);
	}
	
	@Test
	public void testAdd() {
		pos.add(addingX, addingY);
		assertTrue(pos.getX() == initialX + addingX);
		assertTrue(pos.getY() == initialY + addingY);
	}

	@Test
	public void testAddNegatives() {
		pos.add(-addingX, -addingY);
		assertTrue(pos.getX() == initialX - addingX);
		assertTrue(pos.getY() == initialY - addingY);
	}
}

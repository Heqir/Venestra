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
package com.markusekstrom.venestra.engine.components;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.markusekstrom.venestra.engine.components.Position;
import com.markusekstrom.venestra.engine.components.utils.PositionUtils;


public class PositionUtilsTest {

	private static final short x1 = 3;
	private static final short y1 = 7;
	
	private static final short x2 = 13;
	private static final short y2 = 16;
	
	private static Position pos1;
	private static Position pos2;
	
	
	private Position pos;
	
	@Before
	public void setUp() throws Exception {
		pos1 = new Position();
		pos2 = new Position();
	}
	
	@Test
	public void testSet() {
		assertTrue(pos1.x == 0);
		assertTrue(pos1.y == 0);
		PositionUtils.set(pos1, x1, y1);
		assertTrue(pos1.x == x1);
		assertTrue(pos1.y == y1);
	}
	
	@Test
	public void testAdd() {
		PositionUtils.set(pos1, x1, y1);
		PositionUtils.set(pos2, x2, y2);
		PositionUtils.add(pos1, pos2);
		assertTrue(pos1.x == (x1+x2));
		assertTrue(pos1.y == (y1+y2));
		
		PositionUtils.set(pos1, x1, y1);
		PositionUtils.add(pos1, x2, y2);
		assertTrue(pos1.x == (x1+x2));
		assertTrue(pos1.y == (y1+y2));
	}
	
	@Test
	public void testSubtract() {
		PositionUtils.set(pos1, x1, y1);
		PositionUtils.set(pos2, x2, y2);
		PositionUtils.subtract(pos1, pos2);
		assertTrue(pos1.x == (x1-x2));
		assertTrue(pos1.y == (y1-y2));
		
		PositionUtils.set(pos1, x1, y1);
		PositionUtils.subtract(pos1, x2, y2);
		assertTrue(pos1.x == (x1-x2));
		assertTrue(pos1.y == (y1-y2));
		
	}
}

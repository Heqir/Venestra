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
package com.markusekstrom.venestra.engine.components.utils;

import com.markusekstrom.venestra.engine.components.Position;

public class PositionUtils {
	
	//Hidden constructor
	private PositionUtils(){};
	
	/**
	 * Creates and initializes a Position.
	 * 
	 * @param x
	 * The x the position shall be initialized with.
	 * 
	 * @param y
	 * The y the position shall be initialized with.
	 * 
	 * @return
	 * The created and initialized Position.
	 */
	public static Position create(short x, short y){
		Position pos = new Position();
		pos.x = x;
		pos.y = y;
		return pos;
	}
	
	/**
	 * Sets the pos.x to x and pos.y to y.
	 * 
	 * @param pos
	 * The position to set.
	 * 
	 * @param x
	 * The x to set to pos.x.
	 * 
	 * @param y
	 * The y to set to pos.y.
	 */
	public static void set(Position pos, short x, short y) {
		pos.x = x;
		pos.y = y;
	}
	
	/**
	 * Adds pos2 to pos1, i.e. add pos2.x to pos1.x and pos2.y to pos1.y. 
	 * 
	 * @param pos1
	 * The position to add to.
	 * 
	 * @param pos2
	 * The position to add
	 */
	public static void add(Position pos1, Position pos2) {
		pos1.x += pos2.x;
		pos1.y += pos2.y;
	}
	
	/**
	 * Adds x and y to pos.x and pos.y respectively. 
	 * 
	 * @param pos
	 * The position to add to.
	 * 
	 * @param x
	 * The amount to add to pos.x.
	 * 
	 * @param y
	 * The amount to add to pos.y.
	 */
	public static void add(Position pos, short x, short y) {
		pos.x += x;
		pos.y += y;
	}
	
	/**
	 * Subtracts pos2 from pos1, i.e. subtract pos2.x from pos1.x and pos2.y from pos1.y. 
	 * 
	 * @param pos1
	 * The position to subtract from.
	 * 
	 * @param pos2
	 * The position to subtract with
	 */
	public static void subtract(Position pos1, Position pos2) {
		pos1.x -= pos2.x;
		pos1.y -= pos2.y;
	}
	
	/**
	 * Subtracts x and y from pos.x and pos.y respectively. 
	 * 
	 * @param pos
	 * The position to subtract from.
	 * 
	 * @param x
	 * The amount to subtract from pos.x.
	 * 
	 * @param y
	 * The amount to subtract from pos.y.
	 */
	public static void subtract(Position pos, short x, short y) {
		pos.x -= x;
		pos.y -= y;
	}
	
}

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
package com.markusekstrom.venestra.common.components;

import com.artemis.Component;

/**
 * Contains information about tactical location.
 *
 * @author Markus Ekström
 */
public class Position extends Component {
	
	private int x;
	private int y;
	
	/**
	 * Constructs a Position and sets it to the passed values.
	 * 
	 * @param x
	 * The desired position on the x-axis.
	 * 
	 * @param y
	 * The desired position on the y-axis.
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Sets the position along the x-axis to the passed value.
	 * 
	 * @param x
	 * The desired position on the x-axis.
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Sets the position along the y-axis to the passed value.
	 * 
	 * @param y
	 * The desired position on the y-axis.
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Retrieves the position on the x-axis.
	 * 
	 * @return
	 * The position on the x-axis.
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Retrieves the position on the y-axis.
	 * 
	 * @return
	 * The position on the y-axis.
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Adds the passed position to the current position.
	 * 
	 * @param x
	 * The value to add to the current position on the x-axis.
	 * 
	 * @param y
	 * The value to add to the current position on the y-axis.
	 */
	public void add(int x, int y) {
		this.x += x;
		this.y += y;
	}
}

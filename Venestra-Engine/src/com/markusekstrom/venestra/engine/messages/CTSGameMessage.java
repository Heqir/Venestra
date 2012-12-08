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

import com.markusekstrom.venestra.engine.util.VenestraUtils;

/**
 * A class describing a Client-to-Server message 
 * containing the changes a client wants to make to the game state.
 *
 * @author Markus Ekström
 */
public class CTSGameMessage implements IMessageEvent{
	private final int[][] positions;
    
	/**
	 * Creates a Client-to-Server game message.
	 * 
	 * @param positions
	 * A matrix containing the ID's of moved pieces and their current and 
	 * desired position. It should be set up as follows:
	 * 
	 * positions[x][0] = ID of piece.
	 * positions[x][1] = current x-position.
	 * positions[x][2] = current y-position.
	 * positions[x][3] = desired x-position.
	 * positions[x][4] = desired y-position.
	 */
	public CTSGameMessage(int[][] positions) {
		this.positions = VenestraUtils.copyMatrix(positions);
	}
    
	/**
	 * Returns a matrix containing the ID's of moved pieces and
	 * their current and desired position. The convention is as follows:
	 * 
	 * positions[x][0] = ID of piece.
	 * positions[x][1] = current x-position.
	 * positions[x][2] = current y-position.
	 * positions[x][3] = desired x-position.
	 * positions[x][4] = desired y-position.
	 * 
	 * @return
	 * A matrix of ints describing movement.
	 */
	public int[][] getPositions() {
		return positions;
	}
	
	@Override
	public String getType() {
		return this.getClass().getSimpleName();
	}
}

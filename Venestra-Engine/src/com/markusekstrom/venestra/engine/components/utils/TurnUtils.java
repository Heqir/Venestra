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

import com.markusekstrom.venestra.engine.components.Actor;
import com.markusekstrom.venestra.engine.components.Turn;

public class TurnUtils {

	//Hidden constructor.
	private TurnUtils(){};
	
	/**
	 * Creates and initializes a turn.
	 * 
	 * @param startingTurn
	 * The turn number to start on.
	 * 
	 * @param startingActor
	 * The actor who is starting.
	 * 
	 * @return
	 * An initialized turn.
	 */
	public static Turn create(short startingTurn, Actor startingActor) {
		Turn turn = new Turn();
		turn.currentTurn = startingTurn;
		turn.currentActor = startingActor;
		return turn;
	}
	
	/**
	 * Creates
	 * 
	 * @param turn
	 * @param desiredTurn
	 * @param desiredActor
	 */
	public static void set(Turn turn, short desiredTurn, Actor desiredActor) {
		turn.currentTurn = desiredTurn;
		turn.currentActor = desiredActor;
	}
	
}

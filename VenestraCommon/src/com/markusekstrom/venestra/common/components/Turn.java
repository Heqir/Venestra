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

import java.awt.Component;
/**
 * Contains information about a turn.
 *
 * @author Markus Ekström
 */
public class Turn extends Component{
	/**
	 * The possible actors of the turn.
	 */
	public static enum Actor{
		Player,
		Enemies
	}
	
	private int currentTurn;
	private Actor currentActor;
	
	public Turn(int startingTurn, Actor startingActor) {
		currentTurn = startingTurn;
		currentActor = startingActor;
	}
	
	/**
	 * Sets the current turn.
	 * @param turnNumber The number to set the current turn to.
	 */
	public void setTurn(int turnNumber) {
		currentTurn = turnNumber;
	}
	
	/**
	 * Returns the current turn.
	 * @return An integer representing the current turn.
	 */
	public int getTurn() {
		return currentTurn;
	}
	
	/**
	 * Increments the current turn by 1.
	 */
	public void incrementTurn() {
		currentTurn++;
	}
	
	/**
	 * Sets the current actor to the passed actor.
	 * @param actor The actor to be set to current.
	 */
	public void setActor(Actor actor) {
		currentActor = actor;
	}
	
	/**
	 * Returns the current actor.
	 * @return The current actor.
	 */
	public Actor getActor() {
		return currentActor;
	}
	
	
}

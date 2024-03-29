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
package com.markusekstrom.venestra.server.core.states;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;

/**
 * A manager for the game's states.
 * 
 * @author Markus Ekstr�m
 */
public class StateManager implements PropertyChangeListener {
	private Map<StateID, IState> stateMap = new HashMap<StateID, IState>();
	private IState currentState;
	private PropertyChangeSupport pcs;

	/**
	 * Constructs a <code>StateManager</code> using the <code>Engine</code>
	 * provided.
	 * @param engine The engine from AndEngine.
	 */
	public StateManager() {
		pcs = new PropertyChangeSupport(this);
	}
	
	/**
	* Adds a state.
	* @param stateID The desired ID of the new state.
	* @param state The new state.
	*/
	public void addState(StateID stateID, IState state) {
		if (stateMap.put(stateID, state) == null)
			state.addPropertyChangeListener(this);
	}

	/**
	* Removes a state specified by the ID.
	* @param stateID The ID of the state to be removed.
	*/
	public void removeState(StateID stateID) {
		IState state = stateMap.remove(stateID);
		if (state != null)
			state.removePropertyChangeListener(this);
	}

	/**
	* Sets the current state to the passed state.
	* @param stateID The ID of the state to be set to current.
	*/
	public void setState(StateID stateID) {
		if (stateMap.get(stateID) != null) {
			currentState = stateMap.get(stateID);
		}
	}
	
	/**
	 * Updates the current state.
	 * @param tpf Time since last frame.
	 */
	public void update(float tpf) {
		currentState.update(tpf);
	}
	
	/**
	 * Reacts if there is to be a state change.
	 */
	public void propertyChange(PropertyChangeEvent event) {
	}
	
	/**
	 * Adds a listener to this state manager.
	 * @param pcl the listener to add
	 */
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		pcs.addPropertyChangeListener(pcl);
	}

	/**
	 * Removes a listener from this state manager.
	 * @param pcl the listener to remove
	 */
	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		pcs.removePropertyChangeListener(pcl);
	}
	
}

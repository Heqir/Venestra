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
package com.markusekstrom.venestra.engine.messages;

/**
 * An interface for network messages.
 *
 * @author Markus Ekstr�m
 */
public interface IMessageEvent {
	
	/**
	 * Returns the type of message.
	 * 
	 * @return 
	 * The type of message in the form of a String.
	 */
	public String getType();
	
}

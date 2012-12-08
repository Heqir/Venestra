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
package com.markusekstrom.venestra.engine.util;

public class VenestraUtils {
	
	/**
	 * Creates a shallow copy of an array.
	 * 
	 * @param array
	 * The array to be copied.
	 * 
	 * @return
	 * A shallow copy of the passed array.
	 */	
	public static <T> T[][] copyMatrix(T[][] array) {
		@SuppressWarnings("unchecked") T[][] arrayCopy = (T[][])new Object[array.length][array[0].length];
		
		if (array != null) {
			for(int i = 0; i<array.length; i++) {
				for(int j = 0; j<array[0].length; j++) {
					arrayCopy[i][j] = array[i][j];
				}
			}
		}
		return arrayCopy;
	}
	
	/**
	 * Creates a shallow copy of an array of integers.
	 * 
	 * @param array
	 * The array to be copied.
	 * 
	 * @return
	 * A shallow copy of the passed array.
	 */	
	public static int[][] copyMatrix(int[][] array) {
		int[][] arrayCopy = new int[array.length][array[0].length];
		
		if (array != null) {
			for(int i = 0; i<array.length; i++) {
				for(int j = 0; j<array[0].length; j++) {
					arrayCopy[i][j] = array[i][j];
				}
			}
		}
		return arrayCopy;
	}
}

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
package com.markusekstrom.venestra.desktop.core;
	 

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.markusekstrom.venestra.client.core.VenestraClient;
import com.markusekstrom.venestra.engine.constants.GeneralConstants;

public class VenestraDesktop {
	
	public static void main(String[] args) {
		 LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
	      cfg.title = GeneralConstants.GAME_NAME;
	      cfg.useGL20 = true;
	      cfg.width = GeneralConstants.RES_WIDTH;
	      cfg.height = GeneralConstants.RES_HEIGHT;
	      cfg.fullscreen = true;
	      new LwjglApplication(new VenestraClient(), cfg);

	}
}

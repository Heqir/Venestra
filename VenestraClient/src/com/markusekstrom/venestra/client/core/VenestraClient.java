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
package com.markusekstrom.venestra.client.core;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.markusekstrom.venestra.client.core.states.InGameState;
import com.markusekstrom.venestra.common.constants.GeneralConstants;
import com.markusekstrom.venestra.common.constants.StateID;

public class VenestraClient extends StateBasedGame{
	
	public VenestraClient(String gameName) {
		super(gameName);
	      this.addState(new InGameState());
	}

	@Override
	public void initStatesList(GameContainer gameContainer)
			throws SlickException {
	      this.getState(StateID.MENU_STATE).init(gameContainer, this);
	      this.getState(StateID.IN_GAME_STATE).init(gameContainer, this);
	      this.enterState(StateID.MENU_STATE);
		
	}
	
	public static void main(String[] args) {
	      AppGameContainer appgc;
	      try{
	         appgc = new AppGameContainer(new VenestraClient(GeneralConstants.GAME_NAME));
	         appgc.setDisplayMode(1920, 1080, true);
	         appgc.start();
	      }catch(SlickException e){
	         e.printStackTrace();
	      }
	   }

	}
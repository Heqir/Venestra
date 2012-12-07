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
package com.markusekstrom.venestra.server.network;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import com.markusekstrom.venestra.engine.messages.IMessageListener;
import com.markusekstrom.venestra.engine.messages.MessagingSupport;


public class ServerGameMessageHandler extends SimpleChannelHandler{
	
	private MessagingSupport ms = new MessagingSupport();
	
	public ServerGameMessageHandler(IMessageListener listener) {
		//ms.addListener(listener);
	}
	
	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        Channel ch = e.getChannel();
        e.getMessage();
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {
		e.getCause().printStackTrace();
		e.getChannel().close();
	}
	
	@Override
	public void channelOpen(ChannelHandlerContext ctx, ChannelStateEvent e) {
		GameServer.allChannels.add(e.getChannel());
	}
	
//	 @Override
//	 public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
//		 GameMessage time = new GameMessage((int) (System.currentTimeMillis() / 1000));
//		 
//	     ChannelFuture f = e.getChannel().write(time);
//	            
//	     f.addListener(ChannelFutureListener.CLOSE);
//	 }
}

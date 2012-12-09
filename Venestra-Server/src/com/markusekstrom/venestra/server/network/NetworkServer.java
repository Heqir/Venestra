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
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.group.DefaultChannelGroup;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.serialization.ClassResolvers;
import org.jboss.netty.handler.codec.serialization.ObjectDecoder;
import org.jboss.netty.handler.codec.serialization.ObjectEncoder;

import com.markusekstrom.venestra.engine.messages.IMessageListener;
import com.markusekstrom.venestra.server.core.VenestraServer;


public class NetworkServer implements Runnable{
	
	final static ChannelGroup allChannels = new DefaultChannelGroup("server");
	
	final IMessageListener listener;
	
	public NetworkServer(IMessageListener listener) {
		this.listener = listener;
	}
	
	public void run() {
		ChannelFactory factory = new NioServerSocketChannelFactory(
										Executors.newCachedThreadPool(), 
										Executors.newCachedThreadPool());
		
		ServerBootstrap bootstrap = new ServerBootstrap(factory);
		
		bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
			public ChannelPipeline getPipeline() throws Exception {
				return Channels.pipeline(
									new ObjectDecoder(ClassResolvers.cacheDisabled(getClass().getClassLoader())),
									new ObjectEncoder(),
									new ServerMessageHandler(listener)
				);
			}
		});
		
		bootstrap.setOption("child.tcpNoDelay", true);
		bootstrap.setOption("child.keepAlive", true);
		
		Channel channel = bootstrap.bind(new InetSocketAddress(8080));
		allChannels.add(channel);
		/*
		 * Code for shutting down the server.
		 * 
		 *  ChannelGroupFuture future = allChannels.close();
		 *  future.awaitUninterruptibly();
		 *  factory.releaseExternalResources();
		 */
		
	}
}

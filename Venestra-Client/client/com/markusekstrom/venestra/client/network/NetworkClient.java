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
package com.markusekstrom.venestra.client.network;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.serialization.ClassResolvers;
import org.jboss.netty.handler.codec.serialization.ObjectDecoder;
import org.jboss.netty.handler.codec.serialization.ObjectEncoder;

public class NetworkClient implements Runnable{
	@Override
	public void run() {

	        ChannelFactory factory = new NioClientSocketChannelFactory(
	        								Executors.newCachedThreadPool(),
	        								Executors.newCachedThreadPool());

	        ClientBootstrap bootstrap = new ClientBootstrap(factory);

	        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
	        	public ChannelPipeline getPipeline() {
	        		return Channels.pipeline(	
	        							new ObjectEncoder(),
	        							new ObjectDecoder(ClassResolvers.cacheDisabled(getClass().getClassLoader())),
	    								new ClientMessageHandler());
	        	}
	        });
	        
	        bootstrap.setOption("tcpNoDelay", true);
	        bootstrap.setOption("keepAlive", true);

	        ChannelFuture future = bootstrap.connect(new InetSocketAddress("localhost", 8080));
	        future.awaitUninterruptibly();
	        if(!future.isSuccess()) {
	        	future.getCause().printStackTrace();
	        }
	        future.getChannel().getCloseFuture().awaitUninterruptibly();
	        factory.releaseExternalResources();
		
	}
}

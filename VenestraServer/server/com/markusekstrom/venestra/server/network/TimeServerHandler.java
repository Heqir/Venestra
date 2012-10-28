package com.markusekstrom.venestra.server.network;

import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import com.markusekstrom.venestra.common.core.GameMessage;


public class TimeServerHandler extends SimpleChannelHandler{
	
	 @Override
	 public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
		 GameMessage time = new GameMessage((int) (System.currentTimeMillis() / 1000));
		 
	     ChannelFuture f = e.getChannel().write(time);
	            
	     f.addListener(ChannelFutureListener.CLOSE);
	 }
	
//	@Override
//	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
//        Channel ch = e.getChannel();
//        ch.write(e.getMessage());
//	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {
		e.getCause().printStackTrace();
		e.getChannel().close();
	}
	
	@Override
	public void channelOpen(ChannelHandlerContext ctx, ChannelStateEvent e) {
		TimeServer.allChannels.add(e.getChannel());
	}
}

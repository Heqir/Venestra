package com.markusekstrom.venestra.client.network;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import com.markusekstrom.venestra.common.core.GameMessage;

public class GameClientHandler extends SimpleChannelHandler{

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
    	GameMessage m = (GameMessage) e.getMessage();
    	System.out.println(m);
    	e.getChannel().close();
    }
    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {
    	e.getCause().printStackTrace();
    	e.getChannel().close();
    }
}
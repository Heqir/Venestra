package com.markusekstrom.venestra.server.network;

import static org.jboss.netty.buffer.ChannelBuffers.buffer;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import com.markusekstrom.venestra.common.core.GameMessage;

public class GameMessageEncoder extends SimpleChannelHandler {
	public void writeRequested(ChannelHandlerContext ctx, MessageEvent e) {
		GameMessage time = (GameMessage) e.getMessage();
        
		ChannelBuffer buf = buffer(4);
		buf.writeInt(time.getValue());
		
		Channels.write(ctx, e.getFuture(), buf);
	}
}

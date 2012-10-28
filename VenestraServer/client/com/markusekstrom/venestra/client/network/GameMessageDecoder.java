package com.markusekstrom.venestra.client.network;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

import com.markusekstrom.venestra.common.core.GameMessage;

public class GameMessageDecoder extends FrameDecoder {

	@Override
	protected Object decode(ChannelHandlerContext ctx, Channel channel,
			ChannelBuffer buffer) {
			   
	   if (buffer.readableBytes() < 4) {
		   return null;
	   }
	   
	   return new GameMessage(buffer.readInt());
	}
}

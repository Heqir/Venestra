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

public class GameClient {
	public static void main(String[] args) throws Exception {
       // String host = args[0];
       // int port = Integer.parseInt(args[1]);

        ChannelFactory factory = new NioClientSocketChannelFactory(
        								Executors.newCachedThreadPool(),
        								Executors.newCachedThreadPool());

        ClientBootstrap bootstrap = new ClientBootstrap(factory);

        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
        	public ChannelPipeline getPipeline() {
        		return Channels.pipeline(	
        							new GameMessageDecoder(),
    								new GameClientHandler());
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

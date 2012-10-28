package com.markusekstrom.venestra.common.core;

import java.util.Date;

public class GameMessage {
	private final int value;
    
	public GameMessage(int value) {
		this.value = value;
	}
    
	public int getValue() {
		return value;
	}
    
	@Override
	public String toString() {
	return new Date(value * 1000L).toString();
    }
}

package com.byclosure;

public class Screenshot {
	private byte[] data;

	public Screenshot(byte[] data) {
		this.data = data;
	}

	public byte[] getData() {
		return this.data;
	}
}
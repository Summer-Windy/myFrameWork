package com.xbb.net.service;

public class FloppyWriter implements IDeviceWriter {

	@Override
	public void saveToDevice() {
		System.out.println("save to floppy...");
	}

}

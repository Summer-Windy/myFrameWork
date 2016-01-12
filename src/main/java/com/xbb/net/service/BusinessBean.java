package com.xbb.net.service;

public class BusinessBean {
	
	public BusinessBean() {
		System.out.println("BusinessBean lazy loading ...");
	}

	private IDeviceWriter writer;
	public void setDeviceWriter(IDeviceWriter writer){ this.writer = writer;}
	public IDeviceWriter getDeviceWriter(){return writer;};
	
	
	
	public void save(){
		if(writer == null)
			System.out.println("DeviceWriter needed ...");
		writer.saveToDevice();
	}
}

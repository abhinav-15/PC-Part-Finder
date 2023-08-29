package com.ppf.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Device {

	@Id
	private int deviceId;
	private String deviceName;

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public Device() {

	}

	public Device(int deviceId, String deviceName) {
		super();
		this.deviceId = deviceId;
		this.deviceName = deviceName;
	}

	@Override
	public String toString() {
		return "Product [deviceId=" + deviceId + ", deviceName=" + deviceName + "]";
	}
}

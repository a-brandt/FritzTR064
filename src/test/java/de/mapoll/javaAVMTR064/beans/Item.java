package de.mapoll.javaAVMTR064.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Item {

	@XmlElement(name = "Index")
	private String index;

	@XmlElement(name = "IPAddress")
	private String ipAddress;

	@XmlElement(name = "MACAddress")
	private String macAddress;

	@XmlElement(name = "Active")
	private String active;

	@XmlElement(name = "HostName")
	private String hostName;

	@XmlElement(name = "InterfaceType")
	private String interfaceType;

	@XmlElement(name = "X_AVM-DE_Port")
	private String xAvmDePort;

	@XmlElement(name = "X_AVM-DE_Speed")
	private String xAvmDeSpeed;

	@XmlElement(name = "X_AVM-DE_UpdateAvailable")
	private String xAvmDeUpdateAvailable;

	@XmlElement(name = "X_AVM-DE_UpdateSuccessful")
	private String xAvmDeUpdateSuccessful;

	@XmlElement(name = "X_AVM-DE_InfoURL")
	private String xAvmDeInfoUrl;

	@XmlElement(name = "X_AVM-DE_Model")
	private String xAvmDeModel;

	@XmlElement(name = "X_AVM-DE_URL")
	private String xAvmDeUrl;

	@XmlElement(name = "X_AVM-DE_Guest")
	private String xAvmDeGuest;

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getInterfaceType() {
		return interfaceType;
	}

	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}

	public String getxAvmDePort() {
		return xAvmDePort;
	}

	public void setxAvmDePort(String xAvmDePort) {
		this.xAvmDePort = xAvmDePort;
	}

	public String getxAvmDeSpeed() {
		return xAvmDeSpeed;
	}

	public void setxAvmDeSpeed(String xAvmDeSpeed) {
		this.xAvmDeSpeed = xAvmDeSpeed;
	}

	public String getxAvmDeUpdateAvailable() {
		return xAvmDeUpdateAvailable;
	}

	public void setxAvmDeUpdateAvailable(String xAvmDeUpdateAvailable) {
		this.xAvmDeUpdateAvailable = xAvmDeUpdateAvailable;
	}

	public String getxAvmDeUpdateSuccessful() {
		return xAvmDeUpdateSuccessful;
	}

	public void setxAvmDeUpdateSuccessful(String xAvmDeUpdateSuccessful) {
		this.xAvmDeUpdateSuccessful = xAvmDeUpdateSuccessful;
	}

	public String getxAvmDeInfoUrl() {
		return xAvmDeInfoUrl;
	}

	public void setxAvmDeInfoUrl(String xAvmDeInfoUrl) {
		this.xAvmDeInfoUrl = xAvmDeInfoUrl;
	}

	public String getxAvmDeModel() {
		return xAvmDeModel;
	}

	public void setxAvmDeModel(String xAvmDeModel) {
		this.xAvmDeModel = xAvmDeModel;
	}

	public String getxAvmDeUrl() {
		return xAvmDeUrl;
	}

	public void setxAvmDeUrl(String xAvmDeUrl) {
		this.xAvmDeUrl = xAvmDeUrl;
	}

	public String getxAvmDeGuest() {
		return xAvmDeGuest;
	}

	public void setxAvmDeGuest(String xAvmDeGuest) {
		this.xAvmDeGuest = xAvmDeGuest;
	}

	@Override
	public String toString() {
		return "Item [index=" + index + ", ipAddress=" + ipAddress + ", macAddress=" + macAddress + ", active=" + active
				+ ", hostName=" + hostName + ", interfaceType=" + interfaceType + ", xAvmDePort=" + xAvmDePort
				+ ", xAvmDeSpeed=" + xAvmDeSpeed + ", xAvmDeUpdateAvailable=" + xAvmDeUpdateAvailable
				+ ", xAvmDeUpdateSuccessful=" + xAvmDeUpdateSuccessful + ", xAvmDeInfoUrl=" + xAvmDeInfoUrl
				+ ", xAvmDeModel=" + xAvmDeModel + ", xAvmDeUrl=" + xAvmDeUrl + ", xAvmDeGuest=" + xAvmDeGuest + "]";
	}

}

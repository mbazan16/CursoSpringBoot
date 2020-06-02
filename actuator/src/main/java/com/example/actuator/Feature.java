package com.example.actuator;

public class Feature {
	
	private Boolean enabled;
	
	private String name;

	public Feature() {
		super();
	}
	
	

	public Feature(String name) {
		super();
		this.name = name;
		this.enabled=true;
	}



	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}

package com.biscuits.pantone;

public class Pantone {

	private String name;
	private String hexColor;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHexColor() {
		return hexColor;
	}
	public void setHexColor(String hexColor) {
		this.hexColor = hexColor.substring(2,9);
	}
	
	public String toString(){
		return this.name + " " + this.hexColor;
	}
}

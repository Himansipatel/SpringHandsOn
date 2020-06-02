package org.himansi.springexample;

public class Triangle {
	private String type;
	private int height;

	public Triangle(String type) {
		this.type = type;
	}
	
	public Triangle(int height) {
		this.height = height;
	}

	public Triangle(String type, int height) {
		this.type = type;
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void Draw() {
		System.out.println(getType() + " Traingle Drawn !!.. of height "+getHeight());
	}
}

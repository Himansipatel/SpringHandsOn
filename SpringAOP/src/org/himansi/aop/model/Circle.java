package org.himansi.aop.model;

public class Circle {
	private String name;
	private int a;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int cetReturn(int a) {
		this.a = a;
		return a;
	}

}

package org.himansi.springexample;

import java.util.List;

public class TriangleCollection {
	private List<Point> points;

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public void draw() {
		int pointsize = getPoints().size();
		for (int i = 0; i < pointsize; i++) {
			System.out.println("Triangle Collection point " + i + " : x = " + points.get(i).getX() + ",y = "
					+ points.get(i).getY());
		}
	}

}

package org.himansi.springexample;

public class Square {

	private Point p1, p2, p3, p4;

	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}

	public Point getP3() {
		return p3;
	}

	public void setP3(Point p3) {
		this.p3 = p3;
	}

	public Point getP4() {
		return p4;
	}

	public void setP4(Point p4) {
		this.p4 = p4;
	}

	public void Draw() {
		System.out.println("Square point 1 : x = "+getP1().getX()+",y = "+getP1().getY());
		System.out.println("Square point 2 : x = "+getP2().getX()+",y = "+getP2().getY());
		System.out.println("Square point 3 : x = "+getP3().getX()+",y = "+getP3().getY());
		System.out.println("Square point 4 : x = "+getP4().getX()+",y = "+getP4().getY());
	}
}

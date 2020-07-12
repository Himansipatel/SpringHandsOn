package org.himansi.jdbc;

import org.himansi.jdbc.dao.JdbcDaoImpl;
import org.himansi.jdbc.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Circle circle = new JdbcDaoImpl().getCircle(1);
		System.out.println(circle.getName());
	}

}

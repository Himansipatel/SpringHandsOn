package org.himansi.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.himansi.jdbc.model.Circle;

public class JdbcDaoImpl {

	public Circle getCircle(int circleId) {
		System.out.println("ccccccccccccccccccccc");
		Connection conn=null;
		try {		
		//String driver = "org.apache.derby.jdbc.ClientDriver";
			System.out.println("ddddddddddddddd");
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		System.out.println("bbbbbbbbbbbbb");
		conn = DriverManager.getConnection("jdbc:derby://localhost:1527/D:/JAVALIB/derby14..2.0/bin/db;create=true");
		System.out.println("aaaaaaaaaaaaa");
		PreparedStatement ps = conn.prepareStatement("select * from circle where id = ?");
		ps.setInt(1,circleId);
		Circle circle = null;
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			System.out.println("hi there");
			circle=new Circle(circleId, rs.getString("name"));
		}
		rs.close();
		ps.close();
		return circle;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
}

package com.github.allanfs.dgapp.modelo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class RecheioDBTest {

	@Test
	public void test() throws SQLException {
		
		Connection conection = DriverManager.getConnection("jdbc:postgresql://10.89.4.40:5432/db", "postgres", "123");
//		fail("Not yet implemented");
		DatabaseMetaData m = conection.getMetaData();
		ResultSet rs = m.getTables("db", null, "%", null);
		while (rs.next()) {
		  System.out.println(rs.getString(3));
		}
	}

}

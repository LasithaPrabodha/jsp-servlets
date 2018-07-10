package com.auction.web.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


/**
 * Servlet implementation class auctionServlet
 */
@WebServlet("/auctionServlet")
public class AuctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    // Define data source/ connection pool for Resource injection 
    @Resource(name="jdbc/auction")
    private DataSource dataSource;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// step up the printwriter 
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
		// get a connection to the database 
		Connection myConn = null;
		Statement myStmnt = null;
		ResultSet myRes = null;
		
		try {
			myConn = dataSource.getConnection();
			// create sql statements
			String sql = "select * from auctiondetails";
			myStmnt = myConn.createStatement();
			
			// execute sql statements
			myRes = myStmnt.executeQuery(sql);
			
			// process the result set
			while(myRes.next()) {
				String name = myRes.getString("name");
				out.println(name);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}

package com.auction.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

public class AuctionDBUtil {
	private DataSource dataSource;

	public AuctionDBUtil(DataSource dbSrc) {
		dataSource = dbSrc;
	}

	public List<Item> getItems(String searchVal) throws Exception {
		List<Item> items = new ArrayList<>();

		Connection myConn = null;
		PreparedStatement pprStmnt = null;
		ResultSet myRes = null;
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select a.id, a.name, c.categoryname, a.`min-bid`, a.dateadded "
					+ "from auctiondetails a join itemstatus i on a.id=i.id "
					+ "join categories c on a.category = c.id where i.status = 1 AND a.name LIKE ?"
					+ "order by name";

			pprStmnt = myConn.prepareStatement(sql);
			pprStmnt.setString(1, "%"+searchVal+"%");

			// execute query
			myRes = pprStmnt.executeQuery();

			// process result set
			while (myRes.next()) {
				// retrieve data set from result set row
				int id = myRes.getInt("id");
				String name = myRes.getString("name");
				String category = myRes.getString("categoryname");
				Double minBid = myRes.getDouble("min-bid");
				Date dateAdded = myRes.getDate("dateadded");

				// create new result object
				Item tempItem = new Item(id, name, category, minBid, dateAdded);

				// add to list of items
				items.add(tempItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close JDBC objects
			close(myConn, pprStmnt, myRes);
		}
		return items;

	}

	private void close(Connection myConn, PreparedStatement pprStmnt, ResultSet myRes) {
		try {
			if (myRes != null) {
				myRes.close();
			}
			if (pprStmnt != null) {
				pprStmnt.close();
			}
			if (myConn != null) {
				myConn.close(); // doesn't close.. just out it back to connection pool.
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}

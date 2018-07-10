package com.auction.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class AuctionControllerServlet
 */
@WebServlet("/AuctionControllerServlet")
public class AuctionControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AuctionDBUtil aucDBUtil;

	@Resource(name = "jdbc/auction")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();
		// create our db util... and pass in the connection pool / datasource
		try {
			aucDBUtil = new AuctionDBUtil(dataSource);
		} catch (Exception e) {
			throw new ServletException();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// list the items in MVC fashion
			listItems(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void listItems(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get the items from the dbutil
		String searchVal = "";
		
		if (request.getParameterMap().containsKey("searchBy")) {
			searchVal = request.getParameter("searchBy");
        }
		
		List<Item> items = aucDBUtil.getItems(searchVal);
			
		// add items to the request
		request.setAttribute("ITEM_LIST", items);

		// send them to the jsp page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-items.jsp");
		dispatcher.forward(request, response);

	}
}

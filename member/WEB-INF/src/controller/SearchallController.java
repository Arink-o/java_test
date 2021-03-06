package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Customer;
import service.SearchService;

@WebServlet("/searchall")
public class SearchallController extends HttpServlet {

	protected void doPost (HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException{
		SearchService searchService = new SearchService();
		List<Customer> customerList = searchService.searchallCustomer();
		request.setAttribute("customerList", customerList);
		ServletContext sc = getServletContext();
		sc.getRequestDispatcher("/" + "mypage.jsp").forward(request, response);
	}
}

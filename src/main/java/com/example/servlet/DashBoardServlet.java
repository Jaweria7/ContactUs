package com.example.servlet;

import com.example.dao.ContactDAO;
import com.example.model.Contact;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/dashboard")
public class DashBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContactDAO contactDAO;

	public void init() {
		contactDAO = new ContactDAO();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("username") == null) {
			response.sendRedirect("Login.jsp"); // Redirect to login if not logged in
		} 
		else {
			// Proceed to show the dashboard
			loadDashboardData(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("DashBoard.jsp");
			dispatcher.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int contactId = Integer.parseInt(request.getParameter("contactId"));
		String currentStatus = request.getParameter("currentStatus");

		String newStatus = "active".equals(currentStatus) ? "archive" : "active";
		contactDAO.updateContactStatus(contactId, newStatus);

		// Reload the dashboard data
		loadDashboardData(request);

		// Redirect back to the dashboard
		response.sendRedirect("dashboard");
	}

	private void loadDashboardData(HttpServletRequest request) {
		List<Contact> activeContacts = contactDAO.selectActiveContacts();
		List<Contact> archivedContacts = contactDAO.selectArchivedContacts();

		request.setAttribute("listContact", activeContacts);
		request.setAttribute("listArchivedContacts", archivedContacts);
	}
}

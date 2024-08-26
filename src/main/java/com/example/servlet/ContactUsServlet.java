package com.example.servlet;

import com.example.dao.ContactDAO;
import com.example.model.Contact;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/contactUs")
public class ContactUsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContactDAO contactDAO;

	public void init() {
		contactDAO = new ContactDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("ContactUs.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");

		Contact contact = new Contact(name, email, message, "active");
		contactDAO.insertContact(contact);

		request.setAttribute("successMessage", "Your information has been submitted successfully.");
		RequestDispatcher dispatcher = request.getRequestDispatcher("ContactUs.jsp");
		dispatcher.forward(request, response);
	}
}

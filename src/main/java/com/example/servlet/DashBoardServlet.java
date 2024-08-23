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
import java.util.List;

@WebServlet("/dashboard")
public class DashBoardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ContactDAO contactDAO;

    public void init() {
        contactDAO = new ContactDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Contact> listContact = contactDAO.selectActiveContacts();
        request.setAttribute("listContact", listContact);
        
        List<Contact> archivedContacts = contactDAO.selectArchivedContacts();
        request.setAttribute("listArchivedContacts", archivedContacts);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("DashBoard.jsp");
        dispatcher.forward(request, response);
    }
}

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Contact" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache"); 
    response.setDateHeader("Expires", 0);

    session = request.getSession();
    if (session == null || session.getAttribute("user") == null) {
        response.sendRedirect("Login.jsp");
        return;
    }
%>

<html>
<head>
    <title>Dashboard</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid black;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        .btn {
            padding: 5px 10px;
            margin: 2px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h2>Active Contacts Dashboard</h2>
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Message</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Contact> activeContacts = (List<Contact>) request.getAttribute("listContact");

                if (activeContacts != null && !activeContacts.isEmpty()) {
                    for (Contact contact : activeContacts) {
            %>
                        <tr>
                            <td><%= contact.getName() %></td>
                            <td><%= contact.getEmail() %></td>
                            <td><%= contact.getMessage() %></td>
                            <td><%= contact.getStatus() %></td>
                            <td>
                                <form action="dashboard" method="post">
                                    <input type="hidden" name="contactId" value="<%= contact.getId() %>">
                                    <input type="hidden" name="currentStatus" value="<%= contact.getStatus() %>">
                                    <button type="submit" class="btn">Archive</button>
                                </form>
                            </td>
                        </tr>
            <%
                    }
                } else {
            %>
                    <tr>
                        <td colspan="5">No active data available</td>
                    </tr>
            <%
                }
            %>
        </tbody>
    </table>
    
    <br><br><br>
    
    <h2>Archived Contacts Dashboard</h2>
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Message</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Contact> archivedContacts = (List<Contact>) request.getAttribute("listArchivedContacts");

                if (archivedContacts != null && !archivedContacts.isEmpty()) {
                    for (Contact contact : archivedContacts) {
            %>
                        <tr>
                            <td><%= contact.getName() %></td>
                            <td><%= contact.getEmail() %></td>
                            <td><%= contact.getMessage() %></td>
                            <td><%= contact.getStatus() %></td>
                            <td>
                                <form action="dashboard" method="post">
                                    <input type="hidden" name="contactId" value="<%= contact.getId() %>">
                                    <input type="hidden" name="currentStatus" value="<%= contact.getStatus() %>">
                                    <button type="submit" class="btn">Activate</button>
                                </form>
                            </td>
                        </tr>
            <%
                    }
                } else {
            %>
                    <tr>
                        <td colspan="5">No archived data available</td>
                    </tr>
            <%
                }
            %>
        </tbody>
    </table>
    <br><br>
    <a href="contactUs">Contact Us</a>
    <a href="logout">Logout</a>
    
    
</body>
</html>

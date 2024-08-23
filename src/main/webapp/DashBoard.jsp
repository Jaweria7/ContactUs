<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Contact" %>
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
                        </tr>
            <%
                    }
                } else {
            %>
                    <tr>
                        <td colspan="4">No active data available</td>
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
                        </tr>
            <%
                    }
                } else {
            %>
                    <tr>
                        <td colspan="4">No archived data available</td>
                    </tr>
            <%
                }
            %>
        </tbody>
    </table>
    
</body>
</html>

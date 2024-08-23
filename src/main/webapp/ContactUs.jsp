<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact Us</title>
    <style>
        form {
            max-width: 600px;
            margin: 0 auto;
        }

        label {
            display: block;
            margin: 10px 0 5px;
        }

        input, textarea {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            background-color: #28a745;
            color: white;
            cursor: pointer;
        }

        button:hover {
            background-color: #218838;
        }

        .message {
            margin: 20px 0;
            padding: 10px;
            background-color: #d4edda;
            color: #155724;
            border: 1px solid #c3e6cb;
            border-radius: 4px;
        }
    </style>
</head>
<body>
    <h2 style="text-align: center">Contact Us</h2>
    
    <%
        String successMessage = (String) request.getAttribute("successMessage");
        if (successMessage != null) {
    %>
        <div class="message"><%= successMessage %></div>
    <%
        }
    %>
    
    <form action="contactUs" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>

        <label for="message">Message:</label>
        <textarea id="message" name="message" rows="4" required></textarea>

        <button type="submit">Submit</button>
    </form>
</body>
</html>

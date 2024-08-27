# Contact Us Project

## Overview

The Contact Us Project is a web application that allows users to submit contact information through a form. Submitted contact information can be categorized as either "active" or "archived" and is displayed in separate tables on the dashboard. Users can also manage contact statuses and view their details through a web interface.

## Features

- **Contact Form**: Users can submit their name, email, and message.
- **Dashboard**: Displays two tables for active and archived contacts.
- **Status Management**: Allows toggling the status of contacts between "active" and "archived".
- **Session Management**: Users must log in to access the dashboard.
- **Logout**: Users can log out and are redirected to the login page with no access to cached pages.

## Technologies Used

- **Java**: Backend development with servlets.
- **JSP**: Frontend templating.
- **PostgreSQL**: Database for storing contact information.
- **HTML/CSS**: Styling and structuring the web pages.
- **Apache Tomcat**: Servlet container.

## Setup Instructions

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- Apache Tomcat
- PostgreSQL
- IDE like Eclipse or IntelliJ IDEA

### Database Setup

1. **Create a Database**: Create a PostgreSQL database named `postgres` (or any name you prefer).
2. **Create Table**: Create a table for storing contact information with the following schema:

    ```sql
    CREATE TABLE contacts (
        id SERIAL PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        email VARCHAR(255) NOT NULL,
        message TEXT NOT NULL,
        status VARCHAR(50) NOT NULL
    );
    ```

3. **Configure Database Connection**: Update `ContactDAO.java` with your database URL, username, and password.

### Project Setup

1. **Clone the Repository**:

    ```bash
    git clone <repository-url>
    ```

2. **Import into IDE**: Import the project into your preferred IDE as a dynamic web project.

3. **Deploy**: Deploy the project to Apache Tomcat.

4. **Configure Web Application**: Ensure the web application is properly configured with the `web.xml` file for servlet mappings.

## Usage

### Accessing the Application

1. **Login**: Access the login page at `http://localhost:8080/ContactUsProject/LoginServlet.java`.
2. **Dashboard**: After logging in, navigate to the dashboard.
3. **Contact Us**: Access the contact form.

### Contact Form Submission

1. **Fill Out the Form**: Enter your name, email, and message in the contact form.
2. **Submit**: Click the "Submit" button to add the contact information to the database.

### Managing Contacts

1. **View Contacts**: The dashboard displays active and archived contacts.
2. **Toggle Status**: Use the button to change the status of a contact.

### Logout

- Click the "Logout" button on the dashboard to end your session and redirect to the login page.

package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Queries;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		String buttonName = request.getParameter("button");

		switch (buttonName) {
		case "sign in":
			if (new Queries().signIn(userName, password)) {				
				RequestDispatcher rd = request.getRequestDispatcher("home.html");
				rd.forward(request, response);
//				response.sendRedirect("http://localhost:8080/Login/home.html");
			}

			else {
				out.println("<h1>Inavlid login Details !</h1>");
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
			break;

		case "sign up":
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			
			if (new Queries().signUp(userName, password)) {
				out.println("<h1>User Added ! Please login</h1>");
			}

			else {
				out.println("<h1>User couldn't be added !</h1>");
			}
			rd.include(request, response);
			break;

		default:
			break;
		}

	}

}

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Student;
import service.IstudentService;
import servicefactory.Studentservicefactory;

@WebServlet("/controller/*")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doprocess( request,  response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doprocess( request,  response);
	}
	private void doprocess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter out=response.getWriter();
		
		if(request.getRequestURI().endsWith("insertform")) {
			String sname=request.getParameter("sname");
			int sage=Integer.parseInt(request.getParameter("sage"));
			String saddress=request.getParameter("saddress");
			IstudentService studentservice=Studentservicefactory.getstudentservice();
			try {
				 String message=studentservice.addStudent(sname, sage, saddress);
				if(message.equalsIgnoreCase("success")) {
					out.print("<h1 style=color:green;> STUDENT REGISTRATION IS SUCCESSFULL</h1>");
				}
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
			
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		
	if(request.getRequestURI().endsWith("searchform")) {
		int sid=Integer.parseInt(request.getParameter("sid"));
		IstudentService studentservice=Studentservicefactory.getstudentservice();
		try {
			Student std=studentservice.searchStudent(sid);
			if(std!=null){
				
			out.print("<table border='1'class=\"table\">\r\n"
					+ "  <thead>\r\n"
					+ "    <tr>\r\n"
					+ "      <th scope=\"col\">Student Id</th>\r\n"
					+ "      <th scope=\"col\">Student Name</th>\r\n"
					+ "      <th scope=\"col\">Student age</th>\r\n"
					+ "      <th scope=\"col\">Student address</th>\r\n"
					+ "    </tr>\r\n"
					+ "  </thead>\r\n"
					+ "  <tbody>\r\n"
					+ "    <tr>\r\n"
					+ "      <th scope=\"row\">"+ std.getSid()+"</th>\r\n"
					+ "      <td>"+std.getSname()+"</td>\r\n"
					+ "      <td>"+std.getSage()+"</td>\r\n"
					+ "      <td>"+std.getSadress()+"</td>\r\n"
					+ "    </tr>");
			
			}
			else {
				out.print("<h1 style=color:red;> NO RECORDS FOUND</h1>");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	if(request.getRequestURI().endsWith("updateform")) {
		int sid=Integer.parseInt(request.getParameter("sid"));
		String sname=request.getParameter("sname");
		int sage=Integer.parseInt(request.getParameter("sage"));
		String saddress=request.getParameter("saddress");
		Student std = new Student();
		std.setSaddress(saddress);
		std.setSage(sage);
		std.setSid(sid);
		std.setSname(sname);
		
		IstudentService studentservice=Studentservicefactory.getstudentservice();
		try {
       String message=studentservice.updateStudent(std);
			if(message.equalsIgnoreCase("success")) {
				out.print("<h1 style=color:green;>STUDENT RECORD UPDATED</h1>");
			}
			else {
				out.print("<h1 style=color:red;>STUDENT RECORD UPDATEDATION FAILED PLEASE TRY AGAIN</h1>");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	if(request.getRequestURI().endsWith("deleteform")) {
		int sid=Integer.parseInt(request.getParameter("sid"));
		IstudentService studentservice=Studentservicefactory.getstudentservice();
		try {
			String message=studentservice.deleteStudent(sid);
			if(message.equalsIgnoreCase("success")) {
				out.print("<h1 style=color:green;>RECORD DELETED SUCCESSFULLY</h1>");
			}
			else {
				out.print("<h1 style=color:red;>RECORD DELETION FAILED PLEASE TRY AGAIN</h1>");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}

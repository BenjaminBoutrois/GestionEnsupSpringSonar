package eu.ensup.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eu.ensup.domaine.Student;
import eu.ensup.domaine.User;
import eu.ensup.service.StudentService;
import eu.ensup.service.IStudentService;

/**
 * Servlet implementation class AjoutEtudiantServlet
 */
//@WebServlet("/AjoutEtudiant")
public class AddStudentServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private IStudentService studentService;
	private RequestDispatcher dispatcher = null;
	private User user = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudentServlet()
	{
		studentService = new StudentService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		dispatcher = request.getRequestDispatcher("etudiantAjout.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Student student = null;

		try
		{
			student = new Student(request.getParameter("firstName"), request.getParameter("lastName"),
					request.getParameter("mailAddress"), request.getParameter("address"),
					request.getParameter("numberPhone"), request.getParameter("birthDate"));
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		HttpSession session = request.getSession();

		session.setAttribute("student", null);

		user = (User) session.getAttribute("user");

		studentService.createStudent(student);

		// Refresh students list
		session.setAttribute("students", studentService.getAllStudents());

		if (user.getProfil().equalsIgnoreCase("D"))
		{
			dispatcher = request.getRequestDispatcher("etudiant.jsp");
		}
		else
		{
			dispatcher = request.getRequestDispatcher("etudiantAjout.jsp");
		}

		dispatcher.forward(request, response);
	}
}

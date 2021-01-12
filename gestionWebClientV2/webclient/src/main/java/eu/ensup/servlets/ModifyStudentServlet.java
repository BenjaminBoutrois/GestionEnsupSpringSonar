package eu.ensup.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eu.ensup.domaine.Student;
import eu.ensup.service.StudentService;
import eu.ensup.service.IStudentService;

/**
 * Servlet implementation class ModifyStudentServlet
 */
public class ModifyStudentServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private IStudentService studentService;
	private RequestDispatcher dispatcher = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifyStudentServlet()
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

		studentService.updateStudent(Integer.parseInt(request.getParameter("id")), student);

		session.setAttribute("student", null);
		session.setAttribute("students", studentService.getAllStudents());

		dispatcher = request.getRequestDispatcher("etudiant.jsp");
		dispatcher.forward(request, response);
	}
}

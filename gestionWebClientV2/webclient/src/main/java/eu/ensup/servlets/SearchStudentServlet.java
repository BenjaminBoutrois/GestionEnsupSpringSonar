package eu.ensup.servlets;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class RechercheEtudiantServlet
 */
public class SearchStudentServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private IStudentService studentService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchStudentServlet()
	{
		super();
		studentService = new StudentService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();

		List<Student> students = studentService.searchStudent(request.getParameter("firstNameR"),
				request.getParameter("lastNameR"));

		session.setAttribute("students", students);

		RequestDispatcher dispatcher = null;

		dispatcher = request.getRequestDispatcher("etudiant.jsp");
		dispatcher.forward(request, response);
	}
}

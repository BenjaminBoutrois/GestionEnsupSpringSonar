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
 * Servlet implementation class EditerEtudiantServlet
 */
public class EditStudentServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private IStudentService studentService;
	private RequestDispatcher dispatcher = null;

	/**
	 * Default constructor.
	 */
	public EditStudentServlet()
	{
		studentService = new StudentService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		editStudent(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void editStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		String object = request.getParameter("id");
		int id = Integer.valueOf(object);

		Student student = studentService.getStudent(id);

		dispatcher = request.getRequestDispatcher("etudiantModif.jsp");

		session.setAttribute("student", student);

		dispatcher.forward(request, response);
	}

}

package eu.ensup.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eu.ensup.domaine.Course;
import eu.ensup.domaine.Student;
import eu.ensup.service.CourseService;
import eu.ensup.service.StudentService;
import eu.ensup.service.ICourseService;
import eu.ensup.service.IStudentService;

/**
 * Servlet implementation class EtudiantCoursServlet
 */
public class StudentCourseServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private IStudentService studentService;
	private ICourseService courseService;
	private RequestDispatcher dispatcher = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentCourseServlet()
	{
		super();
		studentService = new StudentService();
		courseService = new CourseService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		String object = request.getParameter("id");
		int id = Integer.valueOf(object);

		Student student = studentService.getStudent(id);
		List<Course> courses = courseService.getAllCourses();

		dispatcher = request.getRequestDispatcher("etudiantCours.jsp");
		session.setAttribute("student", student);
		session.setAttribute("courses", courses);

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String email = request.getParameter("mail");
		String course = request.getParameter("listeCours");
		Student student = studentService.getStudentByMail(email);

		System.out.println(course + " " + student.getId());

		courseService.associateCourse(course, student.getId());
		dispatcher = request.getRequestDispatcher("etudiant.jsp");
		dispatcher.forward(request, response);
	}
}

package eu.ensup.dao;

import java.util.List;

import eu.ensup.domaine.Course;

public interface ICourseDao
{

	/**
	 * Associe un cours à un étudiant.
	 * @param courseTheme Le theme du cours.
	 * @param idStudent L'id de l'étudiant à qui associer le cours.
	 */
	void associateCourse(String courseTheme, int idStudent);

	/**
	 * Retourne tous les cours de la base de données.
	 * @return La liste de tous les cours de la base de données.
	 */
	List<Course> getAllCourses();

}
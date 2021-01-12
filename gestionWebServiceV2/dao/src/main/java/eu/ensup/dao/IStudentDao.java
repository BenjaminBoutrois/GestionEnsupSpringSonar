package eu.ensup.dao;

import java.util.List;

import eu.ensup.domaine.Student;

public interface IStudentDao
{

	/**
	 * Crée un étudiant dans la base de données.
	 * @param student L'instance d'entité Student à créer.
	 */
	void createStudent(Student student);

	/**
	 * Retourne un étudiant en fonction de son id.
	 * @param id L'id de l'étudiant à chercher.
	 * @return L'étudiant dont l'id correspond.
	 */
	Student getStudent(int id);

	/**
	 * Retourne un étudiant en fonction de son adresse mail.
	 * @param mail Une chaîne de caractères représentant l'adresse mail à chercher.
	 * @return L'étudiant dont l'adresse mail correspond.
	 */
	Student getStudentByMail(String mail);

	/**
	 * Retourne la liste de tous les étudiants de la table student.
	 * @return La liste de tous les étudiants de la table student.
	 */
	List<Student> getAllStudents();

	/**
	 * Supprime un étudiant de la base de données.
	 * @param id L'id de l'étudiant à supprimer.
	 */
	void deleteStudent(int id);

	/**
	 * Met à jour les données d'un étudiant.
	 * @param oldStudentId L'id de l'étudiant à modifier.
	 * @param newStudent L'objet Student contenant les données du nouvel étudiant.
	 */
	void updateStudent(int oldStudentId, Student newStudent);
	
	/**
	 * Recherche un ou plusieurs étudiants en fonction de leur données.
	 * @param firstName Le prénom du ou des étudiants à chercher.
	 * @param lastName Le nom de famille du ou des étudiants à chercher.
	 * @return La liste des étudiants correspondant au prénom et au nom entrés.
	 */
	List<Student> searchStudent(String firstName, String lastName);
}
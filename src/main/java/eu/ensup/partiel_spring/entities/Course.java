package eu.ensup.partiel_spring.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Classe métier représentant un cours.
 * 
 * @author 33651
 *
 */
@Entity
public class Course
{
	@Id
	private String themeCourse;
	private int numberHours;
	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(
//        name = "student_courses",
//        joinColumns = {@JoinColumn(name = "student_id")},
//        inverseJoinColumns = {@JoinColumn(name = "theme_course")}
//	)
//	private Set<Student> students = new HashSet<Student>();
	
	
	@ManyToMany
	@JoinTable(
			name = "student_course",
			joinColumns = @JoinColumn(name = "themeCourse"),
			inverseJoinColumns = @JoinColumn(name = "id")
			)
	private Set<Student> students = new HashSet<Student>();
	

	public Course()
	{
		super();
	}

	public Course(String themeCourse, int numberHours)
	{
		super();
		this.themeCourse = themeCourse;
		this.numberHours = numberHours;
	}

	public String getThemeCourse()
	{
		return themeCourse;
	}

	public void setThemeCourse(String themeCourse)
	{
		this.themeCourse = themeCourse;
	}

	public int getNumberHours()
	{
		return numberHours;
	}

	public void setNumberHours(int numberHours)
	{
		this.numberHours = numberHours;
	}

	@Override
	public String toString()
	{
		return "Course [themeCourse=" + themeCourse + ", numberHours=" + numberHours + "]";
	}
}

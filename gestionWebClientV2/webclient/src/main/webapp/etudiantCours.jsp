<%@page import="eu.ensup.domaine.Course"%>
<%@page import="eu.ensup.domaine.Student"%>

<%@page import="java.util.List"%>
<!-- header -->
<%@include file="header.jsp"%>
<!-- Navigation-->
<%@include file="menuhaut.jsp"%>

<div class="container">
<br/><br/><br/><br/><br/><br/>
	<%
	List<Course> courses = (List<Course>) session.getAttribute("courses");
	%>
	<h1>Associer un cours à un étudiant</h1>
	<form action="EtudiantCoursServlet" method="post">
	<br/><br/>
	<% Student student = (Student) session.getAttribute("student");%>
	
		<input type="text" id="mail" class="form-control" name="mail" value="<%=student.getMailAddress()%>">
		
		<br/><br/>
		
	  	<select name="listeCours" class="browser-default custom-select">
				<% 
				        for (Course course : courses)
				        {
				%>
					   <option name="cours" value="<%=course.getThemeCourse()%>"><%=course.getThemeCourse()%></option>
				<%
				        }
				%>
		</select>
			<br/> <br/>
			<div class="text-center mb-2">
					<button type="submit" class="btn btn-primary mb-4">Associer</button>
			</div>
</div>

<!-- footer -->
<%@include file="footer.jsp"%>
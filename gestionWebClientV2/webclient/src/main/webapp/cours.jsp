<%@page import="eu.ensup.domaine.Course"%>
<%@page import="eu.ensup.domaine.Student"%>

<%@page import="java.util.List"%>
<!-- header -->
<%@include file="header.jsp"%>
<!-- Navigation-->
<%@include file="menuhaut.jsp"%>

<div class="container">
	<br /> <br /> <br /> <br /> <br /> <br />

	<!-- Masthead Heading-->
	<h1>Liste des cours</h1>

	<div class="table-responsive text-nowrap">
		<!--Table-->

		<table class="table table-striped" id="paginationFull">

			<!--Table head-->
			<thead>
				<tr>
					<th>#</th>
					<th>Cours</th>
					<th>Nombre d'heures</th>
				</tr>
			</thead>
			<!--Table head-->

			<!--Table body-->
			<tbody>
				<%
					List<Course> listeCourse = (List<Course>) session.getAttribute("courses");
				%>
				<%
					int i = 0;
				%>
				<%
					for (Course course : listeCourse) {
				%>
				<%
					
				%>
				<tr>
					<td scope="row">
						<%
							i++;
						%>
					</td>
					<td><%=course.getThemeCourse()%></td>
					<td><%=course.getNumberHours()%></td>
					
					
				</tr>
				<%
					}
				%>
			</tbody>
			<!--Table body-->


		</table>
		<!--Table-->
	</div>
	

	<!--Section: Live preview-->

</div>




<!-- footer -->
<%@include file="footer.jsp"%>
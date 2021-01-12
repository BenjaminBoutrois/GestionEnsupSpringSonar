<%@page import="java.util.ArrayList"%>
<%@page import="eu.ensup.domaine.User"%>
<%@page import="eu.ensup.domaine.Student"%>
<%@page import="java.util.List"%>

<!-- header -->
<%@include file="header.jsp"%>
<!-- Navigation-->
<%@include file="menuhaut.jsp"%>

<div class="container">
	<br /> <br /> <br /> <br /> <br /> <br />

	<ul>
		<li><a href="etudiantAjout.jsp">Ajouter un étudiant</a></li>
	</ul>

	<form action="RechercheEtudiantServlet" method="post">

		<div class="form-row">

			<div class="col">
				<div class="md-form md-outline mt-0">
					<input type="text" id="firstNameR" name="firstNameR"
						class="form-control"> <label for="firstNameR">Prénom</label>
				</div>
			</div>

			<div class="col">
				<div class="md-form md-outline mt-0">
					<input type="text" id="lastNameR" name="lastNameR"
						class="form-control"> <label for="lastNameR">Nom de famille</label>
				</div>
			</div>

			<div class="text-center mb-2">
				<button type="submit" class="btn btn-primary mb-4">Rechercher</button>
			</div>
		</div>
	</form>

	<!-- Masthead Heading-->
	<%
		List<Student> students = new ArrayList<Student>();
		students = (List<Student>) session.getAttribute("students");
		if (user.getProfil().equalsIgnoreCase("D"))
		{
			
		%>
		<h1>Liste des étudiants</h1>
		<%
		}
		else
		{
		%>
		<h1>Informations sur un étudiant</h1>
		<%
		}
		%>
	

	<div class="table-responsive text-nowrap">
		<!--Table-->

		<table class="table table-striped" id="paginationFull">

			<!--Table head-->
			<thead>
				<tr>

					<th id="ID" name="ID">Id</th>
					<th style="width: 150px;">Prénom</th>
					<th>Nom</th>
					<th>Mail</th>
					<th>Adresse</th>
					<th style="width: 70px;">N° tél</th>
					<th style="width: 70px;">Date de naissance</th>
					<th>Action</th>
				</tr>
			</thead>
			<!--Table head-->

			<!--Table body-->
			<tbody>
				<%
					int i = 0;

				for (Student student : students)
				{
				%>

				<tr>
					<td><%=student.getId()%></td>
					<td><%=student.getFirstName()%></td>
					<td><%=student.getLastName()%></td>
					<td><%=student.getMailAddress()%></td>
					<td><%=student.getAddress()%></td>
					<td><%=student.getNumberPhone()%></td>
					<td><%=student.getBirthDate()%></td>
					<td>

						<ul>
							<li>
								<a href="EditerEtudiantServlet?id=<%=student.getId()%>" >Editer</a>				
								
								<a href="SupprimerEtudiantServlet?id=<%=student.getId()%>" style="color:red">Supprimer</a>
								
								<a href="ViewEtudiantServlet?id=<%=student.getId()%>" style="color:blue">Voir</a>
								
								<a href="EtudiantCoursServlet?id=<%=student.getId()%>" style="color:blue">Cours</a>
								
							
							</li>
						</ul>

					</td>
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
<script>
	
</script>
<%@include file="footer.jsp"%>
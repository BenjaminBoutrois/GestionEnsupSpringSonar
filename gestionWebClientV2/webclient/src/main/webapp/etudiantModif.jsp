
<!-- header -->
<%@page import="eu.ensup.domaine.Student"%>
<%@include file="header.jsp"%>
<!-- Navigation-->
<%@include file="menuhaut.jsp"%>

<!-- Début ajout etudiant -->

<div class="container">
	<br /> <br /> <br /> <br /> <br /> <br />

	<ul>
		<li><a href="etudiant.jsp">Liste des étudiants</a></li>
	</ul>

	<!-- Masthead Heading-->
	<h1>Modifier un étudiant</h1>
	
	
	<div class="">
	
		<div class="pt-4 pb-3">
			<% Student student = (Student) session.getAttribute("student");%>
			<form action="ModifEtudiantServlet" method="post">

				<div class="form-row">
				
					<div class="col">
						<div class="md-form md-outline mt-0">
							<input type="text" id="firstName" name="firstName" class="form-control" value="<%=student.getFirstName()%>"> 
							<label for="firstName">Prénom</label>
						</div>
					</div>
					
					<div class="col">
						<div class="md-form md-outline mt-0">
							<input type="text" id="lastName" name="lastName" class="form-control" value="<%=student.getLastName()%>"> 
							<label for="lastName">Nom de famille</label>
						</div>
					</div>
					
				</div>

				<div class="md-form md-outline mt-0">
					<input type="text" id="mailAddress" class="form-control" name="mailAddress" value="<%=student.getMailAddress()%>"> 
					<label for="mailAddress">Adresse mail</label>
				</div>
				
				
				<div class="md-form md-outline">
					<input  id="address" class="form-control" name="address" value="<%=student.getAddress()%>" >
					<label for="address">Adresse</label>
				</div>
				
				<div class="md-form md-outline mt-0">
					<input type="text" id="numberPhone" name="numberPhone" class="form-control" value="<%=student.getNumberPhone()%>">
					<label for="numberPhone">Numéro de téléphone</label>
				</div>				
				
				<div class="md-form md-outline mt-0">
					<input type="date" id="birthDate" name="birthDate" class="form-control" value="<%=student.getBirthDate()%>">
					<label for="birthDate">Date de naissance - (format yyyy-mm-dd)</label>
				</div>
				<div class="md-form md-outline mt-0"  style="visibility:hidden;">
					<input type="text" id="id" name="id" class="form-control" value="<%=student.getId()%>">
					<label for="id">id</label>
				</div>	
			
								
				<br/> <br/>
				<div class="text-center mb-2">
					<button type="submit" class="btn btn-primary mb-4">Modifier</button>
				</div>

			</form>



		</div>

	</div>
	<!-- Card -->

</div>
<!-- Fin ajout etudiant -->

<!-- footer -->
<%@include file="footer.jsp"%>
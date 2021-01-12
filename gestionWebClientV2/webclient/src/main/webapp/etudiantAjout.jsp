
<!-- header -->
<%@include file="header.jsp"%>
<!-- Navigation-->
<%@include file="menuhaut.jsp"%>

<!-- Début ajout etudiant -->

<div class="container">
	<br /> <br /> <br /> <br /> <br /> <br />

	

	<!-- Masthead Heading-->
	<h1>Ajouter un étudiant</h1>
	
	
	<div class="">
	
		<div class="pt-4 pb-3">

			<form action="AjoutEtudiantServlet" method="post">

				<div class="form-row">
				
					<div class="col">
						<div class="md-form md-outline mt-0">
							<label for="firstName">Prénom</label>
							<input type="text" id="firstName" name="firstName" class="form-control"> 
						</div>
					</div>
					
					<div class="col">
						<div class="md-form md-outline mt-0">
							<label for="lastName">Nom de famille</label>
							<input type="text" id="lastName" name="lastName" class="form-control"> 
						</div>
					</div>
					
				</div>

				<div class="md-form md-outline mt-0">				
					<label for="mailAddress">Adresse mail</label>
					<input type="text" id="mailAddress" class="form-control" name="mailAddress"> 
				</div>
				
				
				<div class="md-form md-outline">	
					<label for="address">Adresse</label>
					<textarea  id="address" class="form-control" name="address"></textarea>
				</div>
				
				<div class="md-form md-outline mt-0"  type ="hidden;">
					<label for="numberPhone">Numéro de téléphone</label>
					<input type="text" id="numberPhone" name="numberPhone" class="form-control">
				</div>				
				
				<div class="md-form md-outline mt-0">
					<label for="birthDate">Date de naissance (format yyyy-mm-dd)</label>
					<input type="date" id="birthDate" name="birthDate" class="form-control">
				</div>
			
								
				<br/> <br/>
				<div class="text-center mb-2">
					<button type="submit" class="btn btn-primary mb-4">Ajouter</button>
				</div>

			</form>



		</div>

	</div>
	<!-- Card -->

</div>
<!-- Fin ajout etudiant -->

<!-- footer -->
<%@include file="footer.jsp"%>
<%@page import="eu.ensup.domaine.Student"%>
<%@page import="java.util.List"%>

<!-- header -->
<%@include file="header.jsp"%>
<!-- Navigation-->
<%@include file="menuhaut.jsp"%>

<div class="container">
	<br /> <br /> <br /> <br /> <br /> <br />

	
	<!-- Masthead Heading-->
	<h1>Informations de l'étudiant</h1>

	<div class="table-responsive text-nowrap">
		<!--Table-->
		<% Student student = (Student) session.getAttribute("student"); %>
		Id        	 	: <%=student.getId()%>
		<br/><br/>
		Prénom		 	: <%=student.getFirstName()%>
		<br/><br/>
		Nom		 	 	: <%=student.getLastName()%>
		<br/><br/>
		Adresse mail 	: <%=student.getMailAddress()%>
		<br/><br/>
		Adresse		 	: <%=student.getAddress()%>
		<br/><br/>
		N° téléphone 	: <%=student.getNumberPhone()%>
		<br/><br/>
		Date naissance 	: <%=student.getBirthDate()%>

	</div>

	<!--Section: Live preview-->

</div>




<!-- footer -->
<script>

</script>
<%@include file="footer.jsp"%>